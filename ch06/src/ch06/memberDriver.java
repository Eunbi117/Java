package ch06;

//���α׷��� ���� 6-9 main
import java.util.Scanner;

public class memberDriver
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		member m = new member("�̸�", "987654-1234567", "����", 30000);

		System.out.print("�ִ� ���� �ð��� �Է��ϼ��� : ");
		System.out.println("�ӱ� : " + m.getWage(sc.nextInt()) + "\n");	// ���� �ð��� �����ϴ� �ӱ� ��ȯ

		System.out.print("�ð��� �ӱ��� �������� �Է��ϼ��� : ");
		m.setTimeWage(sc.nextInt());							// �ð��� �ӱ� ����
		System.out.println();

		System.out.print("�ִ� ���� �ð��� �Է��ϼ��� : ");
		System.out.println("�ӱ� : " + m.getWage(sc.nextInt()));
	}
}
