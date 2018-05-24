// 프로그래밍 문제 3-4
// 연간 근로소득에 따른 소득세를 계산하는 프로그램

import java.util.*;

public class r3_4
{
	public static void main (String[] args)
	{
		System.out.println("연간 근로소득에 따른 소득세를 계산하는 프로그램입니다.\n");
	
		int labor_income = 0;		// 연간 근로소득
		long income_tax = 0;		// 소득세
	
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("연간 근로소득을 입력하세요(단위 : 만 원)");
		labor_income = sc.nextInt();			// 연간 근로소득 입력
		
		// 소득세 계산
		if ( labor_income <= 20000000 )		// 연간 근로소득이 2000만원 이하
			income_tax = (long) (labor_income * 0.05);	// 소득세는 연간 근로소득의 5%

		else if ( labor_income <= 40000000) 			// 연간 근로소득이 (2000만원 초과), 4000만원 이하
			income_tax = (long) (labor_income * 0.15);	// 소득세는 연간 근로소득의 15%

		else if ( labor_income <= 80000000 )		// 연간 근로소득이 (4000만원 초과), 8000만원 이하
			income_tax = (long) (labor_income * 0.25);	// 소득세는 연간 근로소득의 25%

		else					// (연간 근로소득이 8000만원 초과)
			income_tax = (long) (labor_income * 0.4);	// 소득세는 연간 근로소득의 40%

		// 출력
		System.out.println("소득세 : " + income_tax + "원");
	}
}
