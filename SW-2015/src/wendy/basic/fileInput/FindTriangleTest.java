package wendy.basic.fileInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 삼각형 형태 알아내기 
 */
public class FindTriangleTest {
	private static PointManager manager = new PointManager();
	
	public static void main(String args[]) throws IOException{
		String content = "";
		
//		if (args.length == 0) {                   // args.length 는 옵션 개수
//			System.err.println("Input Filename...");
//			System.exit(1);                         // 읽을 파일명을 주지 않았을 때는 종료
//	    }

	    try {
	    	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/anjeongmin/Documents/Study/T-Study/SW-2015/bin/wendy/basic/fileInput/triangleTest.txt"),"UTF8"));

      		String str;
      		while ((str = in.readLine()) != null) {
      			content += str;
			}
  			in.close();
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }

		    
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String content = in.readLine().replaceAll(" ", "");
		
		List<Point> pointList = new ArrayList<Point>();
		
		content = content.replaceAll(" ", "");
		for(int i = 0; i < content.length() - 1; i += 2){
			pointList.add(new Point(Integer.parseInt(content.substring(i,i + 1)), Integer.parseInt(content.substring(i + 1, i + 2))));
		}
		
		//직선 , 동일한 점?
		boolean isSame = true;
		boolean isSlope = true;
		int index = 0;
		
		while(index < pointList.size() - 1){
			if(!manager.isSamePoint(pointList.get(index), pointList.get(index + 1))){
				isSame = false;
			}
			index++;
		}
		
		index = 0;
		
		while(index < pointList.size() - 1){
			if(!manager.isSlopePoint(pointList.get(index), pointList.get(index + 1))){
				isSlope = false;
			}
			index++;
		}

		double bigDistanceIndex = 0;
		double bigDistance = 0.0;
		
		for(int i = 0; i < pointList.size() - 1; i++){
			double calDistance = manager.calculateDistance(pointList.get(i), pointList.get(i + 1));
			if(bigDistance < calDistance){
				bigDistance = calDistance;
				bigDistanceIndex = i;
			}
		}
		
		pointList.remove(bigDistanceIndex);
		double distance = manager.calculateDistance(pointList.get(0), pointList.get(1));

		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/anjeongmin/Documents/Study/T-Study/SW-2015/src/wendy/basic/fileInput/triangleTestOutPut.txt", false));
			out.write("입력 점은 " + content); out.newLine();
			
			if(distance == bigDistance){
				out.write("직각 삼각형 입니다."); out.newLine();
			}else if(distance < bigDistance){
				out.write("예각 삼각형 입니다."); out.newLine();
			}else {
				out.write("둔각 삼각형 입니다."); out.newLine();
			}
	      out.close();
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}


class PointManager{
	public double calculateDistance(Point p1, Point p2){
		int gapX = Math.abs(p2.x - p1.x);
		int gapY = Math.abs(p2.y - p1.y);
		
		return (gapX * gapX) + (gapY * gapY);
	}
	
	public boolean isSamePoint(Point p1, Point p2){
		return p1.x == p2.x && p1.y == p2.y;
	}
	
	public boolean isSlopePoint(Point p1, Point p2){
		return p1.x == p2.x || p1.y == p2.y;
	}	
	
	
}