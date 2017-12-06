package Action;

import java.util.Map;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import Class.Group;
import Class.Groupmessage;
import Data.GroupRepository;
import Data.GroupUserRepository;
import Data.MessageRepository;

public class JoinGroup {
    public String joingroupid;

    public String getJoingroupid() {
        return joingroupid;
    }

    public void setJoingroupid(String joingroupid) {
        this.joingroupid = joingroupid;
    }

    public String execute() throws Exception {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> session1 = ac.getSession();
        String username = (String) session1.get("username");
        System.err.println(joingroupid);
        System.err.println(username);
        GroupUserRepository groupuserrepository = new GroupUserRepository();
        if (groupuserrepository.isInGroup(joingroupid, username)) {
            System.err.println("inInGroup");
            groupuserrepository.close();
            return "error";
        }
        System.out.println("NotInGroup");
        //groupuserrepository.addGroupUser(joingroupid, username);
        Groupmessage message=new Groupmessage();
        message.setType(0);
        message.setGroupid(joingroupid);
        message.setMessageid(UUID.randomUUID().toString().replace("-", ""));
        message.setSender(username);
        GroupRepository groupRepository=new GroupRepository();
        Group group=new Group();
        group=groupRepository.getgroup(joingroupid);
        message.setReceiver(group.getManager());
        message.setGroupname(group.getGroupname());
        message.setState(0);
        MessageRepository repository=new MessageRepository();
        repository.addMessage(message);
        repository.close();
        groupRepository.close();
        groupuserrepository.close();
        return "success";
    }
}
