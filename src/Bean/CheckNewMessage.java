package Bean;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Data.MessageRepository;

public class CheckNewMessage {
	public int messageNumber;
	public int getMessageNumber() {
		return this.messageNumber;
	}
	public void setMessageNumber(int number) {
		this.messageNumber=number;
	}
	public CheckNewMessage() throws ClassNotFoundException, SQLException {
		messageNumber=0;
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		String username=(String) session1.get("username");
		MessageRepository messageRepository=new MessageRepository();
		messageNumber=messageRepository.getMessageNumber(username);
		System.err.println(messageNumber);
	}
}
