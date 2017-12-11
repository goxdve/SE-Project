package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Class.User;
import Data.UserRepository;

import java.net.URLDecoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

public class Register extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 5424080242037436671L;
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
         String pwd1 = request.getParameter("password1");
         String pwd2 = request.getParameter("password2");
         int sex = Integer.parseInt(request.getParameter("sex"));
         String birth = request.getParameter("birthday");
         String telephone = request.getParameter("telephone");
         String signature = request.getParameter("signature");

         UserRepository userDao = new UserRepository();
         int status = 0;
         if (userDao.ContainsUser(username)) {
             status = 2;
         } else if (!pwd1.equals(pwd2)) {
             status = 3;
         } else {
             status = 1;
             User user = new User();
             user.setUsername(username);
             user.setPassword(pwd1);
             user.setSex(sex);
             user.setThumbupnum(0);
             user.setTelephone(telephone);
             user.setSignature(signature);
             Calendar now = Calendar.getInstance();
             int presentYear = now.get(Calendar.YEAR);
             int birthYear = Integer.valueOf(birth.substring(0, 4));
             int age = presentYear - birthYear;
             user.setAge(age);
             userDao.register(user);
         }
         userDao.close();
         Map<String, Object> map = new HashMap<String, Object>(); 
         map.put("RegisterResult", status);

         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}
