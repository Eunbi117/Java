package ch09;
import java.util.Scanner;


class Cylinder_9_4 extends Circle_9_3
{
	private double height;

	// 기본 생성자 메소드
	public Cylinder_9_4()
	{
		super();		// Circle_9_3 클래스의 기본 생성자 메소드 호출
		height = 0;
	}
	// 특정 x 좌표 값과 y 좌표 값, 반지름, 높이로 초기화하는 생성자 메소드
	public Cylinder_9_4(double x, double y, double r, double h)
	{
		super(x, y, r);	// Circle_9_3 클래스의 생성자 메소드 호출
		height = h;
	}

	// 높이를 반환하는 메소드
	double getHeight()
	{
		return height;
	}
	
	// 표면적을 계산하여 반환하는 메소드
	double getArea()
	{
		double area = 0;
		area = super.getArea() * 2 + 2 * super.getPI() * super.getRadius() * height;
		return area;
	}
	// 부피를 계산하여 반환하는 메소드
	double getVolume()
	{
		double volume = 0;
		volume = super.getArea() * height;
		return volume;
	}
	
	// 원기둥의 정보를 출력하는 메소드
	void print()
	{
		String result = "";
		result += "중심 = [" + super.getX() + ", " + super.getY() + "], ";
		result += "반지름 = " + super.getRadius() + ", ";
		result += "높이 = " + height;
		System.out.println(result);
	}
}


public class PointDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		// PointXY 클래스
		System.out.print("점의 x와 y 좌표를 입력하세요 : ");
		PointXY p = new PointXY(sc.nextDouble(), sc.nextDouble());

		// Circle 클래스
		System.out.print("원의 중심 좌표와 반지름을 입력하세요 : ");
		Circle_9_3 c = new Circle_9_3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

		// Cylinder 클래스
		System.out.print("원기둥의 원의 중심 좌표와 반지름과 높이를 입력하세요 : ");
		Cylinder_9_4 cy = new Cylinder_9_4(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		
		System.out.println();
		p.print();		// 점들의 좌표 출력
		c.print();		// 원 정보 출력
		cy.print();		// 원기둥 정보 출력
		
		System.out.println();
		
		System.out.println("원의 면적 : " + c.getArea());
		System.out.println("원기둥의 표면적 : " + cy.getArea());
		System.out.println("원기둥의 부피 : " + cy.getVolume());
	}
}
