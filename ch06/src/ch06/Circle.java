package ch06;

//프로그래밍 문제 6-3
class Circle
{
	int radius;				// 반지름
	double area;				// 면적
	double circumference;			// 둘레
	final double PI = 3.14;			// 원주율
	
	public Circle(int r)//생성자메소드
	{
		radius = r;
	}
	
	double getArea()			// 원의 면적을 계산하여 반환
	{
		area = radius * radius * PI;
		return area;
	}
	double getCircumference()	// 원의 둘레를 계산하여 반환
	{
		circumference = 2 * radius * PI;
		return circumference;
	}
	void setRadius(int newR)	// 반지름 변경
	{
		radius = newR;
	}
}
