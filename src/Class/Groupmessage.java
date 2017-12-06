package Class;

public class Groupmessage {
	public int type;//消息类型:0-申请  1-同意  2-拒绝  3-组解散  4-被踢
	private String messageid;//消息ID
	private String groupid;//小组ID
	public String groupname;//小组名
	private String sender;//消息的发送者
	private String receiver;//消息的接收者
	private int state;//处理状态:0-未读   1-已读
	public String getGroupid() {
		return this.groupid;
	}
	public void setMessageid(String messageid) {
		this.messageid=messageid;
	}
	public String getMessageid() {
		return this.messageid;
	}
	public void setGroupid(String groupid) {
		this.groupid=groupid;
	}
	public String getGroupname() {
		return this.groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname=groupname;
	}
	public String getSender() {
		return this.sender;
	}
	public void setSender(String sender) {
		this.sender=sender;
	}
	public String getReceiver() {
		return this.receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver=receiver;
	}
	public int getState() {
		return this.state;
	}
	public void setState(int state) {
		this.state=state;
	}
	public int getTyepe() {
		return this.type;
	}
	public void setType(int type) {
		this.type=type;
	}
}
