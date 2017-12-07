package Bean;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class CheckLoginState {
	public boolean loggedin;
	public boolean getLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin=loggedin;
	}
	public CheckLoginState() {
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		if (!session1.containsKey("username")) {
			loggedin = false;
			return;
		}
		loggedin = true;
	}
}
