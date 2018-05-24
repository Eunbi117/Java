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

	public int getGaro() {//접근 메소드-> 따로 매개변수 필요하지 않다
		//이미 이 클래스 내에 속성값을 접근하여 반환하는 메소드
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
			System.out.println("에러");
		}
	}

	public void setSero(int a) {
		if (a > 0 && a < 20) {
			sero = a;
		} else {
			System.out.println("에러");
		}
	}
}
