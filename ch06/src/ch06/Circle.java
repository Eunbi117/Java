package ch06;

//���α׷��� ���� 6-3
class Circle
{
	int radius;				// ������
	double area;				// ����
	double circumference;			// �ѷ�
	final double PI = 3.14;			// ������
	
	public Circle(int r)//�����ڸ޼ҵ�
	{
		radius = r;
	}
	
	double getArea()			// ���� ������ ����Ͽ� ��ȯ
	{
		area = radius * radius * PI;
		return area;
	}
	double getCircumference()	// ���� �ѷ��� ����Ͽ� ��ȯ
	{
		circumference = 2 * radius * PI;
		return circumference;
	}
	void setRadius(int newR)	// ������ ����
	{
		radius = newR;
	}
}
