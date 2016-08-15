package wendy.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        
        Thread t3 = new Thread(t2); // 생성자 Thread(Runnable target)
         
        t1.start();
        t3.start();
    }
}

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); // 조상 Thread의 getName()을 호출
        }
    }
}
 
class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread(); // 현재 실행 중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}
