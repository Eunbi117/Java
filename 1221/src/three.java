import java.util.Scanner;

public class three {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 수를 입력하세요: ");
		int one = scan.nextInt();
		
		System.out.print("두번째 수를 입력하세요: ");
		int two = scan.nextInt();
		
		System.out.print("세번째 수를 입력하세요: ");
		int three = scan.nextInt();
		
		int max = one;
		int min = one;
		
		if(max < two){
			max = two;
		}
		if(max < three){
			max = three;
		}
		
		if(min > two){
			min = two;
		}
		if(min > three){
			min = three;
		}
		
		int sum = 0;
		sum = one+two+three;
		
		double aver = 0;
		aver = sum/3.0;
		
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		System.out.println("합계: " + sum);
		System.out.println("평균: " + aver);
		
	}

}
