// 프로그래밍 문제 4-2
// 1부터 10까지의 정수 i에 대해 1부터 i까지의 합 sum을 계산하여 출력하는 프로그램

public class r4_2
{
	public static void main (String[] args)
	{
		System.out.println("1부터 10까지의 정수 i에 대해 1부터 i까지의 합 sum을 계산하여 출력하는 프로그램입니다.\n");
	
		int sum = 0;						// 1부터 i까지의 정수의 합
		
		System.out.println("값\t합");
		
		for ( int i = 1 ; i <= 10 ; i++ )	// 1부터 10까지의 정수 i
		{
			sum += i;					// sum = 1 + 2 + ..... + i
			
			// 값 출력
			System.out.println(i + "\t" + sum);
		}
	}
}

