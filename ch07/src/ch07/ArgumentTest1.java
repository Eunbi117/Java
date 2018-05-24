package ch07;

class Argument{
	public void change(int i, int j[], StringBuffer sb){
		i = 20;
		j[3] = 400;
		sb.append(" 화이팅 자바!");//StringBuffer에 문자 추가하기 위한 메소드
	}
	
	public void display(int i, int j[], StringBuffer sb){
		System.out.println("객체 변수 i의 값: " + i);
		System.out.print("배열의 값: ");
		//배열인 j의 갯수(길이)만큼 for문을 돌려서 배열 출력
		for(int index = 0; index < j.length ; index++){
			System.out.print(j[index]+ " ");
		}
		System.out.println();
		System.out.println("문자열 sb의 값: " + sb);
	}
}


class ArgumentTest1{
	public static void main(String[] args) {
		Argument d = new Argument();//객체 생성 -> 생성자 메소드는 따로 없음
		int a = 10;
		int b[] = {1,2,3,4};
		StringBuffer c = new StringBuffer("배우기 쉽죠?");//StringBuffer 생성하고 선언
		System.out.println("첫번째 display() 메소드 호출");
		d.display(a, b, c);//출력하는 메소드
		d.change(a, b, c);//변경하는 메소드
		
		System.out.println("================================");
		
		System.out.println("값을 변환한 다음 두번째 display() 메소드 호출");
		d.display(a, b, c);//change 메소드에서 변한 다음 출력된다.
	}
}