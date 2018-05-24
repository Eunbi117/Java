// 프로그래밍 문제 4-5
// 자바 프로그래밍 시험 점수를 입력받아 통과 점수를 받은 학생 수와 낙제 점수를 받은 학생 수를 계산하여 출력하는 프로그램

import java.util.*;

public class r4_5
{
	public static void main (String[] args)
	{
		System.out.println("통과와 낙제 점수를 받은 학생 수를 계산하여 출력하는 프로그램입니다.\n");
		
		int i = 0;						// 학생 수
		int score = 0;					// 점수
		int passing_num = 0;			// 통과 점수를 받은 학생 수
		int failure_num = 0;			// 낙제 점수를 받은 학생 수
		
		Scanner sc = new Scanner(System.in);
		
		while ( i < 1 )							// 학생의 수는 1명 이상
		{
			System.out.print("학생의 수를 입력하세요 : ");
			i = sc.nextInt();					// 학생 수 입력
		}
		
		for ( int j = 1 ; j <= i ; j++ )		// 학생 수만큼 점수 입력 반복
		{
			System.out.print(j + "번째 학생의 점수를 입력하세요 : ");
			score = sc.nextInt();				// 점수 입력

			if ( score >= 60 )					// 60점 이상 - 통과
			{
				System.out.println("통과 점수를 받으셨습니다.\n");
				passing_num++;					// 통과 점수를 받은 학생 수 1 증가
			}
			else								// 60점 미만 - 낙제
			{
				System.out.println("낙제 점수를 받으셨습니다.\n");
				failure_num++;					// 낙제 점수를 받은 학생 수 1 증가
			}
		}
		
		// 출력
		System.out.println("통과 : " + passing_num + "명, 낙제 : " + failure_num + "명");
	}
}
