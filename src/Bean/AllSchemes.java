package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Scheme;
import Data.SchemeRepository;

public class AllSchemes {
    public ArrayList<Scheme> schemes;
    public int page;
    private static int termsPerPage = 5;

    public ArrayList<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(ArrayList<Scheme> schemes) {
        this.schemes = schemes;
    }

    public AllSchemes() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("schemepage") || (int) session1.get("schemepage") <= 0) {
            page = 1;
        } else {
            page = (int) session1.get("schemepage");
        }
        session1.put("schemepage", -1);
        SchemeRepository schemerepository = new SchemeRepository();
        int schemeNum = schemerepository.getSize();
        int maxpage = (schemeNum + termsPerPage - 1) / termsPerPage;
        int termsPresentPage = termsPerPage;
        if (page >= maxpage) {
            page = maxpage;
            termsPresentPage = schemeNum - (maxpage - 1) * termsPresentPage;
        }
        System.err.println("page = " + page);
        System.err.println("schemeNum = " + schemeNum);
        System.err.println("maxpage = " + maxpage);
        System.err.println("termsPresentPage = " + termsPresentPage);
        schemes = schemerepository.getSchemes((page - 1) * termsPerPage + 1, termsPresentPage);
        schemerepository.close();
    }
}
