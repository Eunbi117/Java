// 프로그래밍 문제 4-8
// 워드라는 손님이 탈 때까지의 택시요금을 계산하는 프로그램

import java.util.*;

public class r4_8
{
	public static void main (String[] args)
	{
		System.out.println("워드라는 손님이 탈 때까지의 택시요금을 계산하는 프로그램입니다.\n");
		
		String name = "";		// 손님 이름
		int fare = 0;			// 요금
		int sum = 0;			// 수입 합계
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		while ( !(name.equals("워드")) )		// 워드가 입력될 때까지 반복
		{
			System.out.print("손님의 이름을 입력하세요 : ");
			name = sc.next();					// 손님의 이름 입력
			System.out.print("요금을 입력하세요 : ");
			fare = sc.nextInt();				// 요금 입력
			
			sum += fare;						// 수입 합계 = 이전 합계 + 입력된 요금
		}
		
		// 출력
		System.out.println("\n총 수입은 " + sum + "원입니다.");
	}
}
