// 프로그래밍 문제 4-10
// 랜덤으로 지정된 1~100 사이의 숫자 맞추기 게임 - 종료를 원할 때까지 반복

import java.util.*;

public class r4_10
{
	public static void main (String[] args)
	{
		System.out.println("1~100 사이의 랜덤 숫자 맞추기 게임입니다.\n");

		int random_num = 0;				// 맞춰야 할 숫자
		int input_num = 0;				// 입력한 숫자
		int count = 0;					// 숫자를 입력한 횟수
		String continue_input="";			// 숫자 맞추기 게임을 계속할지 입력
		
		boolean continue_check = true;

		// 입력
		Scanner sc = new Scanner(System.in);
		
		while ( continue_check )
		{
			random_num = (int)(Math.random() * 100) + 1;		// 1~100 사이의 숫자

			boolean b_check = true;
			
			while ( b_check )
			{
				System.out.print("추측한 숫자를 입력하세요 (그만두려면 0 입력) : ");
				input_num = sc.nextInt();
				count++;
				
				if ( input_num == 0 )
				{
					b_check = false;			// 종료
				}
				else if ( random_num == input_num )		// 추측한 숫자가 맞는 경우
				{
					System.out.println("맞추셨습니다.\n");
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
			
			System.out.println("추측한 횟수 : " + count + "\n");
			
			// 숫자 맞추기 게임을 계속할지 확인
			System.out.print("게임을 계속 하시겠습니까? (그만두려면 q 입력) ");
			continue_input = sc.next();
			
			if ( continue_input.equals("q") )			// q 를 입력받으면 종료
			{
				System.out.println("게임을 종료합니다.");
				continue_check = false;					// 종료
			}
			else
			{
				System.out.println("게임을 계속합니다.\n");
				count = 0;//다시 게임 시작시 추측한 횟수 초기화
			}
		}
	}
}
