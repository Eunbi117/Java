// ���α׷��� ���� 4-3-for
// �Ž������� ����ϴ� ���α׷�

import java.util.*;

public class r4_3
{
	public static void main (String[] args)
	{
		System.out.println("�Ž������� ����ϴ� ���α׷��Դϴ�.\n");
		
		int price = 0;			// ���� �ݾ�
		int change = 0;			// �Ž�����
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���űݾ��� �Է��ϼ��� [0-500] : ");
		price = sc.nextInt();			// ���� �ݾ� �Է�
		
		change = 500 - price;			// �Ž����� = 500 - ���� �ݾ�

		System.out.println(change + "���� �Ž������� ������ ����:");

		for ( int i = 1 ; change != 0 ; i *= 10 )		// �Ž������� 0���̸� ����, �ݺ��� ������ i * 10
		{
			// 1�� �ڸ����� ������ ���� ���
			System.out.println("\t" + i + "�� ¥�� ����\t" + (change % 10) + "��");
			change /= 10;				// �Ž����� = �Ž����� / 10
										// ����� ���� 1�� �ڸ� ���� ���� ����
		}
	}
}
