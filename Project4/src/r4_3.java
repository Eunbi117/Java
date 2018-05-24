// 프로그래밍 문제 4-3-for
// 거스름돈을 계산하는 프로그램

import java.util.*;

public class r4_3
{
	public static void main (String[] args)
	{
		System.out.println("거스름돈을 계산하는 프로그램입니다.\n");
		
		int price = 0;			// 구매 금액
		int change = 0;			// 거스름돈
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("구매금액을 입력하세요 [0-500] : ");
		price = sc.nextInt();			// 구매 금액 입력
		
		change = 500 - price;			// 거스름돈 = 500 - 구매 금액

		System.out.println(change + "원의 거스름돈은 다음과 같다:");

		for ( int i = 1 ; change != 0 ; i *= 10 )		// 거스름돈이 0원이면 종료, 반복할 때마다 i * 10
		{
			// 1의 자리부터 동전의 갯수 계산
			System.out.println("\t" + i + "원 짜리 동전\t" + (change % 10) + "개");
			change /= 10;				// 거스름돈 = 거스름돈 / 10
										// 출력이 끝난 1의 자리 숫자 떼어 버림
		}
	}
}
