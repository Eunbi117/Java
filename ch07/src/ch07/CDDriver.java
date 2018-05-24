package ch07;

class CD{
	String sub;//제목
	String name;//이름
	int price;//가격
	
	
	//생성자 메소드
	public CD(String sub, String name, int price){
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
		return "제목: " + sub + " 연주자: " + name + " 구입가격: " + price;
	}
	
	
}


public class CDDriver{
	public static void main(String[] args) {
		CD cd = new CD("가야금 작품집", "홍길동", 25000);
		
		System.out.println(cd.getAll());
		
		cd.setSub("하농");
		
		System.out.println(cd.getAll());
	}
}