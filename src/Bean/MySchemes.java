package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Scheme;
import Data.SchemeRepository;

public class MySchemes {
	public ArrayList<Scheme> allmyschemes;

	public ArrayList<Scheme> getAllmyschemes() {
		return allmyschemes;
	}

	public void setAllmyschemes(ArrayList<Scheme> allmyschemes) {
		this.allmyschemes = allmyschemes;
	}
	public boolean loggedin;

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	public MySchemes ()throws Exception
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username")) {
            loggedin = false;
            return;
        }
        loggedin = true;
        String username = (String)session1.get("username");
        
        SchemeRepository schemeRepository =new SchemeRepository();
        setAllmyschemes(schemeRepository.mySchemes(username));
	}
}
