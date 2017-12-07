package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Class.Groupmessage;

public class MessageRepository {
	Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public MessageRepository() throws ClassNotFoundException, SQLException {
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
    public void addMessage(Groupmessage message) throws SQLException {
    	int type=message.getTyepe();
    	String messageid=message.getMessageid();
		String groupid=message.getGroupid();
		String groupname=message.getGroupname();
		String sender=message.getSender();
		String receiver=message.getReceiver();
		int state=message.getState();
		String sql="insert into groupmessage(type,messageid,groupid,groupname,sender,receiver,state)values("+type+",'"+messageid+"','"+groupid+"','"+groupname+"','"+sender+"','"+receiver+"',"+state+")";
		stat.execute(sql);
	}
    public int getMessageNumber(String name) throws SQLException {
		int number=0;
    	String sql="select * from groupmessage where receiver='"+name+"'";
    	ResultSet rs=stat.executeQuery(sql);
    	while (rs.next()) {
    		if (rs.getInt("state")==0) {
				number++;
			}
		}
		return number;
	}
    public ArrayList<Groupmessage> getMessages(String name) throws SQLException {
    	ArrayList<Groupmessage> messages = new ArrayList<Groupmessage>();
    	Groupmessage aMessage;
    	String sql="select * from groupmessage where receiver='"+name+"'";
    	ResultSet rs=stat.executeQuery(sql);
    	while (rs.next()) {
    		aMessage = new Groupmessage();
			aMessage.setGroupid(rs.getString("groupid"));
			aMessage.setMessageid(rs.getString("messageid"));
			aMessage.setGroupname(rs.getString("groupname"));
			aMessage.setType(rs.getInt("type"));
			aMessage.setSender(rs.getString("sender"));
			aMessage.setReceiver(rs.getString("receiver"));
			aMessage.setState(rs.getInt("state"));
			messages.add(aMessage);
		}
    	return messages;
	}
    public Groupmessage getMessageByID(String messageID) throws SQLException {
    	Groupmessage message;
    	message=new Groupmessage();
    	String sql="select * from groupmessage where messageid='"+messageID+"'";
    	ResultSet rs=stat.executeQuery(sql);
    	while (rs.next()) {
			message.setGroupid(rs.getString("groupid"));
			message.setMessageid(rs.getString("messageid"));
			message.setGroupname(rs.getString("groupname"));
			message.setType(rs.getInt("type"));
			message.setSender(rs.getString("sender"));
			message.setReceiver(rs.getString("receiver"));
			message.setState(rs.getInt("state"));
		}
    	return message;
    }
    public void changeState(String messageid) throws SQLException {
    	String sql="update groupmessage set state=1 where messageid='"+messageid+"'";
    	System.err.println(sql);
    	stat.executeUpdate(sql);
    }
}
