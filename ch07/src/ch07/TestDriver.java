package ch07;


//9�� ����
import java.util.Scanner;

class StudentTest{
	Scanner scan = new Scanner(System.in);
	
	String name;
	int middle;//�߰�
	int end;//�⸻
	boolean err;//�ݺ����� ����
	double aver;//���
	
	
	//�̸��� �ʱ�ȭ
	public StudentTest(String name){
		this.name = name;
	}
	
	//�߰�, �⸻ ���� �޴� �޼ҵ�
	public void setScore(){

		System.out.print(name+"�� �߰����� ������ �Է��϶�. ");
		do{
			err = true;//�ٽ� while���� �� �� �ʱ�ȭ
			middle = scan.nextInt();
			if(middle < 0 || middle > 100){
				System.out.println("�� ����� �̵����� ����");
				err = false;
				System.out.print(name+"�� �߰����� ������ �ٽ� �Է��϶�. ");
			}
		}while(!err);
		
		System.out.print(name+"�� �⸻���� ������ �Է��϶�. ");
		do{
			err = true;//�ٽ� while���� �� �� �ʱ�ȭ
			end = scan.nextInt();
			if(end < 0 || end > 100){
				System.out.println("�� ����� �̵����� ����");
				err = false;
				System.out.print(name+"�� �⸻���� ������ �ٽ� �Է��϶�. ");
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
		StudentTest s1 = new StudentTest("������");
		StudentTest s2 = new StudentTest("������");
		
		s1.setScore();//�߰������� �⸻������ ����ڿ��� ������� �ִ� �޼ҵ�
		System.out.println(s1.name + "�� ��������� " + s1.getAver() + "�̴�."); 
		System.out.println();
		
		s2.setScore();
		System.out.println(s2.name + "�� ��������� " + s2.getAver() + "�̴�."); 
	
	}
}