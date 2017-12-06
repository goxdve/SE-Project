package Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import Class.Scheme;
import Data.SchemeRepository;

public class AllSchemes {
    public ArrayList<Scheme> schemes;
    public int page;
    private static int termsPerPage = 10; // 每页展示的帖子数量

    public ArrayList<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(ArrayList<Scheme> schemes) {
        this.schemes = schemes;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public AllSchemes() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession(); 
        if (!session1.containsKey("schemepage") || (int)session1.get("schemepage") <= 0) {
            page = 1;
        } else {
            page = (int)session1.get("schemepage");
        }
        session1.put("schemepage", -1);
        int conditionexists = 0;
        if (session1.containsKey("ConditionExists"))
            conditionexists = (int)session1.get("ConditionExists");
        session1.put("ConditionExists", 0);
        SchemeRepository schemeDao = new SchemeRepository();
        ArrayList<Scheme> tmp;
        if (conditionexists == 0) {
            tmp = schemeDao.getSchemes("", "", "");
        } else {
            String destprovince = (String)session1.get("destprovince");
            String destcity = (String)session1.get("destcity");
            String departureprovince = (String)session1.get("departureprovince");
            String departurecity = (String)session1.get("departurecity");
            String beginDate = (String)session1.get("beginDate");
            int duration = (int)session1.get("duration");
            int expenses = (int)session1.get("expenses");
            System.out.println("AllSchemes.java: destprovince = " + destprovince);
            System.out.println("AllSchemes.java: destcity = " + destcity);
            System.out.println("AllSchemes.java: departureprovince = " + departureprovince);
            System.out.println("AllSchemes.java: departurecity = " + departurecity);
            System.out.println("AllSchemes.java: beginDate = " + beginDate);
            System.out.println("AllSchemes.java: duration = " + duration);
            System.out.println("AllSchemes.java: expenses = " + expenses);
            tmp = schemeDao.getSchemes(destprovince, departureprovince, beginDate);
            Collections.sort(tmp, new Comparator<Scheme>() {
                @Override
                public int compare(Scheme o1, Scheme o2) {
                    return 
                    ((o1.getDestcity() == destcity ? 100 : 0) + 
                    (o1.getDeparturecity() == departurecity ? 100 : 0) +
                    (o1.getBeginDate() == beginDate ? 50 : 0) -
                    Math.abs(o1.getDuration() - duration) * 40 - 
                    Math.abs(o1.getExpenses() - expenses) * 40)
                    -
                    ((o1.getDestcity() == destcity ? 100 : 0) + 
                    (o1.getDeparturecity() == departurecity ? 100 : 0) +
                    (o1.getBeginDate() == beginDate ? 50 : 0) -
                    Math.abs(o1.getDuration() - duration) * 40 - 
                    Math.abs(o1.getExpenses() - expenses) * 40);
                }
            });
        }
        int schemeNum = tmp.size();
        int maxpage = (schemeNum + termsPerPage - 1) / termsPerPage;
        if (maxpage == 0)
            maxpage = 1;
        int termsPresentPage = termsPerPage;
        if (page >= maxpage) {
            page = maxpage;
            termsPresentPage = schemeNum - (maxpage - 1) * termsPerPage;
        }
        int startPos = (page - 1) * termsPerPage + 1;
        int endPos = (page - 1) * termsPerPage + termsPresentPage;
        schemes = new ArrayList<Scheme>();
        for (int i = startPos; i <= endPos; i++)
            schemes.add(tmp.get(i - 1));
    }
}