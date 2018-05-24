package ch06;

//프로그래밍 문제 6-9
class member
{
	String name;					// 이름
	String personal_number;			// 주민등록번호
	String position;				// 직위
	int time_wage;					// 시간당 임금
	
	public member(String name, String personal_number, String position, int time_wage)
	{
		this.name = name;
		this.personal_number = personal_number;
		this.position = position;
		this.time_wage = time_wage;
	}
	int getWage(int time)			// 임금 반환-> 시간에 따라 임금 바뀜
	{
		int wage;
		if (time > 40)				// 주당 근무 시간 40시간 초과
			wage = (int)(time * time_wage * 1.5);
		else
			wage = time * time_wage;
		return wage;
	}
	void setTimeWage(int vary)		// 시간당 임금 증감액 입력
	{
		if (vary > time_wage || vary < -time_wage)
			System.out.println("증감액만큼 증액 또는 감액할 수 없습니다.");
		else
			time_wage += vary;
	}
}
