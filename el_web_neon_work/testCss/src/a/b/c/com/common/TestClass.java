package a.b.c.com.common;
import java.util.ArrayList;

public class TestClass {
	
	public void test(){
		System.out.println("a.b.c.com.xml.TestClassÅ¬·¡½º¿¡ ÀÖ´Â test ¸Ş¼Òµå ½ÃÀÛ");
		
		ArrayList<String> aList = new ArrayList<String>();
		
		aList.add("±è»óÁø");
		aList.add("±è»óÁø1");
		aList.add("±è»óÁø2");
		aList.add("±è»óÁø3");
		aList.add("±è»óÁø4");
		aList.add("±è»óÁø5");
		aList.add("±è»óÁø6");
		aList.add("±è»óÁø7");
		aList.add("±è»óÁø8");
		aList.add("±è»óÁø9");
		
		for(int i  =0; i < aList.size(); i++){
			System.out.println("aList("+i+") ->"+ aList.get(i));
		}
		
	}

}
