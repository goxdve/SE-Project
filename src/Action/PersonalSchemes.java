package Action;
import Class.*;
import Data.*;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

public class PersonalSchemes
{
    //弄一个参加计划的表
    ArrayList<Scheme> personalSchemes;

    public ArrayList<Scheme> getPersonalSchemes() {
        return personalSchemes;
    }

    public void setPersonalSchemes(ArrayList<Scheme> personalSchemes) {
        this.personalSchemes = personalSchemes;
    }

    public String execute() throws Exception
    {
        String ret = "success";
        ActionContext context = ActionContext.getContext();
        Map application = context.getApplication();
        String Username = (String) application.get("Username");
        setPersonalSchemes((new SchemeRepository().PersonalSchemes(Username)));
        
        return ret;
    }
}
