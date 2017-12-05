package Action;

public class GetRoute 
{
	public String start;
	public String end;
	public int mean;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	public int getMean() {
		return mean;
	}
	public void setMean(int mean) {
		this.mean = mean;
	}
	public String execute()
	{
		System.out.println(getStart()+" "+getEnd()+" "+getMean());
		return "success";
	}

}
