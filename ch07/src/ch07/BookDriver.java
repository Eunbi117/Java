package ch07;

class Book{
	String sub;//������
	String name;//����
	int price;//����
	
	//������ �޼ҵ�
	public Book(String sub, String name, int price){
		this.sub = sub;
		this.name = name;
		this.price = price;
	}
	
	//������ �޼ҵ�
	public void setSub(String sub){
		this.sub = sub;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	//��ȯ �޼ҵ�
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
		return "������: " + sub + " ����: " + name + " ����: " + price;
	}
	
	 
}


public class BookDriver{
	public static void main(String[] args) {
		Book Book = new Book("��", "����������������", 12000);
		
		System.out.println(Book.getAll());
		
		//������ �޼ҵ�
		Book.setSub("����");
		
		System.out.println(Book.getAll());
		
		//��ȯ �޼ҵ� ����Ͽ� ������ ��ȯ�ؼ� ������
		System.out.println(Book.getSub());
	}
}