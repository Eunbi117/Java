
/**
 * TCP_GUIMain.java
 * 가장 메인 화면
 * 1.대기실 프레임.
 * 2.소켓연결.
 * 3.닉네임전송
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TCP_GUIMain extends JFrame implements ActionListener {
	
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	JPanel panel = new JPanel();
	private Dimension frameSize, screenSize;
	JButton newRoom = new JButton("방만들기");
	JButton exitB = new JButton("나가기");
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("파일");
	private Menu help = new Menu("도움말");
	private MenuItem fexit = new MenuItem("종료");
	private MenuItem help2 = new MenuItem("도움말");
	private MenuItem ver = new MenuItem("버전");
	
	String name ;
	String newName;
	String roomNum="";
	TCP_GUIClientThread guiClientThread;
	int row=0;
	Calendar time = Calendar.getInstance();	//대기실 접속시간
	
	JTable table;
	JScrollPane sp;
	String[] colName = {"번호","방이름","인원"};
	Object[][] val;
	DefaultTableModel model;
	
	JList<String> Idlist = new JList<String>();
	JList<String> Timelist = new JList<String>();
	
	
	public TCP_GUIMain(){
		super("♠ Chatting Waiting Room ♠");
		screenSizeLocation(); // 모니터 중앙에 프레임 띄우기
		this.setResizable(false); // 창을 띄운 후 사이즈 재조정 금지
		panel.setLayout(null);
		
		this.setMenuBar(mb);	//메뉴바.
		mb.add(file);			//파일.
		mb.add(help);			//도움말
		file.addSeparator();	//구분선  
		file.add(fexit);		//파일의 채팅종료.
		help.add(help2);		//도움말안에 도움말
		help.add(ver);			//도움말의 버전
		
		
		
		try {
			/*** 1. 소켓생성 ***/
			s = new Socket("61.75.199.53",3333);	//IP주소, Port 번호
			
			/*** 2. 스트림 생성 ***/
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));	//읽기 스트림
			pw = new PrintWriter(s.getOutputStream(),true);	//쓰기스트림
			
			/*** 스레드 시작.(채팅) ***/
			guiClientThread = new TCP_GUIClientThread(s,br,pw, this);
			guiClientThread.start();
		
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	
		/*** 테이블 생성.(채팅방 목록). 시작. ***/
		model = new DefaultTableModel(val, colName) {	
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 내용 수정 불가
				return false;
			}
		};
		table = new JTable(model);
		sp = new JScrollPane(table);
		panel.add(sp);
		sp.setBounds(130, 10, 400, 370);
		/*** 테이블 생성.(채팅방 목록). 끝. ***/
		
		
		/*** 마우스 이벤트 리스너 정의 (더블클릭 : 방입장할때) 시작 ***/
		table.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2) { // 더블 클릭
					
					System.out.println("name : " + name);
					
					// 더블 클릭한 곳의 열
					row = table.rowAtPoint(arg0.getPoint());
					
					System.out.println("table.getValueAt(row, 0) : " + table.getValueAt(row, 0).toString());
					
					// table.getValueAt(row, 0) : 이 위치의 값 (내용) - 방번호가됨
					roomNum = table.getValueAt(row, 0).toString();
					System.out.println("roomNum : "+ roomNum);
					
					//서버로 방만들었다는것을 보냄.
					pw.println("go|"+roomNum+"|"+name+"|");
					
				}
			}
		});
		/*** 마우스 이벤트 리스너 정의 (더블클릭 : 방입장할때) 끝  ***/
		
		
		
		/*** 방목록 테이블안의 데이터 가운데 정렬 시작 ***/
		//디폴트테이블셀렌더러를 생성.
		DefaultTableCellRenderer dtor = new DefaultTableCellRenderer();
		//렌더러의 가로정렬을 CENTER로.
		dtor.setHorizontalAlignment(SwingConstants.CENTER);
		//정렬할 테이블의 컬럼모델을 가져옴.
		
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			//컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여 각각의 셀렌더러를 dtor에 설정.
			tcm.getColumn(i).setCellRenderer(dtor);
		}
		/*** 방목록 테이블안의 데이터 가운데 정렬 끝 ***/
		
		
		/*** 테이블 인자를 받아 특정 셀의 크기 및 사이즈변경 불가 설정 시작. ***/
		table.getTableHeader().setReorderingAllowed(false);  //테이블 컬럼의 이동을 방지.
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(260);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		/*** 테이블 인자를 받아 특정 셀의 크기 및 사이즈변경 불가 설정 끝. ***/
		
		/*** 내정보 나타내기 시작 ***/
		
		TitledBorder Idborder = new TitledBorder(new LineBorder(Color.black),"내 대화명");
		JPanel IdPan = new JPanel();
		IdPan.setLayout(null);
		IdPan.setBorder(Idborder);
		IdPan.setBounds(5, 10, 120, 50);
		IdPan.add(Idlist);
		Idlist.setBounds(37, 20, 50, 25);
		
		TitledBorder timeborder = new TitledBorder(new LineBorder(Color.black),"접속 시간");
		JPanel TimePan = new JPanel();
		TimePan.setLayout(null);
		TimePan.setBorder(timeborder);
		TimePan.setBounds(5, 60, 120, 50);
		TimePan.add(Timelist);
		Timelist.setBounds(20, 18, 90, 25);
		
		panel.add(IdPan);
		IdPan.setBackground(Color.white);
		panel.add(TimePan);
		TimePan.setBackground(Color.white);
		/*** 내정보 나타내기 끝 ***/
		
		/*** 방만들기 버튼 시작 ***/
		panel.add(newRoom);
		newRoom.setBounds(10, 310, 110, 30);
		newRoom.addActionListener(this);
		/*** 방만들기 버튼 끝 ***/
		
		
		/*** 나가기 버튼 시작 ***/
		panel.add(exitB);
		exitB.setBounds(10, 345, 110, 30);
		exitB.addActionListener(this);
		/*** 나가기 버튼 끝 ***/
		
		
		/*** 창 설정 시작 ***/
		add(panel);
		setSize(550,430);
		setVisible(true);	//화면에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/***창 설정 끝 ***/
		
		
		/*** 방만들기 버튼 리스너 정의 시작 ***/
		newRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Vector vector = new Vector();
				String roomName = JOptionPane.showInputDialog("채팅방 이름을 입력해주세요.",JOptionPane.INFORMATION_MESSAGE);
				if(roomName != null) { // 확인 누를 시
					roomName = roomName.trim(); // 공백제거
					if(roomName.equals("")) { 
						JOptionPane.showMessageDialog(null, "방 제목을 정확히 입력해주세요.", "Room Name", JOptionPane.INFORMATION_MESSAGE);
					}else {
												
						roomNum = table.getRowCount()+1+"";
						System.out.println("roomNum : " + roomNum);
						pw.println("room|"+roomNum+"|"+roomName+"|");
						pw.println("go|"+roomNum+"|"+name+"|");
						roomNum = roomNum;
						
					} 			
				}
			}
		});
		/*** 방만들기 버튼 리스너 정의 끝 ***/
		
		
		/*** 메뉴의 나가기 리스너 정의 시작 ***/
		fexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "채팅이 종료됩니다.", "종료", JOptionPane.INFORMATION_MESSAGE);
	        	pw.println("exit|"+ name +"|");
	        	System.exit(0);
			}
		});
		/*** 메뉴의 나가기 리스너 정의 끝 ***/
		
		
		/*** 메뉴의 도움말 리스너 정의 시작 ***/
		help2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"* <<< 대기실 도움말 >>>\n"+
						"* 상단왼쪽에는 사용자의 대화명과 대기실에 접속한 시간이 나타납니다.\n" +
						"* 방만들기 버튼을 눌러 채팅 방을 만들수 있습니다.\n" +
						"* 채팅방의 이름을 입력하면 채팅이 시작됩니다.\n" +
						"* 방 목록에서 입장을 원하는 방을 클릭하여 입장할 수있습니다.\n" +
						"* 나가기버튼으로 로그아웃 하거나, 파일의 종료에서 로그아웃 할 수 있습니다.\n",
						"도움말", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/*** 메뉴의 도움말 리스너 정의 끝 ***/
			
		
		/*** 메뉴의 버전 리스너 정의 시작 ***/
		ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "* Chatting Program\n * 영산대학교 사이버경찰학과\n * YJ Lee....\n", "version", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/*** 메뉴의 버전 리스너 정의 끝 ***/
		
		
		/*** 나가기 버튼 리스너 정의 시작 ***/
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "채팅이 종료됩니다.", "exit", JOptionPane.INFORMATION_MESSAGE);
				pw.println("exit|"+ name +"|");
				System.exit(0);
			}
		});
		/*** 나가기 버튼 리스너 정의 끝 ***/
	}
	
	public void serverconnection() {
		while(true){
			name = JOptionPane.showInputDialog("대화명을 입력해주세요.",JOptionPane.INFORMATION_MESSAGE);
		
			while (true) {
				if(name != null){	
					name = name.trim(); // 공백제거
					if (name.length()>3) {
						name = JOptionPane.showInputDialog("대화명은 세글자 이내로 입력해주세요.",JOptionPane.INFORMATION_MESSAGE);
					} else if(name.equals("")){
						name = JOptionPane.showInputDialog("대화명을 정확히 입력해주세요.",JOptionPane.INFORMATION_MESSAGE);
					}else{
						break;
					}
				}else{
					System.exit(0);
				}	
			}			
			break;
		}
		
		//서버로 대화명 보냄.
		pw.println(name);
		
	}
	
	
	// 화면 중앙에 Frame 위치
	public void screenSizeLocation() {

		frameSize = getSize(); // 컴포넌트 크기
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 화면의 크기 구하기
		
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		new TCP_GUIMain().serverconnection();
	}
}
