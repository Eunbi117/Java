package ch06;

public class FiveFiveDriver {

	public static void main(String[] args) {
		FiveFive ff = new FiveFive(); // ó�� ���� ���� 1,1;

		System.out.println("���� : " + ff.Myun() + "�ѷ� : " + ff.Dule());
		System.out.println("���� : " + ff.getGaro() + "���� : " + ff.getSero());

		ff.setGaro(3);//������ �޼ҵ� ����ؼ� ���θ� 1���� 3���� ����
		ff.setSero(5);//���θ� 1���� 5�� ����
		
		System.out.println("���� : " + ff.Myun() + "�ѷ� : " + ff.Dule());
		System.out.println("���� : " + ff.getGaro() + "���� : " + ff.getSero());
		
	}

}
