package ch07;

class Student{
	String num;//�й�
	String name;//�̸�
	int one;//���� 3��
	int two;
	int three;
	double aver;//���
	
	//������ �޼ҵ�
	public Student(String num, String name, int one, int two, int three){
		this.num = num;
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	//1~3 ������ �������� ���� �Ӽ��� �ִ� ������ ���� �ٲٴ� �޼ҵ�
	public void setScore(int number, int score){
		if(number == 1){
			one = score;
		}
		else if(number == 2){
			two = score;
		}
		else if(number == 3){
			three = score;
		}
		else{
			System.out.println("1,2,3 �߿� �ϳ� �������...");
		}
	}
	
	//��ȯ�ϴ� �޼ҵ�
	public int getScore(int number){
		int getscore = 0;//���� ������ ���� ����Ǿ� �������� �����ϱ����� ����
		
		if(number == 1){
			getscore = one;
		}
		else if(number == 2){
			getscore = two;
		}
		else if(number == 3){
			getscore = three;
		}
		else{
			System.out.println("1,2,3 �߿� �ϳ� �������...");
		}
		
		return getscore;
	}
	
	//��� ���ϴ� �޼ҵ�
	public double getAver(){
		aver = (one+two+three)/3.0;//����ϴ� ����
		
		return aver;
	}
	
	
	public String getAll(){
		return "�й�: " + num + " �̸�: " + name + " ù��°����: " + one + " �ι�°����: " + two + " ����°����: "+three + " ���: " + getAver();
	}
	
	
}

public class StudentDriver{
	public static void main(String[] args) {
		Student st = new Student("201103038", "������", 10, 20, 30);
		
		System.out.println(st.getAll());
		
		st.setScore(1, 15);
		
		System.out.println(st.getAll());
		
		st.setScore(4, 40);//������ ���
	}
}