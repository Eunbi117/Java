import java.util.Scanner;

public class Ex02_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;//총 값을 저장하는 변수
		
		System.out.print("1~10사이의 정수입력: ");
		int num = sc.nextInt();
		
		System.out.println("값\t합");
		for(int i = 1; i <= num; i++){
			sum += i;//sum = sum + i 누적
			System.out.println(i + "\t" +sum);
		}
		
	}
}
