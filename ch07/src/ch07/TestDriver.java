package ch07;


//9번 문제
import java.util.Scanner;

class StudentTest{
	Scanner scan = new Scanner(System.in);
	
	String name;
	int middle;//중간
	int end;//기말
	boolean err;//반복문을 위해
	double aver;//평균
	
	
	//이름만 초기화
	public StudentTest(String name){
		this.name = name;
	}
	
	//중간, 기말 점수 받는 메소드
	public void setScore(){

		System.out.print(name+"의 중간시험 점수를 입력하라. ");
		do{
			err = true;//다시 while문을 돌 때 초기화
			middle = scan.nextInt();
			if(middle < 0 || middle > 100){
				System.out.println("너 경고임 이딴점수 없음");
				err = false;
				System.out.print(name+"의 중간시험 점수를 다시 입력하라. ");
			}
		}while(!err);
		
		System.out.print(name+"의 기말시험 점수를 입력하라. ");
		do{
			err = true;//다시 while문을 돌 때 초기화
			end = scan.nextInt();
			if(end < 0 || end > 100){
				System.out.println("너 경고임 이딴점수 없음");
				err = false;
				System.out.print(name+"의 기말시험 점수를 다시 입력하라. ");
			}
		}while(!err);
		
	}
	
	 public double getAver(){
		 aver = (middle + end) / 2.0;
		 return aver;
	 }
}

public class TestDriver{
	public static void main(String[] args) {
		StudentTest s1 = new StudentTest("최은비");
		StudentTest s2 = new StudentTest("권혜경");
		
		s1.setScore();//중간점수랑 기말점수를 사용자에게 물어봐서 넣는 메소드
		System.out.println(s1.name + "의 평균점수는 " + s1.getAver() + "이다."); 
		System.out.println();
		
		s2.setScore();
		System.out.println(s2.name + "의 평균점수는 " + s2.getAver() + "이다."); 
	
	}
}