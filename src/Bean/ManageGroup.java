package Bean;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Group;
import Class.User;
import Data.GroupRepository;
import Data.GroupUserRepository;
import Data.UserRepository;

public class ManageGroup {
    private Group group;
    private ArrayList<User> users;
    private ArrayList<String> usernames;

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

    public ManageGroup() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String groupid = request.getParameter("groupid");

        // 根据GroupID获取Group
        GroupRepository groupRepositoryDao = new GroupRepository();
        group = groupRepositoryDao.getgroup(groupid);
        groupRepositoryDao.close();

        // 根据GroupID获取该组内所有用户的用户名usernames
        GroupUserRepository groupUserDao = new GroupUserRepository();
        usernames = groupUserDao.getUsernames(groupid);
        groupUserDao.close();

        // 根据usernames获取所有用户对象users
        UserRepository userDao = new UserRepository();
        users = new ArrayList<User>();
        for (String s : usernames) {
            User user = userDao.getUser(s);
            users.add(user);
        }
        userDao.close();       

    }
}
