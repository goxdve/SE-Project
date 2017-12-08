package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class OtherSpace {
    public String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("OtherSpace.java: username = " + username);
        return "success";
    }
}
