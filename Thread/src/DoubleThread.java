class ThreadTest1 extends Thread{
	//다중 스레드
	
	public ThreadTest1(String str){
		setName(str);//스레드 이름 설정
	}
	public void run(){
		for(int i = 1; i <= 10; i++){
			System.out.println(i + getName());
		}
		
		System.out.println("끝" + getName());
	}
}

public class DoubleThread{
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1(": 배우기 쉬운 자바");
		ThreadTest1 t2 = new ThreadTest1(": 배우기 어려운 자바");
		
		//스레드 동시에 발생
		t1.start();
		t2.start();
	}
} 