
/**
 * TCP_GUIClient.java
 * 채팅방을 만들었을때 채팅창을 담당.
 * 1.채팅창 프레임.
 * 2.오직 채팅창에관한것만..
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TCP_GUIClient extends JFrame implements ActionListener{
	
	String data = null;
	JTextArea textArea = new JTextArea();
	JList<String> list = new JList<>();
	JScrollPane jp = new JScrollPane(textArea);
	JScrollPane jp2 = new JScrollPane(list);
	JTextField text = new JTextField();
	JButton send = new JButton("전송");
	JButton exit = new JButton("나가기");
	JButton wisper = new JButton("귓속말");
	JPanel panel = new JPanel();
	private Dimension frameSize, screenSize;
	JLabel label = new JLabel("         사용자목록");
	TextField su = new TextField();
	JLabel namelabel = null;
	JLabel namelabel2 = new JLabel("님 대화를 시작합니다.");
	JLabel sulabel = new JLabel("현재 접속자 수 :");
	JLabel mesLabel;
	String save_message=null;
	static public JFileChooser chooser = new JFileChooser();
	String name="";
	String Number;
	String sayClientId=null;
	boolean sayMode=false;
	
	TCP_GUIServer ss;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	BufferedWriter bw;
	
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("파일");
	private Menu help = new Menu("도움말");
	private MenuItem fsave = new MenuItem("대화 저장");
	private MenuItem fexit = new MenuItem("종료");
	private MenuItem help2 = new MenuItem("도움말");
	private MenuItem ver = new MenuItem("버전");
	
	public TCP_GUIClient(BufferedReader tmpBr, PrintWriter tmpPw, String tmpname, String roomNum){
		super("♤ Chatting Room ♤");
		screenSizeLocation(); // 모니터 중앙에 프레임 띄우기
		this.setResizable(false); // 창을 띄운 후 사이즈 재조정 금지
		
		br = tmpBr;
		pw = tmpPw;
		Number = roomNum;
		name = tmpname;
		
		textArea.setEditable(false);
		panel.setLayout(null);
		
		this.setMenuBar(mb);	//메뉴바.
		mb.add(file);			//메뉴의 파일.
		mb.add(help);
		file.add(fsave);		//메뉴(파일)의 대화저장.
		file.addSeparator();//구분선  
		file.add(fexit);		//메뉴(파일)의 채팅종료.
		help.add(help2);
		help.add(ver);
		panel.add(jp);	//입력받은 메시지를 뿌려주는 대화창.
		jp.setBounds(5, 30, 400, 300);
		panel.add(label);	//사용자목록 레이블.
		label.setBounds(405, 5, 125, 23);
		panel.add(jp2);		//사용자 리스트.
		jp2.setBounds(406, 30, 125, 275);
		panel.add(text);	//글을 입력하는 텍스트필드.
		text.setBounds(5, 331, 295, 25);
		text.addActionListener(this);	
		FocusListener focusListener = null;
		text.addFocusListener(focusListener);
		panel.add(send);	//전송 버튼
		send.setBounds(300, 331, 104, 24);
		send.addActionListener(this);
		panel.add(exit);	//나가기 버튼
		exit.setBounds(406, 331, 124, 24);
		exit.addActionListener(this);
		panel.add(wisper);	//귓속말
		wisper.setBounds(406, 305, 124, 24);
		add(panel);

		setSize(550,430);
		setVisible(true);
		text.requestFocus();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter(){ // 채팅방 종료
        	public void windowClosing(WindowEvent e) {
        		pw.println("exit|"+ name +"|");
        	}
    	});
		/////////////////////////////////////////////////////
		
		//글입력 기본 한글로 설정. 
		text.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				InputContext ctx = getInputContext();
				Character.Subset[] subset = {Character.UnicodeBlock.HANGUL_SYLLABLES};
				ctx.setCharacterSubsets(subset);
			}
		});
		
		//메뉴의 대화저장 리스너 정의
		fsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_message = textArea.getText();
				int re = chooser.showSaveDialog(TCP_GUIClient.chooser);
				if(re == JFileChooser.APPROVE_OPTION) {
					File file_open = chooser.getSelectedFile();
					try {
						PrintStream ps = new PrintStream(new File(file_open.toString()));						
						ps.printf(save_message);
						ps.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					};
				}
			}
		});
		
		// 귓속말 버튼 누를 시
		wisper.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				sayClientId = list.getSelectedValue();
				
				if(sayClientId == null) {
					JOptionPane.showMessageDialog(null, "귓속말할 ID 를 선택해주세요.");
				}else if(sayClientId != null && sayMode == false) {
					sayMode = true;
					wisper.setText("귓속말 해제");
					wisper.setForeground(Color.blue);
					text.requestFocus();
				}else if(sayClientId != null && sayMode == true){
					wisper.setText("귓속말");
					wisper.setForeground(Color.black);
					sayMode = false;
					text.requestFocus();
				}
			}
		});
		
		//메뉴의 나가기 리스너 정의
		fexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "채팅이 종료됩니다.", "종료", JOptionPane.INFORMATION_MESSAGE);
	        	pw.println("exit|"+ name +"|");
	        	setVisible(false);
			}
		});
		
		//메뉴의 도움말 리스너 정의
		help2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"* <<< 채팅방 도움말 >>>\n"+
						"* 메시지를 입력하여 상대와 대화를 할 수 있습니다.\n" +
						"* 사용자목록에서 사용자를 선택하고 귓속말 버튼을 누르면\n" +
						"  선택한 사용자에게만 메시지를 전송할 수 있습니다.\n" +
						"* 귓속말해제는 접속한 사용자 모두에게 메시지를 전송할 수 있습니다.\n" +
						"* 클라이언트가 접속하면 접속시간이 나타납니다.\n" +
						"* *명은 현재 접속자 수를 나타냅니다.\n" +
						"* 파일의 대화저장은 대화상대와 대화한 내용을 사용자의 컴퓨터에 저장할 수있습니다.\n" +
						"* 파일의 종료나 채팅창의 나가기 버튼을 눌러 채팅을 종료합니다.",
						"도움말", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//메뉴의 버전 리스너 정의
		ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "* Chatting Program\n * 영산대학교 사이버경찰학과\n * YJ Lee....\n", "version", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//대화창의 나가기 버튼 리스너 정의
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "채팅이 종료됩니다.", "exit", JOptionPane.INFORMATION_MESSAGE);
				pw.println("exit|"+ name +"|");
	        	setVisible(false);
			}
		});
	}
	
	
	// 화면 중앙에 Frame 위치
	public void screenSizeLocation() {

		frameSize = getSize(); // 컴포넌트 크기
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 화면의 크기 구하기
		
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
		
	
	//데이터 전송
	public void actionPerformed(ActionEvent arg0) {
		String data = text.getText();
		if (data.equals("")) {	//아무것도 입력하지않으면 데이터전송 불가
		}else {
			//만얃에 귓속말이면 혼자한테 보내기
			//..아니면 모두에게 보내기
			if (sayMode) {
				pw.println("data|"+data+"|"+sayClientId+"|" + Number + "|");
			} else {
				pw.println("text|"+Number+"|"+data+"|");
			}
			text.setText("");	
			text.requestFocus();
		}
	}

}
