package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Privateletter;
import Data.PrivateletterRepository;


public class MySendedPrivateLetter 
{
	public boolean loggedin;

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	public ArrayList<Privateletter> allmysendedPrivateletter;

	public ArrayList<Privateletter> getAllmysendedPrivateletter() {
		return allmysendedPrivateletter;
	}

	public void setAllmysendedPrivateletter(ArrayList<Privateletter> allmysendedPrivateletter) {
		this.allmysendedPrivateletter = allmysendedPrivateletter;
	}

	public MySendedPrivateLetter()throws Exception
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username")) {
            loggedin = false;
            return;
        }
        loggedin = true;
        String username = (String)session1.get("username");
        
        PrivateletterRepository privateletterRepository = new PrivateletterRepository();
        setAllmysendedPrivateletter(privateletterRepository.MySendedPrivateLetter(username));
	}
	
}
