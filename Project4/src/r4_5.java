// ���α׷��� ���� 4-5
// �ڹ� ���α׷��� ���� ������ �Է¹޾� ��� ������ ���� �л� ���� ���� ������ ���� �л� ���� ����Ͽ� ����ϴ� ���α׷�

import java.util.*;

public class r4_5
{
	public static void main (String[] args)
	{
		System.out.println("����� ���� ������ ���� �л� ���� ����Ͽ� ����ϴ� ���α׷��Դϴ�.\n");
		
		int i = 0;						// �л� ��
		int score = 0;					// ����
		int passing_num = 0;			// ��� ������ ���� �л� ��
		int failure_num = 0;			// ���� ������ ���� �л� ��
		
		Scanner sc = new Scanner(System.in);
		
		while ( i < 1 )							// �л��� ���� 1�� �̻�
		{
			System.out.print("�л��� ���� �Է��ϼ��� : ");
			i = sc.nextInt();					// �л� �� �Է�
		}
		
		for ( int j = 1 ; j <= i ; j++ )		// �л� ����ŭ ���� �Է� �ݺ�
		{
			System.out.print(j + "��° �л��� ������ �Է��ϼ��� : ");
			score = sc.nextInt();				// ���� �Է�

			if ( score >= 60 )					// 60�� �̻� - ���
			{
				System.out.println("��� ������ �����̽��ϴ�.\n");
				passing_num++;					// ��� ������ ���� �л� �� 1 ����
			}
			else								// 60�� �̸� - ����
			{
				System.out.println("���� ������ �����̽��ϴ�.\n");
				failure_num++;					// ���� ������ ���� �л� �� 1 ����
			}
		}
		
		// ���
		System.out.println("��� : " + passing_num + "��, ���� : " + failure_num + "��");
	}
}
