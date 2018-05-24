// 프로그래밍 문제 3-3
// 구입한 제품의 수량에 따른 가격을 계산하는 프로그램

import java.util.*;

public class r3_3
{
	public static void main (String[] args)
	{
		System.out.println("구입한 제품의 수량에 따른 가격을 계산하는 프로그램입니다.\n");

		int num = 0;					// 구입한 제품의 수량
		int price = 0;					// 가격
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("구입한 제품의 수량을 입력하세요 : ");
		num = sc.nextInt();				// 제품 수량 입력
		
		// 가격 계산
		if ( num >= 10 )			// 10개 이상 구입하면 10% 할인
		{
			price = (int)(100000 * num * 0.9);	// 가격 = 수량 * 100000 * 0.9
		}
		else					// (구입한 제품의 수량이 10개 미만)
		{
			price = 100000 * num;			// 가격 = 수량 * 100000
		}
		
		// 출력
		System.out.println("구입한 제품의 수량은 " + num + "개이고, 가격은 " + price + "원 입니다.");
	}
}
