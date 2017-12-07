package Action;

import java.util.HashMap;
import java.util.Map;

import Data.SchemeRepository;
import net.sf.json.JSONObject;

public class CancelScheme 
{
	public String schemeID;
	
	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public String result;

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
	public String execute() throws Exception
	{
		SchemeRepository schemeRepository = new SchemeRepository();
		schemeRepository.cancelscheme(schemeID);
		schemeRepository.close();
		Map map = new HashMap();
		map.put("result", "success");
        JSONObject obj = JSONObject.fromObject(map);
        result = obj.toString();
		return "success";
	}
}
