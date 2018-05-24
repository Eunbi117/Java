
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
	JButton stop = new JButton("��������");
	JTextArea textArea = new JTextArea();
	JScrollPane Areajp = new JScrollPane(textArea);
	JPopupMenu jpm = new JPopupMenu("pop");
	JMenuItem jmiexit = new JMenuItem("����������");
	
	JTable table;
	JScrollPane jp2;
	String[] colName = {"��ȣ","���̸�","�ο�"};
	String[] colID = {"��ȭ��"};
	String[] colTime = {"���� ���ӽð�"};
	Object[][] val;
	DefaultTableModel model;
	TCP_GUIServer guiserver;
	
	int row,listrow;
	String listName;
	boolean out=false;
	String tmp;
	
	public TCP_GUIServerFrame(){
		super("�� Chatting Server ��");
		screenSizeLocation(); // ����� �߾ӿ� ������ ����
		this.setResizable(false); // â�� ��� �� ������ ������ ����
		panel.setLayout(null);
		
		
		panel.add(jp);		//����� ����Ʈ.
		jp.setBorder(new TitledBorder(new EtchedBorder(),"���� ������ ���"));
		jp.setBounds(406, 240, 125, 165);
		
		panel.add(stop);	//����������ư
		stop.setBounds(405, 410, 125, 28);
		
		panel.add(Areajp);	//�����ؽ�Ʈ������
		Areajp.setBorder(new TitledBorder(new EtchedBorder(),"### Server ###"));
		textArea.setEditable(false);
		Areajp.setBounds(10, 20, 520, 195);
		
		/*** ���̺� ����.(ä�ù� ���). ����. ***/
		model = new DefaultTableModel(val, colName) {	
			public boolean isCellEditable(int rowIndex, int mColIndex) { // ���� ���� �Ұ�
				return false;
			}
		};
		table = new JTable(model);
		jp2 = new JScrollPane(table);
		panel.add(jp2);
		jp2.setBorder(new TitledBorder(new EtchedBorder(),"ä�ù� ���"));
		jp2.setBounds(10, 240, 390, 200);
		/*** ���̺� ����.(ä�ù� ���). ��. ***/
		
		jpm.add(jmiexit);
		panel.add(jpm);
		
		/*** �������� ��ư ������ ���� ���� ***/
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		/*** �������� ��ư ������ ���� �� ***/
		
//		/*** ȸ����� ���콺 ������ ���� ����***/
//		
//		list.addMouseListener(new MouseListener() {
//			public void mouseReleased(MouseEvent arg0) {}
//			public void mousePressed(MouseEvent arg0) {
//				row = list.locationToIndex(arg0.getPoint());
//				listrow = list.getSelectedIndex();
//				if(row == listrow){
//					if (arg0.getModifiers() == arg0.BUTTON3_MASK) {
//						//textArea.append("������ ���� Ŭ���߾�\n");
//						listName = list.getSelectedValue();
//						textArea.append("������ ���̵� -> "+listName+"\n");
//						jpm.show(list, arg0.getX(), arg0.getY());
//						
//					}
//				}
//			}
//			public void mouseExited(MouseEvent arg0) {}
//			public void mouseEntered(MouseEvent arg0) {}
//			public void mouseClicked(MouseEvent arg0) {}
//		});
//		/*** ȸ����� ���콺 ������ ���� ��***/
	
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
	
	
	
	// ȭ�� �߾ӿ� Frame ��ġ
	public void screenSizeLocation() {

		frameSize = getSize(); // ������Ʈ ũ��
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ���� ũ�� ���ϱ�
		
		// (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
		setLocation((screenSize.width - frameSize.width)/5, (screenSize.height - frameSize.height)/5);
		
	}
	
	public static void main(String[] args) {
		new TCP_GUIServerFrame();
	}

}
