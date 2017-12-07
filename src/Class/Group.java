package Class;

public class Group {
    private String groupid;             // 小組ID
    private String groupname;           // 组名
    private String destprovince;        // 目的地(省份)
    private String destcity;            // 目的地(地市)
    private String departureprovince;   // 出发地(省份)
    private String departurecity;       // 出发地(地市)
    private String begindate;           // 出发日期
    private int membercount;            // 人数
    private int maxmembercount;         // 人数上限
    private String manager;             // 管理员
    private long timestamp;             // 时间戳
    private int completed;				// 是否结束
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
    public String getDestprovince() {
        return destprovince;
    }
    public void setDestprovince(String destprovince) {
        this.destprovince = destprovince;
    }
    public String getDestcity() {
        return destcity;
    }
    public void setDestcity(String destcity) {
        this.destcity = destcity;
    }
    public String getDepartureprovince() {
        return departureprovince;
    }
    public void setDepartureprovince(String departureprovince) {
        this.departureprovince = departureprovince;
    }
    public String getDeparturecity() {
        return departurecity;
    }
    public void setDeparturecity(String departurecity) {
        this.departurecity = departurecity;
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
    public int getCompleted() {
    	return this.completed;
    }
    public void setCompleted(int completed) {
		this.completed=completed;
	}
}
