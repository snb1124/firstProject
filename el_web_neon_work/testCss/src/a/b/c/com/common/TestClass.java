package a.b.c.com.common;
import java.util.ArrayList;

public class TestClass {
	
	public void test(){
		System.out.println("a.b.c.com.xml.TestClassŬ������ �ִ� test �޼ҵ� ����");
		
		ArrayList<String> aList = new ArrayList<String>();
		
		aList.add("�����");
		aList.add("�����1");
		aList.add("�����2");
		aList.add("�����3");
		aList.add("�����4");
		aList.add("�����5");
		aList.add("�����6");
		aList.add("�����7");
		aList.add("�����8");
		aList.add("�����9");
		
		for(int i  =0; i < aList.size(); i++){
			System.out.println("aList("+i+") ->"+ aList.get(i));
		}
		
	}

}
