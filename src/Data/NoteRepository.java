package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;

import Class.Note;

public class NoteRepository {
	Connection con = null;
    Statement stat = null;
    ResultSet rs = null;
    
    public NoteRepository() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "123456";
        String dbUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf8",
                new Object[] { "localhost", "3306", "tourba" });

        Class.forName(driver);
        this.con = DriverManager.getConnection(dbUrl, username, password);
        this.stat = this.con.createStatement();
    }
    
    public void close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
    
    public boolean addNote(Note note){
    	String noteID=note.getNoteID();
    	String noteTitle=note.getNoteTitle();
    	String travelNote=note.getTravelNote();
    	String ownerName=note.getOwnerName();
    	String noteTime=note.getNoteTime();
    	String sql="insert into note(noteID,noteTitle,travelNote,ownerName,noteTime)values('"+noteID+"','"+noteTitle+"','"+travelNote+"','"+ownerName+"','"+noteTime+"')";
		try {
			stat.execute(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
    public boolean showAll() throws SQLException {
    	String sql="select * from note";
    	rs=stat.executeQuery(sql);
    	ArrayList<Note> noteList=new ArrayList<Note>();
    	while (rs.next()) {
			Note n = new Note();
			n.setNoteID(rs.getString(1));
			n.setNoteTitle(rs.getString(2));
			n.setTravelNote(rs.getString(3));
			n.setOwnerName(rs.getString(4));
			n.setNoteTime(rs.getString(5));
			noteList.add(n);
		}
    	ActionContext.getContext().put("noteList", noteList);
    	return true;
    }
    public boolean oneNoteInfo(String noteID) throws SQLException {
		String sql="select * from note where noteID='"+noteID+"'";
		rs=stat.executeQuery(sql);
		if (rs.next()) {
			Note note=new Note();
			note.setNoteID(rs.getString(1));
			note.setNoteTitle(rs.getString(2));
			note.setTravelNote(rs.getString(3));
			note.setOwnerName(rs.getString(4));
			note.setNoteTime(rs.getString(5));
			ActionContext.getContext().put("aNote", note);
		}
		return true;
	}
}
