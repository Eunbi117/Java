package ch09;
import java.util.Scanner;


class Cylinder_9_4 extends Circle_9_3
{
	private double height;

	// �⺻ ������ �޼ҵ�
	public Cylinder_9_4()
	{
		super();		// Circle_9_3 Ŭ������ �⺻ ������ �޼ҵ� ȣ��
		height = 0;
	}
	// Ư�� x ��ǥ ���� y ��ǥ ��, ������, ���̷� �ʱ�ȭ�ϴ� ������ �޼ҵ�
	public Cylinder_9_4(double x, double y, double r, double h)
	{
		super(x, y, r);	// Circle_9_3 Ŭ������ ������ �޼ҵ� ȣ��
		height = h;
	}

	// ���̸� ��ȯ�ϴ� �޼ҵ�
	double getHeight()
	{
		return height;
	}
	
	// ǥ������ ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	double getArea()
	{
		double area = 0;
		area = super.getArea() * 2 + 2 * super.getPI() * super.getRadius() * height;
		return area;
	}
	// ���Ǹ� ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	double getVolume()
	{
		double volume = 0;
		volume = super.getArea() * height;
		return volume;
	}
	
	// ������� ������ ����ϴ� �޼ҵ�
	void print()
	{
		String result = "";
		result += "�߽� = [" + super.getX() + ", " + super.getY() + "], ";
		result += "������ = " + super.getRadius() + ", ";
		result += "���� = " + height;
		System.out.println(result);
	}
}


public class PointDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// PointXY Ŭ����
		System.out.print("���� x�� y ��ǥ�� �Է��ϼ��� : ");
		PointXY p = new PointXY(sc.nextDouble(), sc.nextDouble());

		// Circle Ŭ����
		System.out.print("���� �߽� ��ǥ�� �������� �Է��ϼ��� : ");
		Circle_9_3 c = new Circle_9_3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

		// Cylinder Ŭ����
		System.out.print("������� ���� �߽� ��ǥ�� �������� ���̸� �Է��ϼ��� : ");
		Cylinder_9_4 cy = new Cylinder_9_4(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		
		System.out.println();
		p.print();		// ������ ��ǥ ���
		c.print();		// �� ���� ���
		cy.print();		// ����� ���� ���
		
		System.out.println();
		
		System.out.println("���� ���� : " + c.getArea());
		System.out.println("������� ǥ���� : " + cy.getArea());
		System.out.println("������� ���� : " + cy.getVolume());
	}
}
