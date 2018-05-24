// 프로그래밍 문제 8-2

import java.util.Scanner;

public class r8_2{
	public static void main(String[] args){
		
	Scanner sc = new Scanner(System.in);
	System.out.print("입력할 점수들의 수를 입력하세요 : ");
	int numSize = sc.nextInt();
	int[] num = new int[numSize];
	

	//배열에 점수 저장
	for (int i = 0 ; i < num.length ; i++)
	{
		System.out.print((i+1) + "번째 점수를 입력하세요 : ");
		num[i] = sc.nextInt();
	}
	
	//저장된 순서대로 배열 출력
	System.out.println("본래 순서의 점수들 : ");
		for (int i = 0 ; i < num.length ; i++)
		{
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	
		
		// 역순 저장
		int temp = 0;
		int s = 0;
		
		for (int a = num.length-1 ; a >= num.length/2 ; a--)
		{
			temp = num[a];
			num[a] = num[s];
			num[s++] = temp;
		}
		
		//역순 저장한 거 출력
		System.out.println("반대 순서의 점수들 : ");
		for (int i = 0 ; i < num.length ; i++)
		{
			System.out.print(num[i] + "\t");
		}
		System.out.println();
		

	}
}
