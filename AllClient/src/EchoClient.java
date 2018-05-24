import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String args[]) {
		Socket socket = null;
		String host;
		BufferedReader inputKBD, input;
		BufferedWriter output;
		String theLine;
		if (args.length > 0) {
			host = args[0]; // 원격 호스트를 입력받음
		} else {
			host = "210.123.254.10";
			// host="localhost"; // 로컬 호스트를 원격 호스트로 사용
		}
		try {
			socket = new Socket(host, 7778); // echo 서버에 접속한다.
			inputKBD = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			input = new BufferedReader(new InputStreamReader(System.in));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			System.out.println("서버와 연결되었습니다. 전송할 문장을 입력하십시오.");
			while (true) {
				theLine = input.readLine(); // 데이터를 입력한다.
				if (theLine.equals("quit"))
					break; // 프로그램 종료
				output.write(theLine + '\r' + '\n');
				output.flush(); // 서버에 데이터 전송
				System.out.println(inputKBD.readLine()); // 다시 수신해서 화면에 출력한다.
			}
		} catch (UnknownHostException e) {
			System.err.println(args[0] + " 호스트를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				socket.close(); // 소켓을 닫는다.
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}