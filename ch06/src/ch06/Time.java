package ch06;

//���α׷��� ���� 6-10

//�ð��� ������ �� �ִ� �޼ҵ尡 ����ִ� ���̺귯�� import
import java.text.SimpleDateFormat;
import java.util.Date;

class Time
{
	String hour;				// ��
	String minute;				// ��
	String second;				// ��
	String current_hour;		// ���� ��
	String current_min;			// ���� ��
	String current_sec;			// ���� ��
	
	public Time(String h, String m, String s)
	{//�ʱ�ȭ-> ������ �޼ҵ�: ����ڿ��� ���� ������ �ʱ�ȭ��
		hour = h;
		minute = m;
		second = s;
	}

	void setCurrentTime()			// ���� �ð� ����
	{
		current_hour = new SimpleDateFormat("HH").format(new Date());
		current_min = new SimpleDateFormat("mm").format(new Date());
		current_sec = new SimpleDateFormat("ss").format(new Date());
	}

	String getCurrentHour()			// ���� �� ��ȯ ���� �޼ҵ�
	{
		return current_hour;
	}
	String getCurrentMinute()		// ���� �� ��ȯ
	{
		return current_min;
	}
	String getCurrentSecond()		// ���� �� ��ȯ
	{
		return current_sec;
	}
	String getHour()				// �Է��� �� ��ȯ
	{
		return hour;
	}
	String getMinute()				// �Է��� �� ��ȯ
	{
		return minute;
	}
	String getSecond()				// �Է��� �� ��ȯ
	{
		return second;
	}
	
	void varyHour()					// �ð� ����
	{
		if (getHour().equals(getCurrentHour()))
			System.out.println("�ð��� ��ġ�մϴ�.");
		else						// �ð��� ���� �ð��� �÷� ����
		{
			System.out.println("�ð��� " + current_hour + "�÷� �����մϴ�.");
			hour = current_hour;
		}
	}
	void varyMinute()				// �� ����
	{
		if (getMinute().equals(getCurrentMinute()))
			System.out.println("���� ��ġ�մϴ�.");
		else						// ���� ���� �ð��� ������ ����
		{
			System.out.println("���� " + current_min + "������ �����մϴ�.");
			minute = current_min;
		}
	}
	void varySecond()				// �� ����
	{
		if (getSecond().equals(getCurrentSecond()))
			System.out.println("�ʰ� ��ġ�մϴ�.");
		else						// �ʸ� ���� �ð��� �ʷ� ����
		{
			System.out.println("�ʸ� " + current_sec + "�ʷ� �����մϴ�.");
			second = current_sec;
		}
	}
}
