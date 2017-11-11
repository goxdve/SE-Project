package Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;
import java.util.UUID;
import Data.GroupRepository;
import Data.GroupUserRepository;
import jdk.internal.dynalink.beans.StaticClass;
import Class.Group;

public class NewGroup extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -5528845636740933107L;
    // 这一部分内容通过页面获取
    private String groupname;
    private String destination;
    private String begindate;
    private int maxmembercount;
    
    // 这一部分属性在Action中获取
    private int membercount;
    private String groupid;
    private String manager;
    private long timestamp;
    
    public String getGroupname() {
        return groupname;
    }
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getBegindate() {
        return begindate;
    }
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }
    public int getMaxmembercount() {
        return maxmembercount;
    }
    public void setMaxmembercount(int maxmembercount) {
        this.maxmembercount = maxmembercount;
    }
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (!session.containsKey("username"))
            return "error";
        
        groupid = UUID.randomUUID().toString().replaceAll("-", "");
        manager = (String)session.get("username");
        Group group = new Group();
        java.util.Date now = new java.util.Date();
        long aspecialtime = Long.parseLong("15103051387");
        timestamp = now.getTime() / 100 - aspecialtime;
        membercount = 1;
        
        group.setGroupname(groupname);
        group.setDestination(destination);
        group.setBegindate(begindate);
        group.setMaxmembercount(maxmembercount);
        group.setGroupid(groupid);
        group.setMembercount(membercount);
        group.setManager(manager);
        group.setTimestamp(timestamp);
        
        
        GroupRepository grouprepository = new GroupRepository();
        grouprepository.addGroup(group);
        GroupUserRepository groupuserepository = new GroupUserRepository();
        groupuserepository.addGroupUser(groupid, manager);
        
        return SUCCESS;
    }
}
