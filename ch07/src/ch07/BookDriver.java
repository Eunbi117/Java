package ch07;

class Book{
	String sub;//도서명
	String name;//저자
	int price;//가격
	
	//생성자 메소드
	public Book(String sub, String name, int price){
		this.sub = sub;
		this.name = name;
		this.price = price;
	}
	
	//변경자 메소드
	public void setSub(String sub){
		this.sub = sub;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	//반환 메소드
	public String getSub(){
		return sub;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public String getAll(){
		return "도서명: " + sub + " 저자: " + name + " 가격: " + price;
	}
	
	 
}


public class BookDriver{
	public static void main(String[] args) {
		Book Book = new Book("신", "베르나르베르베르", 12000);
		
		System.out.println(Book.getAll());
		
		//변경자 메소드
		Book.setSub("개미");
		
		System.out.println(Book.getAll());
		
		//반환 메소드 사용하여 제목을 반환해서 가져옴
		System.out.println(Book.getSub());
	}
}