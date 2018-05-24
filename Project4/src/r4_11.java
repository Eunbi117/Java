// 프로그래밍 문제 4-11
// 각 구 별로 두 명의 시장 후보의 득표수를 입력받아 선거 결과(총 득표수, 득표율, 당선된 후보)를 알려주는 프로그램

import java.util.*;

public class r4_11
{
	public static void main (String[] args)
	{
		System.out.println("각 구 별로 두 명의 시장 후보의 득표수를 입력받아 선거 결과를 알려주는 프로그램입니다.\n");
		
		String continue_input = "";				// 보고할 구가 있는지 확인
		int input_num = 0;						// 득표수 입력
		int first_num = 0;						// 첫 번째 후보의 득표수
		int second_num = 0;						// 두 번째 후보의 득표수
		double first_rate = 0;					// 첫 번째 후보의 득표율
		double second_rate = 0;					// 두 번째 후보의 득표율
		
		// 입력
		Scanner sc = new Scanner(System.in);

		while ( !(continue_input.equals("no")) )		// 보고할 구가 있는지 확인하는 변수의 값이 no이면 종료
		{
			System.out.print("\n보고할 구가 있나요(있으면 yes 없으면 no를 입력하세요) : ");
			continue_input = sc.next();					// 보고할 구가 있는지 입력
			
			if ( continue_input.equals("yes") )			// yes라고 답한 경우만 득표수 입력 받음
			{
				System.out.print("첫 번째 후보가 그 구에서 얻은 득표 수를 입력하세요 : ");
				input_num = sc.nextInt();
				first_num += input_num;
				System.out.print("두 번째 후보가 그 구에서 얻은 득표 수를 입력하세요 : ");
				input_num = sc.nextInt();
				second_num += input_num;
			}
			else if ( continue_input.equals("no") )		// no라고 답한 경우 while문 종료
			{
				break;
			}
			else	// yes와 no 이외의 값을 입력한 경우 잘못 입력 - while문 처음으로 돌아가서 다시 입력
			{
				System.out.println("잘못 입력하셨습니다. yes와 no 중에서 하나를 입력하세요.");
			}
		}

		// 득표율 계산 및 결과 출력
		if ( first_num == 0 && second_num == 0 )	// 두 후보의 득표수가 모두 0인 경우(어떤 구의 보고도 받지 않은 상태)
		{
			System.out.println("\n투표 결과가 입력되지 않았습니다.");
		}
		else										// 두 후보 중 한명이라도 득표수가 0이 아닌 경우 득표율 및 결과 출력
		{
			// 득표율 = 해당 후보의 득표수 / 전체 투표수 * 100
			first_rate = (double) first_num / (first_num + second_num) * 100;		// 첫 번째 후보의 득표율 계산
			second_rate = (double) second_num / (first_num + second_num) * 100;		// 두 번째 후보의 득표율 계산
			
			// 정수는 %d, 실수는 %f
			// %f 사이의 2.1에서 2는 정수의 자릿수, 1은 소숫점 아래 자릿수를 나타냄
			System.out.printf("\n\n첫 번째 후보가 얻은 총 투표수는 %d이고 득표율은 %2.1f%% 입니다.\n", first_num, first_rate);
			System.out.printf("두 번째 후보가 얻은 총 투표수는 %d이고 득표율은 %2.1f%% 입니다.\n\n", second_num, second_rate);
			
			if ( first_num > second_num )			// 첫 번째 후보의 득표수가 두 번째 후보의 득표수 보다 큰 경우
				System.out.println("첫 번째 후보가 시장으로 당선되었습니다.");
			else if ( first_num < second_num )		// 첫 번째 후보의 득표수가 두 번째 후보의 득표수보다 작은 경우
				System.out.println("두 번째 후보가 시장으로 당선되었습니다.");
			else									// 첫 번째 후보의 득표수와 두 번째 후보의 득표수가 같은 경우
				System.out.println("두 후보의 득표수가 같습니다.");
		}
	}
}
