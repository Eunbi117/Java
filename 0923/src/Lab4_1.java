import java.util.Scanner;

public class Lab4_1 {
	
	void info(Robot r){
		System.out.println("������ " + r.price + "�����Դϴ�.");
		System.out.println("����� " + r.toString());
	}
	
	public static void main(String[] args) {
		int number;//������ ��ȣ ����
		//���� �κ��� ������ �־ Ŭ���� ����
		DanceRobot dr = new DanceRobot(500);
		SingRobot sr = new SingRobot(300);
		DrawRobot wr = new DrawRobot(600);
		
		Scanner sc = new Scanner(System.in);
		
		Lab4_1 lab = new Lab4_1();//static���� �޼ҵ带 �ҷ��� �� ���� ���۽� ���� Ŭ���� ����

		do{
			System.out.println("� �κ��� �����Ͻðڽ��ϱ�? (0��������)");
			System.out.println("1. ���ߴ·κ�, 2. �뷡�ϴ·κ�, 3. �׸��׸��·κ�");
			number = sc.nextInt();
			
			if(number == 0)
				break;
			if(number == 1){
				lab.info(dr);
			}else if(number == 2){
				lab.info(sr);
			}else if(number == 3){
				lab.info(wr);
			}else{
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}while(number != 0);
		System.out.println("���α׷��� �����ڽ��ϴ�.");
		
	}

}
