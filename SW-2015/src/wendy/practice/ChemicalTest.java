package wendy.practice;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ChemicalTest {
	public static void main(String args[]) throws Exception	{
		int T;
        int test_case;
        /* 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
           만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면,
           그 아래에서 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
           따라서 본인의 PC 에서 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다.
           단, 이 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(new FileInputStream(ChemicalTest.class.getResource(".").getPath() + "chemicalTest.txt"));
        
		T = sc.nextInt();        
		sc.nextLine();
		
		Map<String, String> elements = new ElementManager().getElement();
		toLowerCaseKeyValue(elements);
		List<String> sentenceList = new ArrayList<String>();
		List<Boolean> oneWord = new ArrayList<Boolean>();
		List<Boolean> twoWord = new ArrayList<Boolean>();
		boolean isExist = false;
		
		while(sc.hasNext()){
			sentenceList.add(sc.nextLine());
		}
		
		System.out.println(sentenceList);
		
		for(test_case = 2; test_case <= 2; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
        
			String sentence = sentenceList.get(test_case - 1);
			System.out.println(sentence);
			
			for(int j = 0; j < sentence.length() - 1; j++){
				if(elements.get(divideElement(sentence, j, 1)) == null){
					oneWord.add(j, false);
				}else if(elements.get(divideElement(sentence, j, 1)) != null){
					oneWord.add(j, true);
				}
				
				if(elements.get(divideElement(sentence, j, 2)) == null){
					twoWord.add(j, false);
				}else if(elements.get(divideElement(sentence, j, 2)) != null){
					twoWord.add(j, true);
				}
			}
			
			for(boolean b : oneWord){
				System.out.print(b + ", ");
			}
			System.out.println();
			for(boolean b : twoWord){
				System.out.print(b + ", ");
			}
			
			
			//선정
			Set<String> collect = new TreeSet<String>();
			for(int i = 0; i < oneWord.size(); i++){
				if(i + 1 < oneWord.size()){
					Boolean me = oneWord.get(i);
					Boolean me2 = twoWord.get(i);
					Boolean next = oneWord.get(i + 1);
					Boolean next2 = twoWord.get(i + 1);
					
					if((me && next2) && !(me2 && next)){
						collect.add(sentence.substring(i, i + 1));
						collect.add(sentence.substring(i + 1, i + 3));
						i++;
					}else if(!(me && next2) && (me2 && next)){
						collect.add(sentence.substring(i, i + 2));
						collect.add(sentence.substring(i + 1, i + 2));
						i++;
					}else if((me && next) || (me2 && next2)){
						Boolean before = twoWord.get(i - 1);
						if(before){
							collect.add(sentence.substring(i + 1, i + 3));
						}else{
							collect.add(sentence.substring(i, i + 1));
						}
					}
				}else{
					Boolean before2 = twoWord.get(i - 1);
					if(!before2){
						collect.add(sentence.substring(i, i + 1));
					}
				}
			}
			
			System.out.println();
			int totalLength = 0;
			for(String item : collect){
				System.out.print(item + " ");
				totalLength += item.length();
			}
			
			System.out.println(totalLength);
			
			
			
			//	이 부분에서 정답을 출력하십시오.
//			System.out.println("Case #" + test_case + "" + isOneWordExist + ", " + isTwoWordExist);
			
		}
	}
	
	/**
	 * <pre>
	 * 현재 Map 에 등록된 Key의 값을 모두 소문자로 변경한다.
	 * </pre>
	 *
	 */
	public static void toLowerCaseKeyValue(Map<String, String> elements) {
		Iterator itr = elements.keySet().iterator();
		List keyList = new ArrayList();
		Map tempMap = new LinkedHashMap();
		while(itr.hasNext()) {
			String keyName = (String)itr.next();
			String newKeyName = keyName.toLowerCase();
			if (!keyName.equals(newKeyName)) {
				tempMap.put(newKeyName, elements.get(keyName));
				keyList.add(keyName);
			}
		}
		for(int i=0;i<keyList.size();i++) {
			elements.remove(keyList.get(i));
		}
		elements.putAll(tempMap);
	}

	
	public static String divideElement(String sentence, int index, int gap){
		return sentence.substring(index, index + gap);
	}
}

