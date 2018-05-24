package ch07;

import java.util.Scanner;

class PairOfDice extends Die {// 문제 5번 클래스를 상속
	int total;// 총점수 저장

	// 초기화 하는 생성자 메소드
	public PairOfDice() {
		total = 0;
	}

	// 총 점수 누적하여 출력
	public int getTotal(int total) {
		this.total += total;

		return this.total;
	}

	// 주사위 두개가 다 1이 나왔을 때 사용할 메소드
	public int noTotal() {
		total = 0;

		return total;
	}

}

public class Pig {
	public static void main(String[] args) {
		PairOfDice me = new PairOfDice();// 나!
		PairOfDice com = new PairOfDice();// 컴퓨터!
		boolean turn = true;// true일 때 사용자, false일 때 컴퓨터의 차례이다.
		int i = 1;// 몇 판 하는지 볼까?
		boolean switchturn = true;// 컴퓨터가 20점을 초과했을 때 1번만 사용자에게 차례를 돌리기 위해 구분하려고

		Scanner sc = new Scanner(System.in);
		String bing = "";// 사용자가 차례 넘기기 위해

		System.out.println("게임 스타트!");

		do {
			while (turn) {// 차례가 다 있음 -> 사용자가 true일 때 돌아감
				System.out.println();
				System.out.println("-----" + i + "번째 판-----");
				System.out.println();
				System.out.println("너 차례");
				System.out.print("안하고 차례 돌릴려면 [돌려]라고 입력! 계속이면 아무키 입력! ");
				bing = sc.next();
				if (bing.equals("돌려")) {
					System.out.println("컴퓨터에게 차례가 넘어갑니다.");
					turn = false;
					break;
				}

				me.setDie();// 주사위 돌림
				if (me.die_fir == 1 || me.die_sec == 1) {// 주사위 값 한개가 1이면
					if (me.die_fir == 1 && me.die_sec == 1) {// 주사위 값 두개가 1이면
						me.noTotal();// 지금까지의 점수는 없었던 걸로...
						System.out.println("너 주사위 나온 값: " + me.die_fir + " " + me.die_sec);
						System.out.println("에베베베 너 점수 없당~~~");
						System.out.println("너 총 값: " + me.total);
					}else{
						System.out.println("너 주사위 나온 값: " + me.die_fir + " " + me.die_sec);
						System.out.println("주사위 값 하나가 1이어서 점수 안넣을 거임ㅎ");
						System.out.println("너 총 값: " + me.total);
					}
				} else {
					System.out.println("너 주사위 나온 값: " + me.die_fir + " " + me.die_sec);
					int score = me.round();// round라는 메소드는 주사위의 두 면을 합친 정수를 반환
											// 받는 변수
					System.out.println("너 총 값: " + me.getTotal(score));
				}

				turn = false;
				i++;// 몇판하는지 셀려고
				System.out.println();
			}

			while (!turn) {// 컴퓨터는 false일 때 돌아간다
				System.out.println("내 차례");
				if (com.total > 20 && switchturn) {
					System.out.println("20점 초과해서 너 차례로 주래...짜증...");
					turn = true;
					switchturn = false;// 한번만 차례 넘겨줄거임
					break;
				}
				com.setDie();// 주사위 돌림
				if (com.die_fir == 1 || com.die_sec == 1) {// 주사위 값 한개가 1이면
					if (com.die_fir == 1 && com.die_sec == 1) {// 주사위 값 두개가
						// 1이면
						com.noTotal();// 지금까지의 점수는 없었던 걸로...
						System.out.println("내 주사위 나온 값: " + com.die_fir + " " + com.die_sec);
						System.out.println("에베베베 너 점수 없당~~~");
						System.out.println("내 총 값: " + com.total);
					}
					else{
						System.out.println("내 주사위 나온 값: " + com.die_fir + " " + com.die_sec);
						System.out.println("주사위 값 하나가 1이어서 점수 안넣을 거임ㅎ");
						System.out.println("내 총 값: " + com.total);
					}
				}
				else {
					System.out.println("내 주사위 나온 값: " + com.die_fir + " " + com.die_sec);
					System.out.println("내 총 값: " + com.getTotal(com.round()));
				}
				turn = true;
			}

		} while (me.total < 100 && com.total < 100);

		// 승패 출력
		System.out.println();
		if (me.total > 100) {
			System.out.println("너님 승리!");
		} else if (com.total > 100) {
			System.out.println("나님 승리!");
		}

	}
}