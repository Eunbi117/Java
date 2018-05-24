package choieunbi.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import choieunbi.domain.Book;

public class Admin {//서점 관리자
	private String id;//아이디
	private String pwd;//비밀번호
	int num = 0;//메뉴를 구분해줄 변수
	int gg = 0;//i값 저장해줄 변수 --> 오류처리를 위한 어쩔수없는 변수....휴
	
	
	static ArrayList<Book> bookstand = new ArrayList<Book>();//책꽂이
	static ArrayList<Book> buy2;//guest에서 사용한 buy 리스트 사용하기 위함
	
	Scanner sc = new Scanner(System.in);
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	//하는일
	public void remain(int num){//재고관리
		
		if(num == 1){//책등록
			//책의 제목과 값을 입력 코드는 랜덤사용(4자리)
				
			System.out.print("책제목: ");
			String btitle = sc.next();
			System.out.print("책가격: ");
			int bprice = sc.nextInt();
			
			int cardnum = (int)((Math.random()*8999)+1000);
			
			//코드번호 중복처리
			for(int i = 0; i < bookstand.size(); i++){//이미 저장한 것중에 같은 cardnum이 있으면
				if(cardnum == bookstand.get(i).getCardnum()){
					cardnum = (int)((Math.random()*8999)+1000);//다시 생성해줘요
					i = i-1;//다시 처음부터 같은 숫자가 있는지 비교
					break;
				}
			}
			
			Book b = new Book();
			
			b.setTitle(btitle);
			b.setPrice(bprice);
			b.setCardnum(cardnum);
			b.setOk("보관");
			
			bookstand.add(b);
			
			System.out.println("\'" +btitle+"\' 책 등록이 완료되었습니다!");

		}
		else if(num == 2){//책목록 조회
			//모든 책을 코드번호, 제목, 가격, 판매확정 여부 보여줌
			
			if(bookstand.size() == 0){
				System.out.println("책꽂이에 아무것도 없어 관리자 노나봐ㅜㅜ");
			}
			else{
				System.out.println("총 권수: " + bookstand.size());
				System.out.println();
				for(int i = 0; i < bookstand.size(); i++){
					System.out.print("책제목 :" + bookstand.get(i).getTitle() + "\n");
					System.out.print("책가격 :" + bookstand.get(i).getPrice()+ "\n");
					System.out.print("책코드 :" + bookstand.get(i).getCardnum()+ "\n");
					System.out.print("판매확정 여부 :" + bookstand.get(i).getOk() + "\n");
					System.out.println();
				}
			}

		}
		else{
			System.out.println("이전 메뉴로 고고씽~");
			System.out.println();
		}
			
	}
	
	public void order(int num){//주문관리
		if(num == 1){//주문조회
			//구매자가 결정한거 보여줌 --> guest에 buy arraylist 사용
			
			//guest에 쓰인 buy arraylist를 사용하기 위해
			guest g = new guest();//객체 생성
			buy2 = g.returnbuy();//리턴받은 arraylist를 buy2에 넣기
			
			if(buy2.size() == 0){
				System.out.println("주문한거 없어영");
			}
			else{
				System.out.println("총 권수 :" + buy2.size());
				System.out.println();
				for(int i = 0; i < buy2.size(); i++){
					System.out.print("책제목 :" + buy2.get(i).getTitle() + "\n");
					System.out.print("책가격 :" + buy2.get(i).getPrice()+ "\n");
					System.out.print("책코드 :" + buy2.get(i).getCardnum()+ "\n");
					System.out.print("판매확정 여부 :" + buy2.get(i).getOk() + "\n");
					System.out.println();
				}
			}
			
		}
		else if(num == 2){//판매확정
			//판매확정 처리 --> 판매확정 변수 추가
			
			//guest에 쓰인 buy arraylist를 사용하기 위해
			guest g = new guest();//객체 생성
			buy2 = g.returnbuy();//리턴받은 arraylist를 buy2에 넣기
			
			if(buy2.size() == 0){
				System.out.println("주문한거 없어영");
			}
			else{
				System.out.print("판매 확정시킬 책 코드를 입력해: ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getCardnum() == codenum){
						gg = i;
						break;
					}
				}
				if(buy2.get(gg).getCardnum() == codenum){
					buy2.get(gg).setOk("판매");//상태를 보관에서 판매로 바꾼다
					
					System.out.println("정상적으로 \'" + buy2.get(gg).getTitle() + "\'책이 판매처리 되었습니다.");
				}
				else
					System.out.println("그런 코드번호 없어용!");
					
			}
			
		}
		else if(num == 3){//판매취소
			//판매확정 처리 난 것을 취소
			
			
			//guest에 쓰인 buy arraylist를 사용하기 위해
			guest g = new guest();//객체 생성
			buy2 = g.returnbuy();//리턴받은 arraylist를 buy2에 넣기
			
			if(buy2.size() == 0){
				System.out.println("주문한거 없어영");
			}
			else{
				System.out.print("판매 취소시킬 책 코드를 입력해: ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getCardnum() == codenum){
						gg = i;
						break;
					}
				}
				if(buy2.get(gg).getCardnum() == codenum){
					buy2.get(gg).setOk("보관");
					
					System.out.println("정상적으로 \'" + buy2.get(gg).getTitle() + "\'책이 판매 취소처리 되었습니다.");
				}
				else{
					System.out.println("그런 코드번호 없어용!");
				}
					
			}
		}
		else{
			System.out.println("이전 메뉴로 고고씽~");
			System.out.println();
		}
	}
	
	public void account(int num){//결산관리
		if(num == 1){//판매건조회
			//판매확정 처리된 것들의 코드번호 제목 가격 여부 보여줌
			
			if(buy2.size() == 0){
				System.out.println("아직 판매건수가...없어요ㅜㅜ");
			}
			else{
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getOk().equals("판매")){
						gg = i;
						break;
					}
				}if(buy2.get(gg).getOk().equals("판매")){
					System.out.println("총 권수 :" + buy2.size());
					System.out.println();
					
					System.out.print("책제목 :" + buy2.get(gg).getTitle() + "\n");
					System.out.print("책가격 :" + buy2.get(gg).getPrice()+ "\n");
					System.out.print("책코드 :" + buy2.get(gg).getCardnum()+ "\n");
					System.out.print("판매확정 여부 :" + buy2.get(gg).getOk() + "\n");
					System.out.println();
				}
				else
					System.out.println("판매로 결정된 책이 없어요!");
				
			}
			
			
		}
		else if(num == 2){//매출조회
			//판매 확정된 모든 책의 가격을 더해서 총매출액 표시
			int sum = 0;//총매출액
			
			if(buy2.size() == 0){
				System.out.println("판매건수가 없어서 매출액 없어 거지야");
			}
			else{
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getOk().equals("판매")){
						sum += buy2.get(i).getPrice();
					}
				}
				System.out.println("총 매출액은 " + sum + "원 입니다.");
				System.out.println("부자되겠어^^");
			}

		}
		else{
			System.out.println("이전 메뉴로 고고씽~");
			System.out.println();
		}
	}
	public static ArrayList<Book> returnbookstand() {//다른 클래스에서 arraylist 사용할라구 리턴해줌
		// TODO Auto-generated method stub
		return bookstand;
	}
	
	public static ArrayList<Book> returnbuy2() {//다른 클래스에서 arraylist 사용할라구 리턴해줌
		// TODO Auto-generated method stub
		return buy2;
	}
}
