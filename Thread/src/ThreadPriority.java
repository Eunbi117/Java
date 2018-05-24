class PriorityTest extends Thread{
	public PriorityTest(String str){
		setName(str);
	}
	
	public void run(){
		for(int i = 1; i <= 5; i++){
			//우선순위 출력해줌
			System.out.println(i + getName() + " 우선순위: " + getPriority());
		}
	}
}

public class ThreadPriority{
	public static void main(String[] args) {
		PriorityTest t1 = new PriorityTest(" : 첫번째 스레드");
		PriorityTest t2 = new PriorityTest(" : 두번째 스레드");
		PriorityTest t3 = new PriorityTest(" : 세번째 스레드");
		
		int priority_t1 = Integer.parseInt(args[0]);
		int priority_t2 = Integer.parseInt(args[1]);
		
		//우선순위 결정
		t1.setPriority(priority_t1);
		t2.setPriority(priority_t2);
		t3.setPriority(Thread.MIN_PRIORITY);//우선순위 값으로 1을 가진다
		
		t1.start();
		t2.start();
		t3.start();
	}
}