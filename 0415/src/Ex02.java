import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է�: ");
		int num = sc.nextInt();
		
		//3�� ����� ��
		if(num % 3 == 0){
			if(num % 5 == 0){
				System.out.println("�� ���ڴ� 3�� 5�� ����Դϴ�.");
			}else{
				System.out.println("�� ���ڴ� 3�� ����Դϴ�.");
			}
		}
		if(num % 5 == 0){
			System.out.println("�� ���ڴ� 5�� ����Դϴ�.");
		}
		if(num % 8 == 0){
			System.out.println("�� ���ڴ� 8�� ����Դϴ�.");
		}
	}
}
