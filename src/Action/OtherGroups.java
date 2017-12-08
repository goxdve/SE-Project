package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Group;


public class OtherGroups {
    public String username;
    public ArrayList<Group> allotherGroups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Group> getAllotherGroups() {
        return allotherGroups;
    }

    public void setAllotherGroups(ArrayList<Group> allotherGroups) {
        this.allotherGroups = allotherGroups;
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        return "success";
    }
}
