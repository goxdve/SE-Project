package Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Data.GroupUserRepository;

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
        System.err.println("NotInGroup");
        groupuserrepository.addGroupUser(joingroupid, username);
        groupuserrepository.close();
        return "success";
    }
}
