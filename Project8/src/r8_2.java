// ���α׷��� ���� 8-2

import java.util.Scanner;

public class r8_2{
	public static void main(String[] args){
		
	Scanner sc = new Scanner(System.in);
	System.out.print("�Է��� �������� ���� �Է��ϼ��� : ");
	int numSize = sc.nextInt();
	int[] num = new int[numSize];
	

	//�迭�� ���� ����
	for (int i = 0 ; i < num.length ; i++)
	{
		System.out.print((i+1) + "��° ������ �Է��ϼ��� : ");
		num[i] = sc.nextInt();
	}
	
	//����� ������� �迭 ���
	System.out.println("���� ������ ������ : ");
		for (int i = 0 ; i < num.length ; i++)
		{
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	
		
		// ���� ����
		int temp = 0;
		int s = 0;
		
		for (int a = num.length-1 ; a >= num.length/2 ; a--)
		{
			temp = num[a];
			num[a] = num[s];
			num[s++] = temp;
		}
		
		//���� ������ �� ���
		System.out.println("�ݴ� ������ ������ : ");
		for (int i = 0 ; i < num.length ; i++)
		{
			System.out.print(num[i] + "\t");
		}
		System.out.println();
		

	}
}
