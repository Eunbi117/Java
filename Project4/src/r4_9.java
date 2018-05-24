// 프로그래밍 문제 4-9
// 랜덤으로 지정된 1~10 사이의 숫자 맞추기 게임

import java.util.*;

public class r4_9
{
	public static void main (String[] args)
	{
		System.out.println("1~10 사이의 랜덤 숫자 맞추기 게임입니다.\n");
		
		int random_num = 0;			// 맞춰야 할 숫자
		int input_num = 0;			// 입력한 숫자
		
		boolean b_check = true;

		// 입력
		Scanner sc = new Scanner(System.in);
		
		random_num = (int)(Math.random() * 10) + 1;		// 1~10 사이의 숫자

		while ( b_check )
		{
			System.out.print("추측한 숫자를 입력하세요 : ");
			input_num = sc.nextInt();
			
			if ( random_num == input_num )			// 추측한 숫자가 맞는 경우
			{
				System.out.println("맞추셨습니다.");
				b_check = false;					// 종료
			}
			else									// 추측한 숫자가 틀린 경우
			{
				System.out.println("추측한 숫자가 틀렸습니다.");
				
				if ( random_num < input_num )		// 추측한 숫자가 큰 경우
					System.out.println("추측한 숫자가 너무 큽니다.\n");
				else								// 추측한 숫자가 작은 경우
					System.out.println("추측한 숫자가 너무 작습니다.\n");
			}
		}
	}
}
