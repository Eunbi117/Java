package ch06;


//3������
 class Circle2 {
	 //�Ӽ�, ������ �޼ҵ�, �޼ҵ�
	 double r;//������ �Ӽ�
	 double area;//���� ���ϴ� ����
	 double cir;//�ѷ� ���ϴ� ����
	 final double PI = 3.14;
	 
	 //������ �޼ҵ�
	 public Circle2(double r){
		 this.r = r;//this�� ���� �ִ� class �ȿ� �մ� ������ ����
	 }
	 
	 public double getArea(){//���� ���ϴ� �޼ҵ�
		 area = r*r*PI;
		 return area;
	 }
	 
	 public double getCir(){//�ѷ� ���ϴ� �޼ҵ�
		 cir = 2*r*PI;
		 return cir;
	 }
	 
	 void setR(double newR){//�������� �����ϱ� ���� �޼ҵ�
		 r = newR;
	 }
	 


}
