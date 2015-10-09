package wendy.problem;

/**
 * 참고 : http://h0tsource.tistory.com/entry/algospotWEIRD
 */

public class WeirdNumbers {
	public static void main(String[] args){
		int n = 12;
		int sum = 0; 
		int sum2 = 0;
		
		boolean isNosubset = true;
		
		for(int i = n / 2; i > 0; i--){
			if(isNosubset && n % i == 0){
				//약수 (6,4,3,2,1)
				sum += i;
				
				sum2 += i;
				if(sum2 > n){
					sum2 -= n;
				}else if(sum2 == n){
					//약수들의 합이 n과 같을 경우
					isNosubset = false;
					break;
				}
			}
		}
		
		if(sum > n && isNosubset){
			System.out.println("weird number!");
		}else{
			System.out.println("not weird number!");
		}
		
	}	
}
