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

import org.apache.catalina.core.ApplicationContext;

import Class.Scheme;

public class SchemeRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public SchemeRepository() throws ClassNotFoundException, SQLException {
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

    public void picture(File file, int id) throws SQLException, IOException {
        FileInputStream in = null;
        in = new FileInputStream(file);
        String sql = "update user set picture = ? where id = " + id;
        System.out.println(id);
        PreparedStatement ps = this.con.prepareStatement(sql);
        System.out.println(in.toString());
        ps.setBinaryStream(1, in, in.available());
        ps.executeUpdate();
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

    public void addScheme(Scheme scheme) throws SQLException {
        stat.execute("INSERT INTO scheme(schemeID,schemeTitle,postDate,postTime,destination,beginDate,"
                + "duration,description,ownerName) VALUES('" + scheme.getSchemeID() + "', '" + scheme.getSchemeTitle()
                + "', '" + scheme.getPostDate() + "', '" + scheme.getPostTime() + "', '" + scheme.getDestination()
                + "', '" + scheme.getBeginDate() + "', '" + scheme.getDuration() + "', '" + scheme.getDescription()
                + "', '" + scheme.getOwnerName() + "');");
    }

}