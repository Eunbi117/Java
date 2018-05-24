import java.util.Scanner;

public class r8_1{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];//배열 10개 만들기
		int sum = 0;//합계
		double aver = 0;//평균
	

		System.out.println("10개의 정수를 입력하세요.");
		
		
		//배열의 길이(갯수)만큼 for문 돌려서 정수 저장
		for(int i = 0 ; i < num.length ; i++)
		{
			num[i] = sc.nextInt();
		}
	
		
		//배열에 저장 된 정수 sum에다가 모두 저장
		for(int i = 0 ; i < num.length ; i++)
		{
			sum += num[i];
		}


		//평균
		aver = (double)sum / num.length;

	

		int min = 100;//최소값에 제일 큰 값을 넣어서 비교
		for(int i = 0 ; i < num.length ; i++)
		{
			if (min > num[i])
				min = num[i];
		}
	

		System.out.println("배열에 저장된 정수들의 합 : " + sum);
		System.out.println("배열에 저장된 정수들의 평균 : " + aver);
		System.out.println("배열에 저장된 정수 중 최소값 : " + min);
	}
}



