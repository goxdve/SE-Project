package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Class.Comment;

public class CommentRepository {
	Connection con = null;
    Statement stat = null;
    ResultSet rs = null;
    public CommentRepository() throws Exception {
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
    public void addComment(Comment aComment) throws Exception {
		String groupid=aComment.getGroupid();
		String groupname=aComment.getGroupname();
		int score=aComment.getScore();
		String comment=aComment.getComment();
		String sql="insert into comments(groupid,groupname,score,comment)values('"+groupid+"','"+groupname+"',"+score+",'"+comment+"')";
		GroupRepository groupRepository=new GroupRepository();
		groupRepository.addComment(aComment);
//		System.out.println("CommentRepository:"+sql);
		stat.execute(sql);
	}
    public ArrayList<String> getAllComments(String groupid) throws Exception {
    	ArrayList<String> allComments=new ArrayList<>();
    	String sql="select * from comments where groupid='"+groupid+"'";
    	rs=stat.executeQuery(sql);
    	while (rs.next()) {
			Comment newComment=new Comment();
			newComment.setComment(rs.getString("comment"));
			newComment.setGroupid(rs.getString("groupid"));
			newComment.setGroupname(rs.getString("groupname"));
			newComment.setScore(rs.getInt("score"));
			allComments.add(newComment.getComment());
		}
    	return allComments;
	}
}
