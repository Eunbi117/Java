import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double kg = 0;
		
		System.out.print("����(����/����): ");
		String sung = sc.next();
		
		System.out.print("Ű: ");
		double height = sc.nextDouble();
		
		if(sung.equals("����")){
			
			if(height > 150){
				kg = (37.8 + 0.89 * (height-150));
				System.out.println("�� ����� �̻����� �����Դ� " + kg + "�Դϴ�.");
			}
			else{
				kg = 37.8;
				System.out.println("�� ����� �̻����� �����Դ� " + kg + "�Դϴ�.");
			}
			
		}else if(sung.equals("����")){
			if(height > 150){
				kg = (40 + 0.89 * (height-150));
				System.out.println("�� ����� �̻����� �����Դ� " + kg + "�Դϴ�.");
			}
			else{
				kg = 40;
				System.out.println("�� ����� �̻����� �����Դ� " + kg + "�Դϴ�.");
			}
		}else{
			System.out.println("�׷� ���� ����");
		}
		
		
	}
}
