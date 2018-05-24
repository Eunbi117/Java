import java.util.Scanner;

public class kg {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("키와 몸무게를 입력해주세요: ");
		int cm = scan.nextInt();
		int kg = scan.nextInt();
		
		double ordi = (cm - 100) * 0.9;
		
		if(ordi > kg)
			System.out.println("저체중입니다.");
		else if(ordi < kg)
			System.out.println("과체중입니다.");
		else
			System.out.println("표준입니다!");
	}
}
