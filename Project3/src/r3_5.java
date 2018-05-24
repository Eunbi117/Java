// 프로그래밍 문제 3-5
// 나이별로 영화 관람 가능 여부를 판단하는 프로그램

import java.util.*;

public class r3_5
{
	public static void main (String[] args)
	{
		System.out.println("입력받은 나이에 따른 영화 관람 가능 여부를 판단하는 프로그램입니다.\n");

		int age = 0;						// 나이
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요.");
		age = sc.nextInt();					// 나이 입력
		
		// 영화 관람 가능 여부 판단 및 출력
		if ( age >= 19 )						// 19세 이상
			System.out.println("영화를 볼 수 있습니다.");	// 관람 가능

		else if ( age >= 15 )				// (19세 미만), 15세 이상
			System.out.println("성인이 동반한 경우에만 영화를 볼 수 있습니다.");	// 성인 동반시 관람 가능

		else						// 15세 미만
			System.out.println("영화를 볼 수 없습니다.");							// 영화 관람 불가능
	}
}
