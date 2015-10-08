package wendy.algorithm;

/**
 * @author wendy
 * 
 */
public class Algorithm {
	
	Integer[] result = null;
	
	public Algorithm(){
		System.out.println("��ü ����");
	}
	/**
	 * ��������
	 * > ������ ���� ���� ������
	 * > O(n^2)

	 * @param array [Integer] �ʱ�迭
	 * @return initArray [Integer] 
	 */
	public Integer[] bubbleSort(Integer[] array){
		result = array;
		for(int i = result.length - 1; i > 0; i++){
			for(int j = 0; j < i; j++){
				if(result[j] > result[j + 1]){
					result = swap(result, j, j + 1);
				}
			}
		}
		
		return result;
	}
	
	
	private Integer[] swap(Integer[] result, int index1, int index2){
		Integer temp = result[index1];
		result[index1] = result[index2];
		result[index2] = temp;
		
		return result;
	}
}


