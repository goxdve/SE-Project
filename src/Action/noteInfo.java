package Action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Data.NoteRepository;

public class noteInfo extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public String execute() throws ClassNotFoundException, SQLException {
		NoteRepository noteRepository=new NoteRepository();
		noteRepository.oneNoteInfo(name);
		return SUCCESS;
	}
	public void setName(String name) {
		name=name.replace("-", "");
		name=name.replace(":", "");
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
}
