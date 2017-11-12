package Action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class SkipSchemesPage {
    int topage;

    public int getTopage() {
        return topage;
    }

    public void setTopage(int topage) {
        this.topage = topage;
    }

    public String execute() {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> session1 = ac.getSession();
        session1.put("schemepage", topage);
        return "success";
    }
}