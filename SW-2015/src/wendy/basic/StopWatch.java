package wendy.basic;

import java.io.IOException;
import java.util.Scanner;

public class StopWatch {
	static String timerBuffer; // 04:11:15 등의 경과 시간 문자열이 저장될 버퍼 정의
	static int oldTime; // 타이머가 ON 되었을 때의 시각을 기억하고 있는 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			stopwatch(sc.nextInt()); // 1을 인수로 넣으면 타이머가 켜짐
		}
	}

	public static void stopwatch(int onOff) {

		if (onOff == 0) { // 타이머 끄고, 시분초를 timerBuffer 에 저장
			System.out.println(oldTime);
			secToHHMMSS(((int) System.currentTimeMillis() / 1000) - oldTime);
			System.out.format("Timer OFF! 경과 시간: [%s]%n", timerBuffer); // 경과 시간
		}

		if (onOff == 1){ // 타이머 켜기
			System.out.println("시작");
			
			if(oldTime == 0){
				oldTime = (int) System.currentTimeMillis() / 1000;
			}
		}

		if (onOff == 2) {
			System.out.println("reset");
			oldTime = 0;
			
		}

	}

	// 정수로 된 시간을 초단위(sec)로 입력 받아, "04:11:15" 등의 형식의 문자열로 시분초를 저장
	public static void secToHHMMSS(int secs) {
		int hour, min, sec;

		sec = secs % 60;
		min = secs / 60 % 60;
		hour = secs / 3600;

		timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
	}

	public static void pause() {
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}
}