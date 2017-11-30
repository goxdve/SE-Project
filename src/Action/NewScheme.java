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
import net.sf.json.JSONObject;
import Class.Scheme;

public class NewScheme extends ActionSupport implements ServletRequestAware {
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
//         System.out.println("NewScheme.java: hello bug");
         Scheme scheme = new Scheme();
         String schemeTitle = URLDecoder.decode(request.getParameter("schemeTitle"), "UTF-8");
         String destination = URLDecoder.decode(request.getParameter("destination"), "UTF-8");
         String beginDate = request.getParameter("beginDate");
         String description = URLDecoder.decode(request.getParameter("description"), "UTF-8");
         int duration = Integer.parseInt(request.getParameter("duration"));

//         System.out.println("NewScheme.java: schemeTitle = " + schemeTitle);
//         System.out.println("NewScheme.java: destination = " + destination);
//         System.out.println("NewScheme.java: beginDate = " + beginDate);
//         System.out.println("NewScheme.java: description = " + description);
//         System.out.println("NewScheme.java: duration = " + duration);
         scheme.setSchemeTitle(schemeTitle);
         scheme.setDestination(destination);
         scheme.setBeginDate(beginDate);
         scheme.setDuration(duration);
         scheme.setDescription(description);
         
         // 发布时间postDate和postTime
         java.util.Date now = new java.util.Date();
         java.sql.Date date = new java.sql.Date(now.getTime());
         java.sql.Time time = new java.sql.Time(now.getTime());
         scheme.setPostDate(date.toString());
         scheme.setPostTime(time.toString());
         
         // 帖子ID
         String schemeID = UUID.randomUUID().toString().replaceAll("-", "");
         scheme.setSchemeID(schemeID);
         
          // 发帖人
         Map<String, Object> session1 = ActionContext.getContext().getSession();
         if (!session1.containsKey("username")) {
             return "NotLoggedIn";
         }
         String ownerName = (String)session1.get("username");
         scheme.setOwnerName(ownerName);
         
         // 时间戳
         long aSpecialTime = Long.parseLong("15103051387");
         long timestamp = now.getTime() / 100 - aSpecialTime;
         scheme.setTimestamp(timestamp);

         SchemeRepository schemeDao = new SchemeRepository();
         schemeDao.addScheme(scheme);

         Map<String, Object> map = new HashMap<String, Object>(); 
         map.put("success", "true");

         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
//         System.out.println("NewScheme.java result = " + result);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}