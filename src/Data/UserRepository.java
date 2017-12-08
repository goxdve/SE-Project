package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String telephone = "";
        String signature = "";
        ResultSet result = stat.executeQuery("select * from user where username='" + username + "'");
        if (result.next()) {
            return false;
        }
        String sql = String.format("insert into user(username,password,age,sex,telephone,"
                + "signature,thumbupnum)values('%s','%s',%d,%d,'%s','%s',%d);", username,
                password,age,sex,telephone,signature,0);
        stat.executeUpdate(sql);
        return true;
    }

    public boolean Login(String username, String password) throws Exception {
        ResultSet rs = stat.executeQuery("select * from user where username='" + username + "'");
        if (rs.next()) {
            if (rs.getString(2).equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void UpdateInformation(User user) throws Exception {
        String sql = String.format(
                "update user set telephone='%s',signature='%s',sex=%d,"
                        + "age=%d where username='%s';",
                        user.getTelephone(),
                        user.getSignature(),
                        user.getSex(),
                        user.getAge(),
                        user.getUsername());
        stat.executeUpdate(sql);
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
            ret.setTelephone(rs.getString("telephone"));
            ret.setSignature(rs.getString("signature"));
            ret.setThumbupnum(rs.getInt("thumbupnum"));
        }
        return ret;
    }
    public boolean ContainsUser(String username) throws Exception {
        String sql = String.format("SELECT COUNT(*) FROM user WHERE username = '%s';", username);
        int rowCount = 0;
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount != 0;
    }
    public void ThumbUp(User user) throws Exception {
        String sql = String.format("update user set thumbupnum = %d where username = '%s';",
                user.getThumbupnum() + 1, user.getUsername());
        System.out.println("Data/UserRepository.java: sql = " + sql);
        stat.executeUpdate(sql);
    }
}