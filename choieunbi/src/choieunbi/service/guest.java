package choieunbi.service;

import java.util.ArrayList;
import java.util.Scanner;

import choieunbi.domain.Book;

public class guest {//�մ�
	private String id;//���̵�
	private String pwd;//��й�ȣ
	int num = 0;
	int codenum = 0;//���� �ڵ� ��ȣ
	int gg = 0;
	
	
	Scanner sc = new Scanner(System.in);
	
	static ArrayList<Book> cart = new ArrayList<Book>();//��ٱ��Ϸ� ����� ArrayList
	static ArrayList<Book> bookstand2;//admin���� ������ arraylist�� ����ϱ� ���� ����
	static ArrayList<Book> buy = new ArrayList<Book>();//������ ���� ArrayList
	
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
	
	//�ϴ���
	public void buy(int num){//����
		if(num == 1){//å��ȸ
			//å���̿� �ִ� ��� å ������
			Admin a = new Admin();//admin class�� ������ arraylist �����ͼ� ���� ��ü ����
			bookstand2 = a.returnbookstand();//���ϵ� bookstand�� �޾Ƽ� ����
			
			if(bookstand2.size() == 0)
				System.out.println("å�忡..å�̾���...�̤�");
			else{
				System.out.println("�� �Ǽ� :" + bookstand2.size());
				System.out.println();
				for(int i=0; i < bookstand2.size(); i++){
					System.out.print("å���� :" + bookstand2.get(i).getTitle() + "\n");
					System.out.print("å���� :" + bookstand2.get(i).getPrice()+ "\n");
					System.out.print("å�ڵ� :" + bookstand2.get(i).getCardnum()+ "\n");
					System.out.println();
				}
			}

		}
		else if(num == 2){//å����
			//�ڵ��ȣ�� �Է��ϸ� ��ٱ��Ͽ� ����	
			
			Admin a = new Admin();//admin class�� ������ arraylist �����ͼ� ���� ��ü ����
			Book b = new Book();//book ��ü�� �ִ� �ڵ��ȣ ���� ������
			
			bookstand2 = a.returnbookstand();//���ϵ� bookstand�� �޾Ƽ� ����

			if(bookstand2.size() == 0){
				System.out.println("���� å�� �����...�̾��ؿ�...");
			}
			else{
				System.out.print("������ �ڵ��ȣ : ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < bookstand2.size(); i++){
					if(bookstand2.get(i).getCardnum() == codenum){//å���̿� �ִ� ��� å�� �ڵ��
						gg = i;
						break;
					}
				}
				if(bookstand2.get(gg).getCardnum() == codenum){
					//�Է¹��� �ڵ��ȣ�� ������ �� ��ü�� cart ArrayList�� ����
					b.setCardnum(bookstand2.get(gg).getCardnum());//i���� �ִ� ��ü�� �־�
					b.setPrice(bookstand2.get(gg).getPrice());
					b.setTitle(bookstand2.get(gg).getTitle());
					b.setOk(bookstand2.get(gg).getOk());
					
					cart.add(b);//��ٱ��Ͽ� book ��ü �ֱ�
					System.out.println("\'"+bookstand2.get(gg).getTitle() + "\' å ��ٱ��Ͽ� �־���~");
				}
				else{
					System.out.println("�׷� �ڵ��� å�� ���µ�.. �ٽ��غ�");
				}
					
			}
		}
		else{
			System.out.println("���� �޴��� ������~");
			System.out.println();
		}
			
	}
	
	public void cart(int num){//��ٱ���
		if(num == 1){//��ٱ��� ��ȸ
			//��ٱ��Ͽ� ��� å ���� ������
			if(cart.size() == 0){
				System.out.println("���� ��ٱ��Ͽ� �ƹ��͵� ���� �̤�");
			}
			else{
				System.out.println("�� �Ǽ� :" + cart.size());
				System.out.println();
				for(int i = 0; i < cart.size(); i++){
					System.out.print("å���� :" + cart.get(i).getTitle() + "\n");
					System.out.print("å���� :" + cart.get(i).getPrice()+ "\n");
					System.out.print("å�ڵ� :" + cart.get(i).getCardnum()+ "\n");
					System.out.println();
				}
			}

		}
		else if(num == 2){//��ٱ��� ����
			//��ٱ��Ͽ� �ִ� å ����
			if(cart.size() == 0){
				System.out.println("���� ��ٱ��Ͽ� �ƹ��͵� ���� �̤�");
			}
			else{
				System.out.print("������ �ڵ��ȣ : ");
				codenum = sc.nextInt();

				for(int i = 0; i < cart.size(); i++){
					if(cart.get(i).getCardnum() == codenum){//īƮ�� �ִ� ��� å�� �ڵ��
						gg = i;
						break;
					}
				}
				if(cart.get(gg).getCardnum() == codenum){
					System.out.println("\'"+cart.get(gg).getTitle() + "\' å ��ٱ��Ͽ��� ����");
					cart.remove(gg);//��ٱ��Ͽ� book ��ü �����ϱ�

					System.out.println();
					System.out.println("��ٱ��Ͽ� ���� å �����ٰ�~");
					
					if(cart.size() == 0){
						System.out.println("���� ��ٱ��Ͽ� å ����!");
					}
					else{
						System.out.println("�� �Ǽ� :" + cart.size());
						System.out.println();
						for(int j=0; j < cart.size(); j++){
							System.out.print("å���� :" + cart.get(j).getTitle() + "\n");
							System.out.print("å���� :" + cart.get(j).getPrice()+ "\n");
							System.out.print("å�ڵ� :" + cart.get(j).getCardnum()+ "\n");
							System.out.println();
						}
					}
				}
				else
					System.out.println("�׷� �ڵ� �������!");
			}
			
			
		}
		else if(num == 3){//����
			//�����ϸ� �ֹ� �Ϸ�
			
			
			if(cart.size() == 0){
				System.out.println("��ٱ��Ͽ� �ƹ��͵� �����ϱ� �켱 ��ٱ��Ͽ� �־�!");
			}
			else{
				System.out.print("������ �ڵ��ȣ: ");
				codenum = sc.nextInt();
				
				for(int i = 0; i < cart.size(); i++){
					if(cart.get(i).getCardnum() == codenum & cart.get(i).getOk().equals("�Ǹ�")){//īƮ�� �ִ� ��� å�� �ڵ��
						gg = i;
						break;
					}
				}
				if(cart.get(gg).getCardnum() == codenum ){
					buy.add(cart.get(gg));//���� book ��ü�� buy arraylist�� ����
					cart.remove(gg);//��ٱ��Ͽ� �ִ� å�� �����ؾ�¡
					System.out.println("\'"+buy.get(gg).getTitle()+"\' ������ �Ϸ�Ǿ����ϴ�! �����մϴ�!");
				}
				else
					System.out.println("�׷� �ڵ��ȣ �����...");
			}
		}
	}
	
	public static ArrayList<Book> returnbuy() {//�ٸ� Ŭ�������� arraylist ����Ҷ� ��������
		// TODO Auto-generated method stub
		return buy;
	}

}