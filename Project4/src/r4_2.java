// ���α׷��� ���� 4-2
// 1���� 10������ ���� i�� ���� 1���� i������ �� sum�� ����Ͽ� ����ϴ� ���α׷�

public class r4_2
{
	public static void main (String[] args)
	{
		System.out.println("1���� 10������ ���� i�� ���� 1���� i������ �� sum�� ����Ͽ� ����ϴ� ���α׷��Դϴ�.\n");
	
		int sum = 0;						// 1���� i������ ������ ��
		
		System.out.println("��\t��");
		
		for ( int i = 1 ; i <= 10 ; i++ )	// 1���� 10������ ���� i
		{
			sum += i;					// sum = 1 + 2 + ..... + i
			
			// �� ���
			System.out.println(i + "\t" + sum);
		}
	}
}

