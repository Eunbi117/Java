package ch06;

//프로그래밍 문제 6-2
import java.util.Scanner;

public class NameDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("성과 이름을 입력하세요.");
		String first = sc.next();//성
		String name = sc.next();//이름
		
		//String args = "args";
		Name n1 = new Name(first, name);//객체 생성 선언
		System.out.println(n1.getFamilyName() + " " + n1.getFirstName());		// 성과 이름 출력
		System.out.println("성명의 길이 : " + n1.getNumber());					// 성명의 길이 출력

		System.out.println("성과 이름을 입력하세요.");
		Name n2 = new Name(sc.next(), sc.next());
		System.out.println(n2.getFamilyName() + " " + n2.getFirstName());		// 성과 이름 출력
		System.out.println("성명의 길이 : " + n2.getNumber());					// 성명의 길이 출력
	}
}
