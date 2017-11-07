package Data;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import Class.*;
public class PersonalSchemeRepository
{
    private static Connection conn = null;
    private static Statement stmt=null;
    private static String SearchString=null;
    private static ResultSet rs=null;
    String ul = "jdbc:mysql://localhost:3306/project";
    String ue = "root";
    String pw = "LvbaProject";
    public ArrayList<Scheme> PersonalSchemes(String Username) throws Exception
    {
        ArrayList<Scheme> personalSchemes = new ArrayList<Scheme>();
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(ul,ue,pw);
        stmt=conn.createStatement();
        SearchString=String.format("SELECT * from PersonalSchemes WHERE Username = \"%s\";", Username);
        rs=stmt.executeQuery(SearchString);
        while(rs.next())
        {
            personalSchemes.add(new Scheme(rs.getDate("id")
                    ,rs.getString("Username")
                    ,rs.getDate("date")
                    ,rs.getInt("price")
                    ,rs.getString("location")
                    ,rs.getInt("duration")
                    ,rs.getString("content")));
            
        }
        return  personalSchemes;
    }
                                    //    private Date id;//发帖日期
                                    //    private String Username;//发帖用户名
                                    //    private Date date;//旅游开始时间
                                    //    private int price;//驴友消费
                                    //    private String location;//旅游地点（大致地点）
                                    //    private int duration;//旅行总时间（暂且认为是天数）
                                    //    private String content;//详情
}
