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
			
			// 스트림 연결 후 스레드 실행 (메세지 수신부)
			this.start();
			
			// 메세지 송신부 실행
			sender();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sender()
	{
		while(true)
		{
			System.out.println("서버에 전송할 메세지를 작성 하세요 : ");
			String msg = scan.nextLine();
			
			if(msg.equals("exit"))
				break;
			
			sendMsg(msg);
			System.out.println("서버에 메세지 전송 완료 응답 대기중 ...");
		}
	}
	
	

	// 메세지 보내기
	public void sendMsg(String str)
	{
		try
		{
			pw.write(str+"\n");
			pw.flush();
		}
		catch(Exception e){
			// 에러시 스트림 닫기
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
				
					
				System.out.println("서버로 부터 수신된 메세지 : "+receive);
			} 
			catch (Exception e) {
				// 에러시 스트림 닫기
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
