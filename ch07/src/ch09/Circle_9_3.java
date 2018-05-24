package ch09;

class Circle_9_3 extends PointXY
{
	private double radius;
	private final double PI = 3.14;

	// �⺻ ������ �޼ҵ�
	public Circle_9_3()
	{
		super();		// PointXY Ŭ������ �⺻ ������ �޼ҵ� ȣ��
		radius = 0;
	}
	// Ư�� x ��ǥ ���� y ��ǥ ��, ���������� �ʱ�ȭ�ϴ� ������ �޼ҵ�
	public Circle_9_3(double x, double y, double r)
	{
		super(x, y);	// PointXY Ŭ������ ������ �޼ҵ� ȣ��
		radius = r;
	}

	// PI ���� ��ȯ�ϴ� �޼ҵ�
	double getPI()
	{
		return PI;
	}
	// ������ ��ȯ�ϴ� �޼ҵ�
	double getRadius()
	{
		return radius;
	}
	// ������ ��ȯ�ϴ� �޼ҵ�
	double getArea()
	{
		double area = 0;
		area = PI * radius * radius;
		return area;
	}
	
	// ���� ������ ����ϴ� �޼ҵ�
	void print()
	{
		String result = "";
		result += "�߽� = [" + super.getX() + ", " + super.getY() + "], ";
		result += "������ = " + radius;
		System.out.println(result);
	}
}
