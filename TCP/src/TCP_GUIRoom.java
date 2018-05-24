
/**
 * TCP_GUIRoom.java
 * 채팅방을 만들었을때 방을 담는 공간.
 * 1.채팅방 번호
 * 2.방이름을 담는다.
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
