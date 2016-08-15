package wendy.basic;

import java.util.ArrayList;
import java.util.List;

public class FindStringTest {
	public static void main(String[] args){
		String str = "SAQLANGUAGEOFCOMPUTER";
		String str2 = "SOFTWAREPROGRAMING";
		
		String key = "";
		String standard = "";
		if(str.length() < str2.length()){
			key = str;
			standard = str2;
		}else{
			key = str2;
			standard = str;
		}
		
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < key.length() - 1; i++){
			for(int j = 2; j <= key.length() - i; j++){
				String keyPart = key.substring(i, i + j);
				if(standard.matches(".*" + keyPart +".*")){
					result.add(keyPart);
				}
			}
		}
		
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
		
		System.out.println(result.size());
	}
}
