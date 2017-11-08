package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionContext;

import Class.User;

public class UserRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public UserRepository() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "XUNmeng..";
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

    public boolean execute(String sql) throws SQLException {
        return this.stat.execute(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return this.stat.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        this.stat.executeUpdate(sql);
    }

    public boolean register(User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        int age = user.getAge();
        int sex = user.getSex();
        ResultSet result = stat.executeQuery("select * from user where username='" + username + "'");
        if (result.next()) {
            close();
            return false;
        }
        String sql = "insert into user(username,password,age,sex)values('" + username
                + "','" + password + "'," + age + "," + sex + ")";
        stat.executeUpdate(sql);
        close();
        
        return true;
    }
    
    public boolean Login(String username,String password) throws Exception {
    	ResultSet rs=stat.executeQuery("select * from user where username='" + username + "'");
    	System.out.println(username);
    	if (rs.next()) {
    		System.out.println(rs.getString(2));
			if(rs.getString(2).equals(password)) {
				ActionContext ac=ActionContext.getContext();
				Map<String, Object> session1=ac.getSession();
				session1.put("username", username);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
    }

}