package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import Data.UserRepository;
import net.sf.json.JSONObject;

public class Login extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 6760341805820670987L;
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
         String username = URLDecoder.decode(request.getParameter("username"), "UTF-8");
         String password = request.getParameter("password");


         UserRepository userrepository = new UserRepository();
         boolean success = false;
         if (userrepository.Login(username, password)) {
             ActionContext ac = ActionContext.getContext();
             Map<String, Object> session1 = ac.getSession();
             session1.put("username", username);
             success = true;
         }
         else
             success = false;

         Map<String, Object> map = new HashMap<String, Object>(); 
         if (success) {
             map.put("LoginResult", 1);
         }
         else {
             map.put("LoginResult", 2);
         }

         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}