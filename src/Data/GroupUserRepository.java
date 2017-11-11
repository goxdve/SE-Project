package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void addGroupUser(String groupid, String username) throws SQLException {
        stat.execute("INSERT INTO groupuser(groupid,username) VALUES('" + groupid
                + "', '" + username + "');");
        close();
    }

}
