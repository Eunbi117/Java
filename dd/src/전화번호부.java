
import javax.swing.JFrame;
import java.util.ArrayList;//������� ������ �����ϰ� �ҷ����� ���ؼ� ���
import java.util.Scanner;//��ĳ�� ���
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ��ȭ��ȣ�� extends JFrame {

	JLabel �̸��� = new JLabel("�̸�");
	JLabel ��ȭ��ȣ�� = new JLabel("��ȭ��ȣ");
	JLabel �ּҶ� = new JLabel("�ּ�");
	JLabel �˻�_�̸��� = new JLabel("�̸�");
	JLabel ����_��ȣ�� = new JLabel("��ȣ");
	JButton ���_Ȯ�ι�ư = new JButton("Ȯ��");
	JButton �˻�_Ȯ�ι�ư = new JButton("Ȯ��");
	JButton ����_Ȯ�ι�ư = new JButton("Ȯ��");

	private JTextField �̸��Է��ؽ�Ʈ = new JTextField();
	private JTextField ��ȭ��ȣ�Է��ؽ�Ʈ = new JTextField();
	private JTextField �ּ��Է¶� = new JTextField();
	private JTextField �˻�_�̸��ؽ�Ʈ = new JTextField();
	private JTextField ����_��ȣ�ؽ�Ʈ = new JTextField();

	JButton ��Ϲ�ư = new JButton("���");
	JButton �˻���ư = new JButton("�˻�");
	JButton ������ư = new JButton("����");
	JButton ��¹�ư = new JButton("���");

	public ��ȭ��ȣ��() {
		setTitle("��ȭ��ȣ��");
		getContentPane().setLayout(null);

		��Ϲ�ư.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// ��Ϲ�ư ���콺 Ŭ�� �̺�Ʈ(��Ϲ�ư��
														// ������ ��� ��Ÿ���� �̺�Ʈ)

				// ���� â�� ������ �����ִ� ���
				if (!�˻�_�̸��ؽ�Ʈ.getText().equals("") || !����_��ȣ�ؽ�Ʈ.getText().equals("")) {
					// alertâ ����
					// ���� â�� ���� �������� ��� �ٸ� â���� �Ѿ �� ����
					// �� ���ų� Ȯ�ι�ư�� ���� �� �Ѿ �� �ִ�
					JOptionPane.showMessageDialog(null, "���� �������� �̵� ����", "alert", JOptionPane.WARNING_MESSAGE);

				} 
				else {

					�̸���.setBounds(139, 74, 57, 15);
					getContentPane().add(�̸���);
					�̸���.setVisible(true);

					��ȭ��ȣ��.setBounds(139, 107, 57, 15);
					getContentPane().add(��ȭ��ȣ��);
					��ȭ��ȣ��.setVisible(true);

					�ּҶ�.setBounds(139, 142, 57, 15);
					getContentPane().add(�ּҶ�);
					�ּҶ�.setVisible(true);

					�̸��Է��ؽ�Ʈ.setBounds(174, 71, 116, 21);
					getContentPane().add(�̸��Է��ؽ�Ʈ);
					�̸��Է��ؽ�Ʈ.setColumns(10);
					�̸��Է��ؽ�Ʈ.setText("");
					�̸��Է��ؽ�Ʈ.setVisible(true);

					��ȭ��ȣ�Է��ؽ�Ʈ.setColumns(10);
					��ȭ��ȣ�Է��ؽ�Ʈ.setBounds(195, 104, 172, 21);
					��ȭ��ȣ�Է��ؽ�Ʈ.setText("");
					��ȭ��ȣ�Է��ؽ�Ʈ.setVisible(true);
					getContentPane().add(��ȭ��ȣ�Է��ؽ�Ʈ);

					�ּ��Է¶�.setColumns(10);
					�ּ��Է¶�.setBounds(174, 139, 237, 55);
					�ּ��Է¶�.setText("");
					�ּ��Է¶�.setVisible(true);
					getContentPane().add(�ּ��Է¶�);

					���_Ȯ�ι�ư.setBounds(326, 243, 97, 23);
					getContentPane().add(���_Ȯ�ι�ư);
					���_Ȯ�ι�ư.setVisible(true);
					���_Ȯ�ι�ư.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (!�̸��Է��ؽ�Ʈ.getText().equals("")) {
								String name = �̸��Է��ؽ�Ʈ.getText();
								String add = �ּ��Է¶�.getText();
								String phone = ��ȭ��ȣ�Է��ؽ�Ʈ.getText();

								Person p = new Person(name, add, phone);

								// �ִ� �޼ҵ� ���
								try {
									add(p);
								} catch (RepeatException e) {
									e.printStackTrace();
								}

								�̸��Է��ؽ�Ʈ.setText("");
								�ּ��Է¶�.setText("");
								��ȭ��ȣ�Է��ؽ�Ʈ.setText("");

								repaint();
								setVisible(true);
							}
						}
					});

					repaint();

					if (�˻�_�̸��ؽ�Ʈ.getText().equals("")) {
						�˻�_�̸���.setVisible(false);
						�˻�_�̸��ؽ�Ʈ.setVisible(false);
						�˻�_Ȯ�ι�ư.setVisible(false);
						repaint();
					}

					if (����_��ȣ�ؽ�Ʈ.getText().equals("")) {
						����_��ȣ��.setVisible(false);
						����_��ȣ�ؽ�Ʈ.setVisible(false);
						����_Ȯ�ι�ư.setVisible(false);
						repaint();
					}

				}
			}

		});

		��Ϲ�ư.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		��Ϲ�ư.setBounds(12, 82, 97, 23);
		getContentPane().add(��Ϲ�ư);

		�˻���ư.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// �˻���ư Ŭ��(�˻���ư�� ������ ��� ��Ÿ����
													// �̺�Ʈ)
				
				if (!�̸��Է��ؽ�Ʈ.getText().equals("") || !�ּ��Է¶�.getText().equals("") || !��ȭ��ȣ�Է��ؽ�Ʈ.getText().equals("") || !����_��ȣ�ؽ�Ʈ.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���� �������� �̵� ����", "alert", JOptionPane.WARNING_MESSAGE);
				}
				else {
					�˻�_�̸���.setBounds(144, 107, 57, 15);
					getContentPane().add(�˻�_�̸���);
					�˻�_�̸���.setVisible(true);
					
					�˻�_�̸��ؽ�Ʈ.setBounds(180, 104, 116, 21);
					�˻�_�̸��ؽ�Ʈ.setText("");
					getContentPane().add(�˻�_�̸��ؽ�Ʈ);
					�˻�_�̸��ؽ�Ʈ.setVisible(true);
					�˻�_�̸��ؽ�Ʈ.setColumns(10);
					
					�˻�_Ȯ�ι�ư.setBounds(326, 243, 97, 23);
					getContentPane().add(�˻�_Ȯ�ι�ư);
					�˻�_Ȯ�ι�ư.setVisible(true);
					
					�˻�_Ȯ�ι�ư.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							String searchname = �˻�_�̸��ؽ�Ʈ.getText();
							
							// �˻� �޼ҵ� ���
							search(searchname);
							
							�˻�_�̸��ؽ�Ʈ.setText("");
							
							repaint();
							setVisible(true);
							
						}
					});
					
					repaint();
					
					if (�̸��Է��ؽ�Ʈ.getText().equals("")) {
						�̸���.setVisible(false);
						��ȭ��ȣ��.setVisible(false);
						�ּҶ�.setVisible(false);
						�̸��Է��ؽ�Ʈ.setVisible(false);
						��ȭ��ȣ�Է��ؽ�Ʈ.setVisible(false);
						�ּ��Է¶�.setVisible(false);
						���_Ȯ�ι�ư.setVisible(false);
						
						repaint();
					}
					
					if (����_��ȣ�ؽ�Ʈ.getText().equals("")) {
						����_��ȣ��.setVisible(false);
						����_��ȣ�ؽ�Ʈ.setVisible(false);
						����_Ȯ�ι�ư.setVisible(false);
						
						repaint();
					}
				}

			}
		});
		�˻���ư.setBounds(12, 116, 97, 23);
		getContentPane().add(�˻���ư);

		������ư.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// ������ư Ŭ��(��Ϲ�ư�� ������ ��� ��Ÿ����
													// �̺�Ʈ)
				
				if (!�̸��Է��ؽ�Ʈ.getText().equals("") || !�ּ��Է¶�.getText().equals("") || !��ȭ��ȣ�Է��ؽ�Ʈ.getText().equals("") || !�˻�_�̸��ؽ�Ʈ.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���� �������� �̵� ����", "alert", JOptionPane.WARNING_MESSAGE);
				}
				else {
					����_��ȣ��.setBounds(144, 107, 57, 15);
					getContentPane().add(����_��ȣ��);
					����_��ȣ��.setVisible(true);
					
					����_��ȣ�ؽ�Ʈ.setBounds(178, 104, 57, 21);
					����_��ȣ�ؽ�Ʈ.setText("");
					����_��ȣ�ؽ�Ʈ.setVisible(true);
					getContentPane().add(����_��ȣ�ؽ�Ʈ);
					����_��ȣ�ؽ�Ʈ.setColumns(10);
					
					����_Ȯ�ι�ư.setBounds(326, 243, 97, 23);
					getContentPane().add(����_Ȯ�ι�ư);
					����_Ȯ�ι�ư.setVisible(true);
					
					����_Ȯ�ι�ư.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							String del = ����_��ȣ�ؽ�Ʈ.getText();
							
							// ���� �޼ҵ� ���
							del(del);
							
							����_��ȣ�ؽ�Ʈ.setText("");
							
							repaint();
							setVisible(true);
							
						}
					});
					
					repaint();
					
					if (�̸��Է��ؽ�Ʈ.getText().equals("")) {
						�̸���.setVisible(false);
						��ȭ��ȣ��.setVisible(false);
						�ּҶ�.setVisible(false);
						�̸��Է��ؽ�Ʈ.setVisible(false);
						��ȭ��ȣ�Է��ؽ�Ʈ.setVisible(false);
						�ּ��Է¶�.setVisible(false);
						repaint();
					}
					
					if (�˻�_�̸��ؽ�Ʈ.getText().equals("")) {
						�˻�_�̸���.setVisible(false);
						�˻�_�̸��ؽ�Ʈ.setVisible(false);
						�˻�_Ȯ�ι�ư.setVisible(false);
						repaint();
						
					}
					
				}

			}
		});
		������ư.setBounds(12, 187, 97, 23);
		getContentPane().add(������ư);

		��¹�ư.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// ��¸��콺 Ŭ��

				if (�̸��Է��ؽ�Ʈ.getText().equals("")) {
					�̸���.setVisible(false);
					��ȭ��ȣ��.setVisible(false);
					�ּҶ�.setVisible(false);
					�̸��Է��ؽ�Ʈ.setVisible(false);
					��ȭ��ȣ�Է��ؽ�Ʈ.setVisible(false);
					�ּ��Է¶�.setVisible(false);
					���_Ȯ�ι�ư.setVisible(false);
					repaint();
				}

				if (�˻�_�̸��ؽ�Ʈ.getText().equals("")) {
					�˻�_�̸���.setVisible(false);
					�˻�_�̸��ؽ�Ʈ.setVisible(false);
					�˻�_Ȯ�ι�ư.setVisible(false);
					repaint();
				}

				if (����_��ȣ�ؽ�Ʈ.getText().equals("")) {
					����_��ȣ��.setVisible(false);
					����_��ȣ�ؽ�Ʈ.setVisible(false);
					����_Ȯ�ι�ư.setVisible(false);

					repaint();
				}

			}
		});
		��¹�ư.setBounds(12, 152, 97, 23);
		getContentPane().add(��¹�ư);

		JLabel ��ȭ��ȣ�ζ� = new JLabel("��ȭ��ȣ��");
		��ȭ��ȣ�ζ�.setFont(new Font("�޸ո���T", Font.PLAIN, 18));
		��ȭ��ȣ�ζ�.setHorizontalTextPosition(SwingConstants.CENTER);
		��ȭ��ȣ�ζ�.setHorizontalAlignment(SwingConstants.CENTER);
		��ȭ��ȣ�ζ�.setBounds(25, 10, 386, 48);
		getContentPane().add(��ȭ��ȣ�ζ�);

		setVisible(true);
		setSize(451, 314);// â ũ�� ����
	}

	static ArrayList<Person> list = new ArrayList<Person>();// ������� ������
															// ArrayList�� �����ϰ�

	// ��ȣ������ �����ϱ� ���� �޼ҵ�
	public static void add(Person p1) throws RepeatException {

		list.add(p1);

	}

	public static void repeat(String name) throws RepeatException {

		for (Person s : list) {
			if (s.getp1Name().equals(name))
				throw new RepeatException(name);
		}

	}

	// ��ȣ���� �˻�
	public static void search(String search) {

		if (list.size() == 0) {
			System.out.println("����� ����� �����ϴ�.");
		}

		// Ȯ�� for�� ���
		for (Person p1 : list) {

			if (search != null || p1.getp1Name().equals(search)) {
				System.out.println("�̸�\t��ȭ��ȣ\t\t�ּ�");
				System.out.println(p1.toString());
			} else {
				System.out.println("ã�� ����� ��ȣ�� �����ϴ�.");
			}

		}

	}

	// ��ȣ���� ����
	public static void del(String del) {
		
		if (list.size() == 0) {
			System.out.println("����� ����� �����ϴ�.");
		}

		for (int i = 0; i < list.size(); i++) {
			if (del != null && list.get(i).getp1Name().equals(del)) {
				list.remove(i);
				System.out.println("���� ����");
			} else {
				System.out.println("ã�� ����� ��ȣ�� �����ϴ�.");
			}
		}

	}

	// ��ü ��ȣ���� ���
	public static void display() {

		if (list != null && list.size() > 0) {

			System.out.println("�̸�\t��ȭ��ȣ\t\t�ּ�");

			for (Person p1 : list) {
				System.out.println(p1.toString());
			}
		}
	}

	

	// �˻��ϱ� ���� ��ü�� ����
	public static void main(String[] args) // ���� �޼ҵ�
	{
		try // �˱� ���� �ؼ��� �ڹ� p.294(���� ó���� �ϱ� ���� ���)
		{
			��ȭ��ȣ�� info = new ��ȭ��ȣ��();// �л� ������ ��� �ִ� ��ü�� ����

			Scanner scan = new Scanner(System.in);

			// �޴�
			while (true) {
				/*
				 * System.out.println("--------�������� ��ȭ��ȣ��----------");
				 * 
				 * System.out.println("��ü ��� [1] "); System.out.println(
				 * "��ȣ �߰� [2] "); System.out.println("��ȣ �˻� [3] ");
				 * System.out.println("��ȣ ���� [4] "); System.out.println(
				 * "[1~4�� �ƴѼ��� ��� ����]  "); System.out.print("� ����� ��� �Ͻðڽ��ϱ�??"
				 * ); String number = scan.nextLine();// number���� ����
				 * 
				 * if (number != null)// number���� ���ǹ� { if
				 * (number.equals("1"))// number�� 1�� ��� ����Ǿ� �ִ� ������ ����Ѵ�. {
				 * display(info); } else if (number.equals("2"))// = 2�� ��� ������
				 * �߰� ��Ų��. { add(info, scan); } else if (number.equals("3"))// =
				 * 3�� ��� ������ �˻��Ѵ�. { search(info, scan); } else if
				 * (number.equals("4"))// = 4�� ��� ������ ���� ��Ų��. { del(info, scan);
				 * } else break;// �� �̿��� ���� �Է� �Ǹ� ���α׷� ���� }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

// ����� ó�� Exception ���
class RepeatException extends Exception {

	private String name;

	public RepeatException(String name) {

		super("RepeatException �߻�  �Է°� �ߺ� : " + name);
		this.name = name;

	}

	public String getName() {
		return name;
	}

}

// Person Ŭ���� ����
class Person {

	// Person Ŭ���� �л��̸�, �ּ�, ��ȭ��ȣ�� ����
	private String p1Name;
	private String p1Juso;
	private String p1Tel;

	// �����ڸ޼ҵ� ����
	public Person() {
		System.out.println("������ �Է����ּ���.");
	}

	public Person(String p1Name, String p1Juso, String p1Tel)// ������ �����ε�
	{
		this.p1Name = p1Name;
		this.p1Juso = p1Juso;
		this.p1Tel = p1Tel;
	}

	// �ʵ忡 ���� ������ ������ �޼ҵ��
	public String getp1Name() {
		return p1Name;
	}

	public void setp1Name(String p1Name) {
		this.p1Name = p1Name;
	}

	public String getp1Juso() {
		return p1Juso;
	}

	public void setp1Juso(String p1Juso) {
		this.p1Juso = p1Juso;
	}

	public String getp1Tel() {
		return p1Tel;
	}

	public void setp1Tel(String p1Tel) {
		this.p1Tel = p1Tel;
	}

	// �л��� ������ ����ϱ� ���� �޼ҵ�
	public String toString() {
		return this.p1Name + "\t" + this.p1Tel + "\t" + this.p1Juso;
	}
}
