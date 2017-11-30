package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String groupid=message.getGroupid();
		String sender=message.getSender();
		String receiver=message.getReceiver();
		int state=message.getState();
		String sql="insert into groupmessage(type,groupid,sender,receiver,state)values("+type+",'"+groupid+"','"+sender+"','"+receiver+"',"+state+")";
		System.err.println(sql);
		stat.execute(sql);
	}
}
