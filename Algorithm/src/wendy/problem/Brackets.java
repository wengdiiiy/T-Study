package wendy.problem;

import java.util.Stack;

/**
 * 출처 : http://h0tsource.tistory.com/25
 */

public class Brackets {
	public static void main(String[] args){
		String test = "{}[]()";
		String test2 = "{}[()(())";

		Stack<Byte> stack = new Stack<Byte>();
		byte[] bytes = test2.getBytes();
		
		int count = test.length();
		
		while(count-- > 0){
			int i;
			for(i = 0; i < bytes.length; i++){
				//열기 -> push
				if(bytes[i] == '[' || bytes[i] == '(' || bytes[i] == '{'){
					stack.push(bytes[i]);
				}else{
					//닫기 -> pop하여 비교
					if(stack.size() > 0){
						if(Math.abs(stack.pop() - bytes[i]) > 2){
							break;
						}
					}else{
						break;
					}
				}
			}
			
			if(count == 0){
				if(stack.size() == 0 && bytes.length == i){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
	}	
}
