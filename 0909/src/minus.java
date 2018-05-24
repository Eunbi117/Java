import java.util.*;

public class minus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int minus = 0;
		
		System.out.print("숫자 두개를 받으시오: ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if(num1 < 0 || num2 >= 10){
			System.out.println("계산할수 없음");
		}else{
			minus = num1-num2;
			
			System.out.println(minus);
		}
	}
}
