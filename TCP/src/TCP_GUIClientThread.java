
/**
 * TCP_GUIClientThread.java
 * 1.������ ������ �ְ� �޴� ���Ҹ�.
 * ������ x.
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
	
	Calendar c=Calendar.getInstance();//���ӽð� ���� �߰� �ϱ�
	
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

				/*** ������ �б� ***/
				data = br.readLine();
				System.out.println("���� �޽��� ==> " + data);
				
				if (data.startsWith("id")) {
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");					
					String tmp = token.nextToken(); // ��ȭ��
	
					if (tmp.equals("�ߺ�")) {
						guimain.name = JOptionPane.showInputDialog("�̹� ������� ��ȭ���Դϴ�.",JOptionPane.INFORMATION_MESSAGE);
						
						pw.println(guimain.name);
						
					}else {
						Vector<String> idvec = new Vector<>(); 
						System.out.println("1...tmp ::::: ->" +tmp);
						idvec.add(tmp);
						guimain.Idlist.setListData(idvec);
						
						
						//ä�ù濡 ������ �ð� ����
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
					
					String tmp = token.nextToken();		//���ȣ
					String tmp2 = token.nextToken();	//��ȭ��
					
					if(tmp.equals(guimain.roomNum)){
						guiClient.textArea.append(tmp2+"\n");
						guiClient.textArea.setCaretPosition(guiClient.textArea.getText().length());
					}else{
						System.out.println("text�� �޶�޶�");
					}
					
				}else if (data.startsWith("room")){
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					
					String tmp=token.nextToken();	//���̸�
					
					Vector<String> vector3 = new Vector<String>();
					
					//���̺� ���� �� �׸�
					vector3.add(guimain.model.getRowCount() + 1+""); // ���ȣ
					vector3.add(tmp);	//���̸�
					vector3.add(1+"");	//�ο���
					
					guimain.model.addRow(vector3);	//ä�ù� ��Ͽ� ��Ÿ����.
					
				}else if(data.startsWith("go")){
					Vector<String> vector2 = new Vector<String>();
					StringTokenizer token = new StringTokenizer(data.substring(3),"|");
					String tmp=token.nextToken();	//���ȣ
					
					if(tmp.equals(guimain.roomNum)){
						String tmp2 = null;
						int tokencnt = token.countTokens();
						int i=0;
						while(token.hasMoreTokens()) {
							i++; // i = i + 1;
							tmp2 = token.nextToken();	//��ȭ��
							if(i == tokencnt) { // i�� �Ľ̵� ���ڿ� ������ ���ٸ�... �Ľ��� ���� ��
								if((guimain.name).equals(tmp2)) { // ������ Client Id �� ���� Id �� ���ٸ�.. ��â�� ���ߵȴ�
									guiClient = new TCP_GUIClient(br, pw,guimain.name,guimain.roomNum);
									System.out.println("����� ID : " + guimain.name);
								}
							}
							vector2.add(tmp2);
						}
						
						guiClient.namelabel = new JLabel(guimain.name);	//��ȭ�� �����ִ� ���̺�
						guiClient.panel.add(guiClient.namelabel);
						guiClient.namelabel.setBounds(5, 8, 50, 25);

						guiClient.panel.add(guiClient.namelabel2);	//ä�ý��� �˸��� ���̺�
						guiClient.namelabel2.setBounds(50, 8, 200, 25);
						
						//ä�ù濡 ������ �ð� ����
						String message = "���ӽð� : " + c.get(Calendar.YEAR) + "/"
				                + (c.get(Calendar.MONTH)+1) + "/"
				                + c.get(Calendar.DATE)+" "
				                + c.get(Calendar.HOUR)+ ":" + c.get(Calendar.MINUTE);
						
						guiClient.mesLabel = new JLabel(message);	//���ӽð� �˸��� ���̺�
						guiClient.panel.add(guiClient.mesLabel);
						guiClient.mesLabel.setBounds(5, 352, 150, 25);


						guiClient.panel.add(guiClient.sulabel);	//�������� ���� ��Ÿ���� ���̺�
						guiClient.sulabel.setBounds(265, 5, 90, 25);
						
						int count = vector2.size();	//vector2.size() : ���� ä�ù�ȿ� ����ִ� ��� ��
						
						guiClient.su.setText(count+"��");	//����� �˸��� �ؽ�Ʈ�ʵ�
						guiClient.panel.add(guiClient.su);	//����� �ʵ�
						guiClient.su.setBounds(370, 5, 35, 24);
						guiClient.su.setEditable(false);

						guiClient.list.setListData(vector2);	//���� ä�ù���� ��� ����Ʈ�� �ֱ�
						
						//���̺��� �ο���
						for(int j=0;j<guimain.model.getRowCount();j++) {
							System.out.println("guimain.model.getValueAt(j, 0) : "+guimain.model.getValueAt(j, 0));
							System.out.println("tmp : "+ tmp);
							if(guimain.model.getValueAt(j, 0).toString().equals(tmp)) {	
								System.out.println("����� vector2 : "+vector2);
								System.out.println("����� vector2.size : "+vector2.size());
								guimain.model.setValueAt(vector2.size(), j, 2);
							}
						}
						
					}else{
						System.out.println("go�� �޶�޶�@@");
					}
					
					
				} else if(data.startsWith("exit")) {
					Vector<String> vector2 = new Vector<String>();
					StringTokenizer token = new StringTokenizer(data.substring(5),"|");
					String tmp=token.nextToken();	// �� ��ȣ
					String tmp2 = null;
					
					while(token.hasMoreTokens()) {
						tmp2 = token.nextToken(); // ID

						vector2.add(tmp2);
					}
					
					//���̺��� �ο���
					for(int j=0;j<guimain.model.getRowCount();j++) {
						
						if(guimain.model.getValueAt(j, 0).toString().equals(tmp)) {
							int count = vector2.size();
							guimain.model.setValueAt(vector2.size(), j, 2);
							guiClient.su.setText(count+"��");
							guiClient.list.setListData(vector2);
								
						}
					}
					
				}else if(data.startsWith("del")) {
					
					StringTokenizer token = new StringTokenizer(data.substring(4),"|");
					String tmp=token.nextToken();	// �� ��ȣ
					
					guimain.model.removeRow(Integer.parseInt(tmp)-1);

					//������ ���ȣ�� �ٸ� ���ȣ���� ������
					if(Integer.parseInt(tmp) < Integer.parseInt(guimain.roomNum)) { 
						//���ȣ�� �ϳ��� �ٿ��ش�.
						guimain.roomNum = (Integer.parseInt(guimain.roomNum) - 1) + "";	
						guiClient.Number = guimain.roomNum;
					}
					
					//	 JTable �� ��ȣ ����
					if(guimain.model.getRowCount() != 0) {
						for(int i=0;i<guimain.model.getRowCount();i++) {
							guimain.model.setValueAt(i+1, i, 0); // ����
							
							// ���� 2���� �� �մ�. �׷��� 1���� ������� ���� �� ���� 1������ �����ؾߵȴ�.
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
