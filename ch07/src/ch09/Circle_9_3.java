package ch09;

class Circle_9_3 extends PointXY
{
	private double radius;
	private final double PI = 3.14;

	// 기본 생성자 메소드
	public Circle_9_3()
	{
		super();		// PointXY 클래스의 기본 생성자 메소드 호출
		radius = 0;
	}
	// 특정 x 좌표 값과 y 좌표 값, 반지름으로 초기화하는 생성자 메소드
	public Circle_9_3(double x, double y, double r)
	{
		super(x, y);	// PointXY 클래스의 생성자 메소드 호출
		radius = r;
	}

	// PI 값을 반환하는 메소드
	double getPI()
	{
		return PI;
	}
	// 반지름 반환하는 메소드
	double getRadius()
	{
		return radius;
	}
	// 면적을 반환하는 메소드
	double getArea()
	{
		double area = 0;
		area = PI * radius * radius;
		return area;
	}
	
	// 원의 정보를 출력하는 메소드
	void print()
	{
		String result = "";
		result += "중심 = [" + super.getX() + ", " + super.getY() + "], ";
		result += "반지름 = " + radius;
		System.out.println(result);
	}
}
