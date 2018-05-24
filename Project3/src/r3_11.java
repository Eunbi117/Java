// 프로그래밍 문제 3-11
// 이전 잔고와 당월 사용금액을 입력받아 연체이자와 새 잔고, 최소 입금액을 계산하여 당월 카드 이용대금 명세서를 출력하는 프로그램

import java.util.*;

public class r3_11
{
	public static void main (String[] args)
	{
		System.out.println("당월 카드 이용대금 명세서를 출력하는 프로그램입니다.\n");
		
		int unsettled = 0;				// 이전 잔고 (미결제금액)
		int spot_month_amounts = 0;		// 당월 사용금액
		double overdue_interest = 0;	// 연체이자
		double bank_balance = 0;		// 새 잔고 (입금해야 할 총 금액)
		double mininum_deposit = 0;		// 최소 입금액
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("이전 잔고(미결제금액)를 입력하세요 : ");
		unsettled = sc.nextInt();				// 이전 잔고 입력
		System.out.print("당월 사용금액을 입력하세요 : ");
		spot_month_amounts = sc.nextInt();		// 당월 사용금액 입력
		
		// 연체이자와 새 잔고 계산
		if ( unsettled > 0 )			// 이전잔고가 0원 이상일 경우
			overdue_interest = (unsettled + spot_month_amounts)	* 0.02;

		bank_balance = unsettled + spot_month_amounts + overdue_interest;
		
		// 최소 입금액 계산
		if ( bank_balance < 100000)		// 새 잔고가 100000원 미만인 경우
			mininum_deposit = bank_balance;	// 최소 입금액은 새 잔고

		else if ( bank_balance <= 300000 )		// 새 잔고가 (100000원 이상), 300000원 이하인 경우
			mininum_deposit = 100000;		// 최소 입금액은 100000원

		else										// 새 잔고가 300000원 초과인 경우
			mininum_deposit = bank_balance * 0.2;	// 최소 입금액은 새 잔고의 20%
		
		// 출력
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│\t당월 카드 이용대금 명세서\t│");
		System.out.println("│\t\t\t\t│");
		System.out.println("│미결제금액 : " + unsettled + "원\t\t│");
		System.out.println("│당월 사용금액 : " + spot_month_amounts + "원\t\t│");
		System.out.println("│연체이자 : " + overdue_interest + "원\t\t\t│");
		System.out.println("│\t\t\t\t│");
		System.out.println("│입금해야 할 총 금액 : " + bank_balance + "원\t│");
		System.out.println("│최소 입금액 : " + mininum_deposit + "원\t\t│");
		System.out.println("└───────────────────────────────┘");
	}
}
