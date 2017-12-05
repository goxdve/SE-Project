package Action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;

import Class.Privateletter;
import Data.PrivateletterRepository;
import net.sf.json.JSONObject;

public class SendPrivateLetter 
{
	public String receiver;
	
	public String privateletterTitle;
	
	public String content;
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPrivateletterTitle() {
		return privateletterTitle;
	}

	public void setPrivateletterTitle(String privateletterTitle) {
		this.privateletterTitle = privateletterTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute()throws Exception
	{
		java.util.Date now=new java.util.Date();
		java.sql.Date date=new java.sql.Date(now.getTime());
		java.sql.Time time=new java.sql.Time(now.getTime());
		String privateletterTime = date+" "+time;
		
		Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username")) {
            return "success";
        }
        String username = (String)session1.get("username");
        
        //第一个
        
		Privateletter privateletter= new Privateletter();
		PrivateletterRepository privateletterRepository = new PrivateletterRepository();
		String privateletterID =UUID.randomUUID().toString().replace("-","");
		
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
        
        //第二个
        
        privateletter= new Privateletter();
		privateletterRepository = new PrivateletterRepository();
		privateletterID =UUID.randomUUID().toString().replace("-","");
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
        
        Map map = new HashMap();
		map.put("result", "success");
        JSONObject obj = JSONObject.fromObject(map);
        result = obj.toString();
		return "success";
	}
}
