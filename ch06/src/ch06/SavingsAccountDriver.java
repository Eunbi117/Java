package ch06;

//���α׷��� ���� 6-8
public class SavingsAccountDriver
{
	public static void main (String[] args)
	{
		SavingsAccount sa1 = new SavingsAccount(0.05, 10000);		// ù �ܰ� 10000��
		SavingsAccount sa2 = new SavingsAccount(0.05, 20000);		// ù �ܰ� 20000��

		// ù ���� ���µ��� ����
		System.out.println("���� 1�� ù �� ���� : " + sa1.getMonth());
		System.out.println("���� 2�� ù �� ���� : " + sa2.getMonth());

		// �� ���� 5%���� 6%�� ����
		sa1.setRate(0.06);
		sa2.setRate(0.06);
		
		// �� ��° ���� ���µ��� ����
		System.out.println("���� 1�� �� ��° �� ���� : " + sa1.getMonth());
		System.out.println("���� 2�� �� ��° �� ���� : " + sa2.getMonth());
	}
}
