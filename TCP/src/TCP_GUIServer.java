
/**
 * TCP_GUIServer.java
 * ���� ����.
 * 1.�������ϻ���.
 * 2.��� �����͸� �޾Ƽ� �ٽ� �ְ�..
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
	Vector<TCP_GUIRoom> chatRoomVector = new Vector<TCP_GUIRoom>(); // ä�ù� List
	
	TCP_GUIServerFrame serverFrame =null;
	
	public TCP_GUIServer(){
		try {
			serverFrame = new TCP_GUIServerFrame();
			ss= new ServerSocket(3333);
			serverFrame.textArea.append("client ���� �����..\n");
			serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
			while(true){
				s = ss.accept();
				serverFrame.textArea.append(s.getInetAddress()+"����\n");
				serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
				st = new TCP_MultiServerThread(this, guiRoom, chatRoomVector);
				st.start();
				
			}
		} catch (Exception e) {
			serverFrame.textArea.append("ServerSocket fail\n");
			serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		}
		
	}
	
	/*** ���ӵ� Ŭ���̾�Ʈ ����. ***/
	public void addThread(TCP_MultiServerThread st) {
		list.add(st);
		serverFrame.textArea.append("���� ������ ȸ�� �� : "+list.size()+"\n");
		serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		
	
	}
	
	/*** ������ ������ Ŭ���̾�Ʈ ArrayList���� ����. ***/
	public void removeThread(TCP_MultiServerThread st) {
		list.remove(st);
		serverFrame.textArea.append(s.getInetAddress()+"����\n");
		serverFrame.textArea.setCaretPosition(serverFrame.textArea.getText().length());
		serverFrame.textArea.append("���� ������ ȸ�� �� : "+list.size()+"\n");
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

	
	
	/*** ���� �� Ŭ���̾�Ʈ�鿡�� ������ ����. ***/
	public void broadCast(String msg) {		//��� Ŭ���̾�Ʈ ��ε�ĳ��Ʈ
		for(TCP_MultiServerThread st : list){
			st.pw.println(msg);
		}
	}
	
	
	/*** ���ӵ� Ŭ���̾�Ʈ �߿��� �ӼӸ� ������ ������Ը� ����������. ***/
	public void broadCast2(String msg,String tmpid,String name) {	//�ӼӸ� ��ε�ĳ��Ʈ
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
	
	/*** Ŭ���̾�Ʈ�� ����Ʈ�� ���.(�̸�������). ***/
	public void clientList() {
		temp.add(list.get(list.size()-1).name);
	}
	
	
	
	public static void main(String[] args) {
		new TCP_GUIServer();
		
	}

}







/*** ������ Ŭ���̾�Ʈ�� Thread�� ����. ***/
class TCP_MultiServerThread extends Thread{
	TCP_GUIServer ss;
	Socket s;
	PrintWriter pw;
	String name;
	String roomName;
	int tmp = 0;
	String roomNum=""; 
	TCP_GUIRoom guiRoom;
	Vector<TCP_GUIRoom> chatRoomVector = null; // ä�ù� List
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
				ss.serverFrame.textArea.append("��ȭ�� �Է¹޴���..\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				name = br.readLine();
				
				for(int x=0;x<ss.list.size();x++) {
					if(name.equals(ss.list.get(x).name)) {
						ss.serverFrame.textArea.append("�ߺ��� ID name : " + name + "/list : " + ss.list.get(x).name+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						isOk2 = "�ߺ�";
						break;
					}else {
						//System.out.println(" @@@@@@@@@ �ߺ��ȵ� ID");
						isOk2 = "";
					}				
				}
				
				if(isOk2.equals("�ߺ�")) {
					pw.println("id|"+"�ߺ�|");
					ss.serverFrame.textArea.append("�ߺ��� ID �޽��� ����\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					isOk2 = "";
				}else {
					//ss.serverFrame.textArea.append("�ߺ��� ID �޽��� ���� ����\n");
					break;
				}
			}

			ss.addThread(this); // ��ε�ĳ������ ���� ������ Client(Thread) ����
			
			//System.out.println("client ID-----");
			String tmpclientid = ss.list.get(ss.list.size()-1).name;
			ss.serverFrame.textArea.append("Client Id : "+tmpclientid+"\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			pw.println("id|"+ss.list.get(ss.list.size()-1).name+"|");
			//System.out.println("client ID-----");
			
			/*** ������ Client list ***/
			Vector<String> vector2 = new Vector<String>();
			for (int i = 0; i < ss.list.size(); i++) { 
				vector2.addElement(ss.list.get(i).name);
			}
			ss.serverFrame.list.setListData(vector2);
			
			
			String data = null;
			
			// ó�� ������ Client ���� ���� ������� �渮��Ʈ �����ֱ�
			ss.serverFrame.textArea.append("���� ä�ù� ����-----------------\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			for(int i=0;i<chatRoomVector.size();i++){
				ss.serverFrame.textArea.append(chatRoomVector.get(i).roomNum+"\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				pw.println("room"+"|"+chatRoomVector.get(i).roomName+"|");	
			}
			ss.serverFrame.textArea.append("���� ä�ù� ����-----------------\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
			
			
			while(true){
				data = br.readLine();
				ss.serverFrame.textArea.append("���� ���޽��� : "+data+"\n");
				ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
				
				if (data.startsWith("data")) {//�ӼӸ� �϶�.
					
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					//�޾ƿ��°� ����.. 0,1,2,3, 4��°���� "|" ���� �߶�..�������� ���ܿ�..
					
					String tmp=token.nextToken();	//�ӼӸ� �޽���.
					String tmpid = token.nextToken();	//�ӼӸ� �����ѻ��.
					String tmpnumber = token.nextToken();	// �� ��ȣ
					
					ss.broadCast2("text|"+tmpnumber+"|"+"["+name+"] �� [ "+tmpid+"]"+tmp,tmpid,name);
					/**
					 * Ŭ���̾�Ʈ�� ������(��ε� ĳ��Ʈ).
					 * text : ������
					 * name : �����»��
					 * tmpid : �ӼӸ� �޴� ���
					 * tmp : �ӼӸ� �޽���.
					 */
					
				}else if(data.startsWith("room")){ // Server ���� �� �� �����
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					
					String tmp=token.nextToken(); // �� ��ȣ
					String tmp2=token.nextToken();	//������
					
					guiRoom = new TCP_GUIRoom(tmp, tmp2);	//���ȣ ,������
					chatRoomVector.add(guiRoom);	//��) chatRoomVector�� �����̶� ġ��	guiRoom�� 101ȣ, 102ȣ...��..
					
					ss.serverFrame.textArea.append("������-----����\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					Vector<String> vector3 = new Vector<String>();
					for(int i=0;i<chatRoomVector.size();i++){
						
						//���̺� ���� �� �׸�
						vector3.add(ss.serverFrame.model.getRowCount() + 1+""); // ���ȣ
						vector3.add(tmp2);	//���̸�
						vector3.add(1+"");	//�ο���
						
						ss.serverFrame.textArea.append("ss.serverFrame.model.getRowCount()+1 : "+ss.serverFrame.model.getRowCount()+1+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						rowCount = ss.serverFrame.model.getRowCount()+1;
						
						ss.serverFrame.textArea.append("��ȣ : " + chatRoomVector.get(i).roomNum + 
								" / id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					}
					ss.serverFrame.model.addRow(vector3);	//ä�ù� ��Ͽ� ��Ÿ����.
					
					ss.serverFrame.textArea.append("������-----��\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					
					ss.broadCast("room|"+tmp2+"|");
					
				}else if(data.startsWith("go")){ // Client �� �濡 ���� �� �� �濡 ���� ���� �����ֱ�
					
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");

					String byun = "";
					
					roomNum=token.nextToken(); 
					String tmp2=token.nextToken(); // �� Client Id
					//System.out.println("go�� Id : " + tmp2);

					for(int i=0;i<chatRoomVector.size();i++) {
						
						//���� ������ ã�� ���ؼ� �񱳸� ���ִµ� 
						//Ŭ���� �����̶� ���ϱ� �ָ�... �׷��� elementAt�� ����.
						//����� �ϳ��� ���ʴ�� �־�鼭 ��..
						TCP_GUIRoom tmpChatRoom2 = (TCP_GUIRoom)chatRoomVector.elementAt(i);

						//���������̶� �ϳ��� ��..
						if(roomNum.equals(tmpChatRoom2.roomNum)) {
							tmpChatRoom2 = tmpChatRoom2;
							
							//������ �濡 �� ���̵� �߰�.
							tmpChatRoom2.roomId.add(tmp2);
							//System.out.println("go�� tmp2 : "+tmp2);
							
							for(int j=0;j<tmpChatRoom2.roomId.size();j++) {
								//���̸��ڿ� ���̵� ����.
								byun = byun+tmpChatRoom2.roomId.get(j)+"|";
							}
						}
					}
					
					//System.out.println("byun : " + byun);
					
					ss.serverFrame.textArea.append("������-----����\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					for(int i=0;i<chatRoomVector.size();i++){
						
						ss.serverFrame.textArea.append("��ȣ : " + chatRoomVector.get(i).roomNum 
								+"/ id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						//���̺��� �ο���
						for(int j=0;j<ss.serverFrame.model.getRowCount();j++) {
							if(ss.serverFrame.model.getValueAt(j, 0).toString().equals(roomNum)) {								
								ss.serverFrame.model.setValueAt(chatRoomVector.get(i).roomId.size(), j, 2);
							}
						}
						
					}
					ss.serverFrame.textArea.append("������-----��\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());

					
					
					ss.broadCast("go"+"|"+roomNum+"|"+byun);
					
					ss.broadCast("text|"+roomNum+"|  �� [ "+name+" ] �� ���� �� ");
				
					
				}else if(data.startsWith("exit")){	//ä�ù濡�� ������
					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					
					String tmp = token.nextToken();	// ���� ID
					
					String byun = "";
					
					for(int i=0;i<chatRoomVector.size();i++) {
					
						tmpChatRoom2 = (TCP_GUIRoom)chatRoomVector.elementAt(i);

						for(int j=0;j<tmpChatRoom2.roomId.size();j++) {
							if(tmp.equals(tmpChatRoom2.roomId.get(j))) {
								tmpChatRoom2 = tmpChatRoom2;
								
								tmpChatRoom2.roomId.removeElement(tmp); // ���� ID�� �����
								roomNum = tmpChatRoom2.roomNum;
								
								for(int k=0;k<tmpChatRoom2.roomId.size();k++) {
									//���̸��ڿ� ���̵� ����.
									byun = byun+tmpChatRoom2.roomId.get(k)+"|";
								}
								
								
								
								if(tmpChatRoom2.roomId.size() == 0) {
									chatRoomVector.removeElement(tmpChatRoom2);
									
									//���̺� �� ���� 
									ss.serverFrame.model.removeRow(Integer.parseInt(roomNum)-1);
									//������ ���ȣ�� �ٸ� ���ȣ���� ������
									if(Integer.parseInt(roomNum) < (rowCount)) { 
										//���ȣ�� �ϳ��� �ٿ��ش�.
										rowCount = rowCount - 1;	
										//guiClient.Number = guimain.roomNum;
									}
									//	 JTable �� ��ȣ ����
									if(ss.serverFrame.model.getRowCount() != 0) {
										for(int k=0;k<ss.serverFrame.model.getRowCount();k++) {
											ss.serverFrame.model.setValueAt(k+1, k, 0); // ����
										}
									}
									
									ss.broadCast("del"+"|"+roomNum+"|");
									
									for(int a=0;a<chatRoomVector.size();a++) {
										
										TCP_GUIRoom tmpChatRoom3 = (TCP_GUIRoom)chatRoomVector.elementAt(a);
										tmpChatRoom3.roomNum = (a+1)+"";
									}
									
								}else {
									
									ss.broadCast("text|"+roomNum+"|  �� [ "+name+" ] �� ���� �� ");

									ss.broadCast("exit"+"|"+roomNum+"|"+byun);
									
								}
								break;
							}
						}

					}

					ss.serverFrame.textArea.append("<exit>������ ����-----------------\n");
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					for(int i=0;i<chatRoomVector.size();i++){
						ss.serverFrame.textArea.append("��ȣ : " + chatRoomVector.get(i).roomNum + 
								" / id : " + chatRoomVector.get(i).roomId+"\n");
						ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
						
						//���̺��� �ο���
						for(int j=0;j<ss.serverFrame.model.getRowCount();j++) {
							if(ss.serverFrame.model.getValueAt(j, 0).toString().equals(roomNum)) {								
								ss.serverFrame.model.setValueAt(chatRoomVector.get(i).roomId.size(), j, 2);
							}
						}
					}
					ss.serverFrame.textArea.append("<exit>������ �� -----------------\n");		
					ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
					
				}
				
				else if(data.startsWith("text")){	//�ӼӸ� �ƴϸ� ��� Ŭ���̾�Ʈ���� ����.(��ε� ĳ��Ʈ).

					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					//�޾ƿ��°� ����.. 0,1,2,3, 4��°���� "|" ���� �߶�..�������� ���ܿ�..
					
					String tmp = token.nextToken();	// �� ��ȣ
					String tmp2 = token.nextToken();	// ����
					
					ss.broadCast("text|"+tmp+"| ["+name+"] "+tmp2);
				}
			}
			
		} catch (Exception e) {	//socket����
			ss.removeThread(this);	//����Ʈ���� Ŭ���̾�Ʈ ����.

			ss.serverFrame.textArea.append("client ���� �����..\n");
			ss.serverFrame.textArea.setCaretPosition(ss.serverFrame.textArea.getText().length());
		} 
	}
}
