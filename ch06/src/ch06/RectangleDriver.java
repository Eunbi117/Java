package ch06;

//���α׷��� ���� 6-6
public class RectangleDriver
{
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle();			// ���� ���� 3, ���� ���� 5�� ���簢�� ��ü
		
		/*r.setCircumference();						// �ѷ� ���
		r.setArea();*/								// ���� ���

		System.out.println("���� : " + r.getWidth());			// ���� ���� ���
		System.out.println("���� : " + r.getLength());			// ���� ���� ���
		System.out.println("���� : " + r.getArea());			// ���� ���
		System.out.println("�ѷ� : " + r.getCircumference());	// �ѷ� ���
	
		
		System.out.println();
		
		
		//������ �޼ҵ� ���
		r.setWidth(21);//���α��̸� 1���� 3���� ����
		r.setLength(5);//���α��̸� 1���� 5�� ����
		
		System.out.println("���� : " + r.getWidth());			// ���� ���� ���
		System.out.println("���� : " + r.getLength());			// ���� ���� ���
		System.out.println("���� : " + r.getArea());			// ���� ���
		System.out.println("�ѷ� : " + r.getCircumference());	// �ѷ� ���
	
	}
}
