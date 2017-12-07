package Action;

import Class.User;
import Data.UserRepository;


public class PerfectInformation {
    // 1.真实姓名;2.性别;3.年龄;4.电话号码;
    // 弄一个存个人信息的表，有默认值
    public String execute() throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setAge(newage);
        user.setSex(newsex);
        user.setSignature(newsignature);
        user.setTelephone(newtelephone);
        UserRepository userDao = new UserRepository();
        userDao.UpdateInformation(user);
        return "success";
    }

    private String username;
    private int newage;
    private int newsex;
    private String newtelephone;
    private String newsignature;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNewage() {
        return newage;
    }

    public void setNewage(int newage) {
        this.newage = newage;
    }

    public int getNewsex() {
        return newsex;
    }

    public void setNewsex(int newsex) {
        this.newsex = newsex;
    }

    public String getNewtelephone() {
        return newtelephone;
    }

    public void setNewtelephone(String newtelephone) {
        this.newtelephone = newtelephone;
    }

    public String getNewsignature() {
        return newsignature;
    }

    public void setNewsignature(String newsignature) {
        this.newsignature = newsignature;
    }

}
