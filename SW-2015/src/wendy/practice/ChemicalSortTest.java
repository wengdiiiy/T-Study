package wendy.practice;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChemicalSortTest {
	public static void main(String args[]) throws Exception	{
		int T;
        int test_case;
        /* 아래 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
           만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 추가하면,
           그 아래에서 입력을 수행할 때 표준 입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
           따라서 본인의 PC 에서 테스트 할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 됩니다.
           단, 이 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(new FileInputStream(ChemicalSortTest.class.getResource(".").getPath() + "chemicalTest.txt"));
        
		T = sc.nextInt();        
		sc.nextLine();
		
		
//		List<Element> elements = new ElementManager().getElement();
//		System.out.println("===== 정렬 하기전 =====");
//		for (Element element : elements) {
//			System.out.println(element.getName());
//		}
// 
//		Collections.sort(elements, new AscCompare());
//		System.out.printf("\n\n===== 오름 차순 정렬 =====\n");
//		for (Element element : elements) {
//			System.out.println(element.getName());
//		}
// 
//		Collections.sort(elements, new DescCompare());
//		for (Element element : elements) {
//			System.out.println(element.getName());
//		}
//		
		for(test_case = 1; test_case <= T; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
        
        
        

			//	이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			
		}
	}
}
