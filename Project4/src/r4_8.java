// ���α׷��� ���� 4-8
// ������ �մ��� Ż �������� �ýÿ���� ����ϴ� ���α׷�

import java.util.*;

public class r4_8
{
	public static void main (String[] args)
	{
		System.out.println("������ �մ��� Ż �������� �ýÿ���� ����ϴ� ���α׷��Դϴ�.\n");
		
		String name = "";		// �մ� �̸�
		int fare = 0;			// ���
		int sum = 0;			// ���� �հ�
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		
		while ( !(name.equals("����")) )		// ���尡 �Էµ� ������ �ݺ�
		{
			System.out.print("�մ��� �̸��� �Է��ϼ��� : ");
			name = sc.next();					// �մ��� �̸� �Է�
			System.out.print("����� �Է��ϼ��� : ");
			fare = sc.nextInt();				// ��� �Է�
			
			sum += fare;						// ���� �հ� = ���� �հ� + �Էµ� ���
		}
		
		// ���
		System.out.println("\n�� ������ " + sum + "���Դϴ�.");
	}
}
