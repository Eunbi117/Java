package ch06;

public class Circle2Driver {
	public static void main(String[] args) {
		Circle2 cir = new Circle2(3.0);
		
		System.out.println("���� ����: " + cir.getArea());
		System.out.println("���� �ѷ�: " + cir.getCir());
		
		//������ �����ϴ� �޼ҵ�
		cir.setR(5.0);//�������� 3.0���� 5.0���� ����
		
		System.out.println("���� ����: " + cir.getArea());
		System.out.println("���� �ѷ�: " + cir.getCir());
		
	}

}
