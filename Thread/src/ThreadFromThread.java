class threadTest extends Thread{//�����带 ��ӹ޾Ƽ�
	public void run(){//�������̵�
		for(int i = 1; i <= 10; i++){
			System.out.println(i);
		}
	}
}

public class ThreadFromThread{
	public static void main(String[] args) {
		threadTest t = new threadTest();
		t.start();//start�� �ϸ� run�޼ҵ� ȣ���-> ������ �������̵� �����Ƿ� �������� �������̵��� run�� ȣ��
	}
}