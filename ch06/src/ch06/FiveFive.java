package ch06;

public class FiveFive {
	int garo;
	int sero;
	private int dule;
	private int myun;

	FiveFive() {
		garo = 1;
		sero = 1;
	}

	public int Dule() {
		dule = (garo + sero) * 2;
		return dule;
	}

	public int Myun() {
		myun = garo * sero;
		return myun;
	}

	public int getGaro() {//���� �޼ҵ�-> ���� �Ű����� �ʿ����� �ʴ�
		//�̹� �� Ŭ���� ���� �Ӽ����� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//garo = a;
		return garo;
	}

	public int getSero() {
		//sero = a;
		return sero;
	}

	public void setGaro(int a) {
		if (a > 0 && a < 20) {
			garo = a;
		} else {
			System.out.println("����");
		}
	}

	public void setSero(int a) {
		if (a > 0 && a < 20) {
			sero = a;
		} else {
			System.out.println("����");
		}
	}
}
