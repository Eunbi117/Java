
/**
 * TCP_GUIRoom.java
 * ä�ù��� ��������� ���� ��� ����.
 * 1.ä�ù� ��ȣ
 * 2.���̸��� ��´�.
 */

import java.util.Vector;


public class TCP_GUIRoom {

	String roomNum;
	String roomName;
	Vector<String> roomId = new Vector<String>();
	
	public TCP_GUIRoom() { }
	
	public TCP_GUIRoom(String room, String name) {
		roomNum = room;
		roomName = name;
	}

}
