package Action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import Class.User;
import Data.UserRepository;
import net.sf.json.JSONObject;

public class ThumbUp extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 4305717014568860571L;
    private HttpServletRequest request;
    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String execute() throws Exception {
        try {
            request = ServletActionContext.getRequest();
            String membername = request.getParameter("membername");
            System.out.println("Action/ThumbUp.java: membername = " + membername);
            UserRepository userDao = new UserRepository();
            User user = userDao.getUser(membername);
            userDao.ThumbUp(user);
            userDao.close();
            Map<String, Object> map = new HashMap<String, Object>(); 
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}