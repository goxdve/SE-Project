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
        
        return "success";
    }
}
