// ���α׷��� ���� 3-8
// ������ ������ ������ �Է¹޾� �̻����� ü���� ����Ͽ� ����ϴ� ���α׷�

import java.util.*;

public class r3_8
{
	public static void main (String[] args)
	{
		System.out.println("������ ������ ������ �Է¹޾� �̻����� ü���� ����ϴ� ���α׷��Դϴ�.\n");
		
		int w_height = 0;		// ������ ����
		int m_height = 0;		// ������ ����
		double w_weight = 0;		// ������ �̻����� ü��
		double m_weight = 0;		// ������ �̻����� ü��
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ������ �Է��ϼ��� : ");
		w_height = sc.nextInt();		// ������ ���� �Է�
		System.out.print("������ ������ �Է��ϼ��� : ");
		m_height = sc.nextInt();		// ������ ���� �Է�

		// ������ �̻����� ü�� ��� �� ���
		if ( w_height > 150 )
			w_weight = 37.8 + 0.75 * (w_height - 150);
		else
			w_weight = 37.8;
		System.out.println("������ �̻����� ü���� " + w_weight + "�̴�.");

		// ������ �̻����� ü�� ��� �� ���
		if ( m_height > 150 )
			m_weight = 40 + 0.89 * (m_height - 150);
		else
			m_weight = 40;
		System.out.println("������ �̻����� ü���� " + m_weight + "�̴�.");
	}
}
