package wendy.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixTest {
	private static MatrixManager matrixManager = new MatrixManager();
	private static List<String> bombList = new ArrayList<String>();
	private static String[][] matrix;
	private static int result = 0;
	
	public static void main(String args[]){
		bombList.add(new String("A"));
		bombList.add(new String("B"));
		bombList.add(new String("C"));

		Scanner scanner = new Scanner("7");
		String size = scanner.next();
		
		Scanner scanner2 = new Scanner("0 0 1 5 3 5 5 6, 1 1 2 4 5 2, 3 2 5 5");
		String content = "";
		while(scanner2.hasNext()){
			content += scanner2.next();
		}
		matrixManager.setSize(Integer.parseInt(size));


		//A,B,C로 쪼개어 2차원 배열에 담는다.
		String[] contents = content.split(",");
		String[][] datas = new String[bombList.size()][0];
		matrix = matrixManager.makeMatrix();
		
    	for(int i = 0; i < datas.length; i++){
    		datas[i] = new String[contents[i].length()];
    		for(int j = 0; j < contents[i].length(); j++){
				datas[i][j] = contents[i].substring(j, j+1);
    		}
    	}
    	
    	System.out.println("[A,B,C 좌표 값]");
    	for(String[] data : datas){
			for(String str : data){
				System.out.print(str + " ");
			}
			System.out.println();
		}
    	
    	//좌표화한 후, A는 '1', B는 '2', C는 '3'의 범위에 해당하는 지역에 "1"을 위치시킨다.
    	for(int i = 0; i < datas.length; i++){
    		for(int j = 0; j < datas[i].length - 1; j+=2){
    			Integer x = (datas[i][j] == null) ? 0 : Integer.parseInt(datas[i][j]);
    			Integer y = (datas[i][j+1] == null) ? 0 : Integer.parseInt(datas[i][j+1]);
    			
    			if(i == 0){
    				matrix[x][y] = "A";
    				fill(i + 1, x, y);
    			}else if(i == 1){
    				matrix[x][y] = "B";
    				fill(i + 1, x, y);
    			}else if(i == 2){
    				matrix[x][y] = "C";
    				fill(i + 1, x, y);
    			}
    		}
    	}
    	
    	//0 숫자 세기 및 화면에 출력
    	
    	System.out.println("\n[결과]");
    	for(String[] data2 : matrix){
    		for(String data : data2){
    			if(data.equals("0")){
					result++;
    			}
    			System.out.print(data);
    		}
    		System.out.println();
    	}
    	
    	System.out.println("\n커버가 안된 지역은 " + result + "곳");
    	
	}
	
	private static void fill(Integer range, Integer x, Integer y){
		Integer size = matrixManager.getSize();
		Integer left = y - range;
		Integer right = y + range;
		Integer top = x - range;
		Integer bottom = x + range;
		
		for(int i = left; i <= right; i++){
			if(i >= 0 && i < size && !bombList.contains(matrix[x][i])){
				matrix[x][i] = "1";
			}
		}
		
		for(int i = top; i <= bottom; i++){
			if(i >= 0 && i < size && !bombList.contains(matrix[x][i])){
				matrix[i][y] = "1";
			}
		}
	}
}


class MatrixManager{
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Matrix를 size * size 크기로 만들고, 0으로 초기화 하여 반환한다.
	 * @return
	 */
	public String[][] makeMatrix(){
		String tempMatrix[][] = new String[size][size];
		
		for(int i = 0; i < tempMatrix.length; i++){
			for(int j = 0; j < tempMatrix[i].length; j++){
				tempMatrix[i][j] = "0";
			}
		}
		
		return tempMatrix;
	}
}
