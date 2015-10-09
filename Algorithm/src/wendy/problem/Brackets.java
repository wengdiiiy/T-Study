package wendy.problem;

import java.util.Stack;

/**
 * 참고 : http://h0tsource.tistory.com/25
 */

public class Brackets {
	public static void main(String[] args){
		Checker.execute("{}[]()");
		Checker.execute("{[()(())}");
	}	
}

class Checker{
	public static void execute(String testString){
		Stack<Byte> stack = new Stack<Byte>();
		byte[] bytes = testString.getBytes();
		
		int count = testString.length();
		
		while(count > 0){
			count--;
			
			for(int index = 0; index < bytes.length; index++){
				//열기 -> push
				if(bytes[index] == '[' || bytes[index] == '(' || bytes[index] == '{'){
					stack.push(bytes[index]);
				}else{
					//닫기 -> pop
					if(stack.size() > 0){
						if(Math.abs(stack.pop() - bytes[index]) > 2){
							break;
						}
					}else{
						break;
					}
				}
			}
			
			if(count == 0){
				if(stack.size() == 0 && bytes.length == testString.length()){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
	}
}