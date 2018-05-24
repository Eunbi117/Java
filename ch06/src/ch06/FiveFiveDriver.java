package ch06;

public class FiveFiveDriver {

	public static void main(String[] args) {
		FiveFive ff = new FiveFive(); // 처음 가로 세로 1,1;

		System.out.println("면적 : " + ff.Myun() + "둘레 : " + ff.Dule());
		System.out.println("가로 : " + ff.getGaro() + "세로 : " + ff.getSero());

		ff.setGaro(3);//변경자 메소드 사용해서 가로를 1에서 3으로 변경
		ff.setSero(5);//세로를 1에서 5로 변경
		
		System.out.println("면적 : " + ff.Myun() + "둘레 : " + ff.Dule());
		System.out.println("가로 : " + ff.getGaro() + "세로 : " + ff.getSero());
		
	}

}
