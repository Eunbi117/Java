// ���α׷��� ���� 3-7
// �� ������ �ٹ� �򰡵�޿� ���� ���� �λ�װ� �� ������ ����Ͽ� ����ϴ� ���α׷�

import java.util.*;

public class r3_7
{
	public static void main (String[] args)
	{
		System.out.println("�� ������ �ٹ� �򰡵�޿� ���� ���� �λ�װ� �� ������ ����ϴ� ���α׷��Դϴ�.\n");

		int annual_income = 0;				// �� ����
		String grade;					// �ٹ� �򰡵��
		double increased_amount = 0;			// �λ�ݾ�

		boolean b_Check = true;	// �򰡵���� ����� �ԷµǾ����� Ȯ��

		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ������ �Է��ϼ��� : ");
		annual_income = sc.nextInt();			// �� ���� �Է�

		while( b_Check )
		{
			System.out.print("�ٹ� �򰡵���� �Է��ϼ���(���, ����, �ҷ�) : ");
			grade = sc.next();			// �ٹ� �򰡵�� �Է�

			// �ٹ� �򰡵�޿� ���� ���� �λ�� ���
			switch (grade)
			{
				case "���":
					increased_amount = annual_income * 0.06;
							// ���� �λ���� �� ������ 6%
					b_Check = false;
					break;
				case "����":
					increased_amount = annual_income * 0.04;
							// ���� �λ���� �� ������ 4%
					b_Check = false;
					break;
				case "�ҷ�":
					increased_amount = annual_income * 0.02;
							// ���� �λ���� �� ������ 2%
					b_Check = false;
					break;
				default:
					System.out.println("�򰡵���� �߸� �Է��ϼ̽��ϴ�.\n");
					break;
			}
		}
		
		// ���
		System.out.println("���� �λ�� : " + increased_amount);
		System.out.println("�� ���� : " + (annual_income + increased_amount));
	}
}