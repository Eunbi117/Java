import java.util.*;

public class minus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int minus = 0;
		
		System.out.print("���� �ΰ��� �����ÿ�: ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if(num1 < 0 || num2 >= 10){
			System.out.println("����Ҽ� ����");
		}else{
			minus = num1-num2;
			
			System.out.println(minus);
		}
	}
}
