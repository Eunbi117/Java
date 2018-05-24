class Account{
	private int total = 0;
	
	//1000원을 더하는 동기화 메소드 선언
	//생성할 5개의 스레드에 의해 공유된다 - > 경쟁적으로 호출
	synchronized void deposit(){
		total = total + 1000;
	}
	
	int gettotal(){
		return total;
	}
}

class Customer extends Thread{
	Account same_a;
	
	//스레드 이름과 Account객체를 설정
	Customer(Account a, String s){
		same_a = a;
		setName(s);
	}
	public void run(){
		for(int i = 1 ; i <= 200; i++){
			System.out.println(getName() + " : " + i + "번째");
			same_a.deposit();
			if(same_a.gettotal() >= 500000) break;
		}
	}
}


public class TVContribution{
	public static void main(String[] args) throws Exception {
		Account same_account = new Account();
		
		//동일한 객체를 지정하면 5개의 스레드가 same_account객체를 공유한다.
		Customer donator1 = new Customer(same_account, "1번째 성금자");
		Customer donator2 = new Customer(same_account, "2번째 성금자");
		Customer donator3 = new Customer(same_account, "3번째 성금자");
		Customer donator4 = new Customer(same_account, "4번째 성금자");
		Customer donator5 = new Customer(same_account, "5번째 성금자");
		
		donator1.start();
		donator2.start();
		donator3.start();
		donator4.start();
		donator5.start();
		
		donator1.join();
		donator2.join();
		donator3.join();
		donator4.join();
		donator5.join();
		
		System.out.println("성금 총액은: " + same_account.gettotal());
	}
}