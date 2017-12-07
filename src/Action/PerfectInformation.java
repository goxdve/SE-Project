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
        Map session1 = context.getSession();
        String username = (String) session1.get("username");
        HashMap<String,Object> newinformation = new HashMap<String, Object>();
        newinformation.put("newpassword",newpassword);
        newinformation.put("newage",newage);
        newinformation.put("newsex",newsex);
        newinformation.put("newtelephone",newtelephone);
        newinformation.put("newsignature",newsignature);
        (new UserRepository()).UpdateInformation(newinformation);
        return ret;
    }
    public String newpassword;
    public int newage;
    public int newsex;
    public String newtelephone;
    public String newsignature;
    
    public String getNewpassword() {
        return newpassword;
    }

    public int getNewage() {
        return newage;
    }

    public int getNewsex() {
        return newsex;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public void setNewage(int newage) {
        this.newage = newage;
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

