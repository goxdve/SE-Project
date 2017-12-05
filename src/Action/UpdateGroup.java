package Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import Data.GroupRepository;
import Class.Group;

public class UpdateGroup extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 5213923617593721299L;
    private HttpServletRequest request;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String execute() {
        try {
//            System.out.println("UpdateGroup.java: hello bug");
            request = ServletActionContext.getRequest();
            String groupname = URLDecoder.decode(request.getParameter("groupname"), "UTF-8");
            String destprovince = URLDecoder.decode(request.getParameter("destprovince"), "UTF-8");
            String destcity = URLDecoder.decode(request.getParameter("destcity"), "UTF-8");
            String departureprovince = URLDecoder.decode(request.getParameter("departureprovince"), "UTF-8");
            String departurecity = URLDecoder.decode(request.getParameter("departurecity"), "UTF-8");
            String begindate = request.getParameter("begindate");
            int maxmembercount = Integer.parseInt(request.getParameter("maxmembercount"));
            String groupid = request.getParameter("groupid");

//            System.out.println("UpdateGroup.java: groupname = " + groupname);
//            System.out.println("UpdateGroup.java: destination = " + destination);
//            System.out.println("UpdateGroup.java: beginDate = " + begindate);
//            System.out.println("UpdateGroup.java: maxmembercount = " + maxmembercount);
            System.out.println("UpdateGroup.java: destprovince =  " + destprovince);
            System.out.println("UpdateGroup.java: destcity = " + destcity);

            GroupRepository grouprepository = new GroupRepository();
            Group group = grouprepository.getgroup(groupid);
//            System.out.println(group);
            group.setGroupname(groupname);
            group.setDestprovince(destprovince);
            group.setDestcity(destcity);
            group.setDepartureprovince(departureprovince);
            group.setDeparturecity(departurecity);
            group.setBegindate(begindate);
            group.setMaxmembercount(maxmembercount);
            grouprepository.updateGroup(group);
            grouprepository.close();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "true");

            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
//            System.out.println("UpdateGroup.java result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}