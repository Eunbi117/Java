
public class Aver {
	public static void main(String[] args) {
		int eng = 88;
		int pro = 92;
		int math = 79;
		int com = 80;
		
		double aver = 0;
		
		aver = (eng+pro+math+com)/4.0;
		
		System.out.println("영작문 과목의 점수: " + eng);
		System.out.println("프로그래밍 과목의 점수: " + pro);
		System.out.println("이산수학 과목의 점수: " + math);
		System.out.println("컴퓨터구조 과목의 점수: " + com);
		System.out.println("평균 점수: " + aver);
	}

}
