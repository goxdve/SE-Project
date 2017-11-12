package Action;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;

import Class.Group;
import Class.User;
import Data.GroupRepository;
import Data.GroupUserRepository;
import Data.UserRepository;

public class ManageGroup extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -411895869128201108L;
    private Group group;
    private String groupid;
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
    public ArrayList<String> getUsernames() {
        return usernames;
    }
    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }
    public String getGroupid() {
        return groupid;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public String execute() throws Exception {
        System.err.println(groupid);
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
        return "success";
    }
}