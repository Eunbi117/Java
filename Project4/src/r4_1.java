// 프로그래밍 문제 4-1
// 인터넷 뱅킹을 위한 암호를 처리하는 프로그램

import java.util.*;

public class r4_1
{
	public static void main (String[] args)
	{
		System.out.println("인터넷 뱅킹을 위한 암호를 처리하는 프로그램입니다.\n");
		
		String input = "";							// 입력받은 암호
		int i = 0;									// 잘못된 암호 입력 횟수

		boolean b_check = true;
		
		while ( b_check )
		{
			System.out.print("암호를 입력하세요 : ");
			
			// 입력
			Scanner sc = new Scanner(System.in);
			input = sc.next();						// 암호 입력
			
			if ( input.equals("myongji60") )			// 맞는 암호가 입력된 경우
			{
				System.out.println("환영합니다.");
				b_check = false;					// 반복문 종료
			}

			else									// 잘못된 암호가 입력된 경우
			{
				System.out.println("암호가 틀립니다.");
				i++;								// 잘못된 암호 입력 횟수 증가
				System.out.println(i + "번 잘못 입력하셨습니다.\n");

				if ( i == 3 )						// 3번 잘못 입력한 경우
				{
					System.out.println("접속을 거부합니다.");
					b_check = false;				// 반복문 종료
				}
			}
		}
	}
}
