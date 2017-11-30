package Action;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Class.Note;
import Data.NoteRepository;

@SuppressWarnings("serial")
public class SaveNote extends ActionSupport{
	private String noteID;//游记的主键
	private String noteTitle;//题目
	private String travelNote;//富文本内容
	private String ownerName;//作者
	private String noteTime;//发布时间
	public String execute() throws ClassNotFoundException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getParameter("editorValue"));
		java.util.Date now=new java.util.Date();
		java.sql.Date date=new java.sql.Date(now.getTime());
		java.sql.Time time=new java.sql.Time(now.getTime());
		noteID=UUID.randomUUID().toString().replace("-", "");
		noteTime=date.toString()+"  "+time.toString();
		travelNote=request.getParameter("editorValue");
		Note note=new Note();
		note.setNoteID(noteID);
		note.setNoteTitle(noteTitle);
		note.setTravelNote(travelNote);
		note.setOwnerName(ownerName);
//		note.setNoteTime(noteTime);
		NoteRepository noteRepository=new NoteRepository();
		if (noteRepository.addNote(note)) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	public void setNoteID(String noteID) {
		this.noteID=noteID;
	}
	public String getNoteID() {
		return this.noteID;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle=noteTitle;
	}
	public String getNoteTitle() {
		return this.noteTitle;
	}
	public void setTravelNote(String travelNote) {
		this.travelNote=travelNote;
	}
	public String getTravelNote() {
		return this.travelNote;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName=ownerName;
	}
	public String getOwnerName() {
		return this.ownerName;
	}
	public void setNoteTime(String noteTime) {
		this.noteTime=noteTime;
	}
	public String getNoteTime() {
		return this.noteTime;
	}
}
