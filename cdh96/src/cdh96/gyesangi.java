package cdh96;

import java.util.Scanner;

public class gyesangi {
public static void main(String[] args) {
	System.out.println("�������� ��Ģ���� ����");
	System.out.println("��Ģ������ ����ּ���<+,-,*,/>");
	Scanner scan = new Scanner(System.in);
	
	double num1, num2;
	double sum;
	String a;
	
	a = scan.next();
	
	switch (a) {
	case "+":
		System.out.println("ù��°");
		num1 = scan.nextDouble();
		System.out.println("�ι�°");
		num2 = scan.nextDouble();
		
		sum = num1 + num2;
		
		System.out.println("��" +sum);
		break;
		
	case "-":
		System.out.println("ù��°");
		num1 = scan.nextDouble();
		System.out.println("�ι�°");
		num2 = scan.nextDouble();
		
		sum = num1 - num2;
		
		System.out.println("��" +sum);
		break;
		
	case "*":
		System.out.println("ù��°");
		num1 = scan.nextDouble();
		System.out.println("�ι�°");
		num2 = scan.nextDouble();
		
		sum = num1 * num2;
		
		System.out.println("��" +sum);
		
		break;
	case "/":
		
		System.out.println("ù��°");
		num1 = scan.nextDouble();
		System.out.println("�ι�°");
		num2 = scan.nextDouble();
		
		if(num1==0 || num2 ==0)
		{
			System.out.println("0���� ������ �����ϴ�.");
		}
		
		sum = num1 / num2;
		
		System.out.println("��" +sum);
		break;
	default:
		break;
	}
	
	
	
	
	
	
}
}
