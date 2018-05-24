package ch07;

import java.util.Scanner;

class PairOfDice extends Die {// ���� 5�� Ŭ������ ���
	int total;// ������ ����

	// �ʱ�ȭ �ϴ� ������ �޼ҵ�
	public PairOfDice() {
		total = 0;
	}

	// �� ���� �����Ͽ� ���
	public int getTotal(int total) {
		this.total += total;

		return this.total;
	}

	// �ֻ��� �ΰ��� �� 1�� ������ �� ����� �޼ҵ�
	public int noTotal() {
		total = 0;

		return total;
	}

}

public class Pig {
	public static void main(String[] args) {
		PairOfDice me = new PairOfDice();// ��!
		PairOfDice com = new PairOfDice();// ��ǻ��!
		boolean turn = true;// true�� �� �����, false�� �� ��ǻ���� �����̴�.
		int i = 1;// �� �� �ϴ��� ����?
		boolean switchturn = true;// ��ǻ�Ͱ� 20���� �ʰ����� �� 1���� ����ڿ��� ���ʸ� ������ ���� �����Ϸ���

		Scanner sc = new Scanner(System.in);
		String bing = "";// ����ڰ� ���� �ѱ�� ����

		System.out.println("���� ��ŸƮ!");

		do {
			while (turn) {// ���ʰ� �� ���� -> ����ڰ� true�� �� ���ư�
				System.out.println();
				System.out.println("-----" + i + "��° ��-----");
				System.out.println();
				System.out.println("�� ����");
				System.out.print("���ϰ� ���� �������� [����]��� �Է�! ����̸� �ƹ�Ű �Է�! ");
				bing = sc.next();
				if (bing.equals("����")) {
					System.out.println("��ǻ�Ϳ��� ���ʰ� �Ѿ�ϴ�.");
					turn = false;
					break;
				}

				me.setDie();// �ֻ��� ����
				if (me.die_fir == 1 || me.die_sec == 1) {// �ֻ��� �� �Ѱ��� 1�̸�
					if (me.die_fir == 1 && me.die_sec == 1) {// �ֻ��� �� �ΰ��� 1�̸�
						me.noTotal();// ���ݱ����� ������ ������ �ɷ�...
						System.out.println("�� �ֻ��� ���� ��: " + me.die_fir + " " + me.die_sec);
						System.out.println("�������� �� ���� ����~~~");
						System.out.println("�� �� ��: " + me.total);
					}else{
						System.out.println("�� �ֻ��� ���� ��: " + me.die_fir + " " + me.die_sec);
						System.out.println("�ֻ��� �� �ϳ��� 1�̾ ���� �ȳ��� ���Ӥ�");
						System.out.println("�� �� ��: " + me.total);
					}
				} else {
					System.out.println("�� �ֻ��� ���� ��: " + me.die_fir + " " + me.die_sec);
					int score = me.round();// round��� �޼ҵ�� �ֻ����� �� ���� ��ģ ������ ��ȯ
											// �޴� ����
					System.out.println("�� �� ��: " + me.getTotal(score));
				}

				turn = false;
				i++;// �����ϴ��� ������
				System.out.println();
			}

			while (!turn) {// ��ǻ�ʹ� false�� �� ���ư���
				System.out.println("�� ����");
				if (com.total > 20 && switchturn) {
					System.out.println("20�� �ʰ��ؼ� �� ���ʷ� �ַ�...¥��...");
					turn = true;
					switchturn = false;// �ѹ��� ���� �Ѱ��ٰ���
					break;
				}
				com.setDie();// �ֻ��� ����
				if (com.die_fir == 1 || com.die_sec == 1) {// �ֻ��� �� �Ѱ��� 1�̸�
					if (com.die_fir == 1 && com.die_sec == 1) {// �ֻ��� �� �ΰ���
						// 1�̸�
						com.noTotal();// ���ݱ����� ������ ������ �ɷ�...
						System.out.println("�� �ֻ��� ���� ��: " + com.die_fir + " " + com.die_sec);
						System.out.println("�������� �� ���� ����~~~");
						System.out.println("�� �� ��: " + com.total);
					}
					else{
						System.out.println("�� �ֻ��� ���� ��: " + com.die_fir + " " + com.die_sec);
						System.out.println("�ֻ��� �� �ϳ��� 1�̾ ���� �ȳ��� ���Ӥ�");
						System.out.println("�� �� ��: " + com.total);
					}
				}
				else {
					System.out.println("�� �ֻ��� ���� ��: " + com.die_fir + " " + com.die_sec);
					System.out.println("�� �� ��: " + com.getTotal(com.round()));
				}
				turn = true;
			}

		} while (me.total < 100 && com.total < 100);

		// ���� ���
		System.out.println();
		if (me.total > 100) {
			System.out.println("�ʴ� �¸�!");
		} else if (com.total > 100) {
			System.out.println("���� �¸�!");
		}

	}
}