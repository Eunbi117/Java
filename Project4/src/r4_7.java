// 프로그래밍 문제 4-7
// 10명의 손님의 택시 요금을 계산하는 프로그램

import java.util.*;

public class r4_7
{
	public static void main (String[] args)
	{
		System.out.println("10명의 손님의 택시 요금을 계산하는 프로그램입니다.\n");
		
		int fare = 0;			// 요금
		int sum = 0;			// 수입 합계
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 1 ; i <= 10 ; i++ )		// 손님 수만큼 반복
		{
			System.out.print(i + "번째 손님의 요금을 입력하세요 : ");
			fare = sc.nextInt();				// 요금 입력
			
			sum += fare;
		}
		
		// 출력
		System.out.println("\n총 수입 : " + sum + "원");
	}
}
