package ch06;

//프로그래밍 문제 6-9 main
import java.util.Scanner;

public class memberDriver
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		member m = new member("이름", "987654-1234567", "직위", 30000);

		System.out.print("주당 일한 시간을 입력하세요 : ");
		System.out.println("임금 : " + m.getWage(sc.nextInt()) + "\n");	// 일한 시간에 대응하는 임금 반환

		System.out.print("시간당 임금의 증감액을 입력하세요 : ");
		m.setTimeWage(sc.nextInt());							// 시간당 임금 변경
		System.out.println();

		System.out.print("주당 일한 시간을 입력하세요 : ");
		System.out.println("임금 : " + m.getWage(sc.nextInt()));
	}
}
