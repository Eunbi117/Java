import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double increse_money = 0;//인상액
		double new_money = 0;//새연봉
		
		System.out.print("현 연봉을 입력: ");
		int money = sc.nextInt();
		
		System.out.print("근무 평가 등급 입력(우수,보통,불량):");
		String grade = sc.next();
		String a = "우수";
		
		if(grade.equals(a)){
			increse_money = money * 0.06;
			new_money = money + increse_money;
		}else if(grade.equals("보통")){
			increse_money = money * 0.04;
			new_money = money + increse_money;
		}else if(grade.equals("불량")){
			increse_money = money * 0.02;
			new_money = money + increse_money;
		}else{
			System.out.println("평가 등급을 잘 못 입력했습니다.");
		}
		
		System.out.println("연봉 인상액: " + increse_money);
		System.out.println("새 연봉: " + new_money);
	}

}
