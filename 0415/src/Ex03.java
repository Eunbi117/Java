import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매 금액(0~500): ");
		int buy = sc.nextInt();
		
		int remain = 500 - buy;//거스름돈
		int mok = 0;
		
		for(int i = 100; i >= 1; i = i/10){
			mok = remain / i;//몇개인지 구함
			System.out.println(i+"원짜리 동전: "+mok);
			remain = remain % i;//나머지를 통해서 계산
		}
	}
}
