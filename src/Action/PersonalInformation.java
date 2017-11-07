package Action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Data.InformationRepository;

public class PersonalInformation 
{
	public String execute() throws Exception
    {
		String ret ="success";
		ActionContext context = ActionContext.getContext();
        Map application = context.getApplication();
        String Username = (String) application.get("Username");
        HashMap<String,Object> information = (new InformationRepository().Information(Username));
        if(information != null)
        {
            setFormerrightname((String)information.get("rightname"));
            setFormersex((String)information.get("sex"));
            setFormerage((int)information.get("age"));
            setFormertelephone((String) information.get("telephone"));
        }
		return ret;
    }
	public String formerrightname;
	public String formersex;
	public int formerage;
	public String formertelephone;
	public String getFormerrightname() {
		return formerrightname;
	}
	public void setFormerrightname(String formerrightname) {
		this.formerrightname = formerrightname;
	}
	public String getFormersex() {
		return formersex;
	}
	public void setFormersex(String formersex) {
		this.formersex = formersex;
	}
	public int getFormerage() {
		return formerage;
	}
	public void setFormerage(int formerage) {
		this.formerage = formerage;
	}
	public String getFormertelephone() {
		return formertelephone;
	}
	public void setFormertelephone(String formertelephone) {
		this.formertelephone = formertelephone;
	}
	
}
