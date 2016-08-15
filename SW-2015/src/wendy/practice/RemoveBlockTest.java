package wendy.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveBlockTest {
	public static void main(String[] args) throws FileNotFoundException {
		int T;
        int test_case;
        /* 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
           만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면,
           그 아래에서 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
           따라서 본인의 PC 에서 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다.
           단, 이 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다. */
		Scanner scanner = new Scanner(new FileInputStream(RemoveBlockTest.class.getResource(".").getPath() + "blockTest.txt"));
//		Scanner scanner = new Scanner(System.in);
        
		T = scanner.nextInt();
		scanner.nextLine();
		
		List<String> list = new ArrayList<String>();
		
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			list.add(str);
		}
		
		List<Integer> size = new ArrayList<Integer>();
		List<String> blockList = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); i += 2){
			size.add(Integer.valueOf(list.get(i)));
			blockList.add(list.get(i + 1));
		}

		List<Integer> initList = null;
		List<Integer> changeList = null;
		
		for(test_case = 1; test_case <= T; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
			initList = new ArrayList<Integer>();
			changeList = new ArrayList<Integer>();
			String blockString = blockList.get(test_case - 1);
			List<String> initStrings = Arrays.asList(blockString.split(" "));
			
			for(String initString : initStrings){
				initList.add(Integer.parseInt(initString));
				changeList.add(Integer.parseInt(initString));
			}
			
			boolean isFinish = false;
			int count = 0;
			while(!isFinish){
				List<Integer> gainList = new ArrayList<Integer>(changeList.size());
				for(int i = 0; i < changeList.size(); i++){
					gainList.add(0);
				}
				
				//획득 
				for(int i = 0; i < changeList.size(); i++){
					Integer leftIndex = i - 1;
					Integer rightIndex = i + 1;

					if(leftIndex < 0){
						Integer diffRight = changeList.get(i) - changeList.get(rightIndex);
						if(diffRight < 0){ //남주기
							setValue(gainList, rightIndex, diffRight);
						}else if(diffRight > 0){
							setValue(gainList, i, diffRight);
						}
					}else if(rightIndex > gainList.size() - 1){
						Integer diffLeft = changeList.get(i) - changeList.get(leftIndex);
						if(diffLeft < 0){ //남주기
							setValue(gainList, leftIndex, diffLeft);
						}else if(diffLeft > 0){
							setValue(gainList, i, diffLeft);
						}
					}else{
						Integer diffLeft = changeList.get(i) - changeList.get(leftIndex);
						Integer diffRight = changeList.get(i) - changeList.get(rightIndex);
						if(diffLeft < 0){ //남주기
							setValue(gainList, leftIndex, diffLeft);
						}else if(diffLeft > 0){
							setValue(gainList, i, diffLeft);
						}
						
						if(diffRight < 0){ //남주기
							setValue(gainList, rightIndex, diffRight);
						}else if(diffRight > 0){
							setValue(gainList, i, diffRight);
						}
					}
				}
				
				
				//gain >> 0 -> -1 
				for(int i = 0; i < gainList.size(); i++){
					if(gainList.get(i) == 0){
						gainList.set(i, -1);
					}					
				}
				
				//값 빼기
				for(int i = 0; i < changeList.size(); i++){
					changeList.set(i, Math.abs(changeList.get(i)) - Math.abs(gainList.get(i)));					
				}
				
				//양끝 제거
				isFinish = isFinish(changeList);
				if(gainList.size() > 2 || !isFinish){
					gainList.remove(0);
					changeList.remove(0);
					gainList.remove(gainList.size() - 1);
					changeList.remove(changeList.size() - 1);
				}
				count++;
				
				//하나 남았을 경우, 모두 0일때
				if(changeList.size() ==1 && changeList.get(0) < 1){
					count--;
				}
				
			}
			
			//	이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + ": " + count + "번");
		}
	}
	
	public static void setValue(List<Integer> list, Integer index, Integer value){
		if(list.get(index) < value){
			list.set(index, value);
		}
	}
	
	public static boolean isFinish(List<Integer> list){
		boolean isFinish = true;
		for(Integer num : list){
			if(num > 0){
				isFinish = false;
			}
		}
		return isFinish;
	}
}