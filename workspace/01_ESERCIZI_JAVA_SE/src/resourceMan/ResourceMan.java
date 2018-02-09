package resourceMan;

import java.net.URL;

public class ResourceMan {
	
	public static void main(String[] args) {
		
		
		URL url1 = ResourceMan.class.getClassLoader().getResource("main/abc.jpg");
		
		System.out.println(url1);
	}
}
