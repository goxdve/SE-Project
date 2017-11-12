package Action;

import Data.UserRepository;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Class.User;
import java.util.Map;

public class Login extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -4085415268098721474L;

    public String execute() throws Exception {
        UserRepository userrepository = new UserRepository();
        if (userrepository.Login(username, password)) {
            ActionContext ac = ActionContext.getContext();
            Map<String, Object> session1 = ac.getSession();
            session1.put("username", username);
            return "success";
        }
        else
            return "error";
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
