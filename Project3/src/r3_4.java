// ���α׷��� ���� 3-4
// ���� �ٷμҵ濡 ���� �ҵ漼�� ����ϴ� ���α׷�

import java.util.*;

public class r3_4
{
	public static void main (String[] args)
	{
		System.out.println("���� �ٷμҵ濡 ���� �ҵ漼�� ����ϴ� ���α׷��Դϴ�.\n");
	
		int labor_income = 0;		// ���� �ٷμҵ�
		long income_tax = 0;		// �ҵ漼
	
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �ٷμҵ��� �Է��ϼ���(���� : �� ��)");
		labor_income = sc.nextInt();			// ���� �ٷμҵ� �Է�
		
		// �ҵ漼 ���
		if ( labor_income <= 20000000 )		// ���� �ٷμҵ��� 2000���� ����
			income_tax = (long) (labor_income * 0.05);	// �ҵ漼�� ���� �ٷμҵ��� 5%

		else if ( labor_income <= 40000000) 			// ���� �ٷμҵ��� (2000���� �ʰ�), 4000���� ����
			income_tax = (long) (labor_income * 0.15);	// �ҵ漼�� ���� �ٷμҵ��� 15%

		else if ( labor_income <= 80000000 )		// ���� �ٷμҵ��� (4000���� �ʰ�), 8000���� ����
			income_tax = (long) (labor_income * 0.25);	// �ҵ漼�� ���� �ٷμҵ��� 25%

		else					// (���� �ٷμҵ��� 8000���� �ʰ�)
			income_tax = (long) (labor_income * 0.4);	// �ҵ漼�� ���� �ٷμҵ��� 40%

		// ���
		System.out.println("�ҵ漼 : " + income_tax + "��");
	}
}