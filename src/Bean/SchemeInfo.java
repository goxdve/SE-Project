package Bean;

import Class.Group;
import Class.Scheme;
import Data.GroupRepository;
import Data.SchemeRepository;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class SchemeInfo {
    private Scheme scheme;
    private Group group;

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public SchemeInfo() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String schemeid = request.getParameter("schemeid");

        SchemeRepository schemeDao = new SchemeRepository();
        scheme = schemeDao.getSchemeByID(schemeid);
        schemeDao.close();

        String groupid = scheme.getRelatedgroupid();
        GroupRepository groupDao = new GroupRepository();
        group = groupDao.getgroup(groupid);
    }
}
