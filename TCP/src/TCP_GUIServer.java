
/**
 * TCP_GUIServer.java
 * 서버 역할.
 * 1.서버소켓생성.
 * 2.모든 데이터를 받아서 다시 주고..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class TCP_GUIServer {
	ServerSocket ss;
	Socket s;
	ArrayList<TCP_MultiServerThread> list  = new ArrayList<TCP_MultiServerThread>();
	ArrayList<String> temp = new ArrayList<>();
	TCP_MultiServerThread st;
	TCP_GUIRoom guiRoom = new TCP_GUIRoom();
	Vector<TCP_GUIRoom> chatRoomVector = new Vector<TCP_GUIRoom>(); // 채팅방 List
	
	TCP_GUIServerFrame serverFrame =null;
	
	public TCP_GUIServer(){
		try {
			serverFrame = new TCP_GUIServerFrame();
			ss= new ServerSocket(3333);
			serverFrame.textArea.append("client 접속 대기중..\n");
			serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
			while(true){
				s = ss.accept();
				serverFrame.textArea.append(s.getInetAddress()+"접속\n");
				serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
				st = new TCP_MultiServerThread(this, guiRoom, chatRoomVector);
				st.start();
				
			}
		} catch (Exception e) {
			serverFrame.textArea.append("ServerSocket fail\n");
			serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		}
		
	}
	
	/*** 접속된 클라이언트 저장. ***/
	public void addThread(TCP_MultiServerThread st) {
		list.add(st);
		serverFrame.textArea.append("현재 접속한 회원 수 : "+list.size()+"\n");
		serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		
	
	}
	
	/*** 접속이 끊어진 클라이언트 ArrayList에서 제거. ***/
	public void removeThread(TCP_MultiServerThread st) {
		list.remove(st);
		serverFrame.textArea.append(s.getInetAddress()+"퇴장\n");
		serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		serverFrame.textArea.append("현재 접속한 회원 수 : "+list.size()+"\n");
		serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		
		//System.out.println("######## CLIENT LIST ##########");
		Vector<String> vector2 = new Vector<String>();
		
		for(int i=0;i<list.size();i++){
			//System.out.println(list.get(i).name);
			broadCast("id"+"|"+list.get(i).name+"|");
			st.pw.println(list.get(i).name);
			vector2.add(list.get(i).name);
		}
		//System.out.println("###############################");
		
		
//		System.out.println("remove vector :: "+vector2);
		serverFrame.list.setListData(vector2);
		
	}

	
	
	/*** 접속 된 클라이언트들에게 데이터 전송. ***/
	public void broadCast(String msg) {		//모든 클라이언트 브로드캐스트
		for(TCP_MultiServerThread st : list){
			st.pw.println(msg);
		}
	}
	
	
	/*** 접속된 클라이언트 중에서 귓속말 선택한 사람에게만 데이터전송. ***/
	public void broadCast2(String msg,String tmpid,String name) {	//귓속말 브로드캐스트
		TCP_MultiServerThread st =null;
		
		for (int i = 0; i < list.size(); i++) {
			st = list.get(i);
			if(list.get(i).name.equals(tmpid)){ 
				st.pw.println(msg);	
			}else if(list.get(i).name.equals(name)){ 
				st.pw.println(msg);
			}
		}
		
	}
	
	/*** 클라이언트를 리스트에 담기.(이름값으로). ***/
	public void clientList() {
		temp.add(list.get(list.size()-1).name);
	}
	
	
	
	public static void main(String[] args) {
		new TCP_GUIServer();
		
	}

}







/*** 각각의 클라이언트들 Thread로 구현. ***/
class TCP_MultiServerThread extends Thread{
	TCP_GUIServer ss;
	Socket s;
	PrintWriter pw;
	String name;
	String roomName;
	int tmp = 0;
	String roomNum=""; 
	TCP_GUIRoom guiRoom;
	Vector<TCP_GUIRoom> chatRoomVector = null; // 채팅방 List
	BufferedReader br;
	String idCheck;
	int rowCount;
	TCP_GUIRoom tmpChatRoom2;
	String newId;
	
	public TCP_MultiServerThread(TCP_GUIServer ss, TCP_GUIRoom tmpguiRoom, Vector<TCP_GUIRoom> tmpchatRoomVector) {
		this.ss = ss;
		guiRoom = tmpguiRoom;
		chatRoomVector = tmpchatRoomVector;
		try {
			br = new BufferedReader(new InputStreamReader(ss.s.getInputStream()));
			pw = new PrintWriter(ss.s.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run(){

		String isOk2 = "";
		
		try {
			
			while(isOk2.equals("")) {
				ss.serverFrame.textArea.append("대화명 입력받는중..\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				name = br.readLine();
				
				for(int x=0;x<ss.list.size();x++) {
					if(name.equals(ss.list.get(x).name)) {
						ss.serverFrame.textArea.append("중복된 ID name : " + name + "/list : " + ss.list.get(x).name+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						isOk2 = "중복";
						break;
					}else {
						//System.out.println(" @@@@@@@@@ 중복안된 ID");
						isOk2 = "";
					}				
				}
				
				if(isOk2.equals("중복")) {
					pw.println("id|"+"중복|");
					ss.serverFrame.textArea.append("중복된 ID 메시지 전송\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					isOk2 = "";
				}else {
					//ss.serverFrame.textArea.append("중복된 ID 메시지 전송 안함\n");
					break;
				}
			}

			ss.addThread(this); // 브로드캐스팅을 위해 접속한 Client(Thread) 저장
			
			//System.out.println("client ID-----");
			String tmpclientid = ss.list.get(ss.list.size()-1).name;
			ss.serverFrame.textArea.append("Client Id : "+tmpclientid+"\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			pw.println("id|"+ss.list.get(ss.list.size()-1).name+"|");
			//System.out.println("client ID-----");
			
			/*** 접속한 Client list ***/
			Vector<String> vector2 = new Vector<String>();
			for (int i = 0; i < ss.list.size(); i++) { 
				vector2.addElement(ss.list.get(i).name);
			}
			ss.serverFrame.list.setListData(vector2);
			
			
			String data = null;
			
			// 처음 접속한 Client 에게 현재 만들어진 방리스트 보여주기
			ss.serverFrame.textArea.append("현재 채팅방 시작-----------------\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			for(int i=0;i<chatRoomVector.size();i++){
				ss.serverFrame.textArea.append(chatRoomVector.get(i).roomNum+"\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				pw.println("room"+"|"+chatRoomVector.get(i).roomName+"|");	
			}
			ss.serverFrame.textArea.append("현재 채팅방 시작-----------------\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			
			
			while(true){
				data = br.readLine();
				ss.serverFrame.textArea.append("받은 모든메시지 : "+data+"\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				
				if (data.startsWith("data")) {//귓속말 일때.
					
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					//받아오는값 구분.. 0,1,2,3, 4번째부터 "|" 까지 잘라..나머지는 숨겨요..
					
					String tmp=token.nextToken();	//귓속말 메시지.
					String tmpid = token.nextToken();	//귓속말 선택한사람.
					String tmpnumber = token.nextToken();	// 방 번호
					
					ss.broadCast2("text|"+tmpnumber+"|"+"["+name+"] → [ "+tmpid+"]"+tmp,tmpid,name);
					/**
					 * 클라이언트로 보내기(브로드 캐스트).
					 * text : 구분자
					 * name : 보내는사람
					 * tmpid : 귓속말 받는 사람
					 * tmp : 귓속말 메시지.
					 */
					
				}else if(data.startsWith("room")){ // Server 관리 용 방 만들기
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					
					String tmp=token.nextToken(); // 방 번호
					String tmp2=token.nextToken();	//방제목
					
					guiRoom = new TCP_GUIRoom(tmp, tmp2);	//방번호 ,방제목
					chatRoomVector.add(guiRoom);	//예) chatRoomVector를 원룸이라 치면	guiRoom은 101호, 102호...들..
					
					ss.serverFrame.textArea.append("방제목-----시작\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					Vector<String> vector3 = new Vector<String>();
					for(int i=0;i<chatRoomVector.size();i++){
						
						//테이블 열에 들어갈 항목
						vector3.add(ss.serverFrame.model.getRowCount() + 1+""); // 방번호
						vector3.add(tmp2);	//방이름
						vector3.add(1+"");	//인원수
						
						ss.serverFrame.textArea.append("ss.serverFrame.model.getRowCount()+1 : "+ss.serverFrame.model.getRowCount()+1+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						rowCount = ss.serverFrame.model.getRowCount()+1;
						
						ss.serverFrame.textArea.append("번호 : " + chatRoomVector.get(i).roomNum + 
								" / id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					}
					ss.serverFrame.model.addRow(vector3);	//채팅방 목록에 나타내기.
					
					ss.serverFrame.textArea.append("방제목-----끝\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					
					ss.broadCast("room|"+tmp2+"|");
					
				}else if(data.startsWith("go")){ // Client 가 방에 들어갔을 시 그 방에 대한 정보 보내주기
					
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");

					String byun = "";
					
					roomNum=token.nextToken(); 
					String tmp2=token.nextToken(); // 들어간 Client Id
					//System.out.println("go한 Id : " + tmp2);

					for(int i=0;i<chatRoomVector.size();i++) {
						
						//내가 들어갈방을 찾기 위해서 비교를 해주는데 
						//클래스 형식이라 비교하기 애매... 그래서 elementAt을 쓴다.
						//방들을 하나씩 차례대로 넣어가면서 비교..
						TCP_GUIRoom tmpChatRoom2 = (TCP_GUIRoom)chatRoomVector.elementAt(i);

						//내가들어간방이랑 하나씩 비교..
						if(roomNum.equals(tmpChatRoom2.roomNum)) {
							tmpChatRoom2 = tmpChatRoom2;
							
							//내가들어간 방에 내 아이디를 추가.
							tmpChatRoom2.roomId.add(tmp2);
							//System.out.println("go의 tmp2 : "+tmp2);
							
							for(int j=0;j<tmpChatRoom2.roomId.size();j++) {
								//방이름뒤에 아이디 붙임.
								byun = byun+tmpChatRoom2.roomId.get(j)+"|";
							}
						}
					}
					
					//System.out.println("byun : " + byun);
					
					ss.serverFrame.textArea.append("방제목-----시작\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					for(int i=0;i<chatRoomVector.size();i++){
						
						ss.serverFrame.textArea.append("번호 : " + chatRoomVector.get(i).roomNum 
								+"/ id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						//테이블의 인원수
						for(int j=0;j<ss.serverFrame.model.getRowCount();j++) {
							if(ss.serverFrame.model.getValueAt(j, 0).toString().equals(roomNum)) {								
								ss.serverFrame.model.setValueAt(chatRoomVector.get(i).roomId.size(), j, 2);
							}
						}
						
					}
					ss.serverFrame.textArea.append("방제목-----끝\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());

					
					
					ss.broadCast("go"+"|"+roomNum+"|"+byun);
					
					ss.broadCast("text|"+roomNum+"|  ☞ [ "+name+" ] 님 입장 ☜ ");
				
					
				}else if(data.startsWith("exit")){	//채팅방에서 나갈때
					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					
					String tmp = token.nextToken();	// 나간 ID
					
					String byun = "";
					
					for(int i=0;i<chatRoomVector.size();i++) {
					
						tmpChatRoom2 = (TCP_GUIRoom)chatRoomVector.elementAt(i);

						for(int j=0;j<tmpChatRoom2.roomId.size();j++) {
							if(tmp.equals(tmpChatRoom2.roomId.get(j))) {
								tmpChatRoom2 = tmpChatRoom2;
								
								tmpChatRoom2.roomId.removeElement(tmp); // 나간 ID만 지우기
								roomNum = tmpChatRoom2.roomNum;
								
								for(int k=0;k<tmpChatRoom2.roomId.size();k++) {
									//방이름뒤에 아이디 붙임.
									byun = byun+tmpChatRoom2.roomId.get(k)+"|";
								}
								
								
								
								if(tmpChatRoom2.roomId.size() == 0) {
									chatRoomVector.removeElement(tmpChatRoom2);
									
									//테이블 열 삭제 
									ss.serverFrame.model.removeRow(Integer.parseInt(roomNum)-1);
									//삭제할 방번호가 다른 방번호보다 작으면
									if(Integer.parseInt(roomNum) < (rowCount)) { 
										//방번호를 하나씩 줄여준다.
										rowCount = rowCount - 1;	
										//guiClient.Number = guimain.roomNum;
									}
									//	 JTable 방 번호 변경
									if(ss.serverFrame.model.getRowCount() != 0) {
										for(int k=0;k<ss.serverFrame.model.getRowCount();k++) {
											ss.serverFrame.model.setValueAt(k+1, k, 0); // 변경
										}
									}
									
									ss.broadCast("del"+"|"+roomNum+"|");
									
									for(int a=0;a<chatRoomVector.size();a++) {
										
										TCP_GUIRoom tmpChatRoom3 = (TCP_GUIRoom)chatRoomVector.elementAt(a);
										tmpChatRoom3.roomNum = (a+1)+"";
									}
									
								}else {
									
									ss.broadCast("text|"+roomNum+"|  ☞ [ "+name+" ] 님 퇴장 ☜ ");

									ss.broadCast("exit"+"|"+roomNum+"|"+byun);
									
								}
								break;
							}
						}

					}

					ss.serverFrame.textArea.append("<exit>방제목 시작-----------------\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					for(int i=0;i<chatRoomVector.size();i++){
						ss.serverFrame.textArea.append("번호 : " + chatRoomVector.get(i).roomNum + 
								" / id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						//테이블의 인원수
						for(int j=0;j<ss.serverFrame.model.getRowCount();j++) {
							if(ss.serverFrame.model.getValueAt(j, 0).toString().equals(roomNum)) {								
								ss.serverFrame.model.setValueAt(chatRoomVector.get(i).roomId.size(), j, 2);
							}
						}
					}
					ss.serverFrame.textArea.append("<exit>방제목 끝 -----------------\n");		
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					
				}
				
				else if(data.startsWith("text")){	//귓속말 아니면 모든 클라이언트에게 전송.(브로드 캐스트).

					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					//받아오는값 구분.. 0,1,2,3, 4번째부터 "|" 까지 잘라..나머지는 숨겨요..
					
					String tmp = token.nextToken();	// 방 번호
					String tmp2 = token.nextToken();	// 내용
					
					ss.broadCast("text|"+tmp+"| ["+name+"] "+tmp2);
				}
			}
			
		} catch (Exception e) {	//socket끊김
			ss.removeThread(this);	//리스트에서 클라이언트 제거.

			ss.serverFrame.textArea.append("client 접속 대기중..\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
		} 
	}
}
