import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double increse_money = 0;//�λ��
		double new_money = 0;//������
		
		System.out.print("�� ������ �Է�: ");
		int money = sc.nextInt();
		
		System.out.print("�ٹ� �� ��� �Է�(���,����,�ҷ�):");
		String grade = sc.next();
		String a = "���";
		
		if(grade.equals(a)){
			increse_money = money * 0.06;
			new_money = money + increse_money;
		}else if(grade.equals("����")){
			increse_money = money * 0.04;
			new_money = money + increse_money;
		}else if(grade.equals("�ҷ�")){
			increse_money = money * 0.02;
			new_money = money + increse_money;
		}else{
			System.out.println("�� ����� �� �� �Է��߽��ϴ�.");
		}
		
		System.out.println("���� �λ��: " + increse_money);
		System.out.println("�� ����: " + new_money);
	}

}
