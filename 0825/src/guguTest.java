
public class guguTest {
	public static void main(String[] args) {

		for(int i = 2; i <= 9; i++){//단수
			System.out.println(i + "단 시~작!");
			for(int j = 1; j<=9; j++){//곱할 숫자
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println();
		}
	}
}
