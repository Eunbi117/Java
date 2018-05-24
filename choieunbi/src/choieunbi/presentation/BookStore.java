package choieunbi.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import choieunbi.domain.Book;
import choieunbi.service.Admin;
import choieunbi.service.dao;
import choieunbi.service.guest;

public class BookStore {
	static Admin a = new Admin();
	static ArrayList<guest> member = new ArrayList<guest>();//회원을 넣을 arraylist
	static ArrayList<Book> bookstand = a.returnbookstand();//텍스트 파일로 저장하기 위해 가져온거

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		Admin bb = new Admin();//관리자 생성(관리자 고용한거임)
		bb.setId("admin");//관리자 아이디
		bb.setPwd("admin");//관리자 비밀번호
		
		int menunum = -1;//continue쓸라면 초기화를 0으로 하면 안된다
		String adid = "";//받은 id값 저장할 변수
		String adpwd = "";//받은 비밀번호 값 저장할 변수
		int booknum = 0;//재고관리 중 원하는 메뉴 선택
		int gg = 0;
		
		Show show = new Show();//프리젠테이션 쓸거야!
		
		//처음 보여주는 프리젠테이션
		show.Open();
		dao.call();
		dao.callguest();

		do{
			
			show.Menu();//첫 메뉴 보여주기
		
			//다른 문자를 입력했을 때 오류처리
			try{
				menunum = sc.nextInt();//메뉴 선택하는 숫자를 저장할 변수
			}catch(InputMismatchException e){
				System.out.println("숫자만 입력해줄래?");
				sc.nextLine();//엔터값을 버려야 한당 계속 반복하지 않게 
				continue;
			}
			

		if(menunum == 1){//관리자 로그인
			System.out.print("관리자 ID:");
			adid = sc.next();//관리자 아이디 저장할 변수

			System.out.print("관리자 PWD:");
			adpwd = sc.next();//관리자 비밀번호 저장할 변수
				
				
			do{
				if(adid.equals(bb.getId()) && adpwd.equals(bb.getPwd())){//받은 id와 비밀번호가 내가 저장한 것과 같으면
					
					show.AdminMenu();//관리자메뉴 보여주기
					
					int adnum;
					//다른 문자를 입력했을 때 오류처리
					try{
						adnum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
					}catch(InputMismatchException e){
						System.out.println("숫자만 입력해줄래?");
						sc.nextLine();//엔터값을 버려야 한당
						continue;
					}
					
					
					if(adnum == 1){//재고관리
						do{
							show.BookMenu();

							try{
								booknum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
							}catch(InputMismatchException e){
								System.out.println("숫자만 입력해줄래?");
								sc.nextLine();//엔터값을 버려야 한당
								continue;
							}
							
							bb.remain(booknum);
							
							
						}while(booknum != 3);
					}
					else if(adnum == 2){//주문관리
						do{
							show.OrderMenu();
							
							try{
								booknum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
							}catch(InputMismatchException e){
								System.out.println("숫자만 입력해줄래?");
								sc.nextLine();//엔터값을 버려야 한당
								continue;
							}
							
							bb.order(booknum);
						}while(booknum != 4);
					}
					else if(adnum == 3){//결산
						do{
							show.PayMenu();
	
							try{
								booknum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
							}catch(InputMismatchException e){
								System.out.println("숫자만 입력해줄래?");
								sc.nextLine();//엔터값을 버려야 한당
								continue;
							}
							
							bb.account(booknum);
						}while(booknum != 3);
					}
					else{
						System.out.println("☆★관리자 로그아웃★☆");
						System.out.println();
						menunum = -1;
					}
				}
				else{
					System.out.println("당신 누구야! 관리자 아니잖아! 저리가라");
					System.out.println();
					break;
					
				}
			}while(menunum != -1);//처음 메뉴로 가기 위해 이 if문 나가기 위한 조건문
			
		}
		
		else if(menunum == 2){//구매자 로그인
			if(member.size() == 0){
				System.out.println("아직 회원이 아무도 음서영ㅠ0ㅠ");
			}
			
			else{
				System.out.print("구매자 ID:");
				String gid = sc.next();//구매자 아이디 저장할 변수
				System.out.print("구매자 PWD:");
				String gpwd = sc.next();//구매자 비밀번호 저장할 변수
				
				int gnum = 0;
				int bnum = 0;
				
				do{
					for(int i = 0; i < member.size(); i++){
						if(member.get(i).getId().equals(gid) && member.get(i).getPwd().equals(gpwd)){//arraylist에 아이디랑 비밀번호가 포함되어 잇으면
							
							show.CustomerMenu();
							
							gg = i;
							
							try{
								gnum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
							}catch(InputMismatchException e){
								System.out.println("숫자만 입력해줄래?");
								sc.nextLine();//엔터값을 버려야 한당
								continue;
							}
							
							guest g = new guest();//손님생성

								if(gnum == 1){//구매
									do{
										show.BuyMenu();
										
										try{
											bnum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
										}catch(InputMismatchException e){
											System.out.println("숫자만 입력해줄래?");
											sc.nextLine();//엔터값을 버려야 한당
											continue;
										}
										g.buy(bnum);
										
										if(bnum < 1 && bnum > 3){
											System.out.println("그런 메뉴 음슴");
											break;
										}
									}while(bnum != 3);
								}

								else if(gnum == 2){//장바구니
									do{
										show.CartMenu();
										
										try{
											bnum = sc.nextInt();//관리자의 메뉴 숫자를 저장할 변수
										}catch(InputMismatchException e){
											System.out.println("숫자만 입력해줄래?");
											sc.nextLine();//엔터값을 버려야 한당
											continue;
										}
										
										g.cart(bnum);
									}while(bnum != 4);
								}
								else if(gnum == 3){
									//처음메뉴
									System.out.println("손님 안녕히가세요\'ㅅ\'");
									System.out.println();
									gnum = -1;
									break;
								}
									
								else{
									System.out.println("그런 메뉴 없다고...");
									System.out.println();
									break;
								}
						}
					}
					if(!(member.get(gg).getId().equals(gid))){//아이디 없을때
						System.out.println("회원가입부터 해야 들어올수 있음\'ㅅ\'");
						break;
					}
					else if((member.get(gg).getId().equals(gid))&&!(member.get(gg).getPwd().equals(gpwd))){//비밀번호 틀렸을 때
						System.out.println("비밀번호를 확인해 주세영!");
						break;
					}	
				}while(gnum != -1);
			}
		}
		
		else if(menunum == 3){//회원가입 선택시
			System.out.println("[BBook]에 가입하실라고요?고고!");
			System.out.print("사용하실 ID: ");
			String newid = sc.next();
			System.out.print("사용하실 비밀번호: ");
			String newpwd = sc.next();
			
			guest g = new guest();//손님생성
			
			if(member.size() == 0){//원래 배열에 아무것도 없을 때
				//그냥 무조건 넣어
				g.setId(newid);//아이디 설정
				g.setPwd(newpwd);//비밀번호 설정
				
				member.add(g);
				
				System.out.println("가입해주셔서 감사합니다!");
				System.out.println();
			}
			
			else{//회원 가입한 사람이 이미 있을 때
				for(int i = 0; i < member.size(); i++){//아이디 중복확인
					if(member.get(i).getId().equals(newid)){//아이디가 이미 있으면
						System.out.println("이미 있는 아이디에요ㅜㅜ 다른 아이디!");
						gg = i;
					}
				}
				if(!(member.get(gg).getId().equals(newid))){//아이디가 중복되지 않거나 
					g.setId(newid);//아이디 설정
					g.setPwd(newpwd);//비밀번호 설정
					
					member.add(g);
					
					System.out.println("가입해주셔서 감사합니다!");
					System.out.println();
				}
			}

		}
		else if(menunum == 0){//프로그램 종료
			System.out.println("[BBook]이 끝날 시간이에요ㅜㅜ");
			System.out.println("다음에 또 들려주세요!");
			
			dao.save();
			dao.saveguest();

		}
		else{
			System.out.println("그런메뉴없는데ㅡㅡ 다시 잘쳐라");
			System.out.println();
		}

	
		}while(menunum != 0);//0을 누르면 프로그램 종료

	}
	
	
	public static ArrayList<guest> returnmember() {//다른 클래스에서 arraylist 사용할라구 리턴해줌
		// TODO Auto-generated method stub
		return member;
	}

}


