package ch06;

//���α׷��� ���� 6-2
import java.util.Scanner;

public class NameDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("���� �̸��� �Է��ϼ���.");
		String first = sc.next();//��
		String name = sc.next();//�̸�
		
		//String args = "args";
		Name n1 = new Name(first, name);//��ü ���� ����
		System.out.println(n1.getFamilyName() + " " + n1.getFirstName());		// ���� �̸� ���
		System.out.println("������ ���� : " + n1.getNumber());					// ������ ���� ���

		System.out.println("���� �̸��� �Է��ϼ���.");
		Name n2 = new Name(sc.next(), sc.next());
		System.out.println(n2.getFamilyName() + " " + n2.getFirstName());		// ���� �̸� ���
		System.out.println("������ ���� : " + n2.getNumber());					// ������ ���� ���
	}
}
