package ch07;

import java.util.Scanner;

//11번 문제
class Girl{
	String name;
	int box;
	
	//생성자 메소드
	public Girl(String name){
		this.name = name;
		box = 0;
	}
	
	//이름 반환하는 메소드
	public String getName(){
		return name;
	}
	
	
	public void setBox(int box){
		this.box += box;
	}
	
	public String getAll(){
		return name+": " + box;
	}
}

public class GirlDriver{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("걸스카우트의 이름을 입력하세요: ");
		Girl g1 = new Girl(sc.next());
		System.out.print("걸스카우트의 이름을 입력하세요: ");
		Girl g2 = new Girl(sc.next());
		System.out.print("걸스카우트의 이름을 입력하세요: ");
		Girl g3 = new Girl(sc.next());
		
		System.out.print("판매 기간을 입력하세요: ");
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++){
			System.out.print(g1.getName()+"의 " + (i+1) + "번째주 판매 상자수를 입력하세요: ");
			g1.setBox(sc.nextInt());
			System.out.print(g2.getName()+"의 " + (i+1) + "번째주 판매 상자수를 입력하세요: ");
			g2.setBox(sc.nextInt());
			System.out.print(g3.getName()+"의 " + (i+1) + "번째주 판매 상자수를 입력하세요: ");
			g3.setBox(sc.nextInt());
		}
		
		System.out.println(g1.getAll());
		System.out.println(g2.getAll());
		System.out.println(g3.getAll());
	}
}