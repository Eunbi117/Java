// ���α׷��� ���� 4-7
// 10���� �մ��� �ý� ����� ����ϴ� ���α׷�

import java.util.*;

public class r4_7
{
	public static void main (String[] args)
	{
		System.out.println("10���� �մ��� �ý� ����� ����ϴ� ���α׷��Դϴ�.\n");
		
		int fare = 0;			// ���
		int sum = 0;			// ���� �հ�
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 1 ; i <= 10 ; i++ )		// �մ� ����ŭ �ݺ�
		{
			System.out.print(i + "��° �մ��� ����� �Է��ϼ��� : ");
			fare = sc.nextInt();				// ��� �Է�
			
			sum += fare;
		}
		
		// ���
		System.out.println("\n�� ���� : " + sum + "��");
	}
}
