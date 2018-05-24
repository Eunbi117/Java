// ���α׷��� ���� 4-4-switch
// ���ڿ� �ȿ� �ִ� ������ ������ ���� �˾Ƴ��� ����ϴ� ���α׷�

import java.util.*;

public class r4_4
{
	public static void main (String[] args)
	{
		System.out.println("���ڿ� �ȿ� �ִ� ������ ������ ���� �˾Ƴ��� ����ϴ� ���α׷��Դϴ�.\n");
		
		String str = "";				// ���ڿ�
		int string_length = 0;			// ���ڿ��� ����
		int a_num = 0;					// ���� a�� ��
		int e_num = 0;					// ���� e�� ��
		int i_num = 0;					// ���� i�� ��
		int o_num = 0;					// ���� o�� ��
		int u_num = 0;					// ���� u�� ��
		int consonant = 0;				// ������ ��
		int empty_num = 0;				// ������ ��
		
		// �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		str = sc.nextLine();			// ���ڿ� �Է�
		// next();�� ������ �ܾ������ ����ǹǷ� ������ �Էµ� �� ������ ĭ���� �����ϱ� ���� nextLine();�� �̿�
		
		string_length = str.length();	// ���ڿ��� ����
		
		System.out.println("���ڿ��� ���� : " + string_length);
		
		for ( int i = 0 ; i < string_length ; i++ )
		{
			switch ( str.charAt(i) )	// ���ڿ��� i��° ����
			{
				// �빮�ڿ� �ҹ��� ��� ������ ���ڿ� ���Եǵ��� �ϱ� ����
				// �ҹ��ڿ� �빮�ڸ� ��� case�� �ް� ������ ���ڰ� 1 �����Ǹ� break
				case 'a':				// �ҹ��� a
				case 'A':				// �빮�� A
					a_num++;			// ���� a�� �� 1 ����
					break;
				case 'e':				// �ҹ��� e
				case 'E':				// �빮�� E
					e_num++;			// ���� e�� �� 1 ����
					break;
				case 'i':				// �ҹ��� i
				case 'I':				// �빮�� I
					i_num++;			// ���� i�� �� 1 ����
					break;
				case 'o':				// �ҹ��� o
				case 'O':				// �빮�� O
					o_num++;			// ���� o�� �� 1 ����
					break;
				case 'u':				// �ҹ��� u
				case 'U':				// �빮�� U
					u_num++;			// ���� u�� �� 1 ����
					break;
				case ' ':
					empty_num++;		// ������ �� 1 ����
					break;
				default:				// ����
					consonant++;		// ������ �� 1 ����
					break;
			}
		}

		// ���
		System.out.println("a�� �� : " + a_num);
		System.out.println("e�� �� : " + e_num);
		System.out.println("i�� �� : " + i_num);
		System.out.println("o�� �� : " + o_num);
		System.out.println("u�� �� : " + u_num);
		System.out.println("������ �� : " + empty_num);
		System.out.println("������ �� : " + consonant);
	}
}
