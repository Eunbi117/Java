package ch07;

//문제 8번
import java.util.Scanner;

class slot{
	int num1;
	int num2;
	int num3;
	
	public slot(){
		num1 = (int) (Math.random() * 10);//0~9사이의 난수
		num2 = (int) (Math.random() * 10);//0~9사이의 난수
		num3 = (int) (Math.random() * 10);//0~9사이의 난수
	}
	
	public void money(){
		if(num1 == num2 && num2 == num3){
			System.out.println("1등에 당첨되었습니다!!!");
		}
		else if(num1 == num2 || num2 == num3 || num1 == num3){
			System.out.println("2등에 당첨되었습니다!!");
		}
		else if(num1 != num2 && num2 != num3 && num1 != num3){
			System.out.println("꽝입니다!");
		}
	}
}

public class SlotMachine{
	public static void main(String[] args) {
		String go = "예";//조건문에 필요한 애
		Scanner scan = new Scanner(System.in);
		
		do{
			slot s = new slot();//객체가 생성되면서 3개의 난수 생김
			System.out.println(s.num1+"\t"+s.num2+"\t"+s.num3);
			s.money();
			System.out.print("게임을 계속하시겠습니까?(예 혹은 아니오): ");
			go = scan.next();
			
		}while(go.equals("예"));
	}
}