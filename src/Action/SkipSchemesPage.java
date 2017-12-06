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
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        session1.put("schemepage", topage);
        session1.put("ConditionExists", 1);
        return "success";
    }
}