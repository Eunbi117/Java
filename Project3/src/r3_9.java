// ���α׷��� ���� 3-9
// ������ �Է¹޾� �������� �ƴ��� �Ǵ��ϴ� ���α׷�

import java.util.*;

public class r3_9
{
	public static void main (String[] args)
	{
		System.out.println("�Է¹��� ������ �������� �Ǵ��ϴ� ���α׷��Դϴ�.\n");
		
		int year = 0;			// ����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		year = sc.nextInt();	// ���� �Է�
		
		if ( year % 4 == 0 && year % 100 != 0 )
				// 4�� ����������� 100���� ����������� �ʴ� ���
		{
			System.out.println(year + " ���� �����Դϴ�.");
		}
		else if ( year % 4 == 0 && year % 100 == 0 && year % 400 == 0 )
				// 4, 100, 400���� ����������� ���
		{
			System.out.println(year + " ���� �����Դϴ�.");
		}
		else
		{
			System.out.println(year + " ���� ������ �ƴմϴ�.");
		}
	}
}
