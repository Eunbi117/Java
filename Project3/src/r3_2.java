// ���α׷��� ���� 3-2
// �Է¹��� ���� ������ 3�� ���, 5�� ���, 8�� ������� �Ǵ��ϴ� ���α׷�

import java.util.*;

public class r3_2
{
	public static void main (String[] args)
	{
		System.out.println("�Է¹��� ���� ������ 3�� ���, 5�� ���, 8�� ������� �Ǵ��ϴ� ���α׷��Դϴ�.\n");

		int input = 0;
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ��� : ");
		input = sc.nextInt();			// ���� ���� �Է�
		
		// ��� �Ǵ�
		if ( input % 3 == 0 )			// 3�� ����� �����ϴ� ���
		{
			if ( input % 5 == 0 && input % 8 == 0 )			// 5�� ���, 8�� ����� ��� �����ϴ� ���
				System.out.println("3�� ���, 5�� ���, 8�� ����̴�.");
			else if ( input % 5 == 0 && input % 8 != 0 )	// 5�� ����� ����, 8�� ����� �������� �ʴ� ���
				System.out.println("3�� ���, 5�� ����̴�.");
			else if ( input % 5 != 0 && input % 8 == 0 )	// 5�� ����� �������� �ʰ� 8�� ����� �����ϴ� ���
				System.out.println("3�� ���, 8�� ����̴�.");
			else											// 5�� ���, 8�� ����� ��� �������� �ʴ� ���
				System.out.println("3�� ����̴�.");
		}
		
		else					// 3�� ����� �������� �ʴ� ���
		{
			if ( input % 5 == 0 && input % 8 == 0 )			// 5�� ���, 8�� ����� ��� �����ϴ� ���
				System.out.println("5�� ���, 8�� ����̴�.");
			else if ( input % 5 == 0 && input % 8 != 0 )	// 5�� ����� ����, 8�� ����� �������� �ʴ� ���
				System.out.println("5�� ����̴�.");
			else if ( input % 5 != 0 && input % 8 == 0 )	// 5�� ����� �������� �ʰ� 8�� ����� �����ϴ� ���
				System.out.println("8�� ����̴�.");
			else											// 5�� ���, 8�� ����� ��� �������� �ʴ� ���
				System.out.println("��� ����� �ƴϴ�.");
		}
	}
}
