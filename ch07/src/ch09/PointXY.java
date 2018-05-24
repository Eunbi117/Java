package ch09;

class PointXY
{
	private double x_coordinate;		// x 좌표 값
	private double y_coordinate;		// y 좌표 값
	
	// 기본 생성자 메소드
	public PointXY()
	{
		setX(0);
		setY(0);
	}
	// 특정 x 좌표 값과 y 좌표 값으로 초기화하는 생성자 메소드
	public PointXY(double x, double y)
	{
		setX(x);
		setY(y);
	}
	
	// x 좌표 값을 반환하는 메소드
	double getX()
	{
		return x_coordinate;
	}
	// y 좌표 값을 반환하는 메소드
	double getY()
	{
		return y_coordinate;
	}

	// x 좌표 값을 변경하는 메소드
	void setX(double x)
	{
		x_coordinate = x;
	}
	// y 좌표 값을 변경하는 메소드
	void setY(double y)
	{
		y_coordinate = y;
	}
	
	// 점들의 좌표를 출력하는 메소드
	void print()
	{
		String result = "";
		result += "점들의 좌표 = [" + x_coordinate + ", " + y_coordinate + "]";
		System.out.println(result);
	}
}
