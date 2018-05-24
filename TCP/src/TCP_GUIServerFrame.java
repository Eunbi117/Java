
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class TCP_GUIServerFrame extends JFrame{

	JPanel panel = new JPanel();
	private Dimension frameSize, screenSize;
	JList<String> list = new JList<String>();
	JScrollPane jp = new JScrollPane(list);
	JButton stop = new JButton("서버종료");
	JTextArea textArea = new JTextArea();
	JScrollPane Areajp = new JScrollPane(textArea);
	JPopupMenu jpm = new JPopupMenu("pop");
	JMenuItem jmiexit = new JMenuItem("쪽지보내기");
	
	JTable table;
	JScrollPane jp2;
	String[] colName = {"번호","방이름","인원"};
	String[] colID = {"대화명"};
	String[] colTime = {"대기실 접속시간"};
	Object[][] val;
	DefaultTableModel model;
	TCP_GUIServer guiserver;
	
	int row,listrow;
	String listName;
	boolean out=false;
	String tmp;
	
	public TCP_GUIServerFrame(){
		super("♤ Chatting Server ♤");
		screenSizeLocation(); // 모니터 중앙에 프레임 띄우기
		this.setResizable(false); // 창을 띄운 후 사이즈 재조정 금지
		panel.setLayout(null);
		
		
		panel.add(jp);		//사용자 리스트.
		jp.setBorder(new TitledBorder(new EtchedBorder(),"현재 접속자 목록"));
		jp.setBounds(406, 240, 125, 165);
		
		panel.add(stop);	//서버중지버튼
		stop.setBounds(405, 410, 125, 28);
		
		panel.add(Areajp);	//서버텍스트에리어
		Areajp.setBorder(new TitledBorder(new EtchedBorder(),"### Server ###"));
		textArea.setEditable(false);
		Areajp.setBounds(10, 20, 520, 195);
		
		/*** 테이블 생성.(채팅방 목록). 시작. ***/
		model = new DefaultTableModel(val, colName) {	
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 내용 수정 불가
				return false;
			}
		};
		table = new JTable(model);
		jp2 = new JScrollPane(table);
		panel.add(jp2);
		jp2.setBorder(new TitledBorder(new EtchedBorder(),"채팅방 목록"));
		jp2.setBounds(10, 240, 390, 200);
		/*** 테이블 생성.(채팅방 목록). 끝. ***/
		
		jpm.add(jmiexit);
		panel.add(jpm);
		
		/*** 서버중지 버튼 리스너 정의 시작 ***/
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		/*** 서버중지 버튼 리스너 정의 끝 ***/
		
//		/*** 회원목록 마우스 리스너 정의 시작***/
//		
//		list.addMouseListener(new MouseListener() {
//			public void mouseReleased(MouseEvent arg0) {}
//			public void mousePressed(MouseEvent arg0) {
//				row = list.locationToIndex(arg0.getPoint());
//				listrow = list.getSelectedIndex();
//				if(row == listrow){
//					if (arg0.getModifiers() == arg0.BUTTON3_MASK) {
//						//textArea.append("오른쪽 마슈 클릭했어\n");
//						listName = list.getSelectedValue();
//						textArea.append("선택한 아이디 -> "+listName+"\n");
//						jpm.show(list, arg0.getX(), arg0.getY());
//						
//					}
//				}
//			}
//			public void mouseExited(MouseEvent arg0) {}
//			public void mouseEntered(MouseEvent arg0) {}
//			public void mouseClicked(MouseEvent arg0) {}
//		});
//		/*** 회원목록 마우스 리스너 정의 끝***/
	
//		jmiexit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//			}
//		});
		
		add(panel);
		setSize(550,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	// 화면 중앙에 Frame 위치
	public void screenSizeLocation() {

		frameSize = getSize(); // 컴포넌트 크기
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 화면의 크기 구하기
		
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
	
	public static void main(String[] args) {
		new TCP_GUIServerFrame();
	}

}
