// ���α׷��� ���� 4-6
// ���� ���� ������ �ְ� ����, ���� ����, ��� ������ ����ϴ� ���α׷�

import java.util.*;

public class r4_6
{
	public static void main (String[] args)
	{
		System.out.println("���� ���� ������ �ְ�, ����, ��� ������ ����ϴ� ���α׷��Դϴ�.\n");
		
		int i = 0;						// �л� ��
		int score = 0;					// ����
		int max = 0;					// �ְ���
		int min = 0;					// ������
		int sum = 0;					// ���� �հ�
		double average = 0;				// ��� ����
		
		boolean b_check = true;
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		
		while ( b_check )			// -99�� �Է¹��� �� ���� ���� �Է� �ݺ�
		{
			System.out.print((i + 1) + "��° �л��� ������ �Է��ϼ��� : ");
			score = sc.nextInt();			// ���� �Է�
			
			if ( score == -99 )				// �Է� ���� ���� -99�� ���
			{
				b_check = false;			// ����
			}
			
			else
			{
				i++;						// �Է¹��� �л��� �� 1 ����
				sum += score;				// �л����� ���� �հ�

				if ( i == 1 )				// ù �л��� ����
				{
					max = score;			// �ִ밪�� ���� ����
					min = score;			// �ּҰ��� ���� ����
				}

				else if ( score > max )		// �Է¹��� ���� �ְ������� ū ���
				{
					max = score;
				}
				else if ( score < min )		// �Է¹��� ���� ���������� ���� ���
				{
					min = score;
				}
			}
		}
		
		average = (double) sum / i;			// ��� = �հ� / �л� ��

		// ���
		System.out.println("\n�� " + i + "���� �л��� ������ �ԷµǾ����ϴ�.\n");
		System.out.println("�ְ��� : " + max + ", ������ : " + min + ", ��� : " + average);
	}
}
