package Bean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Group;
import Data.GroupRepository;

public class ManageGroup {
    private Group group;
    private int maxmembercount;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getMaxmembercount() {
        return maxmembercount;
    }

    public void setMaxmembercount(int maxmembercount) {
        this.maxmembercount = maxmembercount;
    }

    public ManageGroup() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String groupid = request.getParameter("groupid");
        
        GroupRepository grouprepository = new GroupRepository();
        group = grouprepository.getgroup(groupid);
        maxmembercount = group.getMaxmembercount();
        grouprepository.close();
    }
}
