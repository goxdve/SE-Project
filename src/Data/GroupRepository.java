package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Class.Group;

public class GroupRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public GroupRepository() throws ClassNotFoundException, SQLException {
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

    public void addGroup(Group group) throws SQLException {
        String groupid = group.getGroupid();
        String groupname = group.getGroupname();
        String destprovince = group.getDestprovince();
        String destcity = group.getDestcity();
        String departureprovince = group.getDepartureprovince();
        String departurecity = group.getDeparturecity();
        String begindate = group.getBegindate();
        int completed=group.getCompleted();
        int membercount = group.getMembercount();
        int maxmembercount = group.getMaxmembercount();
        String manager = group.getManager();
        long timestamp = group.getTimestamp();
        String sql = String.format( "insert into tourgroup(groupid,groupname,"
                + "destprovince,destcity,begindate,membercount,maxmembercount,"
                + "manager,timestamp,departureprovince,departurecity,completed)values"
                + "(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%d,%d,\"%s\",%d,\"%s\",\"%s\",%d)",
                groupid, groupname, destprovince, destcity, begindate, membercount,
                maxmembercount, manager, timestamp, departureprovince, departurecity,completed);
        System.out.println("GroupRepository.java: sql = " + sql);
        stat.execute(sql);
    }

    public ArrayList<Group> getGroups(int offset, int num) throws SQLException {
        ArrayList<Group> ret = new ArrayList<Group>();
        ResultSet rs = stat.executeQuery(
                "select * from tourgroup order by timestamp desc limit " + (offset - 1) + ", " + num);
        while (rs.next()) {
            String groupid = rs.getString("groupid");
            String groupname = rs.getString("groupname");
            String destprovince = rs.getString("destprovince");
            String destcity = rs.getString("destcity");
            String departureprovince = rs.getString("departureprovince");
            String departurecity = rs.getString("departurecity");
            String begindate = rs.getString("begindate");
            int membercount = rs.getInt("membercount");
            int maxmembercount = rs.getInt("maxmembercount");
            String manager = rs.getString("manager");
            long timestamp = rs.getLong("timestamp");
            int completed = rs.getInt("completed");
            
            
            Group group = new Group();
            group.setGroupid(groupid);
            group.setGroupname(groupname);
            group.setDestcity(destcity);
            group.setDestprovince(destprovince);
            group.setDepartureprovince(departureprovince);
            group.setDeparturecity(departurecity);
            group.setBegindate(begindate);
            group.setMembercount(membercount);
            group.setMaxmembercount(maxmembercount);
            group.setManager(manager);
            group.setTimestamp(timestamp);
            group.setCompleted(completed);
            ret.add(group);
        }
        return ret;
    }

    public int getSize() throws SQLException {
        int rowCount = 0;
        String sql = "SELECT COUNT(*) FROM tourgroup;";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        return rowCount;
    }

    public boolean IsManager(String username, String groupid) throws Exception {
        boolean ret = false;
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from tourgroup WHERE groupid = \"%s\";", groupid);
        rs = stat.executeQuery(SearchString);
        if (rs.first() && rs.getString("manager").equals(username)) {
            ret = true;
        }
        return ret;
    }

    public Group getgroup(String groupid) throws Exception {
        Group ret = new Group();
        String sql = String.format("SELECT * from tourgroup WHERE groupid = \"%s\";", groupid);
        rs = stat.executeQuery(sql);
        if (rs.next()) {
            ret.setGroupid(rs.getString("groupid"));
            ret.setGroupname(rs.getString("groupname"));
            ret.setDestprovince(rs.getString("destprovince"));
            ret.setDestcity(rs.getString("destcity"));
            ret.setBegindate(rs.getString("begindate"));
            ret.setMembercount(rs.getInt("membercount"));
            ret.setMaxmembercount(rs.getInt("maxmembercount"));
            ret.setManager(rs.getString("manager"));
            ret.setTimestamp(rs.getInt("timestamp"));
            ret.setDepartureprovince(rs.getString("departureprovince"));
            ret.setDeparturecity(rs.getString("departurecity"));
            ret.setCompleted(rs.getInt("completed"));
        }
        return ret;
    }

    public void dismissgroup(String groupid) throws Exception {
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from tourgroup WHERE groupid = \"%s\";", groupid);
        rs = stat.executeQuery(SearchString);
        if (rs.first()) {
            rs.deleteRow();
            rs.refreshRow();
        }
        close();
    }

    public void updateGroup(Group group) throws Exception {
        String groupid = group.getGroupid();
        String groupname = group.getGroupname();
        String destprovince = group.getDestprovince();
        String destcity = group.getDestcity();
        String departureprovince = group.getDepartureprovince();
        String departurecity = group.getDeparturecity();
        String begindate = group.getBegindate();
        int membercount = group.getMembercount();
        int maxmembercount = group.getMaxmembercount();
        int completed = group.getCompleted();
        String manager = group.getManager();
        String sql = String.format(
                "update tourgroup set groupname=\"%s\"," + "destprovince=\"%s\","
                        + "destcity=\"%s\",begindate=\"%s\",membercount=%d,"
                        + "maxmembercount=%d,manager=\"%s\",departureprovince=\"%s\","
                        + "departurecity=\"%s\" ,completed= %d ,where groupid=\"%s\";",
                groupname, destprovince, destcity, begindate, membercount,
                maxmembercount, manager, departureprovince, departurecity, completed, groupid);
        stat.executeUpdate(sql);
    }
    
    public void completeGroupTravel(String groupid) throws Exception {
    	String sql="update tourgroup set completed=1 where groupid='"+groupid+"'";
    	stat.executeUpdate(sql);
    }
}
