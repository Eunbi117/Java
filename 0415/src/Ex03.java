import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ݾ�(0~500): ");
		int buy = sc.nextInt();
		
		int remain = 500 - buy;//�Ž�����
		int mok = 0;
		
		for(int i = 100; i >= 1; i = i/10){
			mok = remain / i;//����� ����
			System.out.println(i+"��¥�� ����: "+mok);
			remain = remain % i;//�������� ���ؼ� ���
		}
	}
}
