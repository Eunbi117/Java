
// ���α׷��� ���� 8-4

import java.util.Scanner;

public class r8_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� ���� �Է��ϼ��� : ");
		int num = sc.nextInt();
		String[] answer = new String[num];
		int count = 0;//������ �� �� ����
		double grade = 0.0;//�� ������
		String c = "y";//ä���� ������ �� �ִ��� Ȯ��

		// ���� �Է� �޾� �迭�� ����

		System.out.print("������ �Է��ϼ��� : ");
		for (int i = 0; i < answer.length; i++)
			answer[i] = sc.next();

		// �л� �� �Է� �޾� ����� ��
		while (!(c.equals("n"))) {
			count = 0;
			grade = 0;
			System.out.print("���� �Է��ϼ��� : ");
			for (int i = 0; i < answer.length; i++)
				if (answer[i].equals(sc.next())) {
					count++;
					grade += 1.0;
				} else
					grade -= 0.2;

			System.out.println("���� ��� : " + count);
			System.out.println("���� : " + grade);

			System.out.print("\nä���� ��� �� �ִ°�? y Ȥ�� n�� �Է��ϼ��� : ");
			c = sc.next();
		}
	}
}

		
