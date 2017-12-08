package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Scheme;
import Data.SchemeRepository;

public class OtherSchemes {
    public String username;
    public ArrayList<Scheme> allotherSchemes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Scheme> getAllotherSchemes() {
        return allotherSchemes;
    }

    public void setAllotherSchemes(ArrayList<Scheme> allotherSchemes) {
        this.allotherSchemes = allotherSchemes;
    }

    public String execute() throws Exception {
        SchemeRepository schemeRepository = new SchemeRepository();
        setAllotherSchemes(schemeRepository.mySchemes(username));
        
        return "success";
    }
}
