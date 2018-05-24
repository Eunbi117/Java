package ch06;


//3번문제
 class Circle2 {
	 //속성, 생성자 메소드, 메소드
	 double r;//반지름 속성
	 double area;//면적 구하는 변수
	 double cir;//둘레 구하는 변수
	 final double PI = 3.14;
	 
	 //생성자 메소드
	 public Circle2(double r){
		 this.r = r;//this는 지금 있는 class 안에 잇는 변수를 뜻함
	 }
	 
	 public double getArea(){//면적 구하는 메소드
		 area = r*r*PI;
		 return area;
	 }
	 
	 public double getCir(){//둘레 구하는 메소드
		 cir = 2*r*PI;
		 return cir;
	 }
	 
	 void setR(double newR){//반지름을 변경하기 위한 메소드
		 r = newR;
	 }
	 


}
