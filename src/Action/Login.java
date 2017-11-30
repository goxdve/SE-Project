package Action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import Data.SchemeRepository;
import Data.UserRepository;
import net.sf.json.JSONObject;
import Class.Scheme;

public class Login extends ActionSupport implements ServletRequestAware {
    /**
     * 
     */
    private static final long serialVersionUID = 6760341805820670987L;
    private HttpServletRequest request;
    private String result;
    public void setServletRequest(HttpServletRequest arg) {
        this.request = arg;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String execute() {
       try {
//         System.out.println("LoginAjax.java: hello bug");
         String username = request.getParameter("username");
         String password = request.getParameter("password");

//         System.out.println("LoginAjax.java:username = " + username);
//         System.out.println("LoginAjax.java: password = " + password);

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
//         System.out.println("LoginAjax.java result = " + result);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}