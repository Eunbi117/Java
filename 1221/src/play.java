import java.util.Scanner;

public class play {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int price = 0;
		
		System.out.print("�������! �մ�~ �����̿���Դϱ�? ������Դϱ�?");
		String ticket = scan.next();
		
		System.out.print("�մ� ���̰� ��� �ǽʴϱ�?(�˹ٻ��� ���� ����ð��� �Է��ض� 24�÷� �Է�)");
		int age = scan.nextInt();
		int time = scan.nextInt();
		
		if(ticket.equals("�����̿��")){
			if(time >= 8 && time < 17){
				if(age >= 3 && age <= 12 || age >= 65){
					price = 25000;
				}else{
					price = 34000;
				}
			}
			else{
				if(age >= 3 && age <= 12 || age >= 65){
					price = 21000;
				}else{
					price = 29000;
				}
			}
		}
		
		
		if(ticket.equals("�����")){
			if(time >= 8 && time < 17){
				if(age >= 3 && age <= 12 || age >= 65){
					price = 20000;
				}else{
					price = 27000;
				}
			}
			else{
				if(age >= 3 && age <= 12 || age >= 65){
					price = 17000;
				}else{
					price = 23000;
				}
			}
		}
		
		System.out.println("�մ�~ " + price + "�� ���ø� �˴ϴ�^^");
		
	}

}