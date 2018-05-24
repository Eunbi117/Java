package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Server {
	
	private int port;
	
	private ServerSocket serverSocket;
	
	private HashMap<Integer, User> user_list;
	
	// 생성자 초기화
	public Server(int port)
	{
		this.port = port;
		this.user_list = new HashMap<Integer, User>();
	}
	
	public void start()
	{
		try 
		{
			// 서버 소켓 열기
			serverSocket = new ServerSocket(port);
		} 
		catch (IOException e2) {
			e2.printStackTrace();
		}
		
		
		while(true)
		{
			System.out.println("사용자 접속 대기중 ...");
			try 
			{
				Socket client = serverSocket.accept();
				
				System.out.println(client.getInetAddress()+"사용자 접속 ");

				// 사용자 생성
				User user = new User(client, user_list);
				
				// 접속자 스레드 실행
				user.start();
				
			} 
			catch (IOException e) {
				System.out.println("accept error");
				e.printStackTrace();
				
				// 에러 발생시 자원 닫기
				try
				{
					serverSocket.close();
				}
				catch(Exception e1){e1.printStackTrace();}
				
				break;
			}
		}// while end
	}// method end
	
	
	public static void main(String[] args) {
		
		int port = 1234;
		
		Server server = new Server(port);
		server.start();

	}
}	

 class User extends Thread{
		
	private Socket sock;
	private HashMap<Integer, User> user_list;
		

	private BufferedReader br;
	private PrintWriter pw;
	private int id;
		
	public User(Socket sock, HashMap user_list){
			
		this.sock = sock;
		this.user_list = user_list;
			
		// 스트림 설정
		stream_init();
			
		// 랜덤하게 아이디 생성
		Random r = new Random();
		id = r.nextInt(99999);
			
		// 리스트에 자신을 추가 ID 값은 hashmap 특성상 고유값이여야 한다.
		this.user_list.put(id, this);
	}
		// 스트림 설정
		private void stream_init()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			}
			catch(Exception e){
				System.out.println("스트림 연결 에러");
				e.printStackTrace();}
		}
		
		// 메세지 보내기
		public void sendMsg(String str)
		{
			try
			{
				pw.write(str+"\n");
				pw.flush();
			}
			catch(Exception e){}
		}
		
		public void removeClient(int id){
	        String message = "접속이 끊겼습니다. \n";
	        sendMsg(message);
	        user_list.remove(id);
	    }
		
		
		// 전체 사용자에게 보내기 
		public void broadCast(String str)
		{
			// hashmap에 모든 key를 받아온다.
			Set set = user_list.keySet();
			
			Iterator<Integer> iter = set.iterator();
			
			// 모든 사용자에게 발송하기
			while(iter.hasNext())
			{
				int user_key = iter.next();
				User user = user_list.get(user_key);
				user.sendMsg(str);
			}
		}
		
		
		@Override
		public void run() {
			
			while(true)
			{
				try 
				{
					//메시지 읽어오기
					String msg = br.readLine();
					if(msg == null)
					{
						close(); 
						break;
					}
					
					// 브로드 캐스트
					broadCast(msg);
				} 
				catch (Exception e) {
					System.out.println("접속 끊어짐");
					//e.printStackTrace();
					removeClient(id);
					break;
				}
			}
			
			System.out.println("while 종료");
			close();
		}
		
		
		// 스트림 닫기
		public void close()
		{
			System.out.println("close call");
			try
			{	
				this.br.close();
				this.pw.close();
			}
			catch(Exception e){}
		}

 }
	
