package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.User;
import Data.UserRepository;

public class OtherInformation {
    public User user;
    public String username;

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        UserRepository userRepository = new UserRepository();
        user = userRepository.getUser(username);

        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
