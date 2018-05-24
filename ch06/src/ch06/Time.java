package ch06;

//프로그래밍 문제 6-10

//시간을 가져올 수 있는 메소드가 들어있는 라이브러리 import
import java.text.SimpleDateFormat;
import java.util.Date;

class Time
{
	String hour;				// 시
	String minute;				// 분
	String second;				// 초
	String current_hour;		// 현재 시
	String current_min;			// 현재 분
	String current_sec;			// 현재 초
	
	public Time(String h, String m, String s)
	{//초기화-> 생성자 메소드: 사용자에게 받은 값으로 초기화함
		hour = h;
		minute = m;
		second = s;
	}

	void setCurrentTime()			// 현재 시간 저장
	{
		current_hour = new SimpleDateFormat("HH").format(new Date());
		current_min = new SimpleDateFormat("mm").format(new Date());
		current_sec = new SimpleDateFormat("ss").format(new Date());
	}

	String getCurrentHour()			// 현재 시 반환 접근 메소드
	{
		return current_hour;
	}
	String getCurrentMinute()		// 현재 분 반환
	{
		return current_min;
	}
	String getCurrentSecond()		// 현재 초 반환
	{
		return current_sec;
	}
	String getHour()				// 입력한 시 반환
	{
		return hour;
	}
	String getMinute()				// 입력한 분 반환
	{
		return minute;
	}
	String getSecond()				// 입력한 초 반환
	{
		return second;
	}
	
	void varyHour()					// 시간 변경
	{
		if (getHour().equals(getCurrentHour()))
			System.out.println("시간이 일치합니다.");
		else						// 시간을 현재 시간의 시로 변경
		{
			System.out.println("시간을 " + current_hour + "시로 변경합니다.");
			hour = current_hour;
		}
	}
	void varyMinute()				// 분 변경
	{
		if (getMinute().equals(getCurrentMinute()))
			System.out.println("분이 일치합니다.");
		else						// 분을 현재 시간의 분으로 변경
		{
			System.out.println("분을 " + current_min + "분으로 변경합니다.");
			minute = current_min;
		}
	}
	void varySecond()				// 초 변경
	{
		if (getSecond().equals(getCurrentSecond()))
			System.out.println("초가 일치합니다.");
		else						// 초를 현재 시간의 초로 변경
		{
			System.out.println("초를 " + current_sec + "초로 변경합니다.");
			second = current_sec;
		}
	}
}
