// ���α׷��� ���� 4-1
// ���ͳ� ��ŷ�� ���� ��ȣ�� ó���ϴ� ���α׷�

import java.util.*;

public class r4_1
{
	public static void main (String[] args)
	{
		System.out.println("���ͳ� ��ŷ�� ���� ��ȣ�� ó���ϴ� ���α׷��Դϴ�.\n");
		
		String input = "";							// �Է¹��� ��ȣ
		int i = 0;									// �߸��� ��ȣ �Է� Ƚ��

		boolean b_check = true;
		
		while ( b_check )
		{
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			
			// �Է�
			Scanner sc = new Scanner(System.in);
			input = sc.next();						// ��ȣ �Է�
			
			if ( input.equals("myongji60") )			// �´� ��ȣ�� �Էµ� ���
			{
				System.out.println("ȯ���մϴ�.");
				b_check = false;					// �ݺ��� ����
			}

			else									// �߸��� ��ȣ�� �Էµ� ���
			{
				System.out.println("��ȣ�� Ʋ���ϴ�.");
				i++;								// �߸��� ��ȣ �Է� Ƚ�� ����
				System.out.println(i + "�� �߸� �Է��ϼ̽��ϴ�.\n");

				if ( i == 3 )						// 3�� �߸� �Է��� ���
				{
					System.out.println("������ �ź��մϴ�.");
					b_check = false;				// �ݺ��� ����
				}
			}
		}
	}
}
