package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public void addScheme(Scheme scheme) throws SQLException {
        stat.execute("INSERT INTO scheme(schemeID,schemeTitle,postDate,"
                + "postTime,destination,beginDate,duration,description,"
                + "ownerName,timestamp) VALUES('" + scheme.getSchemeID()
                + "', '" + scheme.getSchemeTitle() + "', '"+ scheme.getPostDate()
                + "', '"+ scheme.getPostTime() + "', '" + scheme.getDestination()
                + "', '" + scheme.getBeginDate() + "', '" + scheme.getDuration()
                + "', '"+ scheme.getDescription() + "', '" + scheme.getOwnerName()
                + "', " + scheme.getTimestamp() + ");");
    }
    
    public ArrayList<Scheme> getSchemes(int offset, int num) throws SQLException {
        ArrayList<Scheme> ret = new ArrayList<Scheme>();
        rs = stat.executeQuery("select * from scheme"
                + " order by timestamp desc limit " +  (offset - 1) +
                ", " + num + "");
        while (rs.next()) {
            String schemeid = rs.getString("schemeID");
            String schemetitle = rs.getString("schemeTitle");
            String destination = rs.getString("destination");
            int duration = rs.getInt("duration");
            String begindate = rs.getString("beginDate");
            String postdate = rs.getString("postDate");
            String posttime = rs.getString("postTime");
            String description = rs.getString("description");
            String owner = rs.getString("ownerName");
            long timestamp = rs.getLong("timestamp");

            Scheme scheme = new Scheme();
            scheme.setSchemeID(schemeid);
            scheme.setSchemeTitle(schemetitle);
            scheme.setDestination(destination);
            scheme.setDuration(duration);
            scheme.setBeginDate(begindate);
            scheme.setPostDate(postdate);
            scheme.setPostTime(posttime);
            scheme.setDescription(description);
            scheme.setOwnerName(owner);
            scheme.setTimestamp(timestamp);
            
            ret.add(scheme);
        }
        return ret;
    }
    
    public int getSize() throws SQLException{
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM scheme;";  
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount;  
    }  
}