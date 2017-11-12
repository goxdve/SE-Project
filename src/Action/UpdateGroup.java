package Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Data.GroupRepository;
import Data.GroupUserRepository;
import Class.Group;

public class UpdateGroup extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 5213923617593721299L;
    // 这一部分内容通过页面获取
    private String groupname;
    private String groupid;
    private String destination;
    private String begindate;
    private int maxmembercount;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
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
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username"))
            return "error";
        System.err.println("aaagroupid = " + groupid);
        GroupRepository grouprepository = new GroupRepository();
        Group group = grouprepository.getgroup(groupid);
        group.setGroupname(groupname);
        group.setDestination(destination);
        group.setBegindate(begindate);
        group.setMaxmembercount(maxmembercount);
        grouprepository.updateGroup(group);
        grouprepository.close();
        return SUCCESS;
    }
}