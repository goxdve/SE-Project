package Class;

public class Scheme {
    private String schemeID;        // 编号
    private String schemeTitle;     // 标题
    private String postDate;        // 发布日期
    private String postTime;        // 发布时间
    private String destprovince;    // 目的地省份
    private String destcity;        // 目的地地市
    private String departureprovince;    // 目的地省份
    private String departurecity;        // 目的地地市
    private String beginDate;       // 起始日期
    private int duration;           // 持续时间: 1. 1-3天   2. 4-7天    3. 7天以上
    private String description;     // 详情
    private String ownerName;       // 发帖人用户名
    private long timestamp;         // 时间戳
    private int expenses;           // 预计开销: 1. 0-500  2. 500-1000   3. 1000-2000   4. 2000以上   
    private String relatedgroupid;  // 关联小组id
    
    public String getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public String getSchemeTitle() {
        return schemeTitle;
    }

    public void setSchemeTitle(String schemeTitle) {
        this.schemeTitle = schemeTitle;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public String getRelatedgroupid() {
        return relatedgroupid;
    }

    public void setRelatedgroupid(String relatedgroupid) {
        this.relatedgroupid = relatedgroupid;
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
    
}
