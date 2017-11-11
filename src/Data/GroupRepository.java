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
        String destination = group.getDestination();
        String begindate = group.getDestination();
        int membercount = group.getMembercount();
        int maxmembercount = group.getMaxmembercount();
        String manager = group.getManager();
        long timestamp = group.getTimestamp();
        stat.execute("insert into tourgroup(groupid,groupname,destination,begindate,"
                + "membercount,maxmembercount,manager,timestamp)values('" + groupid
                + "','" + groupname + "','" + destination + "','" + begindate + "',"
                + membercount + "," + maxmembercount + ",'" + manager + "',"
                + timestamp + ")");
        close();
    }

    public ArrayList<Group> getGroups(int offset, int num) throws SQLException {
        ArrayList<Group> ret = new ArrayList<Group>();
        ResultSet rs = stat.executeQuery("select * from tourgroup"
                + " order by timestamp desc limit offset - 1, num");
        while (rs.next()) {
            String groupid = rs.getString("groupid");
            String groupname = rs.getString("groupname");
            String destination = rs.getString("destination");
            String begindate = rs.getString("begindate");
            int membercount = rs.getInt("membercount");
            int maxmembercount = rs.getInt("maxmembercount");
            String manager = rs.getString("manager");
            long timestamp = rs.getLong("timestamp");
            Group group = new Group();
            group.setGroupid(groupid);
            group.setGroupname(groupname);
            group.setDestination(destination);
            group.setBegindate(begindate);
            group.setMembercount(membercount);
            group.setMaxmembercount(maxmembercount);
            group.setManager(manager);
            group.setTimestamp(timestamp);
            ret.add(group);
        }
        return ret;
    }
}
