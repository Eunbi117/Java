package ch07;

//6�� ����
class Triangle{
	int one;
	int two;
	int three;
	
	//������ �޼ҵ�
	public Triangle(int one, int two, int three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	//� �ﰢ������ �˷��ִ� �޼ҵ�
	public void whichTri(){
		if(one*one+two*two == three*three){//��Ÿ��� ���� -> �����ﰢ��
			System.out.print("�����ﰢ���̴�.");
		}
		else if(one == two || one == three || two == three){//�� ���� ���̰� ������ �̵�ﰢ��
			System.out.print("�̵�ﰢ���̴�.");
		}
		else
			System.out.print("������ �̵�� �ƴϴ�.");
	}
	
}

class TriangleDriver{
	public static void main(String[] args) {
		Triangle t1 = new Triangle(3, 5, 7);
		Triangle t2 = new Triangle(3, 4, 5);
		Triangle t3 = new Triangle(7, 10, 7);
		
		System.out.print("ù��° �ﰢ���� ");
		t1.whichTri();
		
		System.out.println();
		
		System.out.print("�ι�° �ﰢ���� ");
		t2.whichTri();
		
		System.out.println();
		
		System.out.print("����° �ﰢ���� ");
		t3.whichTri();
		
	}
}