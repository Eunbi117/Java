package ch09;

class MonetaryCoin extends Coin {
	private int value;// ������ ���� ��

	// ������ �޼ҵ�
	public MonetaryCoin(int value) {
		super();// �θ� Ŭ������ Coin�� ������ �޼ҵ� ȣ��
		this.value = value;// �ʱ�ȭ
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// ���� ���� ���
	public String nowValue(int i) {
		String result = "���� " + i + ":";
		result += " ���� �� = " + getCoin();// �θ� Ŭ���� Coin���� ���� �� ��ȯ�ϴ� �޼ҵ�
		result += " �� = " + getValue();

		return result;
	}
}

public class MonetaryCoinDriver {
	public static void main(String[] args) {
		MonetaryCoin[] mc = new MonetaryCoin[4];

		// ���� �迭�� �׳� �ȿ� null�� �����Ǵ� ���ϻ�!
		// ������ �޼ҵ带 �θ��� ���� �ƴϱ� ������ �� �迭�� ������ �޼ҵ带 ȣ���� �־�� �Ѵ�.
		mc[0] = new MonetaryCoin(10);
		mc[1] = new MonetaryCoin(50);
		mc[2] = new MonetaryCoin(100);
		mc[3] = new MonetaryCoin(500);

		for (int i = 0; i < mc.length; i++) {
			// ���� ���� ���
			System.out.println(mc[i].nowValue(i + 1));
		}
	}
}
