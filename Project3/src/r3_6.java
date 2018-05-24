// 프로그래밍 문제 3-6
// 날씨에 따라 적절한 활동을 판단하여 출력하는 프로그램

import java.util.*;

public class r3_6
{
	public static void main (String[] args)
	{
		System.out.println("날씨에 따라 적절한 활동을 판단하여 출력하는 프로그램입니다.\n");

		int temperature = 0;					// 온도
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("온도를 입력하세요 : ");
		temperature = sc.nextInt();				// 온도 입력
		
		// 적절한 활동 판단 및 출력
		if ( temperature >= 25 )					// 25도 이상
			System.out.println("수영을 권합니다.");		// 수영
		else if ( temperature >= 15 )			// (25도 미만), 15도 이상
			System.out.println("테니스를 권합니다.");		// 테니스
		else if ( temperature >= 5 )			// (15도 미만), 5도 이상
			System.out.println("골프를 권합니다.");		// 골프
		else							// 5도 미만
			System.out.println("스키를 권합니다.");		// 스키
	}
}
