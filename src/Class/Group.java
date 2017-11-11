package Class;

public class Group {
    private String groupid;         // 小組ID
    private String groupname;       // 组名
    private String destination;     // 目的地
    private String begindate;       // 出发日期
    private int membercount;        // 人数
    private int maxmembercount;     // 人数上限
    private String manager;         // 管理员
    private long timestamp;         // 时间戳
    public String getGroupid() {
        return groupid;
    }
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    public String getGroupname() {
        return groupname;
    }
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getBegindate() {
        return begindate;
    }
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }
    public int getMembercount() {
        return membercount;
    }
    public void setMembercount(int membercount) {
        this.membercount = membercount;
    }
    public int getMaxmembercount() {
        return maxmembercount;
    }
    public void setMaxmembercount(int maxmembercount) {
        this.maxmembercount = maxmembercount;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
