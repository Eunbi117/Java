// ���α׷��� ���� 4-12
// �ڹ� ���α׷����� �����ϴ� �л����� ������ ó���ϴ� ���α׷�

import java.util.*;

public class r4_12
{
	public static void main (String[] args)
	{
		System.out.println("�ڹ� ���α׷����� �����ϴ� �л����� ������ ó���ϴ� ���α׷��Դϴ�.\n");

		int score = 0;					// ���� �Է�
		int a_num = 0;					// A������ ���� �л��� ��
		int b_num = 0;					// B������ ���� �л��� ��
		int c_num = 0;					// C������ ���� �л��� ��
		int d_num = 0;					// D������ ���� �л��� ��
		int f_num = 0;					// F������ ���� �л��� ��
		
		boolean b_check = true;
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		
		while ( b_check )						// -99�� �Է¹��� �� ���� ���� �Է� �ݺ�
		{
			System.out.print("������ �Է��ϼ���(�� �̻� ������ ���ٸ� -99�� �Է��ϼ���): ");
			score = sc.nextInt();
			
			if ( score == -99 )					// -99�� �Է¹����� while�� ����
			{
				b_check = false;
			}
			else								// ������ �Էµ� ��� ���� ����
			{
				if ( score > 100 || score < 0 )	// �Է¹��� ������ 100���� ũ�ų� 0���� ���� ���
				{
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				else if ( score >= 90 )			// 90~100 ������ ���� A ����
				{
					//System.out.println("A�����Դϴ�.");
					a_num++;
				}
				else if ( score >= 80 )			// 80~89 ������ ���� B ����
				{
					//System.out.println("B�����Դϴ�.");
					b_num++;
				}
				else if ( score >= 70 )			// 70~79 ������ ���� C ����
				{
					//System.out.println("C�����Դϴ�.");
					c_num++;
				}
				else if ( score >= 60 )			// 60~69 ������ ���� D ����
				{
					//System.out.println("D�����Դϴ�.");
					d_num++;
				}
				else							// 0~59 ������ ���� F ����
				{
					//System.out.println("F�����Դϴ�.");
					f_num++;
				}
			}
		}
		
		// ���
		System.out.println("A������ ���� �л��� �� : " + a_num);
		System.out.println("B������ ���� �л��� �� : " + b_num);
		System.out.println("C������ ���� �л��� �� : " + c_num);
		System.out.println("D������ ���� �л��� �� : " + d_num);
		System.out.println("f������ ���� �л��� �� : " + f_num);
	}
}
