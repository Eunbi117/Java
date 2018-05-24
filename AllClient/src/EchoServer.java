import java.io.*;
import java.net.*;

public class EchoServer {
	private ServerSocket serverSocket;

	public EchoServer() {

	}

	public static void main(String args[]) {
		new EchoServer().start(); // 생성자 호출 이후에 start() method 호출

	}

	public void start() {
		Socket socket = null;

		BufferedReader input;
		BufferedWriter output;
		String theLine;
		try {
			serverSocket = new ServerSocket(7778);
			// 7778번 포트에서 클라이언트의 접속 요청을 기다리는 서버소켓 객체를 생성한다.
			socket = serverSocket.accept(); // 클라이언트의 접속요청을
			// 기다리고 클라이언트의 소켓과 연결된 서버 측의 소켓(socket)을 생성한다.
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 클라이언트에 전송한 데이터를 읽을 BufferedReader 객체를 생성한다.
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 클라이언트에 데이터를 전송하는 BufferedWriter 객체를 생성한다.
			while ((theLine = input.readLine()) != null) { // 클라이언트의 데이터를 수신
				System.out.println(theLine); // 받은 데이터를 화면에 출력한다.
				output.write(theLine + '\r' + '\n'); // 클라이언트에 데이터를 재전송
				output.flush(); // 클라이언트에 데이터를 재전송
			}
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

}