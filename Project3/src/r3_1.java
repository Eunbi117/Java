import java.util.*;

public class r3_1
{
	public static void main (String[] args)
	{
		System.out.println("�Է¹��� ���� ���� �ִ� Ȧ���� ¦���� ������ ����ϴ� ���α׷��Դϴ�.\n");

		int input = 0;				// �Է¹��� ���� �� ����
		int even = 0;				// ¦���� ����
		int odd = 0;				// Ȧ���� ����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		input = sc.nextInt();			// ���� �Է�

		// ¦��, Ȧ�� �Ǵ� - while�� ���
		while ( input != 0 )			// ������ 0�� �� ������ ��� �ݺ�
		{
			if ( input % 2 == 0 )	// 2�� �������� �� �������� 0�̸� ¦��
				even++;				// ¦���� ���� 1 ����

			else			// 2�� �������� �� �������� 0�� �ƴϸ� Ȧ��
				odd++;				// Ȧ���� ���� 1 ����

			input = input / 10;	// 10���� ����
						// (����� ���� 1�� �ڸ� ���� ���� ����)
		}
		
		// ���
		System.out.println("�Է¹��� ���� ���� �ִ� Ȧ���� " + odd + "��, ¦���� " + even + "�� �Դϴ�.");
	}
}