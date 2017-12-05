package Action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Data.PrivateletterRepository;
import net.sf.json.JSONObject;

public class DeletePrivateLetter {
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
         String privateletterID = request.getParameter("privateletterID");
         PrivateletterRepository privateletterDao = new PrivateletterRepository();
         privateletterDao.DeletePrivateLetter(privateletterID);

         Map<String, Object> map = new HashMap<String, Object>(); 
         JSONObject json = JSONObject.fromObject(map);
         result = json.toString();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "success";
    }
}
