// ���α׷��� ���� 3-5
// ���̺��� ��ȭ ���� ���� ���θ� �Ǵ��ϴ� ���α׷�

import java.util.*;

public class r3_5
{
	public static void main (String[] args)
	{
		System.out.println("�Է¹��� ���̿� ���� ��ȭ ���� ���� ���θ� �Ǵ��ϴ� ���α׷��Դϴ�.\n");

		int age = 0;						// ����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���.");
		age = sc.nextInt();					// ���� �Է�
		
		// ��ȭ ���� ���� ���� �Ǵ� �� ���
		if ( age >= 19 )						// 19�� �̻�
			System.out.println("��ȭ�� �� �� �ֽ��ϴ�.");	// ���� ����

		else if ( age >= 15 )				// (19�� �̸�), 15�� �̻�
			System.out.println("������ ������ ��쿡�� ��ȭ�� �� �� �ֽ��ϴ�.");	// ���� ���ݽ� ���� ����

		else						// 15�� �̸�
			System.out.println("��ȭ�� �� �� �����ϴ�.");							// ��ȭ ���� �Ұ���
	}
}
