package Action;

import Data.UserRepository;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport
{
    public String execute() throws Exception
    {
        String ret = "success";
        return ret;
    }
    public void validate()
    {
        UserRepository userRepository = new UserRepository();
        if(password.equals(passworaagain))
        {
            addFieldError("password","两次密码不一致！");
        }
        else
        {
            try
            {
                String result = userRepository.Register(Username,password);
                if(result.equals("exist"))
                {
                    addFieldError("Username","用户已经存在！");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    String Username;

    String password;

    String passworaagain;

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassworaagain(String passworaagain) {
        this.passworaagain = passworaagain;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public String getPassworaagain() {
        return passworaagain;
    }
}
