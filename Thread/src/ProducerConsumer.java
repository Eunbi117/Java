class Buffer{
	private int contents;
	private boolean available = false;//�����ư��� ����
	
	//������
	public synchronized void put(int value){
		while(available == true){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		
		contents = value;
		System.out.println("������#####: ���� " + contents);
		notify();//��� ������ ����� ����
		available = true;
	}
	
	//�Һ���
	public synchronized int get(){
		while(available == false){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		
		System.out.println("�Һ���####: �Һ� " + contents);
		notify();
		available = false;
		return contents;
	}
}


class Producer extends Thread{
	private Buffer b;
	public Producer(Buffer blank){
		b = blank;
	}
	
	public void run(){
		for(int i = 1; i <= 10; i++){
			b.put(i);
		}
	}
}

class Consumer extends Thread{
	private Buffer b;
	public Consumer(Buffer blank){
		b = blank;
	}
	
	public void run(){
		int value = 0;
		for(int i = 1; i <= 10; i++){
			value = b.get();
		}
	}
}

public class ProducerConsumer{
	public static void main(String[] args) {
		Buffer buff = new Buffer();//�ϳ��� �����ϸ� ��
		//������ buffer ��ü�� ����Ͽ� ������ ��ü ����
		Producer p1 = new Producer(buff);
		Consumer c1 = new Consumer(buff);
		
		p1.start();
		c1.start();
	}
}