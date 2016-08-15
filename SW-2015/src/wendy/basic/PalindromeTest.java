package wendy.basic;

import java.util.ArrayList;
import java.util.List;

//팰린드롬(회문) 찾기
public class PalindromeTest {
	public static void main(String[] args){
		String str = "IAEFGSADAOFSOSPIPOKTOOTSCIVIC";
		
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < str.length() - 1; i++){
			for(int j = 3; j <= str.length() - i; j++){
				String keyPart = str.substring(i, i + j);
				if(palindrome(keyPart)){
					result.add(keyPart);
				}
			}
		}
		
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
		
		System.out.println(result.size());
	}
	
	private static boolean palindrome(String str){
		int len = str.length();
		boolean same = true;
		
		for(int i = 0; i < len / 2; i++){
			if(str.charAt(i) != str.charAt(len - i - 1)){
				same = false;
			}
		}
		return same;
	}
}
