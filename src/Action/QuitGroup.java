package Action;


import Data.GroupUserRepository;

public class QuitGroup {
    public String username;
    private String managername;
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
    
    public void setManagername(String managername) {
		this.managername=managername;
	}
    
    public String getManagername() {
		return this.managername;
	}
    
    public String execute() throws Exception {
        GroupUserRepository groupUserDao = new GroupUserRepository();
        System.err.println(username);
        System.err.println(groupid);
        System.err.println(managername);
        groupUserDao.quitgroup(username, managername, groupid);
        groupUserDao.close();
        return "success";
    }
}
