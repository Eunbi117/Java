package ch07;

//10�� ����
import java.util.Scanner;

class BaseballPlayer{
	String name;
	String position;
	int hit;
	int walk;
	
	//�����ڸ޼ҵ�
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
		BaseballPlayer[] p = new BaseballPlayer[9];//�迭 ����
		
		for(int i = 0; i < 9; i++){//9���� ���� �����Ͽ� �迭�� ����
			System.out.print("������ �̸�, ��ġ, ��Ÿ���� 4������ �Է��ϼ���: ");
			p[i] = new BaseballPlayer(scan.next(), scan.next(), scan.nextInt(), scan.nextInt());
		}
		
		System.out.println();
		System.out.println("\t\t �� ���� ���ġ \t\t");
		System.out.println("�̸� \t��ġ \t��Ÿ��\t\t4����");
		for(int i = 0; i < p.length; i++){
			System.out.println(p[i].getName()+"\t"+p[i].getPosition()+" \t" + p[i].getHit() + " \t\t" + p[i].getWalk());
		}
		
	}
}