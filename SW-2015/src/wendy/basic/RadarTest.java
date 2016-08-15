package wendy.basic;

import java.util.Scanner;

public class RadarTest {
	static Radar radar = null;
	static Integer result = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner("5 5 3 7");
		String settingValue = "";
		while(scanner.hasNext()){
			settingValue += scanner.next();
		}
		
		radar = new Radar(Integer.parseInt(settingValue.split("")[0]), 
				Integer.parseInt(settingValue.split("")[1]), 
				Integer.parseInt(settingValue.split("")[2]), 
				Integer.parseInt(settingValue.split("")[3]));
		
		Scanner scanner2 = new Scanner("1 3 2 5 4 4 3 8 5 5 7 6 8");
		String content = "";
		while(scanner2.hasNext()){
			content += scanner2.next();
		}
        
		for(int i = 0; i < content.length() - 2; i+=2){
			Integer x = Integer.parseInt(content.substring(i, i + 1));
			Integer y = Integer.parseInt(content.substring(i + 1, i + 2));
			checkDistance(x, y);
		}
		
		System.out.println("레이더 감지영역에 있는 적군의 수: " + result);
    }
	
	private static boolean checkDistance(int x, int y){
		boolean isInRadar = false;
		Integer gapX = Math.abs(x - radar.getPointX());
		Integer gapY = Math.abs(y - radar.getPointY());
		
		double distance = Math.sqrt((gapX * gapX) + (gapY * gapY));
		
		if(distance <= radar.getRadius()){
			isInRadar = true;
			result++;
		}
		
		return isInRadar;
	}
}

class Radar{
	Integer pointX;
	Integer pointY;
	Integer radius;
	Integer enemyCount;
	
	public Radar(Integer x, Integer y, Integer r, Integer e){
		this.pointX = x;
		this.pointY = y;
		this.radius = r;
		this.enemyCount = e;
	}

	public Integer getPointX() {
		return pointX;
	}

	public void setPointX(Integer pointX) {
		this.pointX = pointX;
	}

	public Integer getPointY() {
		return pointY;
	}

	public void setPointY(Integer pointY) {
		this.pointY = pointY;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public Integer getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(Integer enemyCount) {
		this.enemyCount = enemyCount;
	}
}