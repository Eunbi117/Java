package ch07;

//���� 8��
import java.util.Scanner;

class slot{
	int num1;
	int num2;
	int num3;
	
	public slot(){
		num1 = (int) (Math.random() * 10);//0~9������ ����
		num2 = (int) (Math.random() * 10);//0~9������ ����
		num3 = (int) (Math.random() * 10);//0~9������ ����
	}
	
	public void money(){
		if(num1 == num2 && num2 == num3){
			System.out.println("1� ��÷�Ǿ����ϴ�!!!");
		}
		else if(num1 == num2 || num2 == num3 || num1 == num3){
			System.out.println("2� ��÷�Ǿ����ϴ�!!");
		}
		else if(num1 != num2 && num2 != num3 && num1 != num3){
			System.out.println("���Դϴ�!");
		}
	}
}

public class SlotMachine{
	public static void main(String[] args) {
		String go = "��";//���ǹ��� �ʿ��� ��
		Scanner scan = new Scanner(System.in);
		
		do{
			slot s = new slot();//��ü�� �����Ǹ鼭 3���� ���� ����
			System.out.println(s.num1+"\t"+s.num2+"\t"+s.num3);
			s.money();
			System.out.print("������ ����Ͻðڽ��ϱ�?(�� Ȥ�� �ƴϿ�): ");
			go = scan.next();
			
		}while(go.equals("��"));
	}
}