package ch06;

//���α׷��� ���� 6-7
class SavingsAccount
{
	double rate;				// ���� ���� ����
	int balance;				// �ܰ�
	int month;					// ���� ����
	
	public SavingsAccount(double r, int b)//���� ������ �ܰ� �Ķ���ͷ� ����
	{
		rate = r;
		balance = b;
	}
	
	int getMonth()					// ���� ���ڸ� ����Ͽ� �ܰ� ���ڸ�ŭ �ø�
	{
		month = (int)(balance * rate / 12);//���� ���
		balance += month;//�ܰ��ٰ� ���ڸ� ����
		return month;//���� ����
	}
	void setRate(double newR)		// ���� ���� ����
	{
		rate = newR;
	}
}
