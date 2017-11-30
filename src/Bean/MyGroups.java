package Bean;

import java.util.ArrayList;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import Data.GroupRepository;
import Data.GroupUserRepository;

public class MyGroups {
    public ArrayList<GroupM> allmygroups;
    public ArrayList<GroupM> getAllmygroups() {
        return allmygroups;
    }

    public void setAllmygroups(ArrayList<GroupM> allmygroups) {
        this.allmygroups = allmygroups;
    }

    public MyGroups() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username"))
            return;
        String username = (String)session1.get("username");
        
        // 获取当前用户所属的所有小组ID
        GroupUserRepository groupUserDao = new GroupUserRepository();
        ArrayList<String> AllMyGroupsid = groupUserDao.mygroupid(username);
        groupUserDao.close();

        // 标记该用户在每个小组中是否管理员
        allmygroups = new ArrayList<GroupM>();
        GroupRepository grouprepository = new GroupRepository();
        for (String s : AllMyGroupsid) {
            String groupname = grouprepository.getgroup(s).getGroupname();
            if (grouprepository.IsManager(username, s)) {
                allmygroups.add(new GroupM(groupname, s, true));
            } else {
                allmygroups.add(new GroupM(groupname, s, false));
            }
        }
        grouprepository.close();
    }
}
class GroupM {
    private String groupid;
    private String groupname;
    private boolean isManaged;
    public boolean getIsManaged() {
        return isManaged;
    }
    public String getGroupid() {
        return groupid;
    }
    public String getGroupname() {
        return groupname;
    }
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public void setManaged(boolean isManaged) {
        this.isManaged = isManaged;
    }
    public GroupM() {
    }
    public GroupM(String groupname, String groupid, boolean isManaged) {
        this.groupname = groupname;
        this.groupid = groupid;
        this.isManaged = isManaged;
    }
}
