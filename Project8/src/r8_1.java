import java.util.Scanner;

public class r8_1{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];//�迭 10�� �����
		int sum = 0;//�հ�
		double aver = 0;//���
	

		System.out.println("10���� ������ �Է��ϼ���.");
		
		
		//�迭�� ����(����)��ŭ for�� ������ ���� ����
		for(int i = 0 ; i < num.length ; i++)
		{
			num[i] = sc.nextInt();
		}
	
		
		//�迭�� ���� �� ���� sum���ٰ� ��� ����
		for(int i = 0 ; i < num.length ; i++)
		{
			sum += num[i];
		}


		//���
		aver = (double)sum / num.length;

	

		int min = 100;//�ּҰ��� ���� ū ���� �־ ��
		for(int i = 0 ; i < num.length ; i++)
		{
			if (min > num[i])
				min = num[i];
		}
	

		System.out.println("�迭�� ����� �������� �� : " + sum);
		System.out.println("�迭�� ����� �������� ��� : " + aver);
		System.out.println("�迭�� ����� ���� �� �ּҰ� : " + min);
	}
}



