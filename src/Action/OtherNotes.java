package Action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import Class.Note;
import Data.NoteRepository;

public class OtherNotes {
    public String username;
    public ArrayList<Note> allotherNotes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Note> getAllotherNotes() {
        return allotherNotes;
    }

    public void setAllotherNotes(ArrayList<Note> allotherNotes) {
        this.allotherNotes = allotherNotes;
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        username = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        NoteRepository noteRepository = new NoteRepository();
        setAllotherNotes(noteRepository.myNotes(username));

        return "success";
    }
}
