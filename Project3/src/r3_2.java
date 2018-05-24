// 프로그래밍 문제 3-2
// 입력받은 양의 정수가 3의 배수, 5의 배수, 8의 배수인지 판단하는 프로그램

import java.util.*;

public class r3_2
{
	public static void main (String[] args)
	{
		System.out.println("입력받은 양의 정수가 3의 배수, 5의 배수, 8의 배수인지 판단하는 프로그램입니다.\n");

		int input = 0;
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		input = sc.nextInt();			// 양의 정수 입력
		
		// 배수 판단
		if ( input % 3 == 0 )			// 3의 배수를 만족하는 경우
		{
			if ( input % 5 == 0 && input % 8 == 0 )			// 5의 배수, 8의 배수도 모두 만족하는 경우
				System.out.println("3의 배수, 5의 배수, 8의 배수이다.");
			else if ( input % 5 == 0 && input % 8 != 0 )	// 5의 배수는 만족, 8의 배수는 만족하지 않는 경우
				System.out.println("3의 배수, 5의 배수이다.");
			else if ( input % 5 != 0 && input % 8 == 0 )	// 5의 배수는 만족하지 않고 8의 배수는 만족하는 경우
				System.out.println("3의 배수, 8의 배수이다.");
			else											// 5의 배수, 8의 배수를 모두 만족하지 않는 경우
				System.out.println("3의 배수이다.");
		}
		
		else					// 3의 배수를 만족하지 않는 경우
		{
			if ( input % 5 == 0 && input % 8 == 0 )			// 5의 배수, 8의 배수도 모두 만족하는 경우
				System.out.println("5의 배수, 8의 배수이다.");
			else if ( input % 5 == 0 && input % 8 != 0 )	// 5의 배수는 만족, 8의 배수는 만족하지 않는 경우
				System.out.println("5의 배수이다.");
			else if ( input % 5 != 0 && input % 8 == 0 )	// 5의 배수는 만족하지 않고 8의 배수는 만족하는 경우
				System.out.println("8의 배수이다.");
			else											// 5의 배수, 8의 배수를 모두 만족하지 않는 경우
				System.out.println("어느 배수도 아니다.");
		}
	}
}
