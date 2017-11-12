package Action;

import Data.UserRepository;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Class.User;
import java.util.Map;

public class Logout extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -7603781847416312815L;

    public String execute() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (session1.containsKey("username")) {
            session1.remove("username");
        }
        return "success";
    }

    public String username;// 用户名

    public String password;// 密码

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
