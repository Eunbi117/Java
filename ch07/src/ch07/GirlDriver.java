package ch07;

import java.util.Scanner;

//11�� ����
class Girl{
	String name;
	int box;
	
	//������ �޼ҵ�
	public Girl(String name){
		this.name = name;
		box = 0;
	}
	
	//�̸� ��ȯ�ϴ� �޼ҵ�
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
		
		System.out.print("�ɽ�ī��Ʈ�� �̸��� �Է��ϼ���: ");
		Girl g1 = new Girl(sc.next());
		System.out.print("�ɽ�ī��Ʈ�� �̸��� �Է��ϼ���: ");
		Girl g2 = new Girl(sc.next());
		System.out.print("�ɽ�ī��Ʈ�� �̸��� �Է��ϼ���: ");
		Girl g3 = new Girl(sc.next());
		
		System.out.print("�Ǹ� �Ⱓ�� �Է��ϼ���: ");
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++){
			System.out.print(g1.getName()+"�� " + (i+1) + "��°�� �Ǹ� ���ڼ��� �Է��ϼ���: ");
			g1.setBox(sc.nextInt());
			System.out.print(g2.getName()+"�� " + (i+1) + "��°�� �Ǹ� ���ڼ��� �Է��ϼ���: ");
			g2.setBox(sc.nextInt());
			System.out.print(g3.getName()+"�� " + (i+1) + "��°�� �Ǹ� ���ڼ��� �Է��ϼ���: ");
			g3.setBox(sc.nextInt());
		}
		
		System.out.println(g1.getAll());
		System.out.println(g2.getAll());
		System.out.println(g3.getAll());
	}
}