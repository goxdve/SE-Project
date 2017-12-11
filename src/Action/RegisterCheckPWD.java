package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

public class RegisterCheckPWD extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1679381484434620578L;
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
         String pwd1 = request.getParameter("pwd1");
         String pwd2 = request.getParameter("pwd2");
         System.out.println("pwd1 = " + pwd1);
         System.out.println("pwd2 = " + pwd2);
         Map<String, Object> map = new HashMap<String, Object>(); 
         if (!pwd1.equals(pwd2)) {
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