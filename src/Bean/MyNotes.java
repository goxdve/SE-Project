package Bean;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Note;
import Data.NoteRepository;

public class MyNotes 
{
	public ArrayList<Note> allmynotes;
	public boolean loggedin;
	public ArrayList<Note> getAllmynotes() {
		return allmynotes;
	}
	public void setAllmynotes(ArrayList<Note> allmynotes) {
		this.allmynotes = allmynotes;
	}
	public boolean isLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	public MyNotes()throws Exception
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
        if (!session1.containsKey("username")) {
            loggedin = false;
            return;
        }
        loggedin = true;
        String username = (String)session1.get("username");
        
        NoteRepository noteRepository = new NoteRepository();
        setAllmynotes(noteRepository.myNotes(username));
	}
}
