// ���α׷��� ���� 3-11
// ���� �ܰ�� ��� ���ݾ��� �Է¹޾� ��ü���ڿ� �� �ܰ�, �ּ� �Աݾ��� ����Ͽ� ��� ī�� �̿��� ������ ����ϴ� ���α׷�

import java.util.*;

public class r3_11
{
	public static void main (String[] args)
	{
		System.out.println("��� ī�� �̿��� ������ ����ϴ� ���α׷��Դϴ�.\n");
		
		int unsettled = 0;				// ���� �ܰ� (�̰����ݾ�)
		int spot_month_amounts = 0;		// ��� ���ݾ�
		double overdue_interest = 0;	// ��ü����
		double bank_balance = 0;		// �� �ܰ� (�Ա��ؾ� �� �� �ݾ�)
		double mininum_deposit = 0;		// �ּ� �Աݾ�
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ܰ�(�̰����ݾ�)�� �Է��ϼ��� : ");
		unsettled = sc.nextInt();				// ���� �ܰ� �Է�
		System.out.print("��� ���ݾ��� �Է��ϼ��� : ");
		spot_month_amounts = sc.nextInt();		// ��� ���ݾ� �Է�
		
		// ��ü���ڿ� �� �ܰ� ���
		if ( unsettled > 0 )			// �����ܰ� 0�� �̻��� ���
			overdue_interest = (unsettled + spot_month_amounts)	* 0.02;

		bank_balance = unsettled + spot_month_amounts + overdue_interest;
		
		// �ּ� �Աݾ� ���
		if ( bank_balance < 100000)		// �� �ܰ� 100000�� �̸��� ���
			mininum_deposit = bank_balance;	// �ּ� �Աݾ��� �� �ܰ�

		else if ( bank_balance <= 300000 )		// �� �ܰ� (100000�� �̻�), 300000�� ������ ���
			mininum_deposit = 100000;		// �ּ� �Աݾ��� 100000��

		else										// �� �ܰ� 300000�� �ʰ��� ���
			mininum_deposit = bank_balance * 0.2;	// �ּ� �Աݾ��� �� �ܰ��� 20%
		
		// ���
		System.out.println();
		System.out.println();
		System.out.println("������������������������������������������������������������������");
		System.out.println("��\t��� ī�� �̿��� ����\t��");
		System.out.println("��\t\t\t\t��");
		System.out.println("���̰����ݾ� : " + unsettled + "��\t\t��");
		System.out.println("����� ���ݾ� : " + spot_month_amounts + "��\t\t��");
		System.out.println("����ü���� : " + overdue_interest + "��\t\t\t��");
		System.out.println("��\t\t\t\t��");
		System.out.println("���Ա��ؾ� �� �� �ݾ� : " + bank_balance + "��\t��");
		System.out.println("���ּ� �Աݾ� : " + mininum_deposit + "��\t\t��");
		System.out.println("������������������������������������������������������������������");
	}
}
