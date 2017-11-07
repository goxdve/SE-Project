package Class;

import java.sql.Time;
import java.sql.Date;

// beginDate暂时设为起始时间, 日后再改
public class Scheme {
    private String schemeID; // 编号
    private String schemeTitle; // 标题
    private java.sql.Date postDate; // 发布日期
    private java.sql.Time postTime; // 发布时间
    private String destination; // 目的地
    private String beginDate; // 起始日期
    private int duration; // 持续时间: 1: 1-3天 2: 4-7天 3: 7天以上
    private String description; // 详情
    private String ownerName; // 发帖人用户名

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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Time getPostTime() {
        return postTime;
    }

    public void setPostTime(Time postTime) {
        this.postTime = postTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

}