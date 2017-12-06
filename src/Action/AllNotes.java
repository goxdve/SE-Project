package Action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import Data.NoteRepository;

public class AllNotes extends ActionSupport{
	/**
     * 
     */
    private static final long serialVersionUID = -416565058314169242L;

    public String execute() throws ClassNotFoundException, SQLException {
		NoteRepository noteRepository=new NoteRepository();
		noteRepository.showAll();
		return SUCCESS;
	}
}
