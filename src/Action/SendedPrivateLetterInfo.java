package Action;

import Class.Privateletter;
import Data.PrivateletterRepository;

public class SendedPrivateLetterInfo 
{
	public String privateletterID;
	public String receiver;
	public String privateletterTitle;
	public String privateletterTime;
	public String content;
	public String execute()throws Exception
	{
		PrivateletterRepository privateletterRepository =new PrivateletterRepository();
		Privateletter privateletter = privateletterRepository.getPrivateletter(privateletterID);
		
		setReceiver(privateletter.getReceiver());
		setPrivateletterTitle(privateletter.getPrivateletterTitle());
		setPrivateletterTime(privateletter.getPrivateletterTime());
		setContent(privateletter.getContent());
		System.out.println(getPrivateletterID()+" "+getReceiver()+" "+getPrivateletterTitle()+" "+getPrivateletterTime()+" "+getContent());
		return "success";
	}
	public String getPrivateletterID() {
		return privateletterID;
	}
	public void setPrivateletterID(String privateletterID) {
		this.privateletterID = privateletterID;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPrivateletterTitle() {
		return privateletterTitle;
	}
	public void setPrivateletterTitle(String privateletterTitle) {
		this.privateletterTitle = privateletterTitle;
	}
	public String getPrivateletterTime() {
		return privateletterTime;
	}
	public void setPrivateletterTime(String privateletterTime) {
		this.privateletterTime = privateletterTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
