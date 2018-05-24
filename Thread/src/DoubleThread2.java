class DoubleThreadTest2 extends Thread{
	//다중 스레드
	
	public DoubleThreadTest2(String str){
		setName(str);//스레드 이름 설정
	}
	public void run(){
		for(int i = 1; i <= 3; i++){
			System.out.println(i + getName());
		}
		
		System.out.println("끝" + getName());
	}
}

public class DoubleThread2{
	public static void main(String[] args) throws Exception {
		ThreadTest1 t1 = new ThreadTest1(": 배우기 쉬운 자바");
		ThreadTest1 t2 = new ThreadTest1(": 배우기 어려운 자바");
		
		System.out.println("스레드 시작전");
		
		//스레드 동시에 발생
		t1.start();
		t2.start();
		
		//각 스레드가 끝나기를 기다렸다가 모든 스레드가 종료되기를 기다린 후 다음 문장으로 제어가 이동
		t1.join();
		t2.join();
		
		System.out.println("스레드 종료 후");
	}
} 