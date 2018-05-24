package ch06;

//프로그래밍 문제 6-8
public class SavingsAccountDriver
{
	public static void main (String[] args)
	{
		SavingsAccount sa1 = new SavingsAccount(0.05, 10000);		// 첫 잔고 10000원
		SavingsAccount sa2 = new SavingsAccount(0.05, 20000);		// 첫 잔고 20000원

		// 첫 달의 계좌들의 이자
		System.out.println("계좌 1의 첫 달 이자 : " + sa1.getMonth());
		System.out.println("계좌 2의 첫 달 이자 : " + sa2.getMonth());

		// 연 이율 5%에서 6%로 변경
		sa1.setRate(0.06);
		sa2.setRate(0.06);
		
		// 두 번째 달의 계좌들의 이자
		System.out.println("계좌 1의 두 번째 달 이자 : " + sa1.getMonth());
		System.out.println("계좌 2의 두 번째 달 이자 : " + sa2.getMonth());
	}
}
