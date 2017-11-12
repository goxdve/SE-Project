package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Group;
import Data.GroupRepository;

public class AllGroups {
    public ArrayList<Group> groups;
    public int page;
    private static int termsPerPage = 7; // 每页展示的小组数量

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public AllGroups() throws Exception {
        Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("grouppage") || (int) session1.get("grouppage") <= 0) {
            page = 1;
        } else {
            page = (int) session1.get("grouppage");
        }
        session1.put("grouppage", -1);
        GroupRepository grouprepository = new GroupRepository();
        int groupNum = grouprepository.getSize();
        int maxpage = (groupNum + termsPerPage - 1) / termsPerPage;
        int termsPresentPage = termsPerPage;
        if (page >= maxpage) {
            page = maxpage;
            termsPresentPage = groupNum - (maxpage - 1) * termsPresentPage;
        }
        groups = grouprepository.getGroups((page - 1) * termsPerPage + 1, termsPresentPage);
        grouprepository.close();
    }
}
