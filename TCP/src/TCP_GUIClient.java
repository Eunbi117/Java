
/**
 * TCP_GUIClient.java
 * ä�ù��� ��������� ä��â�� ���.
 * 1.ä��â ������.
 * 2.���� ä��â�����Ѱ͸�..
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
	JButton send = new JButton("����");
	JButton exit = new JButton("������");
	JButton wisper = new JButton("�ӼӸ�");
	JPanel panel = new JPanel();
	private Dimension frameSize, screenSize;
	JLabel label = new JLabel("         ����ڸ��");
	TextField su = new TextField();
	JLabel namelabel = null;
	JLabel namelabel2 = new JLabel("�� ��ȭ�� �����մϴ�.");
	JLabel sulabel = new JLabel("���� ������ �� :");
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
	private Menu file = new Menu("����");
	private Menu help = new Menu("����");
	private MenuItem fsave = new MenuItem("��ȭ ����");
	private MenuItem fexit = new MenuItem("����");
	private MenuItem help2 = new MenuItem("����");
	private MenuItem ver = new MenuItem("����");
	
	public TCP_GUIClient(BufferedReader tmpBr, PrintWriter tmpPw, String tmpname, String roomNum){
		super("�� Chatting Room ��");
		screenSizeLocation(); // ����� �߾ӿ� ������ ����
		this.setResizable(false); // â�� ��� �� ������ ������ ����
		
		br = tmpBr;
		pw = tmpPw;
		Number = roomNum;
		name = tmpname;
		
		textArea.setEditable(false);
		panel.setLayout(null);
		
		this.setMenuBar(mb);	//�޴���.
		mb.add(file);			//�޴��� ����.
		mb.add(help);
		file.add(fsave);		//�޴�(����)�� ��ȭ����.
		file.addSeparator();//���м�  
		file.add(fexit);		//�޴�(����)�� ä������.
		help.add(help2);
		help.add(ver);
		panel.add(jp);	//�Է¹��� �޽����� �ѷ��ִ� ��ȭâ.
		jp.setBounds(5, 30, 400, 300);
		panel.add(label);	//����ڸ�� ���̺�.
		label.setBounds(405, 5, 125, 23);
		panel.add(jp2);		//����� ����Ʈ.
		jp2.setBounds(406, 30, 125, 275);
		panel.add(text);	//���� �Է��ϴ� �ؽ�Ʈ�ʵ�.
		text.setBounds(5, 331, 295, 25);
		text.addActionListener(this);	
		FocusListener focusListener = null;
		text.addFocusListener(focusListener);
		panel.add(send);	//���� ��ư
		send.setBounds(300, 331, 104, 24);
		send.addActionListener(this);
		panel.add(exit);	//������ ��ư
		exit.setBounds(406, 331, 124, 24);
		exit.addActionListener(this);
		panel.add(wisper);	//�ӼӸ�
		wisper.setBounds(406, 305, 124, 24);
		add(panel);

		setSize(550,430);
		setVisible(true);
		text.requestFocus();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter(){ // ä�ù� ����
        	public void windowClosing(WindowEvent e) {
        		pw.println("exit|"+ name +"|");
        	}
    	});
		/////////////////////////////////////////////////////
		
		//���Է� �⺻ �ѱ۷� ����. 
		text.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				InputContext ctx = getInputContext();
				Character.Subset[] subset = {Character.UnicodeBlock.HANGUL_SYLLABLES};
				ctx.setCharacterSubsets(subset);
			}
		});
		
		//�޴��� ��ȭ���� ������ ����
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
		
		// �ӼӸ� ��ư ���� ��
		wisper.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				sayClientId = list.getSelectedValue();
				
				if(sayClientId == null) {
					JOptionPane.showMessageDialog(null, "�ӼӸ��� ID �� �������ּ���.");
				}else if(sayClientId != null && sayMode == false) {
					sayMode = true;
					wisper.setText("�ӼӸ� ����");
					wisper.setForeground(Color.blue);
					text.requestFocus();
				}else if(sayClientId != null && sayMode == true){
					wisper.setText("�ӼӸ�");
					wisper.setForeground(Color.black);
					sayMode = false;
					text.requestFocus();
				}
			}
		});
		
		//�޴��� ������ ������ ����
		fexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "ä���� ����˴ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
	        	pw.println("exit|"+ name +"|");
	        	setVisible(false);
			}
		});
		
		//�޴��� ���� ������ ����
		help2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"* <<< ä�ù� ���� >>>\n"+
						"* �޽����� �Է��Ͽ� ���� ��ȭ�� �� �� �ֽ��ϴ�.\n" +
						"* ����ڸ�Ͽ��� ����ڸ� �����ϰ� �ӼӸ� ��ư�� ������\n" +
						"  ������ ����ڿ��Ը� �޽����� ������ �� �ֽ��ϴ�.\n" +
						"* �ӼӸ������� ������ ����� ��ο��� �޽����� ������ �� �ֽ��ϴ�.\n" +
						"* Ŭ���̾�Ʈ�� �����ϸ� ���ӽð��� ��Ÿ���ϴ�.\n" +
						"* *���� ���� ������ ���� ��Ÿ���ϴ�.\n" +
						"* ������ ��ȭ������ ��ȭ���� ��ȭ�� ������ ������� ��ǻ�Ϳ� ������ ���ֽ��ϴ�.\n" +
						"* ������ ���ᳪ ä��â�� ������ ��ư�� ���� ä���� �����մϴ�.",
						"����", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//�޴��� ���� ������ ����
		ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "* Chatting Program\n * ������б� ���̹������а�\n * YJ Lee....\n", "version", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//��ȭâ�� ������ ��ư ������ ����
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "ä���� ����˴ϴ�.", "exit", JOptionPane.INFORMATION_MESSAGE);
				pw.println("exit|"+ name +"|");
	        	setVisible(false);
			}
		});
	}
	
	
	// ȭ�� �߾ӿ� Frame ��ġ
	public void screenSizeLocation() {

		frameSize = getSize(); // ������Ʈ ũ��
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ���� ũ�� ���ϱ�
		
		// (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
		
	
	//������ ����
	public void actionPerformed(ActionEvent arg0) {
		String data = text.getText();
		if (data.equals("")) {	//�ƹ��͵� �Է����������� ���������� �Ұ�
		}else {
			//���� �ӼӸ��̸� ȥ������ ������
			//..�ƴϸ� ��ο��� ������
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
