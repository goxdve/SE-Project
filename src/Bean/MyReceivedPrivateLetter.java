package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Privateletter;
import Data.PrivateletterRepository;

public class MyReceivedPrivateLetter 
{
	public boolean loggedin;

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	
	public ArrayList<Privateletter> allmyreceivedPrivateletter;

	public ArrayList<Privateletter> getAllmyreceivedPrivateletter() {
		return allmyreceivedPrivateletter;
	}

	public void setAllmyreceivedPrivateletter(ArrayList<Privateletter> allmyreceivedPrivateletter) {
		this.allmyreceivedPrivateletter = allmyreceivedPrivateletter;
	}
	public MyReceivedPrivateLetter()throws Exception
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username")) {
            loggedin = false;
            return;
        }
        loggedin = true;
        String username = (String)session1.get("username");
        
        PrivateletterRepository privateletterRepository = new PrivateletterRepository();
        setAllmyreceivedPrivateletter(privateletterRepository.MyReceivedPrivateLetter(username));
	}
}
