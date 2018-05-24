package _Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{

	private String ip;
	private int port;
	private Socket socket;
	private Scanner scan;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public Client(String ip , int port)
	{
		this.ip = ip;
		this.port = port;
		
		this.scan = new Scanner(System.in);
	}
	
	public void init()
	{
		try
		{
			socket = new Socket(this.ip, this.port);
			
			try
			{
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			}
			catch(Exception e){e.printStackTrace();}
			
			// ��Ʈ�� ���� �� ������ ���� (�޼��� ���ź�)
			this.start();
			
			// �޼��� �۽ź� ����
			sender();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sender()
	{
		while(true)
		{
			System.out.println("������ ������ �޼����� �ۼ� �ϼ��� : ");
			String msg = scan.nextLine();
			
			if(msg.equals("exit"))
				break;
			
			sendMsg(msg);
			System.out.println("������ �޼��� ���� �Ϸ� ���� ����� ...");
		}
	}
	
	

	// �޼��� ������
	public void sendMsg(String str)
	{
		try
		{
			pw.write(str+"\n");
			pw.flush();
		}
		catch(Exception e){
			// ������ ��Ʈ�� �ݱ�
			close();
		}
	}
	
	
	@Override
	public void run() {
		
		while(true)
		{
			try 
			{
				String receive = br.readLine();
				
					
				System.out.println("������ ���� ���ŵ� �޼��� : "+receive);
			} 
			catch (Exception e) {
				// ������ ��Ʈ�� �ݱ�
				close();
				e.printStackTrace();
				break;
			}
		}
	}
	
	public void close()
	{
		try
		{
			socket.close();
			br.close();
			pw.close();
		}catch(Exception e){}
	}
	
	
	public static void main(String[] args) {
		
		int port = 1234;
		String ip = "127.0.0.1";
		
		Client client = new Client(ip, port);
		client.init();

	}

}
