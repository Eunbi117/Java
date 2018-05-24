
// 프로그래밍 문제 8-4

import java.util.Scanner;

public class r8_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시험 문제 수를 입력하세요 : ");
		int num = sc.nextInt();
		String[] answer = new String[num];
		int count = 0;//정답이 몇 개 인지
		double grade = 0.0;//몇 점인지
		String c = "y";//채점할 문제가 더 있는지 확인

		// 정답 입력 받아 배열에 저장

		System.out.print("정답을 입력하세요 : ");
		for (int i = 0; i < answer.length; i++)
			answer[i] = sc.next();

		// 학생 답 입력 받아 정답과 비교
		while (!(c.equals("n"))) {
			count = 0;
			grade = 0;
			System.out.print("답을 입력하세요 : ");
			for (int i = 0; i < answer.length; i++)
				if (answer[i].equals(sc.next())) {
					count++;
					grade += 1.0;
				} else
					grade -= 0.2;

			System.out.println("맞은 답수 : " + count);
			System.out.println("점수 : " + grade);

			System.out.print("\n채점할 퀴즈가 더 있는가? y 혹은 n을 입력하세요 : ");
			c = sc.next();
		}
	}
}

		
