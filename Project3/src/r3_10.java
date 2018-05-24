// 프로그래밍 문제 3-10
// 이수학점과 TOEIC 점수에 따른 졸업과 수료 여부를 판단하는 프로그램

import java.util.*;

public class r3_10
{
	public static void main (String[] args)
	{
		System.out.println("이수학점과 TOEIC 점수에 따른 졸업과 수료 여부를 판단하는 프로그램입니다.\n");
		
		int credit = 0;			// 학생의 총 이수학점
		int TOEIC_score = 0;		// TOEIC 점수
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("학생의 총 이수학점을 입력하세요 : ");
		credit = sc.nextInt();
		System.out.print("TOEIC 점수를 입력하세요 : ");
		TOEIC_score = sc.nextInt();
		
		System.out.println("\n이수학점 : " + credit + ",	TOEIC 점수 : " + TOEIC_score);
		
		// 졸업과 수료 여부 판단
		if ( credit >= 140 && TOEIC_score >= 700 )
			System.out.println("졸업을 축하합니다.");
		else if ( credit >= 140 && TOEIC_score < 700 )
			System.out.println("아쉽지만 수료하셨습니다.");
		else				// credit < 140
			System.out.println("졸업이 불가합니다.");
	}
}
