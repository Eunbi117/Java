import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		//3의 배수일 때
		if(num % 3 == 0){
			if(num % 5 == 0){
				System.out.println("이 숫자는 3과 5의 배수입니다.");
			}else{
				System.out.println("이 숫자는 3의 배수입니다.");
			}
		}
		if(num % 5 == 0){
			System.out.println("이 숫자는 5의 배수입니다.");
		}
		if(num % 8 == 0){
			System.out.println("이 숫자는 8의 배수입니다.");
		}
	}
}
