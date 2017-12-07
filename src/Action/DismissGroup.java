package Action;

import Data.GroupRepository;
import Data.GroupUserRepository;

public class DismissGroup 
{
	public String dismissgroupid;

	public String getDismissgroupid() {
		return dismissgroupid;
	}

	public void setDismissgroupid(String dismissgroupid) {
		this.dismissgroupid = dismissgroupid;
	}
	public String execute() throws Exception
	{
		(new GroupRepository()).dismissgroup(dismissgroupid);
		(new GroupUserRepository()).dismissgroup(dismissgroupid);
		return "success";
	}
}
