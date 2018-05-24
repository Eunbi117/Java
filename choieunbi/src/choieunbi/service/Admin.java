package choieunbi.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import choieunbi.domain.Book;

public class Admin {//���� ������
	private String id;//���̵�
	private String pwd;//��й�ȣ
	int num = 0;//�޴��� �������� ����
	int gg = 0;//i�� �������� ���� --> ����ó���� ���� ��¿������ ����....��
	
	
	static ArrayList<Book> bookstand = new ArrayList<Book>();//å����
	static ArrayList<Book> buy2;//guest���� ����� buy ����Ʈ ����ϱ� ����
	
	Scanner sc = new Scanner(System.in);
	
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
	public void remain(int num){//������
		
		if(num == 1){//å���
			//å�� ����� ���� �Է� �ڵ�� �������(4�ڸ�)
				
			System.out.print("å����: ");
			String btitle = sc.next();
			System.out.print("å����: ");
			int bprice = sc.nextInt();
			
			int cardnum = (int)((Math.random()*8999)+1000);
			
			//�ڵ��ȣ �ߺ�ó��
			for(int i = 0; i < bookstand.size(); i++){//�̹� ������ ���߿� ���� cardnum�� ������
				if(cardnum == bookstand.get(i).getCardnum()){
					cardnum = (int)((Math.random()*8999)+1000);//�ٽ� ���������
					i = i-1;//�ٽ� ó������ ���� ���ڰ� �ִ��� ��
					break;
				}
			}
			
			Book b = new Book();
			
			b.setTitle(btitle);
			b.setPrice(bprice);
			b.setCardnum(cardnum);
			b.setOk("����");
			
			bookstand.add(b);
			
			System.out.println("\'" +btitle+"\' å ����� �Ϸ�Ǿ����ϴ�!");

		}
		else if(num == 2){//å��� ��ȸ
			//��� å�� �ڵ��ȣ, ����, ����, �Ǹ�Ȯ�� ���� ������
			
			if(bookstand.size() == 0){
				System.out.println("å���̿� �ƹ��͵� ���� ������ �볪���̤�");
			}
			else{
				System.out.println("�� �Ǽ�: " + bookstand.size());
				System.out.println();
				for(int i = 0; i < bookstand.size(); i++){
					System.out.print("å���� :" + bookstand.get(i).getTitle() + "\n");
					System.out.print("å���� :" + bookstand.get(i).getPrice()+ "\n");
					System.out.print("å�ڵ� :" + bookstand.get(i).getCardnum()+ "\n");
					System.out.print("�Ǹ�Ȯ�� ���� :" + bookstand.get(i).getOk() + "\n");
					System.out.println();
				}
			}

		}
		else{
			System.out.println("���� �޴��� ����~");
			System.out.println();
		}
			
	}
	
	public void order(int num){//�ֹ�����
		if(num == 1){//�ֹ���ȸ
			//�����ڰ� �����Ѱ� ������ --> guest�� buy arraylist ���
			
			//guest�� ���� buy arraylist�� ����ϱ� ����
			guest g = new guest();//��ü ����
			buy2 = g.returnbuy();//���Ϲ��� arraylist�� buy2�� �ֱ�
			
			if(buy2.size() == 0){
				System.out.println("�ֹ��Ѱ� ���");
			}
			else{
				System.out.println("�� �Ǽ� :" + buy2.size());
				System.out.println();
				for(int i = 0; i < buy2.size(); i++){
					System.out.print("å���� :" + buy2.get(i).getTitle() + "\n");
					System.out.print("å���� :" + buy2.get(i).getPrice()+ "\n");
					System.out.print("å�ڵ� :" + buy2.get(i).getCardnum()+ "\n");
					System.out.print("�Ǹ�Ȯ�� ���� :" + buy2.get(i).getOk() + "\n");
					System.out.println();
				}
			}
			
		}
		else if(num == 2){//�Ǹ�Ȯ��
			//�Ǹ�Ȯ�� ó�� --> �Ǹ�Ȯ�� ���� �߰�
			
			//guest�� ���� buy arraylist�� ����ϱ� ����
			guest g = new guest();//��ü ����
			buy2 = g.returnbuy();//���Ϲ��� arraylist�� buy2�� �ֱ�
			
			if(buy2.size() == 0){
				System.out.println("�ֹ��Ѱ� ���");
			}
			else{
				System.out.print("�Ǹ� Ȯ����ų å �ڵ带 �Է���: ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getCardnum() == codenum){
						gg = i;
						break;
					}
				}
				if(buy2.get(gg).getCardnum() == codenum){
					buy2.get(gg).setOk("�Ǹ�");//���¸� �������� �Ǹŷ� �ٲ۴�
					
					System.out.println("���������� \'" + buy2.get(gg).getTitle() + "\'å�� �Ǹ�ó�� �Ǿ����ϴ�.");
				}
				else
					System.out.println("�׷� �ڵ��ȣ �����!");
					
			}
			
		}
		else if(num == 3){//�Ǹ����
			//�Ǹ�Ȯ�� ó�� �� ���� ���
			
			
			//guest�� ���� buy arraylist�� ����ϱ� ����
			guest g = new guest();//��ü ����
			buy2 = g.returnbuy();//���Ϲ��� arraylist�� buy2�� �ֱ�
			
			if(buy2.size() == 0){
				System.out.println("�ֹ��Ѱ� ���");
			}
			else{
				System.out.print("�Ǹ� ��ҽ�ų å �ڵ带 �Է���: ");
				int codenum = sc.nextInt();
				
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getCardnum() == codenum){
						gg = i;
						break;
					}
				}
				if(buy2.get(gg).getCardnum() == codenum){
					buy2.get(gg).setOk("����");
					
					System.out.println("���������� \'" + buy2.get(gg).getTitle() + "\'å�� �Ǹ� ���ó�� �Ǿ����ϴ�.");
				}
				else{
					System.out.println("�׷� �ڵ��ȣ �����!");
				}
					
			}
		}
		else{
			System.out.println("���� �޴��� ����~");
			System.out.println();
		}
	}
	
	public void account(int num){//������
		if(num == 1){//�ǸŰ���ȸ
			//�Ǹ�Ȯ�� ó���� �͵��� �ڵ��ȣ ���� ���� ���� ������
			
			if(buy2.size() == 0){
				System.out.println("���� �ǸŰǼ���...�����̤�");
			}
			else{
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getOk().equals("�Ǹ�")){
						gg = i;
						break;
					}
				}if(buy2.get(gg).getOk().equals("�Ǹ�")){
					System.out.println("�� �Ǽ� :" + buy2.size());
					System.out.println();
					
					System.out.print("å���� :" + buy2.get(gg).getTitle() + "\n");
					System.out.print("å���� :" + buy2.get(gg).getPrice()+ "\n");
					System.out.print("å�ڵ� :" + buy2.get(gg).getCardnum()+ "\n");
					System.out.print("�Ǹ�Ȯ�� ���� :" + buy2.get(gg).getOk() + "\n");
					System.out.println();
				}
				else
					System.out.println("�Ǹŷ� ������ å�� �����!");
				
			}
			
			
		}
		else if(num == 2){//������ȸ
			//�Ǹ� Ȯ���� ��� å�� ������ ���ؼ� �Ѹ���� ǥ��
			int sum = 0;//�Ѹ����
			
			if(buy2.size() == 0){
				System.out.println("�ǸŰǼ��� ��� ����� ���� ������");
			}
			else{
				for(int i = 0; i < buy2.size(); i++){
					if(buy2.get(i).getOk().equals("�Ǹ�")){
						sum += buy2.get(i).getPrice();
					}
				}
				System.out.println("�� ������� " + sum + "�� �Դϴ�.");
				System.out.println("���ڵǰھ�^^");
			}

		}
		else{
			System.out.println("���� �޴��� ����~");
			System.out.println();
		}
	}
	public static ArrayList<Book> returnbookstand() {//�ٸ� Ŭ�������� arraylist ����Ҷ� ��������
		// TODO Auto-generated method stub
		return bookstand;
	}
	
	public static ArrayList<Book> returnbuy2() {//�ٸ� Ŭ�������� arraylist ����Ҷ� ��������
		// TODO Auto-generated method stub
		return buy2;
	}
}
