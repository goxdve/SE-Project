package Bean;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Group;
import Class.User;
import Data.GroupRepository;
import Data.GroupUserRepository;
import Data.UserRepository;

public class CommentGroup {
	private Group group;
    private ArrayList<User> users;
    private ArrayList<String> usernames;
    private String messageid;
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public void setMessageid(String messageid) {
		this.messageid=messageid;
	}
    
    public String getMessageid() {
		return this.messageid;
	}
    public CommentGroup() throws Exception {
    	HttpServletRequest request=ServletActionContext.getRequest();
    	String groupid=request.getParameter("groupid");
    	messageid=request.getParameter("messageid");
    	
    	GroupRepository groupRepository=new GroupRepository();
    	group=groupRepository.getgroup(groupid);
    	groupRepository.close();
    	
    	GroupUserRepository groupUserRepository=new GroupUserRepository();
    	usernames=groupUserRepository.getUsernames(groupid);
    	groupUserRepository.close();
    	
    	UserRepository userDao = new UserRepository();
        users = new ArrayList<User>();
        for (String s : usernames) {
            User user = userDao.getUser(s);
            users.add(user);
        }
        userDao.close();
        
    }
}
