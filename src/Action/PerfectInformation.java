package Action;

import Data.*;
import com.opensymphony.xwork2.ActionContext;

import java.util.HashMap;
import java.util.Map;

public class PerfectInformation
{
    //1.真实姓名;2.性别;3.年龄;4.电话号码;
    //弄一个存个人信息的表，有默认值
    public String execute() throws Exception
    {
        String ret = "success";
        ActionContext context = ActionContext.getContext();
        Map application = context.getApplication();
        String Username = (String) application.get("Username");
        HashMap<String, Object>NewInformation = new HashMap<String, Object>();
        NewInformation.put("Username", Username);
        NewInformation.put("rightname", rightname);
        NewInformation.put("sex", sex);
        NewInformation.put("age", age);
        NewInformation.put("telephone", telephone);
        new InformationRepository().ChangeInformation(NewInformation);
        return ret;
    }
    public String rightname;

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname;
    }

    public String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
