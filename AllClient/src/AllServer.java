import java.util.*;
import java.net.*;
import java.io.*;

public class AllServer {
    private HashMap<String, PrintWriter> clients;
    private ServerSocket serverSocket;
	public static void main(String[] args) {
		new AllServer().start(); //생성자 호출 이후에 start() method 호출

	}
	// 생성자
	public AllServer(){
        clients = new HashMap<String, PrintWriter>();
        
        // 여러 스레드에서 접근할 것이므로 동기화
        Collections.synchronizedMap(clients);
	}
    public void start() {
/**/    	Socket socket = null;
    	try{
            // 리스너 소켓 생성
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");
 
            // 클라이언트와 연결되면
            while (true) {
                // 통신 소켓을 생성하고 스레드 생성(소켓은 1:1로만 연결된다)
                socket = serverSocket.accept();
                System.out.println("====연결 ok");

                ServerReceiver receiver = new ServerReceiver(socket);
                receiver.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
/**/        } finally{
/**/        	 if(socket != null){
/**/ 	            try{
/**/ 	            	socket.close();
/**/ 	            }catch(IOException e){
/**/ 	               System.out.println(e);
/**/ 	            }
/**/ 	         }
/**/        }
    	
    }
    class ServerReceiver extends Thread {
        Socket socket;
        BufferedReader input;
        PrintWriter output;
 
        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            } catch (IOException e) {
            }
        }
 
        @Override
        public void run() {
            String name = "";
            try {
                // 클라이언트가 서버에 접속하면 대화방에 알린다.
                name = input.readLine();
                System.out.println("====name:"+ name); //
                sendToAll("#" + name + "[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "님이 대화방에 접속하였습니다.");
 
                clients.put(name, output);
                System.out.println(name + "[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "님이 대화방에 접속하였습니다.");
                System.out.println("현재 " + clients.size() + "명이 대화방에 접속 중입니다.");
 
                // 메세지 전송
                while (input != null) {
                    sendToAll(input.readLine());
                }
            } catch (IOException e) {
            } finally {
                // 접속이 종료되면
                clients.remove(name);
                sendToAll("#" + name + "[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "님이 대화방에서 나갔습니다.");
                System.out.println(name + "[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "님이 대화방에서 나갔습니다.");
                System.out.println("현재 " + clients.size() + "명이 대화방에 접속 중입니다.");
            }
        }
 
        public void sendToAll(String message) {
            Iterator<String> it = clients.keySet().iterator();
 
            while (it.hasNext()) {
                try {
                    PrintWriter pw = clients.get(it.next());
                    pw.println(message);
/**/ 				pw.flush();
                } catch (Exception e) {
                }
            }
        }
    }

}
