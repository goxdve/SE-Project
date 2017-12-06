package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

public class SearchScheme extends ActionSupport {
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
         String departureprovince = URLDecoder.decode(request.getParameter("departureprovince"), "UTF-8");
         String departurecity = URLDecoder.decode(request.getParameter("departurecity"), "UTF-8");
         String destprovince = URLDecoder.decode(request.getParameter("destprovince"), "UTF-8");
         String destcity = URLDecoder.decode(request.getParameter("destcity"), "UTF-8");
         String beginDate = URLDecoder.decode(request.getParameter("beginDate"), "UTF-8");
         int duration = Integer.parseInt(request.getParameter("duration"));
         int expenses = Integer.parseInt(request.getParameter("expenses"));

         Map<String, Object> session1 = ActionContext.getContext().getSession(); 
         session1.put("departureprovince", departureprovince);
         session1.put("departurecity", departurecity);
         session1.put("destprovince", destprovince);
         session1.put("destcity", destcity);
         session1.put("beginDate", beginDate);
         session1.put("duration", duration);
         session1.put("expenses", expenses);
         session1.put("schemepage", 1);
         session1.put("ConditionExists", 1);

         Map<String, Object> map = new HashMap<String, Object>(); 
         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}