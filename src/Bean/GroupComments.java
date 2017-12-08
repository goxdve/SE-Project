package Bean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import Data.CommentRepository;

public class GroupComments {
	private ArrayList<String> comments;
	public void setComments(ArrayList<String> comments) {
		this.comments=comments;
	}
	public ArrayList<String> getComments() {
		return this.comments;
	}
	public GroupComments() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
        String groupid = request.getParameter("groupid");
        CommentRepository commentRepository=new CommentRepository();
        comments=commentRepository.getAllComments(groupid);
	}
}
