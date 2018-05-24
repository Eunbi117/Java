package ch07;

//6번 문제
class Triangle{
	int one;
	int two;
	int three;
	
	//생성자 메소드
	public Triangle(int one, int two, int three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	//어떤 삼각형인지 알려주는 메소드
	public void whichTri(){
		if(one*one+two*two == three*three){//피타고라스 정리 -> 직각삼각형
			System.out.print("직각삼각형이다.");
		}
		else if(one == two || one == three || two == three){//두 변의 길이가 같으면 이등변삼각형
			System.out.print("이등변삼각형이다.");
		}
		else
			System.out.print("직각도 이등변도 아니다.");
	}
	
}

class TriangleDriver{
	public static void main(String[] args) {
		Triangle t1 = new Triangle(3, 5, 7);
		Triangle t2 = new Triangle(3, 4, 5);
		Triangle t3 = new Triangle(7, 10, 7);
		
		System.out.print("첫번째 삼각형은 ");
		t1.whichTri();
		
		System.out.println();
		
		System.out.print("두번째 삼각형은 ");
		t2.whichTri();
		
		System.out.println();
		
		System.out.print("세번째 삼각형은 ");
		t3.whichTri();
		
	}
}