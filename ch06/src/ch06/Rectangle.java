package ch06;

//프로그래밍 문제 6-5
class Rectangle
{
	int width;//가로
	int length;//세로
	int area;//면적
	int circumference;//둘레
	
	//생성자메소드
	public Rectangle()
	{
		width = 1;
		length = 1;
	}
	
/*	public Rectangle(int wid, int len)
	{
		// 각 속성의 값을 1로 하는 매개변수를 가지지 않는 생성자 메소드
		if (wid != 1 && len != 1)
		{
			width = wid;
			length = len;
		}
	}*/
/*	void setArea()				// 면적 계산
	{
		area = width * length;
	}
	void setCircumference()		// 둘레 계산
	{
		circumference = (width + length) * 2;
	}*/
	
	
	int getArea()				// 면적 반환
	{
		area = width * length;
		return area;
	}
	int getCircumference()		// 둘레 반환
	{
		circumference = (width + length) * 2;
		return circumference;
	}
	
	
	int getWidth()				// 가로 길이 반환하는 접근자 메소드
	{
		return width;
	}
	int getLength()				// 세로 길이 반환하는 접근자 메소드
	{
		return length;
	}
	
	
	void setWidth(int newW)		// 가로 길이 변경하는 변경자 메소드
	{
		if (newW > 0 && newW < 20)
			width = newW;
		else{
			System.out.println("가로의 길이 범위는 0~20 사이입니다.");
			System.out.println("범위에서 벗어나서 초기화 값인 1로 계산됩니다.");
		}
	}
	void setLength(int newL)	// 세로 길이 변경하는 변경자 메소드
	{
		if (newL > 0 && newL < 20)
			length = newL;
		else{
			System.out.println("세로의 길이 범위는 0~20 사이입니다.");
			System.out.println("범위에서 벗어나서 초기화 값인 1로 계산됩니다.");
		}
	}
}
