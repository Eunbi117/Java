package ch07;

class Student{
	String num;//학번
	String name;//이름
	int one;//점수 3개
	int two;
	int three;
	double aver;//평균
	
	//생성자 메소드
	public Student(String num, String name, int one, int two, int three){
		this.num = num;
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	//1~3 사이의 정수값에 따라서 속성에 있는 점수의 값을 바꾸는 메소드
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
			System.out.println("1,2,3 중에 하나 넣으라고...");
		}
	}
	
	//반환하는 메소드
	public int getScore(int number){
		int getscore = 0;//각각 정수에 따라서 저장되어 점수값을 저장하기위한 변수
		
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
			System.out.println("1,2,3 중에 하나 넣으라고...");
		}
		
		return getscore;
	}
	
	//평균 구하는 메소드
	public double getAver(){
		aver = (one+two+three)/3.0;//평균하는 공식
		
		return aver;
	}
	
	
	public String getAll(){
		return "학번: " + num + " 이름: " + name + " 첫번째점수: " + one + " 두번째점수: " + two + " 세번째점수: "+three + " 평균: " + getAver();
	}
	
	
}

public class StudentDriver{
	public static void main(String[] args) {
		Student st = new Student("201103038", "최은비", 10, 20, 30);
		
		System.out.println(st.getAll());
		
		st.setScore(1, 15);
		
		System.out.println(st.getAll());
		
		st.setScore(4, 40);//오류문 출력
	}
}