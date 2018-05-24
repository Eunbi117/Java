
import javax.swing.JFrame;
import java.util.ArrayList;//사람들의 정보를 저장하고 불러오기 위해서 사용
import java.util.Scanner;//스캐너 사용
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

public class 전화번호부 extends JFrame {

	JLabel 이름라벨 = new JLabel("이름");
	JLabel 전화번호라벨 = new JLabel("전화번호");
	JLabel 주소라벨 = new JLabel("주소");
	JLabel 검색_이름라벨 = new JLabel("이름");
	JLabel 삭제_번호라벨 = new JLabel("번호");
	JButton 등록_확인버튼 = new JButton("확인");
	JButton 검색_확인버튼 = new JButton("확인");
	JButton 삭제_확인버튼 = new JButton("확인");

	private JTextField 이름입력텍스트 = new JTextField();
	private JTextField 전화번호입력텍스트 = new JTextField();
	private JTextField 주소입력라벨 = new JTextField();
	private JTextField 검색_이름텍스트 = new JTextField();
	private JTextField 삭제_번호텍스트 = new JTextField();

	JButton 등록버튼 = new JButton("등록");
	JButton 검색버튼 = new JButton("검색");
	JButton 삭제버튼 = new JButton("삭제");
	JButton 출력버튼 = new JButton("출력");

	public 전화번호부() {
		setTitle("전화번호부");
		getContentPane().setLayout(null);

		등록버튼.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// 등록버튼 마우스 클릭 이벤트(등록버튼을
														// 눌렀을 경우 나타나는 이벤트)

				// 이전 창의 내용이 적혀있는 경우
				if (!검색_이름텍스트.getText().equals("") || !삭제_번호텍스트.getText().equals("")) {
					// alert창 띄우기
					// 이전 창에 뭔가 적혀있을 경우 다른 창으로 넘어갈 수 없고
					// 다 비우거나 확인버튼을 누른 후 넘어갈 수 있다
					JOptionPane.showMessageDialog(null, "값을 지워야지 이동 가능", "alert", JOptionPane.WARNING_MESSAGE);

				} 
				else {

					이름라벨.setBounds(139, 74, 57, 15);
					getContentPane().add(이름라벨);
					이름라벨.setVisible(true);

					전화번호라벨.setBounds(139, 107, 57, 15);
					getContentPane().add(전화번호라벨);
					전화번호라벨.setVisible(true);

					주소라벨.setBounds(139, 142, 57, 15);
					getContentPane().add(주소라벨);
					주소라벨.setVisible(true);

					이름입력텍스트.setBounds(174, 71, 116, 21);
					getContentPane().add(이름입력텍스트);
					이름입력텍스트.setColumns(10);
					이름입력텍스트.setText("");
					이름입력텍스트.setVisible(true);

					전화번호입력텍스트.setColumns(10);
					전화번호입력텍스트.setBounds(195, 104, 172, 21);
					전화번호입력텍스트.setText("");
					전화번호입력텍스트.setVisible(true);
					getContentPane().add(전화번호입력텍스트);

					주소입력라벨.setColumns(10);
					주소입력라벨.setBounds(174, 139, 237, 55);
					주소입력라벨.setText("");
					주소입력라벨.setVisible(true);
					getContentPane().add(주소입력라벨);

					등록_확인버튼.setBounds(326, 243, 97, 23);
					getContentPane().add(등록_확인버튼);
					등록_확인버튼.setVisible(true);
					등록_확인버튼.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (!이름입력텍스트.getText().equals("")) {
								String name = 이름입력텍스트.getText();
								String add = 주소입력라벨.getText();
								String phone = 전화번호입력텍스트.getText();

								Person p = new Person(name, add, phone);

								// 넣는 메소드 사용
								try {
									add(p);
								} catch (RepeatException e) {
									e.printStackTrace();
								}

								이름입력텍스트.setText("");
								주소입력라벨.setText("");
								전화번호입력텍스트.setText("");

								repaint();
								setVisible(true);
							}
						}
					});

					repaint();

					if (검색_이름텍스트.getText().equals("")) {
						검색_이름라벨.setVisible(false);
						검색_이름텍스트.setVisible(false);
						검색_확인버튼.setVisible(false);
						repaint();
					}

					if (삭제_번호텍스트.getText().equals("")) {
						삭제_번호라벨.setVisible(false);
						삭제_번호텍스트.setVisible(false);
						삭제_확인버튼.setVisible(false);
						repaint();
					}

				}
			}

		});

		등록버튼.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		등록버튼.setBounds(12, 82, 97, 23);
		getContentPane().add(등록버튼);

		검색버튼.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 검색버튼 클릭(검색버튼을 눌렀을 경우 나타나는
													// 이벤트)
				
				if (!이름입력텍스트.getText().equals("") || !주소입력라벨.getText().equals("") || !전화번호입력텍스트.getText().equals("") || !삭제_번호텍스트.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "값을 지워야지 이동 가능", "alert", JOptionPane.WARNING_MESSAGE);
				}
				else {
					검색_이름라벨.setBounds(144, 107, 57, 15);
					getContentPane().add(검색_이름라벨);
					검색_이름라벨.setVisible(true);
					
					검색_이름텍스트.setBounds(180, 104, 116, 21);
					검색_이름텍스트.setText("");
					getContentPane().add(검색_이름텍스트);
					검색_이름텍스트.setVisible(true);
					검색_이름텍스트.setColumns(10);
					
					검색_확인버튼.setBounds(326, 243, 97, 23);
					getContentPane().add(검색_확인버튼);
					검색_확인버튼.setVisible(true);
					
					검색_확인버튼.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							String searchname = 검색_이름텍스트.getText();
							
							// 검색 메소드 사용
							search(searchname);
							
							검색_이름텍스트.setText("");
							
							repaint();
							setVisible(true);
							
						}
					});
					
					repaint();
					
					if (이름입력텍스트.getText().equals("")) {
						이름라벨.setVisible(false);
						전화번호라벨.setVisible(false);
						주소라벨.setVisible(false);
						이름입력텍스트.setVisible(false);
						전화번호입력텍스트.setVisible(false);
						주소입력라벨.setVisible(false);
						등록_확인버튼.setVisible(false);
						
						repaint();
					}
					
					if (삭제_번호텍스트.getText().equals("")) {
						삭제_번호라벨.setVisible(false);
						삭제_번호텍스트.setVisible(false);
						삭제_확인버튼.setVisible(false);
						
						repaint();
					}
				}

			}
		});
		검색버튼.setBounds(12, 116, 97, 23);
		getContentPane().add(검색버튼);

		삭제버튼.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 삭제버튼 클릭(삭록버튼을 눌렀을 경우 나타나는
													// 이벤트)
				
				if (!이름입력텍스트.getText().equals("") || !주소입력라벨.getText().equals("") || !전화번호입력텍스트.getText().equals("") || !검색_이름텍스트.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "값을 지워야지 이동 가능", "alert", JOptionPane.WARNING_MESSAGE);
				}
				else {
					삭제_번호라벨.setBounds(144, 107, 57, 15);
					getContentPane().add(삭제_번호라벨);
					삭제_번호라벨.setVisible(true);
					
					삭제_번호텍스트.setBounds(178, 104, 57, 21);
					삭제_번호텍스트.setText("");
					삭제_번호텍스트.setVisible(true);
					getContentPane().add(삭제_번호텍스트);
					삭제_번호텍스트.setColumns(10);
					
					삭제_확인버튼.setBounds(326, 243, 97, 23);
					getContentPane().add(삭제_확인버튼);
					삭제_확인버튼.setVisible(true);
					
					삭제_확인버튼.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							String del = 삭제_번호텍스트.getText();
							
							// 삭제 메소드 사용
							del(del);
							
							삭제_번호텍스트.setText("");
							
							repaint();
							setVisible(true);
							
						}
					});
					
					repaint();
					
					if (이름입력텍스트.getText().equals("")) {
						이름라벨.setVisible(false);
						전화번호라벨.setVisible(false);
						주소라벨.setVisible(false);
						이름입력텍스트.setVisible(false);
						전화번호입력텍스트.setVisible(false);
						주소입력라벨.setVisible(false);
						repaint();
					}
					
					if (검색_이름텍스트.getText().equals("")) {
						검색_이름라벨.setVisible(false);
						검색_이름텍스트.setVisible(false);
						검색_확인버튼.setVisible(false);
						repaint();
						
					}
					
				}

			}
		});
		삭제버튼.setBounds(12, 187, 97, 23);
		getContentPane().add(삭제버튼);

		출력버튼.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {// 출력마우스 클릭

				if (이름입력텍스트.getText().equals("")) {
					이름라벨.setVisible(false);
					전화번호라벨.setVisible(false);
					주소라벨.setVisible(false);
					이름입력텍스트.setVisible(false);
					전화번호입력텍스트.setVisible(false);
					주소입력라벨.setVisible(false);
					등록_확인버튼.setVisible(false);
					repaint();
				}

				if (검색_이름텍스트.getText().equals("")) {
					검색_이름라벨.setVisible(false);
					검색_이름텍스트.setVisible(false);
					검색_확인버튼.setVisible(false);
					repaint();
				}

				if (삭제_번호텍스트.getText().equals("")) {
					삭제_번호라벨.setVisible(false);
					삭제_번호텍스트.setVisible(false);
					삭제_확인버튼.setVisible(false);

					repaint();
				}

			}
		});
		출력버튼.setBounds(12, 152, 97, 23);
		getContentPane().add(출력버튼);

		JLabel 전화번호부라벨 = new JLabel("전화번호부");
		전화번호부라벨.setFont(new Font("휴먼모음T", Font.PLAIN, 18));
		전화번호부라벨.setHorizontalTextPosition(SwingConstants.CENTER);
		전화번호부라벨.setHorizontalAlignment(SwingConstants.CENTER);
		전화번호부라벨.setBounds(25, 10, 386, 48);
		getContentPane().add(전화번호부라벨);

		setVisible(true);
		setSize(451, 314);// 창 크기 지정
	}

	static ArrayList<Person> list = new ArrayList<Person>();// 사람들의 정보를
															// ArrayList에 저장하고

	// 번호정보를 저장하기 위한 메소드
	public static void add(Person p1) throws RepeatException {

		list.add(p1);

	}

	public static void repeat(String name) throws RepeatException {

		for (Person s : list) {
			if (s.getp1Name().equals(name))
				throw new RepeatException(name);
		}

	}

	// 번호정보 검색
	public static void search(String search) {

		if (list.size() == 0) {
			System.out.println("저장된 사람이 없습니다.");
		}

		// 확장 for문 사용
		for (Person p1 : list) {

			if (search != null || p1.getp1Name().equals(search)) {
				System.out.println("이름\t전화번호\t\t주소");
				System.out.println(p1.toString());
			} else {
				System.out.println("찾는 사람의 번호가 없습니다.");
			}

		}

	}

	// 번호정보 삭제
	public static void del(String del) {
		
		if (list.size() == 0) {
			System.out.println("저장된 사람이 없습니다.");
		}

		for (int i = 0; i < list.size(); i++) {
			if (del != null && list.get(i).getp1Name().equals(del)) {
				list.remove(i);
				System.out.println("삭제 성공");
			} else {
				System.out.println("찾는 사람의 번호가 없습니다.");
			}
		}

	}

	// 전체 번호정보 출력
	public static void display() {

		if (list != null && list.size() > 0) {

			System.out.println("이름\t전화번호\t\t주소");

			for (Person p1 : list) {
				System.out.println(p1.toString());
			}
		}
	}

	

	// 검색하기 위한 객체를 생성
	public static void main(String[] args) // 메인 메소드
	{
		try // 알기 쉽게 해설한 자바 p.294(예외 처리를 하기 위해 사용)
		{
			전화번호부 info = new 전화번호부();// 학생 정보를 담고 있는 객체를 생성

			Scanner scan = new Scanner(System.in);

			// 메뉴
			while (true) {
				/*
				 * System.out.println("--------두혁이의 전화번호부----------");
				 * 
				 * System.out.println("전체 출력 [1] "); System.out.println(
				 * "번호 추가 [2] "); System.out.println("번호 검색 [3] ");
				 * System.out.println("번호 삭제 [4] "); System.out.println(
				 * "[1~4가 아닌수는 사용 종료]  "); System.out.print("어떤 기능을 사용 하시겠습니까??"
				 * ); String number = scan.nextLine();// number변수 생성
				 * 
				 * if (number != null)// number변수 조건문 { if
				 * (number.equals("1"))// number이 1일 경우 저장되어 있는 정보를 출력한다. {
				 * display(info); } else if (number.equals("2"))// = 2일 경우 정보를
				 * 추가 시킨다. { add(info, scan); } else if (number.equals("3"))// =
				 * 3일 경우 정보를 검색한다. { search(info, scan); } else if
				 * (number.equals("4"))// = 4일 경우 정보를 삭제 시킨다. { del(info, scan);
				 * } else break;// 그 이외의 수가 입력 되면 프로그램 종료 }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

// 사용자 처리 Exception 상속
class RepeatException extends Exception {

	private String name;

	public RepeatException(String name) {

		super("RepeatException 발생  입력값 중복 : " + name);
		this.name = name;

	}

	public String getName() {
		return name;
	}

}

// Person 클래스 생성
class Person {

	// Person 클래스 학생이름, 주소, 전화번호를 선언
	private String p1Name;
	private String p1Juso;
	private String p1Tel;

	// 생성자메소드 선언
	public Person() {
		System.out.println("내용을 입력해주세요.");
	}

	public Person(String p1Name, String p1Juso, String p1Tel)// 생성자 오버로딩
	{
		this.p1Name = p1Name;
		this.p1Juso = p1Juso;
		this.p1Tel = p1Tel;
	}

	// 필드에 대한 적절한 접근자 메소드들
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

	// 학생의 정보를 출력하기 위한 메소드
	public String toString() {
		return this.p1Name + "\t" + this.p1Tel + "\t" + this.p1Juso;
	}
}
