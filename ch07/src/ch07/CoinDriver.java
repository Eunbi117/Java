package ch07;

//7�� ����
class Coin{
	String now;//���� ��
	
	public Coin(){
		int x = (int) (Math.random() * 2) + 1;//1~2������ ���� �߻�
		if(x == 1){
			now = "�ո�";
		}
		else if(x == 2){
			now = "�޸�";
		}
	}
	
	public String getCoin(){
		return now;
	}
}

public class CoinDriver{
	public static void main(String[] args) {
		Coin c = new Coin();//��ü ������ �ϸ鼭 ������ ���� ���Ƿ� �����->���� ����
		
		System.out.println("�����: " + c.getCoin());
	}
}