package Bean;

import Action.PerfectInformation;
import Data.*;
import java.util.HashMap;

public class PersonalInformation
{
    public PersonalInformation() throws Exception
    {
        HashMap<String,Object> ret = (new UserRepository()).SearchInformation();
        setPassword((String)ret.get("password"));
        setAge((int)ret.get("age"));
        setSex((int)ret.get("sex"));
    }
    public String password;
    public int sex;
    public int age;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
