// ���α׷��� ���� 4-11
// �� �� ���� �� ���� ���� �ĺ��� ��ǥ���� �Է¹޾� ���� ���(�� ��ǥ��, ��ǥ��, �缱�� �ĺ�)�� �˷��ִ� ���α׷�

import java.util.*;

public class r4_11
{
	public static void main (String[] args)
	{
		System.out.println("�� �� ���� �� ���� ���� �ĺ��� ��ǥ���� �Է¹޾� ���� ����� �˷��ִ� ���α׷��Դϴ�.\n");
		
		String continue_input = "";				// ������ ���� �ִ��� Ȯ��
		int input_num = 0;						// ��ǥ�� �Է�
		int first_num = 0;						// ù ��° �ĺ��� ��ǥ��
		int second_num = 0;						// �� ��° �ĺ��� ��ǥ��
		double first_rate = 0;					// ù ��° �ĺ��� ��ǥ��
		double second_rate = 0;					// �� ��° �ĺ��� ��ǥ��
		
		// �Է�
		Scanner sc = new Scanner(System.in);

		while ( !(continue_input.equals("no")) )		// ������ ���� �ִ��� Ȯ���ϴ� ������ ���� no�̸� ����
		{
			System.out.print("\n������ ���� �ֳ���(������ yes ������ no�� �Է��ϼ���) : ");
			continue_input = sc.next();					// ������ ���� �ִ��� �Է�
			
			if ( continue_input.equals("yes") )			// yes��� ���� ��츸 ��ǥ�� �Է� ����
			{
				System.out.print("ù ��° �ĺ��� �� ������ ���� ��ǥ ���� �Է��ϼ��� : ");
				input_num = sc.nextInt();
				first_num += input_num;
				System.out.print("�� ��° �ĺ��� �� ������ ���� ��ǥ ���� �Է��ϼ��� : ");
				input_num = sc.nextInt();
				second_num += input_num;
			}
			else if ( continue_input.equals("no") )		// no��� ���� ��� while�� ����
			{
				break;
			}
			else	// yes�� no �̿��� ���� �Է��� ��� �߸� �Է� - while�� ó������ ���ư��� �ٽ� �Է�
			{
				System.out.println("�߸� �Է��ϼ̽��ϴ�. yes�� no �߿��� �ϳ��� �Է��ϼ���.");
			}
		}

		// ��ǥ�� ��� �� ��� ���
		if ( first_num == 0 && second_num == 0 )	// �� �ĺ��� ��ǥ���� ��� 0�� ���(� ���� ���� ���� ���� ����)
		{
			System.out.println("\n��ǥ ����� �Էµ��� �ʾҽ��ϴ�.");
		}
		else										// �� �ĺ� �� �Ѹ��̶� ��ǥ���� 0�� �ƴ� ��� ��ǥ�� �� ��� ���
		{
			// ��ǥ�� = �ش� �ĺ��� ��ǥ�� / ��ü ��ǥ�� * 100
			first_rate = (double) first_num / (first_num + second_num) * 100;		// ù ��° �ĺ��� ��ǥ�� ���
			second_rate = (double) second_num / (first_num + second_num) * 100;		// �� ��° �ĺ��� ��ǥ�� ���
			
			// ������ %d, �Ǽ��� %f
			// %f ������ 2.1���� 2�� ������ �ڸ���, 1�� �Ҽ��� �Ʒ� �ڸ����� ��Ÿ��
			System.out.printf("\n\nù ��° �ĺ��� ���� �� ��ǥ���� %d�̰� ��ǥ���� %2.1f%% �Դϴ�.\n", first_num, first_rate);
			System.out.printf("�� ��° �ĺ��� ���� �� ��ǥ���� %d�̰� ��ǥ���� %2.1f%% �Դϴ�.\n\n", second_num, second_rate);
			
			if ( first_num > second_num )			// ù ��° �ĺ��� ��ǥ���� �� ��° �ĺ��� ��ǥ�� ���� ū ���
				System.out.println("ù ��° �ĺ��� �������� �缱�Ǿ����ϴ�.");
			else if ( first_num < second_num )		// ù ��° �ĺ��� ��ǥ���� �� ��° �ĺ��� ��ǥ������ ���� ���
				System.out.println("�� ��° �ĺ��� �������� �缱�Ǿ����ϴ�.");
			else									// ù ��° �ĺ��� ��ǥ���� �� ��° �ĺ��� ��ǥ���� ���� ���
				System.out.println("�� �ĺ��� ��ǥ���� �����ϴ�.");
		}
	}
}
