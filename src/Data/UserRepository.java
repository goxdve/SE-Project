package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import Class.User;

public class UserRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public UserRepository() throws ClassNotFoundException, SQLException {
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
        String sql = "insert into user(username,password,age,sex)values('" + username + "','" + password + "'," + age
                + "," + sex + ")";
        stat.executeUpdate(sql);
        close();

        return true;
    }

    public boolean Login(String username, String password) throws Exception {
        ResultSet rs = stat.executeQuery("select * from user where username='" + username + "'");
        if (rs.next()) {
            if (rs.getString(2).equals(password)) {
                ActionContext ac = ActionContext.getContext();
                Map<String, Object> session1 = ac.getSession();
                session1.put("username", username);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public HashMap<String, Object> SearchInformation() throws Exception {
        HashMap<String, Object> ret = new HashMap<String, Object>();
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> session1 = ac.getSession();
        String username = (String) session1.get("username");
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from user WHERE username = \"%s\";", username);
        rs = stat.executeQuery(SearchString);
        rs.first();
        ret.put("password", rs.getString(2));
        ret.put("age", rs.getInt(3));
        ret.put("sex", rs.getInt(4));
        rs.close();
        stat.close();
        close();
        return ret;
    }

    public void UpdateInformation(HashMap<String, Object> newinformation) throws Exception {
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> session1 = ac.getSession();
        String username = (String) session1.get("username");
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from user WHERE username = \"%s\";", username);
        rs = stat.executeQuery(SearchString);
        rs.first();
        rs.updateString(2, (String) newinformation.get("newpassword"));
        rs.updateInt(3, (int) newinformation.get("newage"));
        rs.updateInt(4, (int) newinformation.get("newsex"));
        rs.updateRow();
        rs.close();
        stat.close();
        close();
    }

    public User getUser(String username) throws Exception {
        String sql = String.format("select * from user where username = \"%s\";", username);
        ResultSet rs = stat.executeQuery(sql);
        User ret = new User();
        if (rs.next()) {
            ret.setUsername(username);
            ret.setPassword(rs.getString("password"));
            ret.setAge(rs.getInt("age"));
            ret.setSex(rs.getInt("sex"));
        }
        return ret;
    }
}