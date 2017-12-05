package Action;

import java.util.HashMap;
import java.util.Map;

import Data.PrivateletterRepository;
import net.sf.json.JSONObject;

public class DeletePrivateLetter 
{
	public String privateletterID;

	public String getPrivateletterID() {
		return privateletterID;
	}

	public void setPrivateletterID(String privateletterID) {
		this.privateletterID = privateletterID;
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
		PrivateletterRepository privateletterRepository = new PrivateletterRepository();
		privateletterRepository.DeletePrivateLetter(privateletterID);
		
		Map map = new HashMap();
		map.put("result", "success");
        JSONObject obj = JSONObject.fromObject(map);
        result = obj.toString();
		return "success";
	}

}
