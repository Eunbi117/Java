// ���α׷��� ���� 4-10
// �������� ������ 1~100 ������ ���� ���߱� ���� - ���Ḧ ���� ������ �ݺ�

import java.util.*;

public class r4_10
{
	public static void main (String[] args)
	{
		System.out.println("1~100 ������ ���� ���� ���߱� �����Դϴ�.\n");

		int random_num = 0;				// ����� �� ����
		int input_num = 0;				// �Է��� ����
		int count = 0;					// ���ڸ� �Է��� Ƚ��
		String continue_input="";			// ���� ���߱� ������ ������� �Է�
		
		boolean continue_check = true;

		// �Է�
		Scanner sc = new Scanner(System.in);
		
		while ( continue_check )
		{
			random_num = (int)(Math.random() * 100) + 1;		// 1~100 ������ ����

			boolean b_check = true;
			
			while ( b_check )
			{
				System.out.print("������ ���ڸ� �Է��ϼ��� (�׸��η��� 0 �Է�) : ");
				input_num = sc.nextInt();
				count++;
				
				if ( input_num == 0 )
				{
					b_check = false;			// ����
				}
				else if ( random_num == input_num )		// ������ ���ڰ� �´� ���
				{
					System.out.println("���߼̽��ϴ�.\n");
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
			
			System.out.println("������ Ƚ�� : " + count + "\n");
			
			// ���� ���߱� ������ ������� Ȯ��
			System.out.print("������ ��� �Ͻðڽ��ϱ�? (�׸��η��� q �Է�) ");
			continue_input = sc.next();
			
			if ( continue_input.equals("q") )			// q �� �Է¹����� ����
			{
				System.out.println("������ �����մϴ�.");
				continue_check = false;					// ����
			}
			else
			{
				System.out.println("������ ����մϴ�.\n");
				count = 0;//�ٽ� ���� ���۽� ������ Ƚ�� �ʱ�ȭ
			}
		}
	}
}
