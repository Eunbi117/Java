class Student1{
	String number;
	String name;
	int math;
	int english;
	int korea;
	int aver;
	
public Student1(String num, String name, int m, int e, int k){
		number = num;
		this.name = name;
	    math = m;
		english = e;
		korea = k;
	}
public void setScore(int number, int score){
	if(number == 1){
		math = score;
	}
	else if(number == 2){
		english = score;
	}
	else if(number == 3){
		korea = score;
	}
	else{
		System.out.println("����");
	}
}

public int getAverage(){
	aver = (math+english+korea)/3;
	return aver;
}
public String getAll(){
	return "�й� : "+number+"\n�̸� : "+name+"\n�������� : "+math+" �������� : "+english+" �������� : "+korea+"\n�������:"+getAverage();

}
}
public class Student {
	public static void main(String[] args){
		Student1 st1 = new Student1("201103038", "������", 80,90,85);
	System.out.println(st1.getAll());
	
	// ���� ������ �ٲٰ� �ʹٸ�, st1.setScore(1, �ٲ�����)�� �Է��� �� System.out����                  ����Ѵ�. 
	// ����, ��� ���������� �ٲ۴�.
}
}
