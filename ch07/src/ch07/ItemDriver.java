package ch07;

class Item{
	String sub;//��ǰ�̸�
	int price;//����
	int num;//����
	
	//������ �޼ҵ�
	public Item(String sub, int price, int num){
		this.sub = sub;
		this.price = price;
		this.num = num;
	}
	
	//������ �޼ҵ�
	public void setSub(String sub){
		this.sub = sub;
	}
	
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	//��ȯ �޼ҵ�
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
		return "��ǰ��: " + sub + " ����: " + price + " ����: " + num;
	}
	
	 
}


public class ItemDriver{
	public static void main(String[] args) {
		Item Item = new Item("��ǻ��", 890000, 5);
		
		System.out.println(Item.getAll());
		
	}
}