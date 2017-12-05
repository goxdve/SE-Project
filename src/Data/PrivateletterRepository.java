package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Class.Privateletter;

public class PrivateletterRepository {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public PrivateletterRepository() throws ClassNotFoundException, SQLException {
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

    public void SendPrivateLetter(Privateletter privateletter) throws Exception {
        stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SearchString = String.format("SELECT * from privateletter;");
        rs = stat.executeQuery(SearchString);
        rs.moveToInsertRow();

        rs.updateString("privateletterID", privateletter.privateletterID);
        rs.updateString("username", privateletter.username);
        rs.updateString("receiver", privateletter.receiver);
        rs.updateString("sender", privateletter.sender);
        rs.updateString("privateletterTitle", privateletter.privateletterTitle);
        rs.updateString("privateletterTime", privateletter.privateletterTime);
        rs.updateString("content", privateletter.content);
        rs.updateLong("timestamp", privateletter.timestamp);

        rs.insertRow();
        rs.close();
        stat.close();
        close();
    }

    public void DeletePrivateLetter(String privateletterID) throws Exception {
        String sql = String.format("delete from privateletter where privateletterID = '%s';",
                privateletterID);
        stat.executeUpdate(sql);
    }

    public ArrayList<Privateletter> MyReceivedPrivateLetter(String username) throws Exception {
        ArrayList<Privateletter> myreceivedPrivateletter = new ArrayList<Privateletter>();
        String SearchString = String
                .format("SELECT * from privateletter WHERE username = \"%s\" order by timestamp desc;", username);
        rs = stat.executeQuery(SearchString);
        int mark;
        while (rs.next()) {
            if (rs.getString("receiver").equals(username)) {
                myreceivedPrivateletter.add(new Privateletter());
                mark = myreceivedPrivateletter.size() - 1;
                myreceivedPrivateletter.get(mark).setPrivateletterID(rs.getString("privateletterID"));
                myreceivedPrivateletter.get(mark).setUsername(rs.getString("username"));
                myreceivedPrivateletter.get(mark).setReceiver(rs.getString("receiver"));
                myreceivedPrivateletter.get(mark).setSender(rs.getString("sender"));
                myreceivedPrivateletter.get(mark).setPrivateletterTitle(rs.getString("privateletterTitle"));
                myreceivedPrivateletter.get(mark).setPrivateletterTime(rs.getString("privateletterTime"));
                myreceivedPrivateletter.get(mark).setContent(rs.getString("content"));
                myreceivedPrivateletter.get(mark).setTimestamp(rs.getLong("timestamp"));
            }
        }
        rs.close();
        stat.close();
        close();
        return myreceivedPrivateletter;
    }

    public ArrayList<Privateletter> MySendedPrivateLetter(String username) throws Exception {
        ArrayList<Privateletter> mysendedPrivateletter = new ArrayList<Privateletter>();
        String SearchString = String
                .format("SELECT * from privateletter WHERE username = \"%s\" order by timestamp desc;", username);
        rs = stat.executeQuery(SearchString);
        int mark;
        while (rs.next()) {
            if (rs.getString("sender").equals(username)) {
                mysendedPrivateletter.add(new Privateletter());
                mark = mysendedPrivateletter.size() - 1;
                mysendedPrivateletter.get(mark).setPrivateletterID(rs.getString("privateletterID"));
                mysendedPrivateletter.get(mark).setUsername(rs.getString("username"));
                mysendedPrivateletter.get(mark).setReceiver(rs.getString("receiver"));
                mysendedPrivateletter.get(mark).setSender(rs.getString("sender"));
                mysendedPrivateletter.get(mark).setPrivateletterTitle(rs.getString("privateletterTitle"));
                mysendedPrivateletter.get(mark).setPrivateletterTime(rs.getString("privateletterTime"));
                mysendedPrivateletter.get(mark).setContent(rs.getString("content"));
                mysendedPrivateletter.get(mark).setTimestamp(rs.getLong("timestamp"));
            }
        }
        rs.close();
        stat.close();
        close();
        return mysendedPrivateletter;
    }

    public Privateletter getPrivateletter(String privateletterID) throws Exception {
        Privateletter privateletter = new Privateletter();
        String SearchString = String.format("SELECT * from privateletter WHERE privateletterID = \"%s\";",
                privateletterID);
        rs = stat.executeQuery(SearchString);
        if (rs.first()) {
            privateletter.setPrivateletterID(rs.getString("privateletterID"));
            privateletter.setUsername(rs.getString("username"));
            privateletter.setReceiver(rs.getString("receiver"));
            privateletter.setSender(rs.getString("sender"));
            privateletter.setPrivateletterTitle(rs.getString("privateletterTitle"));
            privateletter.setPrivateletterTime(rs.getString("privateletterTime"));
            privateletter.setContent(rs.getString("content"));
            privateletter.setTimestamp(rs.getLong("timestamp"));
            return privateletter;
        }
        return null;
    }
}
