import java.util.Scanner;

public class three {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է��ϼ���: ");
		int one = scan.nextInt();
		
		System.out.print("�ι�° ���� �Է��ϼ���: ");
		int two = scan.nextInt();
		
		System.out.print("����° ���� �Է��ϼ���: ");
		int three = scan.nextInt();
		
		int max = one;
		int min = one;
		
		if(max < two){
			max = two;
		}
		if(max < three){
			max = three;
		}
		
		if(min > two){
			min = two;
		}
		if(min > three){
			min = three;
		}
		
		int sum = 0;
		sum = one+two+three;
		
		double aver = 0;
		aver = sum/3.0;
		
		
		System.out.println("�ִ밪: " + max);
		System.out.println("�ּҰ�: " + min);
		System.out.println("�հ�: " + sum);
		System.out.println("���: " + aver);
		
	}

}