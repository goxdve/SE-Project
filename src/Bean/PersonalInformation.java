package Bean;

import Class.User;
import Data.UserRepository;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class PersonalInformation {
    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public PersonalInformation() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession(); 
        String username = (String)session1.get("username");
        UserRepository userDao = new UserRepository();
        user = userDao.getUser(username);
    }
   
}
