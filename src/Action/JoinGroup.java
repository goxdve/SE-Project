package Action;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Class.Group;
import Class.Groupmessage;
import Data.GroupRepository;
import Data.GroupUserRepository;
import Data.MessageRepository;
import net.sf.json.JSONObject;

public class JoinGroup extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -5409811156035654014L;
    private HttpServletRequest request;
    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String execute() throws Exception {
        try {
            boolean IsLoggedIn = false;
            boolean isingroup = true;
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> session1 = ac.getSession();
            if (!session1.containsKey("username")) {
                IsLoggedIn = false;
            } else {
                IsLoggedIn = true;
            }
            if (IsLoggedIn) {
                String username = (String) session1.get("username");
                request = ServletActionContext.getRequest();
                String joingroupid = request.getParameter("groupid");

                GroupUserRepository groupuserrepository = new GroupUserRepository();
                if (groupuserrepository.isInGroup(joingroupid, username)) {
                    isingroup = true;
                } else {
                    isingroup = false;
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
                }
                groupuserrepository.close();
            }

            Map<String, Object> map = new HashMap<String, Object>(); 
            if (!IsLoggedIn) {
                map.put("success", "notloggedin");
            } else if (isingroup) {
                map.put("success", "isingroup");
            } else {
                map.put("success", "true");
            }
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
