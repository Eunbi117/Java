package ch06;

//프로그래밍 문제 6-6
public class RectangleDriver
{
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle();			// 가로 길이 3, 세로 길이 5인 직사각형 객체
		
		/*r.setCircumference();						// 둘레 계산
		r.setArea();*/								// 면적 계산

		System.out.println("가로 : " + r.getWidth());			// 가로 길이 출력
		System.out.println("세로 : " + r.getLength());			// 세로 길이 출력
		System.out.println("면적 : " + r.getArea());			// 면적 출력
		System.out.println("둘레 : " + r.getCircumference());	// 둘레 출력
	
		
		System.out.println();
		
		
		//변경자 메소드 사용
		r.setWidth(21);//가로길이를 1에서 3으로 변경
		r.setLength(5);//세로길이를 1에서 5로 변경
		
		System.out.println("가로 : " + r.getWidth());			// 가로 길이 출력
		System.out.println("세로 : " + r.getLength());			// 세로 길이 출력
		System.out.println("면적 : " + r.getArea());			// 면적 출력
		System.out.println("둘레 : " + r.getCircumference());	// 둘레 출력
	
	}
}
