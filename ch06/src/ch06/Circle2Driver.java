package ch06;

public class Circle2Driver {
	public static void main(String[] args) {
		Circle2 cir = new Circle2(3.0);
		
		System.out.println("원의 면적: " + cir.getArea());
		System.out.println("원의 둘레: " + cir.getCir());
		
		//반지름 변경하는 메소드
		cir.setR(5.0);//반지름을 3.0에서 5.0으로 변경
		
		System.out.println("원의 면적: " + cir.getArea());
		System.out.println("원의 둘레: " + cir.getCir());
		
	}

}
