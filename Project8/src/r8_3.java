// ���α׷��� ���� 8-3

import java.util.Scanner;

public class r8_3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� ���� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int[] answer = new int[num];
		int count = 0;//�� �� �¾Ҵ��� Ȯ��
		double grade = 0;// ����

		// ���� �Է� �޾� �迭�� ����
		System.out.print("������ �Է��ϼ��� : ");
		for (int i = 0; i < answer.length; i++)
			answer[i] = sc.nextInt();

		// �л� �� �Է� �޾� ����� ��
		System.out.print("���� �Է��ϼ��� : ");
		for (int i = 0; i < answer.length; i++)
			if (answer[i] == sc.nextInt())
				count++;

		grade = count * 10;

		System.out.println("���� ��� : " + count);
		System.out.println("���� : " + grade);
	}
}

