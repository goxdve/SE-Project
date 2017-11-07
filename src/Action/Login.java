package Action;

import Data.UserRepository;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import static org.apache.struts2.ServletActionContext.getServletContext;

public class Login extends ActionSupport
{
    public String execute() throws Exception
    {
        String ret = "success";
//        ServletContext application;
//        application = getServletContext();
        ActionContext context = ActionContext.getContext();
        Map application = context.getApplication();
        application.put("Username",Username);
        application.put("page",1);
        return ret;
    }
    public void validate()
    {
        UserRepository userRepository = new UserRepository();
        try
        {
            String result = userRepository.Login(Username,password);
            if(result.equals("error"))
            {
                addFieldError("password","密码错误！");
            }
            else if (result.equals("doesn't exist"))
            {
                addFieldError("Username","用户不存在！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public String Username;//用户名

    public String password;//密码

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }


}
