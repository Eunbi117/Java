// ���α׷��� ���� 3-10
// �̼������� TOEIC ������ ���� ������ ���� ���θ� �Ǵ��ϴ� ���α׷�

import java.util.*;

public class r3_10
{
	public static void main (String[] args)
	{
		System.out.println("�̼������� TOEIC ������ ���� ������ ���� ���θ� �Ǵ��ϴ� ���α׷��Դϴ�.\n");
		
		int credit = 0;			// �л��� �� �̼�����
		int TOEIC_score = 0;		// TOEIC ����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�л��� �� �̼������� �Է��ϼ��� : ");
		credit = sc.nextInt();
		System.out.print("TOEIC ������ �Է��ϼ��� : ");
		TOEIC_score = sc.nextInt();
		
		System.out.println("\n�̼����� : " + credit + ",	TOEIC ���� : " + TOEIC_score);
		
		// ������ ���� ���� �Ǵ�
		if ( credit >= 140 && TOEIC_score >= 700 )
			System.out.println("������ �����մϴ�.");
		else if ( credit >= 140 && TOEIC_score < 700 )
			System.out.println("�ƽ����� �����ϼ̽��ϴ�.");
		else				// credit < 140
			System.out.println("������ �Ұ��մϴ�.");
	}
}
