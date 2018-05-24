package ch07;

//10번 문제
import java.util.Scanner;

class BaseballPlayer{
	String name;
	String position;
	int hit;
	int walk;
	
	//생성자메소드
	public BaseballPlayer(String name, String position, int hit, int walk) {
		this.name = name;
		this.position = position;
		this.hit = hit;
		this.walk = walk;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getHit() {
		return hit;
	}

	public int getWalk() {
		return walk;
	}
	
}


public class BaseballPlayerDriver{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BaseballPlayer[] p = new BaseballPlayer[9];//배열 생성
		
		for(int i = 0; i < 9; i++){//9명의 선수 생성하여 배열에 넣음
			System.out.print("선수의 이름, 위치, 안타수와 4구수를 입력하세요: ");
			p[i] = new BaseballPlayer(scan.next(), scan.next(), scan.nextInt(), scan.nextInt());
		}
		
		System.out.println();
		System.out.println("\t\t 각 선수 통계치 \t\t");
		System.out.println("이름 \t위치 \t안타수\t\t4구수");
		for(int i = 0; i < p.length; i++){
			System.out.println(p[i].getName()+"\t"+p[i].getPosition()+" \t" + p[i].getHit() + " \t\t" + p[i].getWalk());
		}
		
	}
}