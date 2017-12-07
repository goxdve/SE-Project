package Bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import Class.Groupmessage;
import Data.MessageRepository;

public class Message {
	public ArrayList<Groupmessage> messages;
	public void setMessages(ArrayList<Groupmessage> messages) {
		this.messages=messages;
	}
	public ArrayList<Groupmessage> getMessages() {
		return this.messages;
	}
	public Message() throws ClassNotFoundException, SQLException {
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		MessageRepository messageRepository=new MessageRepository();
		messages=messageRepository.getMessages((String)session1.get("username"));
//		for (int i = 0; i < 4; i++) {
//			System.out.println(messages.get(i).getGroupname()+"  "+messages.get(i).getGroupid());
//		}
	}
}
