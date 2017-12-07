package Bean;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class editNote {
	public boolean loggedin;
	public boolean getLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin=loggedin;
	}
	public editNote() {
		Map<String, Object> session1=ActionContext.getContext().getSession();
		if (!session1.containsKey("username")) {
			loggedin=false;
			return;
		}
		loggedin=true;
	}
}
