// ���α׷��� ���� 4-9
// �������� ������ 1~10 ������ ���� ���߱� ����

import java.util.*;

public class r4_9
{
	public static void main (String[] args)
	{
		System.out.println("1~10 ������ ���� ���� ���߱� �����Դϴ�.\n");
		
		int random_num = 0;			// ����� �� ����
		int input_num = 0;			// �Է��� ����
		
		boolean b_check = true;

		// �Է�
		Scanner sc = new Scanner(System.in);
		
		random_num = (int)(Math.random() * 10) + 1;		// 1~10 ������ ����

		while ( b_check )
		{
			System.out.print("������ ���ڸ� �Է��ϼ��� : ");
			input_num = sc.nextInt();
			
			if ( random_num == input_num )			// ������ ���ڰ� �´� ���
			{
				System.out.println("���߼̽��ϴ�.");
				b_check = false;					// ����
			}
			else									// ������ ���ڰ� Ʋ�� ���
			{
				System.out.println("������ ���ڰ� Ʋ�Ƚ��ϴ�.");
				
				if ( random_num < input_num )		// ������ ���ڰ� ū ���
					System.out.println("������ ���ڰ� �ʹ� Ů�ϴ�.\n");
				else								// ������ ���ڰ� ���� ���
					System.out.println("������ ���ڰ� �ʹ� �۽��ϴ�.\n");
			}
		}
	}
}
