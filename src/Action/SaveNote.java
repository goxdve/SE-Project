package Action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import Class.Note;
import Data.NoteRepository;
import net.sf.json.JSONObject;

//@SuppressWarnings("serial")
//public class SaveNote extends ActionSupport{
//	private String noteID;//游记的主键
//	private String noteTitle;//题目
//	private String travelNote;//富文本内容
//	private String ownerName;//作者
//	private String noteTime;//发布时间
//	public String execute() throws ClassNotFoundException, SQLException {
//		HttpServletRequest request=ServletActionContext.getRequest();
//		System.out.println(request.getParameter("editorValue"));
//		java.util.Date now=new java.util.Date();
//		java.sql.Date date=new java.sql.Date(now.getTime());
//		java.sql.Time time=new java.sql.Time(now.getTime());
//		noteID=UUID.randomUUID().toString().replace("-", "");
//		noteTime=date.toString()+"  "+time.toString();
//		travelNote=request.getParameter("editorValue");
//		Note note=new Note();
//		note.setNoteID(noteID);
//		note.setNoteTitle(noteTitle);
//		note.setTravelNote(travelNote);
//		note.setOwnerName(ownerName);
//		note.setNoteTime(noteTime);
//		NoteRepository noteRepository=new NoteRepository();
//		if (noteRepository.addNote(note)) {
//			return SUCCESS;
//		}else {
//			return ERROR;
//		}
//	}
//	public void setNoteID(String noteID) {
//		this.noteID=noteID;
//	}
//	public String getNoteID() {
//		return this.noteID;
//	}
//	public void setNoteTitle(String noteTitle) {
//		this.noteTitle=noteTitle;
//	}
//	public String getNoteTitle() {
//		return this.noteTitle;
//	}
//	public void setTravelNote(String travelNote) {
//		this.travelNote=travelNote;
//	}
//	public String getTravelNote() {
//		return this.travelNote;
//	}
//	public void setOwnerName(String ownerName) {
//		this.ownerName=ownerName;
//	}
//	public String getOwnerName() {
//		return this.ownerName;
//	}
//	public void setNoteTime(String noteTime) {
//		this.noteTime=noteTime;
//	}
//	public String getNoteTime() {
//		return this.noteTime;
//	}
//}
public class SaveNote extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 4161105316627880009L;
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
            request = ServletActionContext.getRequest();
            System.out.println("SaveNote.java: request = " + request);
            String travelNote = URLDecoder.decode(request.getParameter("editorValue"), "UTF-8");
            String noteTitle = URLDecoder.decode(request.getParameter("noteTitle"), "UTF-8");
            String ownerName = URLDecoder.decode(request.getParameter("ownerName"), "UTF-8");

            java.util.Date now = new java.util.Date();
            java.sql.Date date = new java.sql.Date(now.getTime());
            java.sql.Time time = new java.sql.Time(now.getTime());
            String noteID = UUID.randomUUID().toString().replace("-", "");
            String noteTime = date.toString() + "  " + time.toString();
            Note note = new Note();
            note.setNoteID(noteID);
            note.setNoteTitle(noteTitle);
            note.setTravelNote(travelNote);
            note.setOwnerName(ownerName);
            note.setNoteTime(noteTime);
            NoteRepository noteRepository = new NoteRepository();
            Map<String, Object> map = new HashMap<String, Object>();
            if (noteRepository.addNote(note)) {
                map.put("success", "true");
            } else {
                map.put("success", "false");
            }
            JSONObject json = JSONObject.fromObject(map);
            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

}