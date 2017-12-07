package Action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;

import Class.Groupmessage;
import Data.GroupRepository;
import Data.MessageRepository;
import net.sf.json.JSONObject;

public class RefuseMemberMessage 
{
	//refuse只有拒绝消息
	public String groupid;
	public String messageid;
	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String username;
	public String result;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute() throws Exception
	{
		ActionContext ac = ActionContext.getContext();
        Map<String, Object> session1 = ac.getSession();
        String me = (String) session1.get("username");
        
        MessageRepository messageRepository = new MessageRepository();
        GroupRepository groupRepository=new GroupRepository();
        Groupmessage oldmessage = messageRepository.getMessageByID(messageid);
		oldmessage.setState(1);
		messageRepository.changeState(messageid);
		Groupmessage message= new Groupmessage();
		message.setType(2);
		message.setGroupid(groupid);
		message.setGroupname(groupRepository.getgroup(groupid).getGroupname());
		message.setMessageid(UUID.randomUUID().toString().replace("-", ""));
		message.setSender(me);
		message.setReceiver(username);
		message.setState(0);
		messageRepository.addMessage(message);
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "true");
        JSONObject json = JSONObject.fromObject(map);
        result = json.toString();
        return "success";
	}
}
