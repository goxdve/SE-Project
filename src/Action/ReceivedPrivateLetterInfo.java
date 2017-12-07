package Action;

import Class.Privateletter;
import Data.PrivateletterRepository;

public class ReceivedPrivateLetterInfo 
{
	public String privateletterID;
	public String sender;
	public String privateletterTitle;
	public String privateletterTime;
	public String content;
	public String execute()throws Exception
	{
		PrivateletterRepository privateletterRepository =new PrivateletterRepository();
		Privateletter privateletter = privateletterRepository.getPrivateletter(privateletterID);
		
		setSender(privateletter.getSender());
		setPrivateletterTitle(privateletter.getPrivateletterTitle());
		setPrivateletterTime(privateletter.getPrivateletterTime());
		setContent(privateletter.getContent());
		
		return "success";
	}
	public String getPrivateletterID() {
		return privateletterID;
	}
	public void setPrivateletterID(String privateletterID) {
		this.privateletterID = privateletterID;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
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
