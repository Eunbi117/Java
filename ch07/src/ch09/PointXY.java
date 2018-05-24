package ch09;

class PointXY
{
	private double x_coordinate;		// x ��ǥ ��
	private double y_coordinate;		// y ��ǥ ��
	
	// �⺻ ������ �޼ҵ�
	public PointXY()
	{
		setX(0);
		setY(0);
	}
	// Ư�� x ��ǥ ���� y ��ǥ ������ �ʱ�ȭ�ϴ� ������ �޼ҵ�
	public PointXY(double x, double y)
	{
		setX(x);
		setY(y);
	}
	
	// x ��ǥ ���� ��ȯ�ϴ� �޼ҵ�
	double getX()
	{
		return x_coordinate;
	}
	// y ��ǥ ���� ��ȯ�ϴ� �޼ҵ�
	double getY()
	{
		return y_coordinate;
	}

	// x ��ǥ ���� �����ϴ� �޼ҵ�
	void setX(double x)
	{
		x_coordinate = x;
	}
	// y ��ǥ ���� �����ϴ� �޼ҵ�
	void setY(double y)
	{
		y_coordinate = y;
	}
	
	// ������ ��ǥ�� ����ϴ� �޼ҵ�
	void print()
	{
		String result = "";
		result += "������ ��ǥ = [" + x_coordinate + ", " + y_coordinate + "]";
		System.out.println(result);
	}
}
