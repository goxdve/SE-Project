package Action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Class.Note;
import Data.NoteRepository;

public class NewNote extends ActionSupport{

	public String execute() throws ClassNotFoundException, SQLException {
		java.util.Date now=new java.util.Date();
		java.sql.Date date=new java.sql.Date(now.getTime());
		java.sql.Time time=new java.sql.Time(now.getTime());
		noteID=date.toString().replace("-", "")+time.toString().replace(":", "");
		noteTime=time;
		Note note=new Note();
		note.setNoteID(noteID);
		note.setNoteTitle(noteTitle);
		note.setTravelNote(travelNote);
		note.setOwnerName(ownerName);
		note.setNoteTime(noteTime);
		NoteRepository noteRepository=new NoteRepository();
		if (noteRepository.addNote(note)) {
			return SUCCESS;
		}else {
			return ERROR;
		}
		
	}
	private String noteID;//游记的主键
	private String noteTitle;//题目
	private String travelNote;//富文本内容
	private String ownerName;//作者
	private java.sql.Time noteTime;//发布时间
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
	public void setNoteTime(java.sql.Time noteTime) {
		this.noteTime=noteTime;
	}
	public java.sql.Time getNoteTime() {
		return this.noteTime;
	}
	
}
