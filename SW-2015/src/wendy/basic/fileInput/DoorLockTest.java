package wendy.basic.fileInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockTest {
	public static void main(String args[]) throws IOException{
		String content = "";
		String key = "";
		Map<Integer, Boolean> result = new HashMap<Integer, Boolean>();
		
		boolean isOpen = false;
		List<String> list = new ArrayList<String>();
		
	    try {
	    	BufferedReader in = new BufferedReader(new InputStreamReader(
	    			new FileInputStream("/Users/anjeongmin/Documents/Study/T-Study/SW-2015/src/wendy/basic/fileInput/doorLockTest.txt"),"UTF8"));

      		String str;
      		while ((str = in.readLine()) != null) {
      			list.add(str);
      		}
      		
      		key = list.get(0);
      		list.remove(0);
  			in.close();
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }
	    
	    for(int i = 0; i < list.size(); i++){
		    List<String> words = getDividedWords(list.get(i), key.length());
		    for(int j = 0; j < words.size(); j++){
		    	if(words.get(j).equals(key)){
		    		isOpen = true;
		    	}
	    	}
		    result.put(i, isOpen);
	    	isOpen = false;
	    }
	    
	    try{
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/anjeongmin/Documents/Study/T-Study/SW-2015/src/wendy/basic/fileInput/doorLockTestOutPut.txt", false));

			for(int i = 0; i < result.size(); i++){
				if(result.get(i) == true){
					out.write("비밀번호 " + (i + 1) + ": 문이 열렸습니다."); out.newLine();
				}else{
					out.write("비밀번호 " + (i + 1) + ": 틀렸습니다."); out.newLine();
				}
			}
	      out.close();
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }
	}
	
	private static List<String> getDividedWords(String word, int endIndex) {
		List<String> words = new ArrayList<String>();
		
		int maxIndex = word.length();
		for (int i = 0; i < maxIndex; i++, endIndex++) {
			// 현재 나눈 문자열의 끝이 최대 길이보다 클 경우 중지
			if(endIndex > maxIndex){
				continue;
			}else{
				String partWord = word.substring(i, endIndex);
				if(!partWord.contains("#")){
					words.add(partWord);
				}
			}
		}
		return words;
	}
}
