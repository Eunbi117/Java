package choieunbi.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import choieunbi.domain.Book;
import choieunbi.service.Admin;
import choieunbi.service.guest; 


public class Show {
	
	Scanner sc = new Scanner(System.in);
	
	public void Open(){
		System.out.println("온라인 서점 [BBook]에 오신 것을 환영합니다!");
		System.out.println("저희 온라인 서점 [BBook]은 손님에게 편한 쇼핑을 위해 노력하겠습니다!");
		System.out.println("자 쇼핑 시~작!");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
	}

	
	public void Menu(){
		System.out.println();
		System.out.println("==========처음메뉴==========");
		System.out.println("||   1. 관리자 로그인         ||");
		System.out.println("||   2. 구매자 로그인         ||");
		System.out.println("||   3. 회원가입              ||");
		System.out.println("||   0. 프로그램 종료         ||");
		System.out.print("================================>");
		
	}
	
	public void AdminMenu(){
		System.out.println();
		System.out.println("관리자님 어서오세요! 뭘 하실건가요?");
		System.out.println();
		System.out.println("=========관리자메뉴==========");
		System.out.println("||    1. 재고관리             ||");
		System.out.println("||    2. 주문관리             ||");
		System.out.println("||    3. 결산                 ||");
		System.out.println("||    4. 처음메뉴             ||");
		System.out.print("================================>");
		
	}
	
	public void BookMenu(){
		System.out.println();
		System.out.println("==========재고메뉴==========");
		System.out.println("||     1. 책등록             ||");
		System.out.println("||     2. 책목록             ||");
		System.out.println("||     3. 이전메뉴           ||");
		System.out.print("================================>");
		
		}
	
	public void OrderMenu(){
		System.out.println();
		System.out.println("==========주문메뉴==========");
		System.out.println("||    1. 주문조회             ||");
		System.out.println("||    2. 판매확정             ||");
		System.out.println("||    3. 판매취소             ||");
		System.out.println("||    4. 이전메뉴             ||");
		System.out.print("================================>");
		
		}
	
	public void PayMenu(){
		System.out.println();
		System.out.println("==========결산메뉴==========");
		System.out.println("||    1. 판매건조회           ||");
		System.out.println("||    2. 매출조회             ||");
		System.out.println("||    3. 이전메뉴             ||");
		System.out.print("================================>");
		
		}
	
	public void CustomerMenu(){
		System.out.println();
		System.out.println("손님 어서오세요! 뭐하실래요?");
		System.out.println();
		System.out.println("==========손님메뉴==========");
		System.out.println("||     1. 구매               ||");
		System.out.println("||     2. 장바구니           ||");
		System.out.println("||     3. 처음메뉴           ||");
		System.out.print("================================>");
		}
	public void BuyMenu(){
		System.out.println();
		System.out.println("==========구매메뉴==========");
		System.out.println("||     1. 책조회             ||");
		System.out.println("||     2. 책구매             ||");
		System.out.println("||     3. 이전메뉴           ||");
		System.out.print("================================>");
		}
	
	public void CartMenu(){
		System.out.println();
		System.out.println("=========장바구니메뉴========");
		System.out.println("||   1. 장바구니 조회         ||");
		System.out.println("||   2. 장바구니 삭제         ||");
		System.out.println("||   3. 책 결제               ||");
		System.out.println("||   4. 이전메뉴              ||");
		System.out.print("================================>");
		}

}
