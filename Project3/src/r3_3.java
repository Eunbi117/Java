// ���α׷��� ���� 3-3
// ������ ��ǰ�� ������ ���� ������ ����ϴ� ���α׷�

import java.util.*;

public class r3_3
{
	public static void main (String[] args)
	{
		System.out.println("������ ��ǰ�� ������ ���� ������ ����ϴ� ���α׷��Դϴ�.\n");

		int num = 0;					// ������ ��ǰ�� ����
		int price = 0;					// ����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ��ǰ�� ������ �Է��ϼ��� : ");
		num = sc.nextInt();				// ��ǰ ���� �Է�
		
		// ���� ���
		if ( num >= 10 )			// 10�� �̻� �����ϸ� 10% ����
		{
			price = (int)(100000 * num * 0.9);	// ���� = ���� * 100000 * 0.9
		}
		else					// (������ ��ǰ�� ������ 10�� �̸�)
		{
			price = 100000 * num;			// ���� = ���� * 100000
		}
		
		// ���
		System.out.println("������ ��ǰ�� ������ " + num + "���̰�, ������ " + price + "�� �Դϴ�.");
	}
}
