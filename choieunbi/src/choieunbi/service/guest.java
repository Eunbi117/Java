package choieunbi.service;

import java.util.ArrayList;
import java.util.Scanner;

import choieunbi.domain.Book;

public class guest {//손님
	private String id;//아이디
	private String pwd;//비밀번호
	int num = 0;
	int codenum = 0;//받을 코드 번호
	int gg = 0;
	
	
	Scanner sc = new Scanner(System.in);
	
	static ArrayList<Book> cart = new ArrayList<Book>();//장바구니로 사용할 ArrayList
	static ArrayList<Book> bookstand2;//admin에서 생성한 arraylist를 사용하기 위해 생성
	static ArrayList<Book> buy = new ArrayList<Book>();//결제를 위한 ArrayList
	
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
	public void buy(int num){//구매
		if(num == 1){//책조회
			//책꽂이에 있는 모든 책 보여줌
			Admin a = new Admin();//admin class에 생성한 arraylist 가져와서 쓸라구 객체 생성
			bookstand2 = a.returnbookstand();//리턴된 bookstand를 받아서 저장
			
			if(bookstand2.size() == 0)
				System.out.println("책장에..책이없어...ㅜㅜ");
			else{
				System.out.println("총 권수 :" + bookstand2.size());
				System.out.println();
				for(int i=0; i < bookstand2.size(); i++){
					System.out.print("책제목 :" + bookstand2.get(i).getTitle() + "\n");
					System.out.print("책가격 :" + bookstand2.get(i).getPrice()+ "\n");
					System.out.print("책코드 :" + bookstand2.get(i).getCardnum()+ "\n");
					System.out.println();
				}
			}

		}
		else if(num == 2){//책구매
			//코드번호를 입력하면 장바구니에 담긴다	
			
			Admin a = new Admin();//admin class에 생성한 arraylist 가져와서 쓸라구 객체 생성
			Book b = new Book();//book 객체에 있는 코드번호 쓸라구 가져왕
			
			bookstand2 = a.returnbookstand();//리턴된 bookstand를 받아서 저장

			if(bookstand2.size() == 0){
				System.out.println("아직 책이 없어용...미안해용...");
			}
			else{
				System.out.print("구매할 코드번호 : ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < bookstand2.size(); i++){
					if(bookstand2.get(i).getCardnum() == codenum){//책꽂이에 있는 모든 책에 코드랑
						gg = i;
						break;
					}
				}
				if(bookstand2.get(gg).getCardnum() == codenum){
					//입력받은 코드번호가 같으면 그 객체를 cart ArrayList에 저장
					b.setCardnum(bookstand2.get(gg).getCardnum());//i번에 있는 객체를 넣어
					b.setPrice(bookstand2.get(gg).getPrice());
					b.setTitle(bookstand2.get(gg).getTitle());
					b.setOk(bookstand2.get(gg).getOk());
					
					cart.add(b);//장바구니에 book 객체 넣기
					System.out.println("\'"+bookstand2.get(gg).getTitle() + "\' 책 장바구니에 넣었어~");
				}
				else{
					System.out.println("그런 코드의 책이 없는뎅.. 다시해봐");
				}
					
			}
		}
		else{
			System.out.println("이전 메뉴로 고고씽~");
			System.out.println();
		}
			
	}
	
	public void cart(int num){//장바구니
		if(num == 1){//장바구니 조회
			//장바구니에 담긴 책 정보 보여줌
			if(cart.size() == 0){
				System.out.println("아직 장바구니에 아무것도 없엉 ㅜㅠ");
			}
			else{
				System.out.println("총 권수 :" + cart.size());
				System.out.println();
				for(int i = 0; i < cart.size(); i++){
					System.out.print("책제목 :" + cart.get(i).getTitle() + "\n");
					System.out.print("책가격 :" + cart.get(i).getPrice()+ "\n");
					System.out.print("책코드 :" + cart.get(i).getCardnum()+ "\n");
					System.out.println();
				}
			}

		}
		else if(num == 2){//장바구니 삭제
			//장바구니에 있는 책 삭제
			if(cart.size() == 0){
				System.out.println("아직 장바구니에 아무것도 없엉 ㅜㅠ");
			}
			else{
				System.out.print("삭제할 코드번호 : ");
				codenum = sc.nextInt();

				for(int i = 0; i < cart.size(); i++){
					if(cart.get(i).getCardnum() == codenum){//카트에 있는 모든 책에 코드랑
						gg = i;
						break;
					}
				}
				if(cart.get(gg).getCardnum() == codenum){
					System.out.println("\'"+cart.get(gg).getTitle() + "\' 책 장바구니에서 뺐어");
					cart.remove(gg);//장바구니에 book 객체 삭제하기

					System.out.println();
					System.out.println("장바구니에 남은 책 보여줄게~");
					
					if(cart.size() == 0){
						System.out.println("이제 장바구니에 책 없어!");
					}
					else{
						System.out.println("총 권수 :" + cart.size());
						System.out.println();
						for(int j=0; j < cart.size(); j++){
							System.out.print("책제목 :" + cart.get(j).getTitle() + "\n");
							System.out.print("책가격 :" + cart.get(j).getPrice()+ "\n");
							System.out.print("책코드 :" + cart.get(j).getCardnum()+ "\n");
							System.out.println();
						}
					}
				}
				else
					System.out.println("그런 코드 없어없어!");
			}
			
			
		}
		else if(num == 3){//결제
			//결제하면 주문 완료
			
			
			if(cart.size() == 0){
				System.out.println("장바구니에 아무것도 없으니까 우선 장바구니에 넣어!");
			}
			else{
				System.out.print("결제할 코드번호: ");
				codenum = sc.nextInt();
				
				for(int i = 0; i < cart.size(); i++){
					if(cart.get(i).getCardnum() == codenum & cart.get(i).getOk().equals("판매")){//카트에 있는 모든 책에 코드랑
						gg = i;
						break;
					}
				}
				if(cart.get(gg).getCardnum() == codenum ){
					buy.add(cart.get(gg));//같은 book 객체를 buy arraylist에 저장
					cart.remove(gg);//장바구니에 있는 책은 삭제해야징
					System.out.println("\'"+buy.get(gg).getTitle()+"\' 결제가 완료되었습니다! 감사합니다!");
				}
				else
					System.out.println("그런 코드번호 없어요...");
			}
		}
	}
	
	public static ArrayList<Book> returnbuy() {//다른 클래스에서 arraylist 사용할라구 리턴해줌
		// TODO Auto-generated method stub
		return buy;
	}

}
