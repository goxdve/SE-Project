package Action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Class.Comment;
import Data.CommentRepository;
import Data.GroupRepository;
import net.sf.json.JSONObject;

public class NewComment extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7618221630962216201L;
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
			request=ServletActionContext.getRequest();
			String groupid=request.getParameter("groupid");
			GroupRepository groupRepository=new GroupRepository();
			String groupname=groupRepository.getgroup(groupid).getGroupname();
			Integer score=Integer.valueOf(request.getParameter("score"));
			String comment=URLDecoder.decode(request.getParameter("comment"), "UTF-8");
			Comment comment2=new Comment();
			comment2.setComment(comment);
			comment2.setGroupid(groupid);
			comment2.setGroupname(groupname);
			comment2.setScore(score);
			CommentRepository commentRepository=new CommentRepository();
			commentRepository.addComment(comment2);
			
			Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "true");
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "success";
    }
}
