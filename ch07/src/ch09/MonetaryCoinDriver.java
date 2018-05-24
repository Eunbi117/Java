package ch09;

class MonetaryCoin extends Coin {
	private int value;// 동전의 현재 값

	// 생성자 메소드
	public MonetaryCoin(int value) {
		super();// 부모 클래스인 Coin의 생성자 메소드 호출
		this.value = value;// 초기화
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// 동전 정보 출력
	public String nowValue(int i) {
		String result = "동전 " + i + ":";
		result += " 현재 면 = " + getCoin();// 부모 클래스 Coin에서 현재 면 반환하는 메소드
		result += " 값 = " + getValue();

		return result;
	}
}

public class MonetaryCoinDriver {
	public static void main(String[] args) {
		MonetaryCoin[] mc = new MonetaryCoin[4];

		// 위의 배열은 그냥 안에 null로 생성되는 것일뿐!
		// 생성자 메소드를 부르는 것이 아니기 때문에 각 배열에 생성자 메소드를 호출해 주어야 한다.
		mc[0] = new MonetaryCoin(10);
		mc[1] = new MonetaryCoin(50);
		mc[2] = new MonetaryCoin(100);
		mc[3] = new MonetaryCoin(500);

		for (int i = 0; i < mc.length; i++) {
			// 동전 정보 출력
			System.out.println(mc[i].nowValue(i + 1));
		}
	}
}
