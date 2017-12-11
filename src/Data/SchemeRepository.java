package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Class.Scheme;

public class SchemeRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public SchemeRepository() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String username = "jx2k3j2zl4";
        String password = "iz3l1315y14mj00z32whz05hi4z5ymk12ixx12zj";
        String dbUrl = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf8",
                new Object[] { "w.rdc.sae.sina.com.cn", "3306", "app_lvba" });

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
                + "postTime,destprovince,destcity,beginDate,duration,description,"
                + "ownerName,timestamp,expenses,relatedgroupid,departureprovince," + "departurecity) VALUES('"
                + scheme.getSchemeID() + "', '" + scheme.getSchemeTitle() + "', '" + scheme.getPostDate() + "', '"
                + scheme.getPostTime() + "', '" + scheme.getDestprovince() + "', '" + scheme.getDestcity() + "', '"
                + scheme.getBeginDate() + "', " + scheme.getDuration() + ", '" + scheme.getDescription() + "', '"
                + scheme.getOwnerName() + "', " + scheme.getTimestamp() + ", " + scheme.getExpenses() + ", '"
                + scheme.getRelatedgroupid() + "', '" + scheme.getDepartureprovince() + "', '"
                + scheme.getDeparturecity() + "');");
    }

    public ArrayList<Scheme> getSchemes(String dest, String departure, String beginDate) throws SQLException, ParseException {
        ArrayList<Scheme> ret = new ArrayList<Scheme>();
        String sql = "select * from scheme";
        if (dest != "" || departure != "" || beginDate != "") {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = sdf.parse(beginDate);
		    Date date1 = new Date(date.getTime() - 24 * 60 * 60 * 1000);
		    Date date2 = new Date(date.getTime() + 24 * 60 * 60 * 1000);
		    String beginDate1 = sdf.format(date1);
		    String beginDate2 = sdf.format(date2);
            sql = sql + String.format(" where destprovince = '%s' and "
                            + "departureprovince = '%s' and "
                            + "(beginDate = '%s' or beginDate = '%s'"
                            + " or beginDate = '%s')", dest, departure, beginDate,
                            beginDate1, beginDate2);
        }
        sql = sql + " order by timestamp desc;";

        rs = stat.executeQuery(sql);
        while (rs.next()) {
            String schemeid = rs.getString("schemeID");
            String schemetitle = rs.getString("schemeTitle");
            String destprovince = rs.getString("destprovince");
            String destcity = rs.getString("destcity");
            int duration = rs.getInt("duration");
            String begindate = rs.getString("beginDate");
            String postdate = rs.getString("postDate");
            String posttime = rs.getString("postTime");
            String description = rs.getString("description");
            String owner = rs.getString("ownerName");
            String relatedgroupid = rs.getString("relatedgroupid");
            long timestamp = rs.getLong("timestamp");
            int expenses = rs.getInt("expenses");
            String departureprovince = rs.getString("departureprovince");
            String departurecity = rs.getString("departurecity");

            Scheme scheme = new Scheme();
            scheme.setSchemeID(schemeid);
            scheme.setSchemeTitle(schemetitle);
            scheme.setDestprovince(destprovince);
            scheme.setDestcity(destcity);
            scheme.setDuration(duration);
            scheme.setBeginDate(begindate);
            scheme.setPostDate(postdate);
            scheme.setPostTime(posttime);
            scheme.setDescription(description);
            scheme.setOwnerName(owner);
            scheme.setTimestamp(timestamp);
            scheme.setRelatedgroupid(relatedgroupid);
            scheme.setExpenses(expenses);
            scheme.setDepartureprovince(departureprovince);
            scheme.setDeparturecity(departurecity);
            ret.add(scheme);
        }
        return ret;
    }

    public int getSize() throws SQLException {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM scheme;";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount;
    }




     public Scheme getSchemeByID(String inputschemeid) throws Exception {
        Scheme scheme = new Scheme();
        String sql = String.format("SELECT * from scheme WHERE schemeid = \"%s\";", inputschemeid);
        rs = stat.executeQuery(sql);
        if (rs.next()) {
            String schemeid = rs.getString("schemeID");
            String schemetitle = rs.getString("schemeTitle");
            String destprovince = rs.getString("destprovince");
            String destcity = rs.getString("destcity");
            int duration = rs.getInt("duration");
            String begindate = rs.getString("beginDate");
            String postdate = rs.getString("postDate");
            String posttime = rs.getString("postTime");
            String description = rs.getString("description");
            String owner = rs.getString("ownerName");
            String relatedgroupid = rs.getString("relatedgroupid");
            long timestamp = rs.getLong("timestamp");
            int expenses = rs.getInt("expenses");
            String departureprovince = rs.getString("departureprovince");
            String departurecity = rs.getString("departurecity");

            scheme.setSchemeID(schemeid);
            scheme.setSchemeTitle(schemetitle);
            scheme.setDestprovince(destprovince);
            scheme.setDestcity(destcity);
            scheme.setDuration(duration);
            scheme.setBeginDate(begindate);
            scheme.setPostDate(postdate);
            scheme.setPostTime(posttime);
            scheme.setDescription(description);
            scheme.setOwnerName(owner);
            scheme.setTimestamp(timestamp);
            scheme.setRelatedgroupid(relatedgroupid);
            scheme.setExpenses(expenses);
            scheme.setDepartureprovince(departureprovince);
            scheme.setDeparturecity(departurecity);
        }
        return scheme;
    }   
    public ArrayList<Scheme> mySchemes(String username)throws Exception //获得一个人的全部计划
    {
    	ArrayList<Scheme> mySchemes=new ArrayList<Scheme>();
    	String SearchString = String.format("SELECT * from scheme WHERE ownerName = \"%s\";", username);
    	rs=stat.executeQuery(SearchString);
    	int mark;
    	while(rs.next())
    	{
    		mySchemes.add(new Scheme());
    		mark=mySchemes.size()-1;
    		mySchemes.get(mark).setSchemeID(rs.getString("schemeID"));
    		mySchemes.get(mark).setSchemeTitle(rs.getString("schemeTitle"));
    		mySchemes.get(mark).setDestprovince(rs.getString("destprovince"));
    		mySchemes.get(mark).setDestcity(rs.getString("destcity"));
    		mySchemes.get(mark).setDuration(rs.getInt("duration"));
    		mySchemes.get(mark).setBeginDate(rs.getString("beginDate"));
    		mySchemes.get(mark).setPostDate(rs.getString("postDate"));
    		mySchemes.get(mark).setPostTime(rs.getString("postTime"));
    		mySchemes.get(mark).setDescription(rs.getString("description"));
    		mySchemes.get(mark).setOwnerName(rs.getString("ownerName"));
    		mySchemes.get(mark).setTimestamp(rs.getLong("timestamp"));
    		mySchemes.get(mark).setRelatedgroupid(rs.getString("expenses"));
    		mySchemes.get(mark).setRelatedgroupid(rs.getString("relatedgroupid"));
    		mySchemes.get(mark).setDepartureprovince(rs.getString("departureprovince"));
    		mySchemes.get(mark).setDeparturecity(rs.getString("departurecity"));
    	}
    	close();
    	return mySchemes;
    }
    public void cancelscheme(String schemeID)throws Exception {
		String sql="delete from scheme where schemeID = '" + schemeID + "';";
		stat.execute(sql);
    }
}

