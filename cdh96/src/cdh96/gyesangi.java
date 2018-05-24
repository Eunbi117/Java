package cdh96;

import java.util.Scanner;

public class gyesangi {
public static void main(String[] args) {
	System.out.println("두혁이의 사칙연산 계산기");
	System.out.println("사칙연산을 골라주세요<+,-,*,/>");
	Scanner scan = new Scanner(System.in);
	
	double num1, num2;
	double sum;
	String a;
	
	a = scan.next();
	
	switch (a) {
	case "+":
		System.out.println("첫번째");
		num1 = scan.nextDouble();
		System.out.println("두번째");
		num2 = scan.nextDouble();
		
		sum = num1 + num2;
		
		System.out.println("값" +sum);
		break;
		
	case "-":
		System.out.println("첫번째");
		num1 = scan.nextDouble();
		System.out.println("두번째");
		num2 = scan.nextDouble();
		
		sum = num1 - num2;
		
		System.out.println("값" +sum);
		break;
		
	case "*":
		System.out.println("첫번째");
		num1 = scan.nextDouble();
		System.out.println("두번째");
		num2 = scan.nextDouble();
		
		sum = num1 * num2;
		
		System.out.println("값" +sum);
		
		break;
	case "/":
		
		System.out.println("첫번째");
		num1 = scan.nextDouble();
		System.out.println("두번째");
		num2 = scan.nextDouble();
		
		if(num1==0 || num2 ==0)
		{
			System.out.println("0으로 나눌수 없습니다.");
		}
		
		sum = num1 / num2;
		
		System.out.println("값" +sum);
		break;
	default:
		break;
	}
	
	
	
	
	
	
}
}
