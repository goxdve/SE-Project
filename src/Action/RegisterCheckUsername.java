package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import Data.UserRepository;
import net.sf.json.JSONObject;

public class RegisterCheckUsername extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 6906588774585815023L;
    private HttpServletRequest request;
    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String execute() {
       try {
         request = ServletActionContext.getRequest();
         String username = request.getParameter("username");
         UserRepository userDao = new UserRepository();
         Map<String, Object> map = new HashMap<String, Object>(); 
         if (userDao.ContainsUser(username)) {
             map.put("RegisterResult", 1);
         } else {
             map.put("RegisterResult", 2);
         }

         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}