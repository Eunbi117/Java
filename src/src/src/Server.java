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
	
	// ������ �ʱ�ȭ
	public Server(int port)
	{
		this.port = port;
		this.user_list = new HashMap<Integer, User>();
	}
	
	public void start()
	{
		try 
		{
			// ���� ���� ����
			serverSocket = new ServerSocket(port);
		} 
		catch (IOException e2) {
			e2.printStackTrace();
		}
		
		
		while(true)
		{
			System.out.println("����� ���� ����� ...");
			try 
			{
				Socket client = serverSocket.accept();
				
				System.out.println(client.getInetAddress()+"����� ���� ");

				// ����� ����
				User user = new User(client, user_list);
				
				// ������ ������ ����
				user.start();
				
			} 
			catch (IOException e) {
				System.out.println("accept error");
				e.printStackTrace();
				
				// ���� �߻��� �ڿ� �ݱ�
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
			
		// ��Ʈ�� ����
		stream_init();
			
		// �����ϰ� ���̵� ����
		Random r = new Random();
		id = r.nextInt(99999);
			
		// ����Ʈ�� �ڽ��� �߰� ID ���� hashmap Ư���� �������̿��� �Ѵ�.
		this.user_list.put(id, this);
	}
		// ��Ʈ�� ����
		private void stream_init()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			}
			catch(Exception e){
				System.out.println("��Ʈ�� ���� ����");
				e.printStackTrace();}
		}
		
		// �޼��� ������
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
	        String message = "������ ������ϴ�. \n";
	        sendMsg(message);
	        user_list.remove(id);
	    }
		
		
		// ��ü ����ڿ��� ������ 
		public void broadCast(String str)
		{
			// hashmap�� ��� key�� �޾ƿ´�.
			Set set = user_list.keySet();
			
			Iterator<Integer> iter = set.iterator();
			
			// ��� ����ڿ��� �߼��ϱ�
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
					//�޽��� �о����
					String msg = br.readLine();
					if(msg == null)
					{
						close(); 
						break;
					}
					
					// ��ε� ĳ��Ʈ
					broadCast(msg);
				} 
				catch (Exception e) {
					System.out.println("���� ������");
					//e.printStackTrace();
					removeClient(id);
					break;
				}
			}
			
			System.out.println("while ����");
			close();
		}
		
		
		// ��Ʈ�� �ݱ�
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
	
