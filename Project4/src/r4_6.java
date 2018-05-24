// 프로그래밍 문제 4-6
// 퀴즈 시험 점수의 최고 점수, 최저 점수, 평균 점수를 계산하는 프로그램

import java.util.*;

public class r4_6
{
	public static void main (String[] args)
	{
		System.out.println("퀴즈 시험 점수의 최고, 최저, 평균 점수를 계산하는 프로그램입니다.\n");
		
		int i = 0;						// 학생 수
		int score = 0;					// 점수
		int max = 0;					// 최고점
		int min = 0;					// 최저점
		int sum = 0;					// 점수 합계
		double average = 0;				// 평균 점수
		
		boolean b_check = true;
		
		// 입력
		Scanner sc = new Scanner(System.in);
		
		while ( b_check )			// -99를 입력받을 때 까지 점수 입력 반복
		{
			System.out.print((i + 1) + "번째 학생의 점수를 입력하세요 : ");
			score = sc.nextInt();			// 점수 입력
			
			if ( score == -99 )				// 입력 받은 값이 -99일 경우
			{
				b_check = false;			// 종료
			}
			
			else
			{
				i++;						// 입력받은 학생의 수 1 증가
				sum += score;				// 학생들의 점수 합계

				if ( i == 1 )				// 첫 학생의 점수
				{
					max = score;			// 최대값에 점수 저장
					min = score;			// 최소값에 점수 저장
				}

				else if ( score > max )		// 입력받은 값이 최고점보다 큰 경우
				{
					max = score;
				}
				else if ( score < min )		// 입력받은 값이 최저점보다 작은 경우
				{
					min = score;
				}
			}
		}
		
		average = (double) sum / i;			// 평균 = 합계 / 학생 수

		// 출력
		System.out.println("\n총 " + i + "명의 학생의 점수가 입력되었습니다.\n");
		System.out.println("최고점 : " + max + ", 최저점 : " + min + ", 평균 : " + average);
	}
}
