import java.util.Scanner;

public class Lab4_1 {
	
	void info(Robot r){
		System.out.println("가격은 " + r.price + "만원입니다.");
		System.out.println("기능은 " + r.toString());
	}
	
	public static void main(String[] args) {
		int number;//구매할 번호 선택
		//각각 로봇의 가격을 넣어서 클래스 생성
		DanceRobot dr = new DanceRobot(500);
		SingRobot sr = new SingRobot(300);
		DrawRobot wr = new DrawRobot(600);
		
		Scanner sc = new Scanner(System.in);
		
		Lab4_1 lab = new Lab4_1();//static없이 메소드를 불러올 때 메인 시작시 메인 클래스 생성

		do{
			System.out.println("어떤 로봇을 구매하시겠습니까? (0은끝내기)");
			System.out.println("1. 춤추는로봇, 2. 노래하는로봇, 3. 그림그리는로봇");
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
				System.out.println("잘못입력하셨습니다.");
			}
		}while(number != 0);
		System.out.println("프로그램을 끝내겠습니다.");
		
	}

}
