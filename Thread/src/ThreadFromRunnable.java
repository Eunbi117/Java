class RunnableTest implements Runnable{//���� ����� �ȵǹǷ� ����� �ް� �������̽� ���
	public void run(){
		for(int i = 1; i <= 10; i++){
			System.out.println(i);
		}
	}
}


public class ThreadFromRunnable{
	public static void main(String[] args) {
		RunnableTest r = new RunnableTest();//��ü ����
		Thread t = new Thread(r);//������ ��ü �������ٰ� ����
		t.start();
	}
}