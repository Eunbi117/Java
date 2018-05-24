package choieunbi.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import choieunbi.domain.Book;
import choieunbi.service.Admin;
import choieunbi.service.dao;
import choieunbi.service.guest;

public class BookStore {
	static Admin a = new Admin();
	static ArrayList<guest> member = new ArrayList<guest>();//ȸ���� ���� arraylist
	static ArrayList<Book> bookstand = a.returnbookstand();//�ؽ�Ʈ ���Ϸ� �����ϱ� ���� �����°�

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		Admin bb = new Admin();//������ ����(������ ����Ѱ���)
		bb.setId("admin");//������ ���̵�
		bb.setPwd("admin");//������ ��й�ȣ
		
		int menunum = -1;//continue����� �ʱ�ȭ�� 0���� �ϸ� �ȵȴ�
		String adid = "";//���� id�� ������ ����
		String adpwd = "";//���� ��й�ȣ �� ������ ����
		int booknum = 0;//������ �� ���ϴ� �޴� ����
		int gg = 0;
		
		Show show = new Show();//���������̼� ���ž�!
		
		//ó�� �����ִ� ���������̼�
		show.Open();
		dao.call();
		dao.callguest();

		do{
			
			show.Menu();//ù �޴� �����ֱ�
		
			//�ٸ� ���ڸ� �Է����� �� ����ó��
			try{
				menunum = sc.nextInt();//�޴� �����ϴ� ���ڸ� ������ ����
			}catch(InputMismatchException e){
				System.out.println("���ڸ� �Է����ٷ�?");
				sc.nextLine();//���Ͱ��� ������ �Ѵ� ��� �ݺ����� �ʰ� 
				continue;
			}
			

		if(menunum == 1){//������ �α���
			System.out.print("������ ID:");
			adid = sc.next();//������ ���̵� ������ ����

			System.out.print("������ PWD:");
			adpwd = sc.next();//������ ��й�ȣ ������ ����
				
				
			do{
				if(adid.equals(bb.getId()) && adpwd.equals(bb.getPwd())){//���� id�� ��й�ȣ�� ���� ������ �Ͱ� ������
					
					show.AdminMenu();//�����ڸ޴� �����ֱ�
					
					int adnum;
					//�ٸ� ���ڸ� �Է����� �� ����ó��
					try{
						adnum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
					}catch(InputMismatchException e){
						System.out.println("���ڸ� �Է����ٷ�?");
						sc.nextLine();//���Ͱ��� ������ �Ѵ�
						continue;
					}
					
					
					if(adnum == 1){//������
						do{
							show.BookMenu();

							try{
								booknum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
							}catch(InputMismatchException e){
								System.out.println("���ڸ� �Է����ٷ�?");
								sc.nextLine();//���Ͱ��� ������ �Ѵ�
								continue;
							}
							
							bb.remain(booknum);
							
							
						}while(booknum != 3);
					}
					else if(adnum == 2){//�ֹ�����
						do{
							show.OrderMenu();
							
							try{
								booknum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
							}catch(InputMismatchException e){
								System.out.println("���ڸ� �Է����ٷ�?");
								sc.nextLine();//���Ͱ��� ������ �Ѵ�
								continue;
							}
							
							bb.order(booknum);
						}while(booknum != 4);
					}
					else if(adnum == 3){//���
						do{
							show.PayMenu();
	
							try{
								booknum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
							}catch(InputMismatchException e){
								System.out.println("���ڸ� �Է����ٷ�?");
								sc.nextLine();//���Ͱ��� ������ �Ѵ�
								continue;
							}
							
							bb.account(booknum);
						}while(booknum != 3);
					}
					else{
						System.out.println("�١ڰ����� �α׾ƿ��ڡ�");
						System.out.println();
						menunum = -1;
					}
				}
				else{
					System.out.println("��� ������! ������ �ƴ��ݾ�! ��������");
					System.out.println();
					break;
					
				}
			}while(menunum != -1);//ó�� �޴��� ���� ���� �� if�� ������ ���� ���ǹ�
			
		}
		
		else if(menunum == 2){//������ �α���
			if(member.size() == 0){
				System.out.println("���� ȸ���� �ƹ��� ��������0��");
			}
			
			else{
				System.out.print("������ ID:");
				String gid = sc.next();//������ ���̵� ������ ����
				System.out.print("������ PWD:");
				String gpwd = sc.next();//������ ��й�ȣ ������ ����
				
				int gnum = 0;
				int bnum = 0;
				
				do{
					for(int i = 0; i < member.size(); i++){
						if(member.get(i).getId().equals(gid) && member.get(i).getPwd().equals(gpwd)){//arraylist�� ���̵�� ��й�ȣ�� ���ԵǾ� ������
							
							show.CustomerMenu();
							
							gg = i;
							
							try{
								gnum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
							}catch(InputMismatchException e){
								System.out.println("���ڸ� �Է����ٷ�?");
								sc.nextLine();//���Ͱ��� ������ �Ѵ�
								continue;
							}
							
							guest g = new guest();//�մԻ���

								if(gnum == 1){//����
									do{
										show.BuyMenu();
										
										try{
											bnum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
										}catch(InputMismatchException e){
											System.out.println("���ڸ� �Է����ٷ�?");
											sc.nextLine();//���Ͱ��� ������ �Ѵ�
											continue;
										}
										g.buy(bnum);
										
										if(bnum < 1 && bnum > 3){
											System.out.println("�׷� �޴� ����");
											break;
										}
									}while(bnum != 3);
								}

								else if(gnum == 2){//��ٱ���
									do{
										show.CartMenu();
										
										try{
											bnum = sc.nextInt();//�������� �޴� ���ڸ� ������ ����
										}catch(InputMismatchException e){
											System.out.println("���ڸ� �Է����ٷ�?");
											sc.nextLine();//���Ͱ��� ������ �Ѵ�
											continue;
										}
										
										g.cart(bnum);
									}while(bnum != 4);
								}
								else if(gnum == 3){
									//ó���޴�
									System.out.println("�մ� �ȳ���������\'��\'");
									System.out.println();
									gnum = -1;
									break;
								}
									
								else{
									System.out.println("�׷� �޴� ���ٰ�...");
									System.out.println();
									break;
								}
						}
					}
					if(!(member.get(gg).getId().equals(gid))){//���̵� ������
						System.out.println("ȸ�����Ժ��� �ؾ� ���ü� ����\'��\'");
						break;
					}
					else if((member.get(gg).getId().equals(gid))&&!(member.get(gg).getPwd().equals(gpwd))){//��й�ȣ Ʋ���� ��
						System.out.println("��й�ȣ�� Ȯ���� �ּ���!");
						break;
					}	
				}while(gnum != -1);
			}
		}
		
		else if(menunum == 3){//ȸ������ ���ý�
			System.out.println("[BBook]�� �����ϽǶ���?���!");
			System.out.print("����Ͻ� ID: ");
			String newid = sc.next();
			System.out.print("����Ͻ� ��й�ȣ: ");
			String newpwd = sc.next();
			
			guest g = new guest();//�մԻ���
			
			if(member.size() == 0){//���� �迭�� �ƹ��͵� ���� ��
				//�׳� ������ �־�
				g.setId(newid);//���̵� ����
				g.setPwd(newpwd);//��й�ȣ ����
				
				member.add(g);
				
				System.out.println("�������ּż� �����մϴ�!");
				System.out.println();
			}
			
			else{//ȸ�� ������ ����� �̹� ���� ��
				for(int i = 0; i < member.size(); i++){//���̵� �ߺ�Ȯ��
					if(member.get(i).getId().equals(newid)){//���̵� �̹� ������
						System.out.println("�̹� �ִ� ���̵𿡿�̤� �ٸ� ���̵�!");
						gg = i;
					}
				}
				if(!(member.get(gg).getId().equals(newid))){//���̵� �ߺ����� �ʰų� 
					g.setId(newid);//���̵� ����
					g.setPwd(newpwd);//��й�ȣ ����
					
					member.add(g);
					
					System.out.println("�������ּż� �����մϴ�!");
					System.out.println();
				}
			}

		}
		else if(menunum == 0){//���α׷� ����
			System.out.println("[BBook]�� ���� �ð��̿���̤�");
			System.out.println("������ �� ����ּ���!");
			
			dao.save();
			dao.saveguest();

		}
		else{
			System.out.println("�׷��޴����µ��Ѥ� �ٽ� ���Ķ�");
			System.out.println();
		}

	
		}while(menunum != 0);//0�� ������ ���α׷� ����

	}
	
	
	public static ArrayList<guest> returnmember() {//�ٸ� Ŭ�������� arraylist ����Ҷ� ��������
		// TODO Auto-generated method stub
		return member;
	}

}


