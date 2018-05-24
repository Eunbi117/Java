// 프로그래밍 문제 4-4-switch
// 문자열 안에 있는 모음과 자음의 수를 알아내어 출력하는 프로그램

import java.util.*;

public class r4_4
{
	public static void main (String[] args)
	{
		System.out.println("문자열 안에 있는 모음과 자음의 수를 알아내어 출력하는 프로그램입니다.\n");
		
		String str = "";				// 문자열
		int string_length = 0;			// 문자열의 길이
		int a_num = 0;					// 모음 a의 수
		int e_num = 0;					// 모음 e의 수
		int i_num = 0;					// 모음 i의 수
		int o_num = 0;					// 모음 o의 수
		int u_num = 0;					// 모음 u의 수
		int consonant = 0;				// 자음의 수
		int empty_num = 0;				// 공백의 수
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		str = sc.nextLine();			// 문자열 입력
		// next();로 받으면 단어까지만 저장되므로 문장이 입력될 때 공백인 칸까지 저장하기 위해 nextLine();을 이용
		
		string_length = str.length();	// 문자열의 길이
		
		System.out.println("문자열의 길이 : " + string_length);
		
		for ( int i = 0 ; i < string_length ; i++ )
		{
			switch ( str.charAt(i) )	// 문자열의 i번째 문자
			{
				// 대문자와 소문자 모두 모음의 숫자에 포함되도록 하기 위해
				// 소문자와 대문자를 모두 case로 받고 모음의 숫자가 1 증가되면 break
				case 'a':				// 소문자 a
				case 'A':				// 대문자 A
					a_num++;			// 모음 a의 수 1 증가
					break;
				case 'e':				// 소문자 e
				case 'E':				// 대문자 E
					e_num++;			// 모음 e의 수 1 증가
					break;
				case 'i':				// 소문자 i
				case 'I':				// 대문자 I
					i_num++;			// 모음 i의 수 1 증가
					break;
				case 'o':				// 소문자 o
				case 'O':				// 대문자 O
					o_num++;			// 모음 o의 수 1 증가
					break;
				case 'u':				// 소문자 u
				case 'U':				// 대문자 U
					u_num++;			// 모음 u의 수 1 증가
					break;
				case ' ':
					empty_num++;		// 공백의 수 1 증가
					break;
				default:				// 자음
					consonant++;		// 자음의 수 1 증가
					break;
			}
		}

		// 출력
		System.out.println("a의 수 : " + a_num);
		System.out.println("e의 수 : " + e_num);
		System.out.println("i의 수 : " + i_num);
		System.out.println("o의 수 : " + o_num);
		System.out.println("u의 수 : " + u_num);
		System.out.println("공백의 수 : " + empty_num);
		System.out.println("자음의 수 : " + consonant);
	}
}
