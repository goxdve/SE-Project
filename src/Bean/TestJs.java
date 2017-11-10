package Bean;

import java.util.ArrayList;
import java.util.List;

public class TestJs
{
	String word1;
	String word2;
	List<Integer> list;
	public TestJs()
	{
		word1="word1";
		word2="word2";
		list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
	}

	public String getWord1() {
		return word1;
	}

	public void setWord1(String word1) {
		this.word1 = word1;
	}

	public String getWord2() {
		return word2;
	}

	public void setWord2(String word2) {
		this.word2 = word2;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
}
class