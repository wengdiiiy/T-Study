package wendy.thread;

import java.io.IOException;

public class SynchronizedTest {
    public static void main(String[] args) {
        ATM atm = new ATM();
 
        Thread mother = new Thread(atm, "mother");
        Thread son = new Thread(atm, "son");
 
        mother.start();
        son.start();
    }
}

class ATM implements Runnable{
	private int money = 10000;
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(getMoney() <= 0){
				break;
			}
			
			synchronized (this){
				withdraw(1000);
			}
		}
	}
	
	private void withdraw(int money){
		setMoney(getMoney() - money);
		System.out.println(Thread.currentThread().getName() + "-> 잔액 : " + getMoney());
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
