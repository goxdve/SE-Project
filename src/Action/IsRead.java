package Action;

import java.util.HashMap;
import java.util.Map;
import Data.MessageRepository;
import net.sf.json.JSONObject;

public class IsRead {
	private String messageid;
	public String result;
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute() throws Exception
	{
		MessageRepository messageRepository=new MessageRepository();
		messageRepository.changeState(messageid);
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "true");
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return "success";
	}
}
