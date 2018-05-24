package ch06;

//프로그래밍 문제 6-10 main
import java.util.Scanner;

public class TimeDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("시, 분, 초 입력");
		Time t = new Time(sc.next(), sc.next(), sc.next());
		System.out.println("입력된 시간 : " + t.getHour() + "시 " + t.getMinute() + "분 " + t.getSecond() + "초\n");
		
		t.setCurrentTime();			// 현재 시간
		System.out.println("현재 시간 : " + t.getCurrentHour() + "시 " + t.getCurrentMinute() + "분 " + t.getCurrentSecond() + "초\n");

		// 시간 변경
		t.varyHour();//시변경
		t.varyMinute();//분변경
		t.varySecond();//초변경
		

		System.out.println();
		System.out.println("변경 후 시간 : " + t.getHour() + "시 " + t.getMinute() + "분 " + t.getSecond() + "초\n");
	}
}
