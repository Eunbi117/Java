// 프로그래밍 문제 8-3

import java.util.Scanner;

public class r8_3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시험 문제 수를 입력하세요 : ");
		int num = sc.nextInt();
		int[] answer = new int[num];
		int count = 0;//몇 개 맞았는지 확인
		double grade = 0;// 점수

		// 정답 입력 받아 배열에 저장
		System.out.print("정답을 입력하세요 : ");
		for (int i = 0; i < answer.length; i++)
			answer[i] = sc.nextInt();

		// 학생 답 입력 받아 정답과 비교
		System.out.print("답을 입력하세요 : ");
		for (int i = 0; i < answer.length; i++)
			if (answer[i] == sc.nextInt())
				count++;

		grade = count * 10;

		System.out.println("맞은 답수 : " + count);
		System.out.println("점수 : " + grade);
	}
}

