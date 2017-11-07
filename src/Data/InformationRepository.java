package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class InformationRepository
{
    private static Connection conn = null;
    private static Statement stmt=null;
    private static String SearchString=null;
    private static ResultSet rs=null;
    String ul = "jdbc:mysql://localhost:3306/project";
    String ue = "root";
    String pw = "LvbaProject";

    public HashMap<String,Object> Information(String Username) throws Exception
    {
        HashMap<String,Object> information = new HashMap<String, Object>();
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(ul,ue,pw);
        stmt=conn.createStatement();
        SearchString=String.format("SELECT * from Information WHERE Username = \"%s\";", Username);
        rs=stmt.executeQuery(SearchString);
//        setRightname((String)information.get("rightname"));
//        setSex((String)information.get("sex"));
//        setAge((int)information.get("age"));
//        setTelephone((String) information.get("telephone"));
        information.put("rightname",rs.getString(1));
        information.put("sex",rs.getString(2));
        information.put("age",rs.getInt(3));
        information.put("telephone",rs.getString(4));
        rs.close();
        stmt.close();
        conn.close();
        return information;
    }
    public void ChangeInformation(HashMap<String,Object> NewInformation) throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(ul,ue,pw);
        stmt=conn.createStatement();
        SearchString=String.format("SELECT * from Information WHERE Username = \"%s\";",NewInformation.get("Username"));
        rs=stmt.executeQuery(SearchString);
        rs.updateString(2, (String)NewInformation.get("rightname"));
        rs.updateString(3, (String)NewInformation.get("sex"));
        rs.updateInt(4, (int)NewInformation.get("age"));
        rs.updateString(2, (String)NewInformation.get("telephone"));
        rs.close();
        stmt.close();
        conn.close();
    }
}
