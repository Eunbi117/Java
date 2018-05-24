
/**
 * TCP_GUIClientThread.java
 * 1.오로지 데이터 주고 받는 역할만.
 * 프레임 x.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TCP_GUIClientThread extends Thread {

	String data = null;
	BufferedReader br;
	Socket socket;
	PrintWriter pw;
	
	TCP_GUIClient guiClient = null;
	TCP_GUIMain guimain = null;
	
	Calendar c=Calendar.getInstance();//접속시간 위에 뜨게 하기
	
	String idTmp;
	
	public TCP_GUIClientThread(Socket s,BufferedReader br, PrintWriter pw, TCP_GUIMain guimain){
		socket = s;
		this.br=br;
		this.pw =pw;
		this.guimain=guimain;
	}
	public void run() {
		try {
			
			while(true){

				/*** 데이터 읽기 ***/
				data = br.readLine();
				System.out.println("받은 메시지 ==> " + data);
				
				if (data.startsWith("id")) {
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");					
					String tmp = token.nextToken(); // 대화명
	
					if (tmp.equals("중복")) {
						guimain.name = JOptionPane.showInputDialog("이미 사용중인 대화명입니다.",JOptionPane.INFORMATION_MESSAGE);
						
						pw.println(guimain.name);
						
					}else {
						Vector<String> idvec = new Vector<>(); 
						System.out.println("1...tmp ::::: ->" +tmp);
						idvec.add(tmp);
						guimain.Idlist.setListData(idvec);
						
						
						//채팅방에 접속한 시간 저장
						String message = c.get(Calendar.YEAR) + "/"
				                + (c.get(Calendar.MONTH)+1) + "/"
				                + c.get(Calendar.DATE)+" "
				                + c.get(Calendar.HOUR)+ ":" + c.get(Calendar.MINUTE);
						
						Vector<String> timevec = new Vector<>();
						timevec.add(message);
						guimain.Timelist.setListData(timevec);
						
					}

				}else if (data.startsWith("text")) {
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					
					String tmp = token.nextToken();		//방번호
					String tmp2 = token.nextToken();	//대화명
					
					if(tmp.equals(guimain.roomNum)){
						guiClient.textArea.append(tmp2+"\n");
						guiClient.textArea.setCaretPosition(guiClient.textArea.getText().length());
					}else{
						System.out.println("text의 달라달라");
					}
					
				}else if (data.startsWith("room")){
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					
					String tmp=token.nextToken();	//방이름
					
					Vector<String> vector3 = new Vector<String>();
					
					//테이블 열에 들어갈 항목
					vector3.add(guimain.model.getRowCount() + 1+""); // 방번호
					vector3.add(tmp);	//방이름
					vector3.add(1+"");	//인원수
					
					guimain.model.addRow(vector3);	//채팅방 목록에 나타내기.
					
				}else if(data.startsWith("go")){
					Vector<String> vector2 = new Vector<String>();
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");
					String tmp=token.nextToken();	//방번호
					
					if(tmp.equals(guimain.roomNum)){
						String tmp2 = null;
						int tokencnt = token.countTokens();
						int i=0;
						while(token.hasMoreTokens()) {
							i++; // i = i + 1;
							tmp2 = token.nextToken();	//대화명
							if(i == tokencnt) { // i와 파싱된 문자열 갯수가 같다면... 파싱의 제일 끝
								if((guimain.name).equals(tmp2)) { // 마지막 Client Id 와 나의 Id 가 같다면.. 새창이 떠야된다
									guiClient = new TCP_GUIClient(br, pw,guimain.name,guimain.roomNum);
									System.out.println("당신의 ID : " + guimain.name);
								}
							}
							vector2.add(tmp2);
						}
						
						guiClient.namelabel = new JLabel(guimain.name);	//대화명 보여주는 레이블
						guiClient.panel.add(guiClient.namelabel);
						guiClient.namelabel.setBounds(5, 8, 50, 25);

						guiClient.panel.add(guiClient.namelabel2);	//채팅시작 알리는 레이블
						guiClient.namelabel2.setBounds(50, 8, 200, 25);
						
						//채팅방에 접속한 시간 저장
						String message = "접속시간 : " + c.get(Calendar.YEAR) + "/"
				                + (c.get(Calendar.MONTH)+1) + "/"
				                + c.get(Calendar.DATE)+" "
				                + c.get(Calendar.HOUR)+ ":" + c.get(Calendar.MINUTE);
						
						guiClient.mesLabel = new JLabel(message);	//접속시간 알리는 레이블
						guiClient.panel.add(guiClient.mesLabel);
						guiClient.mesLabel.setBounds(5, 352, 150, 25);


						guiClient.panel.add(guiClient.sulabel);	//현재수라는 말을 나타내는 레이블
						guiClient.sulabel.setBounds(265, 5, 90, 25);
						
						int count = vector2.size();	//vector2.size() : 현재 채팅방안에 들어있는 사람 수
						
						guiClient.su.setText(count+"명");	//현재수 알리는 텍스트필드
						guiClient.panel.add(guiClient.su);	//현재수 필드
						guiClient.su.setBounds(370, 5, 35, 24);
						guiClient.su.setEditable(false);

						guiClient.list.setListData(vector2);	//현재 채팅방안의 사람 리스트에 넣기
						
						//테이블의 인원수
						for(int j=0;j<guimain.model.getRowCount();j++) {
							System.out.println("guimain.model.getValueAt(j, 0) : "+guimain.model.getValueAt(j, 0));
							System.out.println("tmp : "+ tmp);
							if(guimain.model.getValueAt(j, 0).toString().equals(tmp)) {	
								System.out.println("방들어갈때 vector2 : "+vector2);
								System.out.println("방들어갈때 vector2.size : "+vector2.size());
								guimain.model.setValueAt(vector2.size(), j, 2);
							}
						}
						
					}else{
						System.out.println("go의 달라달라@@");
					}
					
					
				} else if(data.startsWith("exit")) {
					Vector<String> vector2 = new Vector<String>();
					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					String tmp=token.nextToken();	// 방 번호
					String tmp2 = null;
					
					while(token.hasMoreTokens()) {
						tmp2 = token.nextToken(); // ID

						vector2.add(tmp2);
					}
					
					//테이블의 인원수
					for(int j=0;j<guimain.model.getRowCount();j++) {
						
						if(guimain.model.getValueAt(j, 0).toString().equals(tmp)) {
							int count = vector2.size();
							guimain.model.setValueAt(vector2.size(), j, 2);
							guiClient.su.setText(count+"명");
							guiClient.list.setListData(vector2);
								
						}
					}
					
				}else if(data.startsWith("del")) {
					
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					String tmp=token.nextToken();	// 방 번호
					
					guimain.model.removeRow(Integer.parseInt(tmp)-1);

					//삭제할 방번호가 다른 방번호보다 작으면
					if(Integer.parseInt(tmp) < Integer.parseInt(guimain.roomNum)) { 
						//방번호를 하나씩 줄여준다.
						guimain.roomNum = (Integer.parseInt(guimain.roomNum) - 1) + "";	
						guiClient.Number = guimain.roomNum;
					}
					
					//	 JTable 방 번호 변경
					if(guimain.model.getRowCount() != 0) {
						for(int i=0;i<guimain.model.getRowCount();i++) {
							guimain.model.setValueAt(i+1, i, 0); // 변경
							
							// 나는 2번에 들어가 잇다. 그런데 1번이 사라져서 내가 들어간 방이 1번으로 변경해야된다.
						}
					}
					
					
					System.out.println("roomNum : " + guimain.roomNum);
				}	
			}
			
		} catch (IOException e) {
			System.out.println(e+"client run fail");
		}
	}

}
