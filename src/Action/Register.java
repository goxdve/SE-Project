package Action;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;

import Data.UserRepository;
import Class.User;

public class Register extends ActionSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 7948807408555449626L;
    // 这一部分内容通过页面获取
    private String username;
    private String password1;
    private String password2;
    private String birthday;
    private int sex;
    
    // 在这个Action中得到
    private int age;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }

    public String execute() throws Exception {
        if (!password1.equals(password2))
            return "error";
        Calendar now = Calendar.getInstance();
        int presentYear = now.get(Calendar.YEAR);
        int birthYear = Integer.valueOf(birthday.substring(0, 4));
        age = presentYear - birthYear;
        User user = new User();
        user.setAge(age);
        user.setSex(sex);
        user.setUsername(username);
        user.setPassword(password1);
        UserRepository userrepository = new UserRepository();
        if (userrepository.register(user))
            return "success";
        else
            return "error";
    }
}