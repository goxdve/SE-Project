package Action;

import java.util.HashMap;
import java.util.Map;

import Data.GroupRepository;
import Data.GroupUserRepository;
import net.sf.json.JSONObject;

public class EndTravel {
	private String groupid;
	private String result;
	public void setGroupid(String groupid) {
		this.groupid=groupid;
	}
	public String getGroupid() {
		return this.groupid;
	}
	public void setResult(String result) {
		this.result=result;
	}
	public String getResult() {
		return this.result;
	}
	public String execute() {
		try {
			GroupRepository groupRepository=new GroupRepository();
			groupRepository.completeGroupTravel(groupid);
			GroupUserRepository groupUserRepository=new GroupUserRepository();
			groupUserRepository.inviteComment(groupid);
			Map<String, Object> map = new HashMap<String, Object>();
	        map.put("success", "true");
	        JSONObject json = JSONObject.fromObject(map);
	        result = json.toString();
	        return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
}
