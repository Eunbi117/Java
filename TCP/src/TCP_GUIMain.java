
/**
 * TCP_GUIMain.java
 * ���� ���� ȭ��
 * 1.���� ������.
 * 2.���Ͽ���.
 * 3.�г�������
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
	JButton newRoom = new JButton("�游���");
	JButton exitB = new JButton("������");
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("����");
	private Menu help = new Menu("����");
	private MenuItem fexit = new MenuItem("����");
	private MenuItem help2 = new MenuItem("����");
	private MenuItem ver = new MenuItem("����");
	
	String name ;
	String newName;
	String roomNum="";
	TCP_GUIClientThread guiClientThread;
	int row=0;
	Calendar time = Calendar.getInstance();	//���� ���ӽð�
	
	JTable table;
	JScrollPane sp;
	String[] colName = {"��ȣ","���̸�","�ο�"};
	Object[][] val;
	DefaultTableModel model;
	
	JList<String> Idlist = new JList<String>();
	JList<String> Timelist = new JList<String>();
	
	
	public TCP_GUIMain(){
		super("�� Chatting Waiting Room ��");
		screenSizeLocation(); // ����� �߾ӿ� ������ ����
		this.setResizable(false); // â�� ��� �� ������ ������ ����
		panel.setLayout(null);
		
		this.setMenuBar(mb);	//�޴���.
		mb.add(file);			//����.
		mb.add(help);			//����
		file.addSeparator();	//���м�  
		file.add(fexit);		//������ ä������.
		help.add(help2);		//���򸻾ȿ� ����
		help.add(ver);			//������ ����
		
		
		
		try {
			/*** 1. ���ϻ��� ***/
			s = new Socket("61.75.199.53",3333);	//IP�ּ�, Port ��ȣ
			
			/*** 2. ��Ʈ�� ���� ***/
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));	//�б� ��Ʈ��
			pw = new PrintWriter(s.getOutputStream(),true);	//���⽺Ʈ��
			
			/*** ������ ����.(ä��) ***/
			guiClientThread = new TCP_GUIClientThread(s,br,pw, this);
			guiClientThread.start();
		
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	
		/*** ���̺� ����.(ä�ù� ���). ����. ***/
		model = new DefaultTableModel(val, colName) {	
			public boolean isCellEditable(int rowIndex, int mColIndex) { // ���� ���� �Ұ�
				return false;
			}
		};
		table = new JTable(model);
		sp = new JScrollPane(table);
		panel.add(sp);
		sp.setBounds(130, 10, 400, 370);
		/*** ���̺� ����.(ä�ù� ���). ��. ***/
		
		
		/*** ���콺 �̺�Ʈ ������ ���� (����Ŭ�� : �������Ҷ�) ���� ***/
		table.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2) { // ���� Ŭ��
					
					System.out.println("name : " + name);
					
					// ���� Ŭ���� ���� ��
					row = table.rowAtPoint(arg0.getPoint());
					
					System.out.println("table.getValueAt(row, 0) : " + table.getValueAt(row, 0).toString());
					
					// table.getValueAt(row, 0) : �� ��ġ�� �� (����) - ���ȣ����
					roomNum = table.getValueAt(row, 0).toString();
					System.out.println("roomNum : "+ roomNum);
					
					//������ �游����ٴ°��� ����.
					pw.println("go|"+roomNum+"|"+name+"|");
					
				}
			}
		});
		/*** ���콺 �̺�Ʈ ������ ���� (����Ŭ�� : �������Ҷ�) ��  ***/
		
		
		
		/*** ���� ���̺���� ������ ��� ���� ���� ***/
		//����Ʈ���̺��������� ����.
		DefaultTableCellRenderer dtor = new DefaultTableCellRenderer();
		//�������� ���������� CENTER��.
		dtor.setHorizontalAlignment(SwingConstants.CENTER);
		//������ ���̺��� �÷����� ������.
		
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			//�÷��𵨿��� �÷��� ������ŭ �÷��� ������ for���� �̿��Ͽ� ������ ���������� dtor�� ����.
			tcm.getColumn(i).setCellRenderer(dtor);
		}
		/*** ���� ���̺���� ������ ��� ���� �� ***/
		
		
		/*** ���̺� ���ڸ� �޾� Ư�� ���� ũ�� �� ������� �Ұ� ���� ����. ***/
		table.getTableHeader().setReorderingAllowed(false);  //���̺� �÷��� �̵��� ����.
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(260);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		/*** ���̺� ���ڸ� �޾� Ư�� ���� ũ�� �� ������� �Ұ� ���� ��. ***/
		
		/*** ������ ��Ÿ���� ���� ***/
		
		TitledBorder Idborder = new TitledBorder(new LineBorder(Color.black),"�� ��ȭ��");
		JPanel IdPan = new JPanel();
		IdPan.setLayout(null);
		IdPan.setBorder(Idborder);
		IdPan.setBounds(5, 10, 120, 50);
		IdPan.add(Idlist);
		Idlist.setBounds(37, 20, 50, 25);
		
		TitledBorder timeborder = new TitledBorder(new LineBorder(Color.black),"���� �ð�");
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
		/*** ������ ��Ÿ���� �� ***/
		
		/*** �游��� ��ư ���� ***/
		panel.add(newRoom);
		newRoom.setBounds(10, 310, 110, 30);
		newRoom.addActionListener(this);
		/*** �游��� ��ư �� ***/
		
		
		/*** ������ ��ư ���� ***/
		panel.add(exitB);
		exitB.setBounds(10, 345, 110, 30);
		exitB.addActionListener(this);
		/*** ������ ��ư �� ***/
		
		
		/*** â ���� ���� ***/
		add(panel);
		setSize(550,430);
		setVisible(true);	//ȭ�鿡 ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/***â ���� �� ***/
		
		
		/*** �游��� ��ư ������ ���� ���� ***/
		newRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Vector vector = new Vector();
				String roomName = JOptionPane.showInputDialog("ä�ù� �̸��� �Է����ּ���.",JOptionPane.INFORMATION_MESSAGE);
				if(roomName != null) { // Ȯ�� ���� ��
					roomName = roomName.trim(); // ��������
					if(roomName.equals("")) { 
						JOptionPane.showMessageDialog(null, "�� ������ ��Ȯ�� �Է����ּ���.", "Room Name", JOptionPane.INFORMATION_MESSAGE);
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
		/*** �游��� ��ư ������ ���� �� ***/
		
		
		/*** �޴��� ������ ������ ���� ���� ***/
		fexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "ä���� ����˴ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
	        	pw.println("exit|"+ name +"|");
	        	System.exit(0);
			}
		});
		/*** �޴��� ������ ������ ���� �� ***/
		
		
		/*** �޴��� ���� ������ ���� ���� ***/
		help2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"* <<< ���� ���� >>>\n"+
						"* ��ܿ��ʿ��� ������� ��ȭ��� ���ǿ� ������ �ð��� ��Ÿ���ϴ�.\n" +
						"* �游��� ��ư�� ���� ä�� ���� ����� �ֽ��ϴ�.\n" +
						"* ä�ù��� �̸��� �Է��ϸ� ä���� ���۵˴ϴ�.\n" +
						"* �� ��Ͽ��� ������ ���ϴ� ���� Ŭ���Ͽ� ������ ���ֽ��ϴ�.\n" +
						"* �������ư���� �α׾ƿ� �ϰų�, ������ ���ῡ�� �α׾ƿ� �� �� �ֽ��ϴ�.\n",
						"����", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/*** �޴��� ���� ������ ���� �� ***/
			
		
		/*** �޴��� ���� ������ ���� ���� ***/
		ver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "* Chatting Program\n * ������б� ���̹������а�\n * YJ Lee....\n", "version", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/*** �޴��� ���� ������ ���� �� ***/
		
		
		/*** ������ ��ư ������ ���� ���� ***/
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "ä���� ����˴ϴ�.", "exit", JOptionPane.INFORMATION_MESSAGE);
				pw.println("exit|"+ name +"|");
				System.exit(0);
			}
		});
		/*** ������ ��ư ������ ���� �� ***/
	}
	
	public void serverconnection() {
		while(true){
			name = JOptionPane.showInputDialog("��ȭ���� �Է����ּ���.",JOptionPane.INFORMATION_MESSAGE);
		
			while (true) {
				if(name != null){	
					name = name.trim(); // ��������
					if (name.length()>3) {
						name = JOptionPane.showInputDialog("��ȭ���� ������ �̳��� �Է����ּ���.",JOptionPane.INFORMATION_MESSAGE);
					} else if(name.equals("")){
						name = JOptionPane.showInputDialog("��ȭ���� ��Ȯ�� �Է����ּ���.",JOptionPane.INFORMATION_MESSAGE);
					}else{
						break;
					}
				}else{
					System.exit(0);
				}	
			}			
			break;
		}
		
		//������ ��ȭ�� ����.
		pw.println(name);
		
	}
	
	
	// ȭ�� �߾ӿ� Frame ��ġ
	public void screenSizeLocation() {

		frameSize = getSize(); // ������Ʈ ũ��
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ���� ũ�� ���ϱ�
		
		// (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		new TCP_GUIMain().serverconnection();
	}
}
