package choieunbi.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import choieunbi.domain.Book;
import choieunbi.service.Admin;
import choieunbi.service.guest; 


public class Show {
	
	Scanner sc = new Scanner(System.in);
	
	public void Open(){
		System.out.println("�¶��� ���� [BBook]�� ���� ���� ȯ���մϴ�!");
		System.out.println("���� �¶��� ���� [BBook]�� �մԿ��� ���� ������ ���� ����ϰڽ��ϴ�!");
		System.out.println("�� ���� ��~��!");
		System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
	}

	
	public void Menu(){
		System.out.println();
		System.out.println("==========ó���޴�==========");
		System.out.println("||   1. ������ �α���         ||");
		System.out.println("||   2. ������ �α���         ||");
		System.out.println("||   3. ȸ������              ||");
		System.out.println("||   0. ���α׷� ����         ||");
		System.out.print("================================>");
		
	}
	
	public void AdminMenu(){
		System.out.println();
		System.out.println("�����ڴ� �������! �� �Ͻǰǰ���?");
		System.out.println();
		System.out.println("=========�����ڸ޴�==========");
		System.out.println("||    1. ������             ||");
		System.out.println("||    2. �ֹ�����             ||");
		System.out.println("||    3. ���                 ||");
		System.out.println("||    4. ó���޴�             ||");
		System.out.print("================================>");
		
	}
	
	public void BookMenu(){
		System.out.println();
		System.out.println("==========���޴�==========");
		System.out.println("||     1. å���             ||");
		System.out.println("||     2. å���             ||");
		System.out.println("||     3. �����޴�           ||");
		System.out.print("================================>");
		
		}
	
	public void OrderMenu(){
		System.out.println();
		System.out.println("==========�ֹ��޴�==========");
		System.out.println("||    1. �ֹ���ȸ             ||");
		System.out.println("||    2. �Ǹ�Ȯ��             ||");
		System.out.println("||    3. �Ǹ����             ||");
		System.out.println("||    4. �����޴�             ||");
		System.out.print("================================>");
		
		}
	
	public void PayMenu(){
		System.out.println();
		System.out.println("==========���޴�==========");
		System.out.println("||    1. �ǸŰ���ȸ           ||");
		System.out.println("||    2. ������ȸ             ||");
		System.out.println("||    3. �����޴�             ||");
		System.out.print("================================>");
		
		}
	
	public void CustomerMenu(){
		System.out.println();
		System.out.println("�մ� �������! ���ϽǷ���?");
		System.out.println();
		System.out.println("==========�մԸ޴�==========");
		System.out.println("||     1. ����               ||");
		System.out.println("||     2. ��ٱ���           ||");
		System.out.println("||     3. ó���޴�           ||");
		System.out.print("================================>");
		}
	public void BuyMenu(){
		System.out.println();
		System.out.println("==========���Ÿ޴�==========");
		System.out.println("||     1. å��ȸ             ||");
		System.out.println("||     2. å����             ||");
		System.out.println("||     3. �����޴�           ||");
		System.out.print("================================>");
		}
	
	public void CartMenu(){
		System.out.println();
		System.out.println("=========��ٱ��ϸ޴�========");
		System.out.println("||   1. ��ٱ��� ��ȸ         ||");
		System.out.println("||   2. ��ٱ��� ����         ||");
		System.out.println("||   3. å ����               ||");
		System.out.println("||   4. �����޴�              ||");
		System.out.print("================================>");
		}

}
