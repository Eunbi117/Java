package ch06;

//���α׷��� ���� 6-10 main
import java.util.Scanner;

public class TimeDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("��, ��, �� �Է�");
		Time t = new Time(sc.next(), sc.next(), sc.next());
		System.out.println("�Էµ� �ð� : " + t.getHour() + "�� " + t.getMinute() + "�� " + t.getSecond() + "��\n");
		
		t.setCurrentTime();			// ���� �ð�
		System.out.println("���� �ð� : " + t.getCurrentHour() + "�� " + t.getCurrentMinute() + "�� " + t.getCurrentSecond() + "��\n");

		// �ð� ����
		t.varyHour();//�ú���
		t.varyMinute();//�к���
		t.varySecond();//�ʺ���
		

		System.out.println();
		System.out.println("���� �� �ð� : " + t.getHour() + "�� " + t.getMinute() + "�� " + t.getSecond() + "��\n");
	}
}
