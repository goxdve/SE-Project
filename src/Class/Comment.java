package Class;

public class Comment {
	private String groupid;             // 小組ID
    private String groupname;           // 组名
    private int score;				// 评分
    private String comment;				// 评论正文
    public String getGroupid() {
        return this.groupid;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public String getGroupname() {
        return this.groupname;
    }
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
