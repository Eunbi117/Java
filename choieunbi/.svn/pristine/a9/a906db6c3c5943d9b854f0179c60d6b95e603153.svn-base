package choieunbi.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import choieunbi.domain.Book;
import choieunbi.presentation.BookStore;

public class dao {
	
	static Scanner sc = new Scanner(System.in);
	
	static Admin a = new Admin();
	static ArrayList<Book> bookstand = a.returnbookstand();
	static BookStore bs = new BookStore();
	static ArrayList<guest> member = bs.returnmember();
	
	static public void call(){
		try {
			sc = new Scanner(new FileReader("Books.txt"));
			sc.useDelimiter("\n"); //끊어 읽기

			while(sc.hasNext()){
				int cardnum = sc.nextInt();
				String ok = sc.next();
				int price = sc.nextInt();
				String title = sc.next();
				
				Book b = new Book();//이미 저장되어있는 책들을 다시 책꽂이에 넣어야 함
				
				b.setCardnum(cardnum);
				b.setOk(ok);
				b.setPrice(price);
				b.setTitle(title);
				
				bookstand.add(b);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
	static public void save(){
		//텍스트 파일로 저장하기 위해서 씀
		try{
			FileWriter fw = new FileWriter("Books.txt");//책들을 저장하는 이름
			
			for(int i = 0; i < bookstand.size(); i++){
				fw.write(bookstand.get(i).getCardnum() +"\n");
				fw.write(bookstand.get(i).getOk()+"\n");
				fw.write(bookstand.get(i).getPrice()+"\n");
				fw.write(bookstand.get(i).getTitle()+"\n");
			}		
			fw.flush();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static public void callguest(){
		try {
			sc = new Scanner(new FileReader("Members.txt"));
			sc.useDelimiter("\n"); //끊어 읽기

			while(sc.hasNext()){
				String id = sc.next();
				String pwd = sc.next();
				
				guest g = new guest();
				
				g.setId(id);
				g.setPwd(pwd);
				
				member.add(g);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
	static public void saveguest(){
		try{
			FileWriter fw = new FileWriter("Members.txt");//회원가입한 회원을 저장할거야
			
			for(int i = 0; i < member.size(); i++){
				fw.write(member.get(i).getId()+"\n");
				fw.write(member.get(i).getPwd()+"\n");
			}
			fw.flush();
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
