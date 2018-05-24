// 프로그래밍 문제 3-8
// 여성과 남성의 신장을 입력받아 이상적인 체중을 계산하여 출력하는 프로그램

import java.util.*;

public class r3_8
{
	public static void main (String[] args)
	{
		System.out.println("여성과 남성의 신장을 입력받아 이상적인 체중을 계산하는 프로그램입니다.\n");
		
		int w_height = 0;		// 여성의 신장
		int m_height = 0;		// 남성의 신장
		double w_weight = 0;		// 여성의 이상적인 체중
		double m_weight = 0;		// 남성의 이상적인 체중
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("여성의 신장을 입력하세요 : ");
		w_height = sc.nextInt();		// 여성의 신장 입력
		System.out.print("남성의 신장을 입력하세요 : ");
		m_height = sc.nextInt();		// 남성의 신장 입력

		// 여성의 이상적인 체중 계산 및 출력
		if ( w_height > 150 )
			w_weight = 37.8 + 0.75 * (w_height - 150);
		else
			w_weight = 37.8;
		System.out.println("여성의 이상적인 체중은 " + w_weight + "이다.");

		// 남성의 이상적인 체중 계산 및 출력
		if ( m_height > 150 )
			m_weight = 40 + 0.89 * (m_height - 150);
		else
			m_weight = 40;
		System.out.println("남성의 이상적인 체중은 " + m_weight + "이다.");
	}
}
