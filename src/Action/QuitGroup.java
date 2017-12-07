package Action;


import Data.GroupUserRepository;

public class QuitGroup {
    public String username;
    public String groupid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String execute() throws Exception {
        GroupUserRepository groupUserDao = new GroupUserRepository();
        System.err.println(username);
        System.err.println(groupid);
        groupUserDao.quitgroup(username, groupid);
        groupUserDao.close();
        return "success";
    }
}
