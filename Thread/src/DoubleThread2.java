class DoubleThreadTest2 extends Thread{
	//���� ������
	
	public DoubleThreadTest2(String str){
		setName(str);//������ �̸� ����
	}
	public void run(){
		for(int i = 1; i <= 3; i++){
			System.out.println(i + getName());
		}
		
		System.out.println("��" + getName());
	}
}

public class DoubleThread2{
	public static void main(String[] args) throws Exception {
		ThreadTest1 t1 = new ThreadTest1(": ���� ���� �ڹ�");
		ThreadTest1 t2 = new ThreadTest1(": ���� ����� �ڹ�");
		
		System.out.println("������ ������");
		
		//������ ���ÿ� �߻�
		t1.start();
		t2.start();
		
		//�� �����尡 �����⸦ ��ٷȴٰ� ��� �����尡 ����Ǳ⸦ ��ٸ� �� ���� �������� ��� �̵�
		t1.join();
		t2.join();
		
		System.out.println("������ ���� ��");
	}
} 