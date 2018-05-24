class Buffer{
	private int contents;
	private boolean available = false;//번갈아가며 수행
	
	//생산자
	public synchronized void put(int value){
		while(available == true){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		
		contents = value;
		System.out.println("생산자#####: 생산 " + contents);
		notify();//대기 스레드 깨우는 아이
		available = true;
	}
	
	//소비자
	public synchronized int get(){
		while(available == false){
			try{
				wait();
			}catch(InterruptedException e){}
		}
		
		System.out.println("소비자####: 소비 " + contents);
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
		Buffer buff = new Buffer();//하나만 생성하면 됨
		//동일한 buffer 객체를 사용하여 스레드 객체 생성
		Producer p1 = new Producer(buff);
		Consumer c1 = new Consumer(buff);
		
		p1.start();
		c1.start();
	}
}