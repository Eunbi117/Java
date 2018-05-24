import java.net.*;
import java.io.*;

public class AllClient {
    private String name;
    private Socket socket;
    private String serverIp = "210.123.254.10";
    private BufferedReader inputKBD;

	public static void main(String[] args) {
		new AllClient().start();

	}
	public void start(){
		inputKBD = new BufferedReader(new InputStreamReader(System.in));
		try {			
            socket = new Socket(serverIp, 7777);
            
            System.out.print("서버와 연결되었습니다. 대화명을 입력하세요 : ");
			name =  inputKBD.readLine();
			
            ClientReceiver clientReceiver = new ClientReceiver(socket);
            ClientSender clientSender = new ClientSender(socket);
             
            clientReceiver.start();
            clientSender.start();
        } catch (IOException e) {
        }		
	}
	class ClientReceiver extends Thread {
        Socket socket;
        BufferedReader input;
        String msg;
        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         
            } catch (IOException e) {
            }
        }
        public void run() {
            while (input != null) {
                try {
                	msg =input.readLine();
                    System.out.println(msg);
                } catch (IOException e) {
                }
            }
        }
	}
	class ClientSender extends Thread {
		Socket socket;
		PrintWriter output;
        public ClientSender(Socket socket) {
            this.socket = socket;
            try {
                output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
                output.println(name);
                System.out.println(name+ "님, 대화방에 입장하였습니다.");
            } catch (Exception e) {
            }
        }
        public void run() {
           // Scanner sc = new Scanner(System.in);
            String msg = "";
 
            while (output != null) {
                try {
                    msg = inputKBD.readLine();
                    if(msg.equals("exit"))
                        System.exit(0);
                    
                    output.println("[" + name + "]" + msg);
                    output.flush();
                } catch (IOException e) {
                }
            }
        }
	}
}
