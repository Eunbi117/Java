package ch07;

//7번 문제
class Coin{
	String now;//현재 면
	
	public Coin(){
		int x = (int) (Math.random() * 2) + 1;//1~2사이의 난수 발생
		if(x == 1){
			now = "앞면";
		}
		else if(x == 2){
			now = "뒷면";
		}
	}
	
	public String getCoin(){
		return now;
	}
}

public class CoinDriver{
	public static void main(String[] args) {
		Coin c = new Coin();//객체 생성을 하면서 현재의 면이 임의로 선언됨->동전 던짐
		
		System.out.println("현재면: " + c.getCoin());
	}
}