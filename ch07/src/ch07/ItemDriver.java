package ch07;

class Item{
	String sub;//상품이름
	int price;//가격
	int num;//개수
	
	//생성자 메소드
	public Item(String sub, int price, int num){
		this.sub = sub;
		this.price = price;
		this.num = num;
	}
	
	//변경자 메소드
	public void setSub(String sub){
		this.sub = sub;
	}
	
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	//반환 메소드
	public String getSub(){
		return sub;
	}
	
	
	public int getPrice(){
		return price;
	}
	
	public int getNum(){
		return num;
	}
	
	public String getAll(){
		return "상품명: " + sub + " 가격: " + price + " 개수: " + num;
	}
	
	 
}


public class ItemDriver{
	public static void main(String[] args) {
		Item Item = new Item("컴퓨터", 890000, 5);
		
		System.out.println(Item.getAll());
		
	}
}