import java.util.Scanner;

public class kg {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ű�� �����Ը� �Է����ּ���: ");
		int cm = scan.nextInt();
		int kg = scan.nextInt();
		
		double ordi = (cm - 100) * 0.9;
		
		if(ordi > kg)
			System.out.println("��ü���Դϴ�.");
		else if(ordi < kg)
			System.out.println("��ü���Դϴ�.");
		else
			System.out.println("ǥ���Դϴ�!");
	}
}
