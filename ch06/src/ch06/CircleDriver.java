package ch06;

//���α׷��� ���� 6-4
public class CircleDriver
{
	public static void main(String[] args)
	{
		Circle c = new Circle(3);//��ü ����, ����
		

		System.out.println("���� : " + c.getArea());			// ���� ����Ͽ� ���
		System.out.println("�ѷ� : " + c.getCircumference());	// �ѷ� ����Ͽ� ���
	
	
		c.setRadius(5);	//0 -> 5				// �������� 5�� ����
		
		System.out.println();
		System.out.println("���� : " + c.getArea());			// ���� ����Ͽ� ���
		System.out.println("�ѷ� : " + c.getCircumference());	// �ѷ� ����Ͽ� ���
	}
}
