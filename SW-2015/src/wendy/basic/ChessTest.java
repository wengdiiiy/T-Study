package wendy.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessTest {
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
		
		Scanner scanner2 = new Scanner("0 0 1 5 5 6, 2 4 5 2, 3 2 5 5");
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

		Integer minX = (x - range) < 0 ? 0 : (x - range);
		Integer minY = (y - range) < 0 ? 0 : (y - range);
		Integer maxX = (x + range) > size ? size : (x + range);
		Integer maxY = (y + range) > size ? size : (y + range);
		
		//상하
		for(int i = minX; i <= maxX; i++){
			setValue(i, y);
		}
		
		//좌우
		for(int i = minY; i <= maxY; i++){
			setValue(x, i);
		}
		
		//왼대각선
		
		for(int i = -1 * range; i <= range; i++){
			setValue(x + i, y + i);
			setValue(x + i, y - i);
		}
		
	}
	
	private static void setValue(int x, int y){
		Integer size = matrixManager.getSize() - 1;
		if(x < 0 || x > size || y < 0 || y > size){
			return ;
		}else if(!bombList.contains(matrix[x][y])){
			matrix[x][y] = "1";
		}
	}
	
}
