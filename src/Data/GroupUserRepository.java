package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import Class.Groupmessage;


public class GroupUserRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public GroupUserRepository() throws ClassNotFoundException, SQLException {
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

    public boolean isInGroup(String groupid, String username) throws SQLException {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM groupuser where groupid = '" + groupid + "' and username = '" + username
                + "'";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount != 0;
    }

    public void addGroupUser(String groupid, String username) throws SQLException {
        stat.execute("INSERT INTO groupuser(groupid,username) VALUES('" + groupid
                + "', '" + username + "');");
    }

    public ArrayList<String> getUsernames(String groupid) throws Exception {
        ArrayList<String> ret = new ArrayList<String>();
        String sql = String.format("select * from groupuser where groupid = \"%s\";", groupid);
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {
            ret.add(rs.getString("username"));
        }
        return ret;
    }
    
    public ArrayList<String> mygroupid(String username) throws Exception {
        ArrayList<String> ret = new ArrayList<String>();
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from groupuser WHERE username = \"%s\";", username);
        rs = stat.executeQuery(SearchString);
        while (rs.next()) {
            ret.add(rs.getString("groupid"));
        }
        rs.close();
        stat.close();
        return ret;
    }

    public void quitgroup(String username, String groupid) throws Exception {
        String sql = String.format("delete from groupuser WHERE username = \"%s\""
                + " and groupid = \"%s\";", username, groupid);
        stat.executeUpdate(sql);
    }

    public void dismissgroup(String groupid) throws Exception {
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("DELETE FROM groupuser WHERE groupid = \"%s\"", groupid);
        stat.executeUpdate(SearchString);
        stat.close();
    }
    
    public void inviteComment(String groupid) throws Exception {
    	String sql="select * from groupuser where groupid='"+groupid+"'";
    	rs=stat.executeQuery(sql);
    	MessageRepository messageRepository=new MessageRepository();
    	GroupRepository groupRepository=new GroupRepository();
    	while(rs.next()) {
    		Groupmessage message=new Groupmessage();
    		message.setGroupid(groupid);
    		message.setGroupname(groupRepository.getgroup(groupid).getGroupname());
    		message.setMessageid(UUID.randomUUID().toString().replace("-", ""));
    		message.setSender(groupRepository.getgroup(groupid).getManager());
    		String name=rs.getString("username");
    		if (name.equals(groupRepository.getgroup(groupid).getManager())==false) {
    			message.setReceiver(name);
			} else {
				continue;
			}
    		message.setState(0);
    		message.setType(3);
    		messageRepository.addMessage(message);
    	}
    }
}