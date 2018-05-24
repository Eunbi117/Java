// 프로그래밍 문제 3-9
// 연도를 입력받아 윤년인지 아닌지 판단하는 프로그램

import java.util.*;

public class r3_9
{
	public static void main (String[] args)
	{
		System.out.println("입력받은 연도가 윤년인지 판단하는 프로그램입니다.\n");
		
		int year = 0;			// 연도
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("연도를 입력하세요 : ");
		year = sc.nextInt();	// 연도 입력
		
		if ( year % 4 == 0 && year % 100 != 0 )
				// 4로 나누어떨어지면 100으로 나누어떨어지지 않는 경우
		{
			System.out.println(year + " 년은 윤년입니다.");
		}
		else if ( year % 4 == 0 && year % 100 == 0 && year % 400 == 0 )
				// 4, 100, 400으로 나누어떨어지는 경우
		{
			System.out.println(year + " 년은 윤년입니다.");
		}
		else
		{
			System.out.println(year + " 년은 윤년이 아닙니다.");
		}
	}
}
