package Action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Class.Privateletter;
import Data.PrivateletterRepository;
import Data.UserRepository;
import net.sf.json.JSONObject;

public class SendPrivateLetter extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = -7789117315734386876L;
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
            String receiver = URLDecoder.decode(request.getParameter("receiver"), "UTF-8");
            UserRepository UserDao = new UserRepository();
            boolean ReceiverExits = false;
            if (!UserDao.ContainsUser(receiver)) {
                ReceiverExits = false;
            } else {
                ReceiverExits = true;
                String privateletterTitle = URLDecoder.decode(request.getParameter("privateletterTitle"), "UTF-8");
                String content = URLDecoder.decode(request.getParameter("content"), "UTF-8");

                java.util.Date now = new java.util.Date();
                java.sql.Date date = new java.sql.Date(now.getTime());
                java.sql.Time time = new java.sql.Time(now.getTime());
                String privateletterTime = date.toString() + " " + time.toString();

                Map<String, Object> session1 = ActionContext.getContext().getSession();
                String username = (String)session1.get("username");

                // 第一个
                Privateletter privateletter = new Privateletter();
                PrivateletterRepository privateletterRepository = new PrivateletterRepository();
                String privateletterID = UUID.randomUUID().toString().replace("-", "");
                long aSpecialTime = Long.parseLong("15103051387");
                long timestamp = now.getTime() / 100 - aSpecialTime;
                privateletter.setPrivateletterID(privateletterID);
                privateletter.setUsername(username);
                privateletter.setSender(username);
                privateletter.setReceiver(receiver);
                privateletter.setPrivateletterTitle(privateletterTitle);
                privateletter.setPrivateletterTime(privateletterTime);
                privateletter.setContent(content);
                privateletter.setTimestamp(timestamp);
                privateletterRepository.SendPrivateLetter(privateletter);

                // 第二个
                privateletter = new Privateletter();
                privateletterRepository = new PrivateletterRepository();
                privateletterID = UUID.randomUUID().toString().replace("-", "");
                timestamp = now.getTime() / 100 - aSpecialTime;
                privateletter.setPrivateletterID(privateletterID);
                privateletter.setUsername(receiver);
                privateletter.setSender(username);
                privateletter.setReceiver(receiver);
                privateletter.setPrivateletterTitle(privateletterTitle);
                privateletter.setPrivateletterTime(privateletterTime);
                privateletter.setContent(content);
                privateletter.setTimestamp(timestamp);
                privateletterRepository.SendPrivateLetter(privateletter);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            if (ReceiverExits) {
                map.put("SendResult", "success");
            } else {
                map.put("SendResult", "error");
            }
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
