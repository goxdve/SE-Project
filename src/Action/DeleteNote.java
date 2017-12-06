package Action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Data.NoteRepository;
import net.sf.json.JSONObject;

public class DeleteNote {
	private String noteID;
	public String result;
	public void setNoteID(String noteID) {
		this.noteID=noteID;
	}
	public String getNoteID() {
		return this.noteID;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute() throws ClassNotFoundException, SQLException {
		try {
//			System.out.println(noteID);
			NoteRepository noteRepository=new NoteRepository();
			noteRepository.deleteNote(noteID);
			
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
