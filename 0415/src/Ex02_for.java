import java.util.Scanner;

public class Ex02_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;//�� ���� �����ϴ� ����
		
		System.out.print("1~10������ �����Է�: ");
		int num = sc.nextInt();
		
		System.out.println("��\t��");
		for(int i = 1; i <= num; i++){
			sum += i;//sum = sum + i ����
			System.out.println(i + "\t" +sum);
		}
		
	}
}
