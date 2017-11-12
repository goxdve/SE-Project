package Action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Data.NoteRepository;

public class AllNotes extends ActionSupport{
	public String execute() throws ClassNotFoundException, SQLException {
		NoteRepository noteRepository=new NoteRepository();
		noteRepository.showAll();
		return SUCCESS;
	}
}
