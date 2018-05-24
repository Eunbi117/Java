// 프로그래밍 문제 4-12
// 자바 프로그래밍을 수강하는 학생들의 성적을 처리하는 프로그램

import java.util.*;

public class r4_12
{
	public static void main (String[] args)
	{
		System.out.println("자바 프로그래밍을 수강하는 학생들의 성적을 처리하는 프로그램입니다.\n");

		int score = 0;					// 점수 입력
		int a_num = 0;					// A학점을 받은 학생의 수
		int b_num = 0;					// B학점을 받은 학생의 수
		int c_num = 0;					// C학점을 받은 학생의 수
		int d_num = 0;					// D학점을 받은 학생의 수
		int f_num = 0;					// F학점을 받은 학생의 수
		
		boolean b_check = true;
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		while ( b_check )						// -99를 입력받을 때 까지 점수 입력 반복
		{
			System.out.print("점수를 입력하세요(더 이상 점수가 없다면 -99를 입력하세요): ");
			score = sc.nextInt();
			
			if ( score == -99 )					// -99를 입력받으면 while문 종료
			{
				b_check = false;
			}
			else								// 점수가 입력된 경우 학점 구분
			{
				if ( score > 100 || score < 0 )	// 입력받은 점수가 100보다 크거나 0보다 작은 경우
				{
					System.out.println("잘못 입력하셨습니다.");
				}
				else if ( score >= 90 )			// 90~100 사이의 점수 A 학점
				{
					//System.out.println("A학점입니다.");
					a_num++;
				}
				else if ( score >= 80 )			// 80~89 사이의 점수 B 학점
				{
					//System.out.println("B학점입니다.");
					b_num++;
				}
				else if ( score >= 70 )			// 70~79 사이의 점수 C 학점
				{
					//System.out.println("C학점입니다.");
					c_num++;
				}
				else if ( score >= 60 )			// 60~69 사이의 점수 D 학점
				{
					//System.out.println("D학점입니다.");
					d_num++;
				}
				else							// 0~59 사이의 점수 F 학점
				{
					//System.out.println("F학점입니다.");
					f_num++;
				}
			}
		}
		
		// 출력
		System.out.println("A학점을 받은 학생의 수 : " + a_num);
		System.out.println("B학점을 받은 학생의 수 : " + b_num);
		System.out.println("C학점을 받은 학생의 수 : " + c_num);
		System.out.println("D학점을 받은 학생의 수 : " + d_num);
		System.out.println("f학점을 받은 학생의 수 : " + f_num);
	}
}
