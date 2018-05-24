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
		System.out.println("딴거");
	}
}

public int getAverage(){
	aver = (math+english+korea)/3;
	return aver;
}
public String getAll(){
	return "학번 : "+number+"\n이름 : "+name+"\n수학점수 : "+math+" 영어점수 : "+english+" 국어점수 : "+korea+"\n평균점수:"+getAverage();

}
}
public class Student {
	public static void main(String[] args){
		Student1 st1 = new Student1("201103038", "최은비", 80,90,85);
	System.out.println(st1.getAll());
	
	// 수학 점수를 바꾸고 싶다면, st1.setScore(1, 바꿀점수)를 입력한 후 System.out으로                  출력한다. 
	// 영어, 국어도 만찬가지로 바꾼다.
}
}
