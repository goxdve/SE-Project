package Class;

public class Note {
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
