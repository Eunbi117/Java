package ch06;

//���α׷��� ���� 6-9
class member
{
	String name;					// �̸�
	String personal_number;			// �ֹε�Ϲ�ȣ
	String position;				// ����
	int time_wage;					// �ð��� �ӱ�
	
	public member(String name, String personal_number, String position, int time_wage)
	{
		this.name = name;
		this.personal_number = personal_number;
		this.position = position;
		this.time_wage = time_wage;
	}
	int getWage(int time)			// �ӱ� ��ȯ-> �ð��� ���� �ӱ� �ٲ�
	{
		int wage;
		if (time > 40)				// �ִ� �ٹ� �ð� 40�ð� �ʰ�
			wage = (int)(time * time_wage * 1.5);
		else
			wage = time * time_wage;
		return wage;
	}
	void setTimeWage(int vary)		// �ð��� �ӱ� ������ �Է�
	{
		if (vary > time_wage || vary < -time_wage)
			System.out.println("�����׸�ŭ ���� �Ǵ� ������ �� �����ϴ�.");
		else
			time_wage += vary;
	}
}
