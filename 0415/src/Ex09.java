import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double kg = 0;
		
		System.out.print("성별(남자/여자): ");
		String sung = sc.next();
		
		System.out.print("키: ");
		double height = sc.nextDouble();
		
		if(sung.equals("여자")){
			
			if(height > 150){
				kg = (37.8 + 0.89 * (height-150));
				System.out.println("이 사람의 이상적인 몸무게는 " + kg + "입니다.");
			}
			else{
				kg = 37.8;
				System.out.println("이 사람의 이상적인 몸무게는 " + kg + "입니다.");
			}
			
		}else if(sung.equals("남자")){
			if(height > 150){
				kg = (40 + 0.89 * (height-150));
				System.out.println("이 사람의 이상적인 몸무게는 " + kg + "입니다.");
			}
			else{
				kg = 40;
				System.out.println("이 사람의 이상적인 몸무게는 " + kg + "입니다.");
			}
		}else{
			System.out.println("그런 성별 없음");
		}
		
		
	}
}
