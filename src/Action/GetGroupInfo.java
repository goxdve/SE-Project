package Action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Class.Group;
import java.util.HashMap;
import java.util.Map;
import Data.GroupRepository;
import net.sf.json.JSONObject;

public class GetGroupInfo extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -2156889989856879732L;
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
         String groupid = request.getParameter("groupid");
         GroupRepository groupDao = new GroupRepository();
         Group group = groupDao.getgroup(groupid);

         Map<String, Object> map = new HashMap<String, Object>(); 
         map.put("departureprovince", group.getDepartureprovince());
         map.put("departurecity", group.getDeparturecity());
         map.put("destprovince", group.getDestprovince());
         map.put("destcity", group.getDestcity());
         map.put("beginDate", group.getBegindate());
         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}