package Action;

import java.sql.Date;
import java.sql.Time;

import org.apache.catalina.core.ApplicationFilterFactory;

import com.opensymphony.xwork2.ActionSupport;

import Data.SchemeRepository;
import Class.Scheme;

//beginDate暂时设为起始时间, 日后再改
public class NewScheme extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 6604812497924832449L;
    // 这一部分内容通过页面获取
    private String destination;     // 目的地
    private String beginDate;       // 起始日期
    private int duration;           // 持续时间: 1: 1-3天      2: 4-7天     3: 7天以上
    private String description;     // 详情
    private String schemeTitle;     // 标题
    
    // 这一部分属性在Action中获取 
    private String schemeID;        // 编号    
    private Date postDate;          // 发布日期
    private Time postTime;          // 发布时间
    private String ownerName;       // 发帖人ID
    
    public String getSchemeTitle() {
        return schemeTitle;
    }
    public void setSchemeTitle(String schemeTitle) {
        this.schemeTitle = schemeTitle;
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
    
    public String execute() throws Exception {
        Scheme scheme = new Scheme();
        scheme.setSchemeTitle(schemeTitle);
        scheme.setDestination(destination);
        scheme.setBeginDate(beginDate);
        scheme.setDuration(duration);
        scheme.setDescription(description);
        
        System.out.println(schemeTitle);
        System.out.println(destination);
        System.out.println(beginDate);
        System.out.println(duration);
        System.out.println(description);
        
        
        // 获取发布时间postDate和postTime
        java.util.Date now = new java.util.Date();
        postDate = new java.sql.Date(now.getTime());
        postTime = new java.sql.Time(now.getTime());
        scheme.setPostDate(postDate);
        scheme.setPostTime(postTime);
        
        // 根据发布时间生成帖子编号schemeID
        schemeID = postDate.toString() + postTime.toString();
        scheme.setSchemeID(schemeID);
        
        // ownerName = (String)ActionContext.getContext().getApplication().get("Username");
        ownerName = "testUser";
        scheme.setOwnerName(ownerName);
        
        SchemeRepository schemeDao = new SchemeRepository();
        schemeDao.addScheme(scheme);
        return SUCCESS;
    }
}