// ���α׷��� ���� 3-6
// ������ ���� ������ Ȱ���� �Ǵ��Ͽ� ����ϴ� ���α׷�

import java.util.*;

public class r3_6
{
	public static void main (String[] args)
	{
		System.out.println("������ ���� ������ Ȱ���� �Ǵ��Ͽ� ����ϴ� ���α׷��Դϴ�.\n");

		int temperature = 0;					// �µ�
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�µ��� �Է��ϼ��� : ");
		temperature = sc.nextInt();				// �µ� �Է�
		
		// ������ Ȱ�� �Ǵ� �� ���
		if ( temperature >= 25 )					// 25�� �̻�
			System.out.println("������ ���մϴ�.");		// ����
		else if ( temperature >= 15 )			// (25�� �̸�), 15�� �̻�
			System.out.println("�״Ͻ��� ���մϴ�.");		// �״Ͻ�
		else if ( temperature >= 5 )			// (15�� �̸�), 5�� �̻�
			System.out.println("������ ���մϴ�.");		// ����
		else							// 5�� �̸�
			System.out.println("��Ű�� ���մϴ�.");		// ��Ű
	}
}
