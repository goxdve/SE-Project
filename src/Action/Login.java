package Action;

import Data.UserRepository;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Class.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static org.apache.struts2.ServletActionContext.getServletContext;

public class Login extends ActionSupport
{
    public String execute() throws Exception
    {
    	User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserRepository userrepository = new UserRepository();
        if (userrepository.Login(username, password))
            return "success";
        else
            return "error";
    }
//    public void validate()
//    {
//        UserRepository userRepository = null;
//		try {
//			userRepository = new UserRepository();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        try
//        {
//            String result = userRepository.Login(username,password);
//            if(result.equals("error"))
//            {
//                addFieldError("password","密码错误！");
//            }
//            else if (result.equals("doesn't exist"))
//            {
//                addFieldError("Username","用户不存在！");
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }

    public String username;//用户名

    public String password;//密码

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
