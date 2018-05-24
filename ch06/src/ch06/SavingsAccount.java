package ch06;

//프로그래밍 문제 6-7
class SavingsAccount
{
	double rate;				// 연간 이율 변경
	int balance;				// 잔고
	int month;					// 월별 이자
	
	public SavingsAccount(double r, int b)//연간 이율과 잔고를 파라미터로 받음
	{
		rate = r;
		balance = b;
	}
	
	int getMonth()					// 월별 이자를 계산하여 잔고를 이자만큼 늘림
	{
		month = (int)(balance * rate / 12);//이자 계산
		balance += month;//잔고에다가 이자를 누적
		return month;//이자 리턴
	}
	void setRate(double newR)		// 연간 이율 변경
	{
		rate = newR;
	}
}
