package ch07;

class CD{
	String sub;//����
	String name;//�̸�
	int price;//����
	
	
	//������ �޼ҵ�
	public CD(String sub, String name, int price){
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
		return "����: " + sub + " ������: " + name + " ���԰���: " + price;
	}
	
	
}


public class CDDriver{
	public static void main(String[] args) {
		CD cd = new CD("���߱� ��ǰ��", "ȫ�浿", 25000);
		
		System.out.println(cd.getAll());
		
		cd.setSub("�ϳ�");
		
		System.out.println(cd.getAll());
	}
}