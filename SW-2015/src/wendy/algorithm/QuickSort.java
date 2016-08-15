package wendy.algorithm;

public class QuickSort {
	static int bufferArray[] = new int[8];
	
	public static void main(String[] args) {
		int[] array = {10, 45, 22, 3, 1, 50, 80, 55};
		quicksort(array, 0, array.length - 1);
		for(int item : array){
			System.out.print(item + " ");
		}
		System.out.println();
		
		int[] array2 = {10, 45, 22, 3, 1, 50, 80, 55};
		mergesort(array2, 0, array2.length - 1);
		
		for(int item : array){
			System.out.print(item + " ");
		}
	}
	
	private static void quicksort(int[] array, int left, int right){
		if(left < right){
			int partition = partition(array, left, right);
			quicksort(array, left, partition - 1);
			quicksort(array, partition + 1, right);
		}
	}
	
	private static int partition(int[] array, int left, int right){
		int low = left;
		int high = right;
		int pivot = array[left];
		
		while(low < high){
			do{
				low++;
			}while(low <= right && array[low] < pivot);
			
			while(high >= left && array[high] > pivot){
				high--;
			}
			
			if(low < high){
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}
		
		int temp = array[left];
		array[left] = array[high];
		array[high] = temp;
		
		return high;
	}


	private static void mergesort(int[] array, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
	
	private static void merge(int[] array, int low, int mid, int high){
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while((i <= mid) && (j <= high)){
			if(array[i] <= array[j]){
				bufferArray[k] = array[i];
				i++;
			}else{
				bufferArray[k] = array[j];
				j++;
			}
			k++;
		}
		
		
		if(i > mid){
			for(int m = j; m <= high; m++){
				bufferArray[k++] = array[m];
			}
		}else{
			for(int m = i; m <= mid; m++){
				bufferArray[k++] = array[m];
			}
		}
		
		for (int m = low; m <= high; m++)
			array[m] = bufferArray[m];
	}
}
