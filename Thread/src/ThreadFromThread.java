class threadTest extends Thread{//스레드를 상속받아서
	public void run(){//오버라이딩
		for(int i = 1; i <= 10; i++){
			System.out.println(i);
		}
	}
}

public class ThreadFromThread{
	public static void main(String[] args) {
		threadTest t = new threadTest();
		t.start();//start를 하면 run메소드 호출됨-> 위에서 오버라이딩 했으므로 하위에서 오버라이딩한 run이 호출
	}
}