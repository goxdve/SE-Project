package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Group;


public class OtherGroups {
    public String username;
    public ArrayList<Group> allotherGroups;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Group> getAllotherGroups() {
        return allotherGroups;
    }

    public void setAllotherGroups(ArrayList<Group> allotherGroups) {
        this.allotherGroups = allotherGroups;
    }

    public String execute() throws Exception {
        GroupUserRepository groupUserRepository = new GroupUserRepository();
        GroupRepository groupRepository = new GroupRepository();
        ArrayList<String> mygroupid= groupUserRepository.mygroupid(username);
        allotherGroups= new ArrayList<Group>();
        for(int i=0;i<mygroupid.size();++i)
        {
        	allotherGroups.add(groupRepository.getgroup(mygroupid.get(i)));
        }
        return "success";
    }
}
