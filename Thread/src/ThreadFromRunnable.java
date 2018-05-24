class RunnableTest implements Runnable{//다중 상속이 안되므로 상속을 받고 인터페이스 사용
	public void run(){
		for(int i = 1; i <= 10; i++){
			System.out.println(i);
		}
	}
}


public class ThreadFromRunnable{
	public static void main(String[] args) {
		RunnableTest r = new RunnableTest();//객체 생성
		Thread t = new Thread(r);//스레드 객체 생성에다가 넣음
		t.start();
	}
}