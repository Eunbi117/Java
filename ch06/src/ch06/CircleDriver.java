package ch06;

//프로그래밍 문제 6-4
public class CircleDriver
{
	public static void main(String[] args)
	{
		Circle c = new Circle(3);//객체 생성, 선언
		

		System.out.println("면적 : " + c.getArea());			// 면적 계산하여 출력
		System.out.println("둘레 : " + c.getCircumference());	// 둘레 계산하여 출력
	
	
		c.setRadius(5);	//0 -> 5				// 반지름을 5로 변경
		
		System.out.println();
		System.out.println("면적 : " + c.getArea());			// 면적 계산하여 출력
		System.out.println("둘레 : " + c.getCircumference());	// 둘레 계산하여 출력
	}
}
