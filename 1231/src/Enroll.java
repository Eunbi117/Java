import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Enroll_Test extends JFrame {

	boolean t = false;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:mysql://203.255.177.208:3306/java7";
	String dbId = "java7";
	String dbPw = "test1234";
	// String selectSql = "select * from member"; // Select占쏙옙

	private boolean connect() {
		boolean result = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			// JOptionPane.showMessageDialog(this, "접속완료");
			result = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());

			System.exit(0);
		}
		return result;
	}

	public Enroll_Test() {
		Container c = getContentPane();
		JTextField[] jtf_2_13 = new JTextField[12];
		ArrayList<member> arr = new ArrayList<member>();
		member mem = new member();

		c.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		JLabel study_la = new JLabel("*스터디 등록*");
		c.add(study_la);
		study_la.setFont(new Font("고딕체", Font.BOLD, 20));

		JPanel panel = new JPanel();
		c.add(panel);
		panel.setLayout(new GridLayout(6, 4, 0, 0));

		panel.add(new JLabel("유형선택"));

		JComboBox stdComboBox = new JComboBox(new String[] { "선택", "CIS", "STUDY_1", "STUDY_2", "STUDY_3" });
		panel.add(stdComboBox);

		panel.add(new JLabel("팀아이디"));

		JTextField idText = new JTextField(10);
		panel.add(idText);

		panel.add(new JLabel("팀 비번"));

		JPasswordField pwText = new JPasswordField(10);
		panel.add(pwText);
		pwText.getPassword();

		panel.add(new JLabel("조장이메일"));

		JTextField emailText = new JTextField(10);
		panel.add(emailText);

		panel.add(new JLabel("인원수"));

		JComboBox studentComboBox = new JComboBox(new String[] { "선택", "2", "3", "4", "5", "6" });
		panel.add(studentComboBox);

		JLabel btnNewButton3 = new JLabel("");
		JButton btnNewButton2 = new JButton("중복확인");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url, dbId, dbPw);
					String sql = "select id from member";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);
					// JOptionPane.showMessageDialog(this, "접속완료");
					if (idText.getText().trim().equals("")) {
						//t = true;
						JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.");
					} else {
						while (rs.next()) {
							if (rs.getString("id").equals(idText.getText())) {
								// JOptionPane.showMessageDialog(null, "이미사용중인
								// 아이디입니다.");
								t = false;
								break;
							} else {
								t = true;
								// JOptionPane.showMessageDialog(null, "사용가능한
								// 아이디입니다.");
							}
						}
						if (t) {
							JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						} else {
							JOptionPane.showMessageDialog(null, "이미사용중인 아이디입니다.");
						}
					}
				} catch (ClassNotFoundException e1) {
					System.out.println("클래스 못찾음");
				} catch (SQLException e1) {
					System.out.println("디비연결에러");
				}
				// setVisible(false);

			}
		});
		panel.add(btnNewButton3);
		panel.add(btnNewButton2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel enroll_la = new JLabel("*팀원 등록*");
		c.add(enroll_la);
		enroll_la.setFont(new Font("고딕체", Font.BOLD, 20));
		c.add(panel_1);

		panel_1.add(new JLabel("이름"));

		panel_1.add(new JLabel("학번"));

		studentComboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (studentComboBox.getSelectedItem().toString().equals("2")) {
					for (int i = 0; i < 4; i++) {
						jtf_2_13[i].setVisible(true);
					}
					for (int i = 4; i < 12; i++) {
						jtf_2_13[i].setVisible(false);
					} // for
				} // if

				else if (studentComboBox.getSelectedItem().toString().equals("3")) {
					for (int i = 0; i < 6; i++) {
						jtf_2_13[i].setVisible(true);
					} // for

					for (int i = 6; i < 12; i++) {
						jtf_2_13[i].setVisible(false);
					} // for

				} else if (studentComboBox.getSelectedItem().toString().equals("4")) {
					for (int i = 0; i < 8; i++) {
						jtf_2_13[i].setVisible(true);
					}

					for (int i = 8; i < 12; i++) {
						jtf_2_13[i].setVisible(false);
					} // for
				} else if (studentComboBox.getSelectedItem().toString().equals("5")) {

					for (int i = 0; i < 10; i++) {
						jtf_2_13[i].setVisible(true);
					}

					for (int i = 10; i < 12; i++) {
						jtf_2_13[i].setVisible(false);
					} // for
				} else if (studentComboBox.getSelectedItem().toString().equals("6")) {
					for (int i = 0; i < 12; i++) {
						jtf_2_13[i].setVisible(true);
					}

				} // else if

			}
		});

		for (int i = 0; i < 12; i++) {
			jtf_2_13[i] = new JTextField(10);
			panel_1.add(jtf_2_13[i]);
		} // for

		JButton btnNewButton = new JButton("등록하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (t == false) {
					JOptionPane.showMessageDialog(null, "중복확인을 해주세요!");
				} else {
					// setVisible(false);

					JOptionPane.showMessageDialog(null, "등록되었습니다.");

					if (connect()) {
						String insertSql = "insert member(type, id, pwd, email, peoplenum, name1, studentnum1, name2, studentnum2, name3, studentnum3, name4, studentnum4, name5, studentnum5, name6, studentnum6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

						try {
							pstmt = conn.prepareStatement(insertSql);

							String type = stdComboBox.getSelectedItem().toString();
							String id = idText.getText();
							String pwd = new String(pwText.getPassword());
							String email = emailText.getText();
							String people = studentComboBox.getSelectedItem().toString();

							int cnt = 0;
							String[] name = new String[6];
							int[] studentnum = new int[6];
							for (int i = 0; i < 12; i += 2) {
								if (jtf_2_13[i].getText().trim().equals("")) {
									// name[i] = null;
									// studentnum[i+1] = 0;
									// System.out.println(name[i]);
								} else {
									name[i / 2] = jtf_2_13[i].getText();
									studentnum[i / 2] = Integer.parseInt(jtf_2_13[i + 1].getText());
									++cnt;
									System.out.println(cnt);
									// System.out.println(name[i]);
								}
							}
							////////////////////////////////////////////////////
							String name1 = jtf_2_13[0].getText();
							int studentnum1 = Integer.parseInt(jtf_2_13[1].getText());
							String name2 = jtf_2_13[2].getText();
							int studentnum2 = Integer.parseInt(jtf_2_13[3].getText());
							String name3 = jtf_2_13[4].getText();
							int studentnum3 = 0;
							String name4 = jtf_2_13[6].getText();
							int studentnum4 = 0;
							String name5 = jtf_2_13[8].getText();
							int studentnum5 = 0;
							String name6 = jtf_2_13[10].getText();
							int studentnum6 = 0;

							pstmt.setString(1, type);
							pstmt.setString(2, id);
							pstmt.setString(3, pwd);
							pstmt.setString(4, email);
							pstmt.setString(5, people);
							pstmt.setString(6, name[0]);
							pstmt.setInt(7, studentnum[0]);
							pstmt.setString(8, name[1]);
							pstmt.setInt(9, studentnum[1]);

							for (int i = 0; i < cnt - 2; i++) {
								pstmt.setString(10 + i * 2, name[i + 2]);
								pstmt.setInt(11 + i * 2, studentnum[i + 2]);
							}

							// if (jtf_2_13[cnt *
							// 2].getText().trim().equals("")) {
							for (int i = 0; i < (6 - cnt) * 2; i += 2) {
								pstmt.setNull(cnt * 2 + 6 + i, Types.VARCHAR);
								pstmt.setNull(cnt * 2 + 7 + i, Types.INTEGER);
								System.out.println(cnt * 2 + 6);
							}

							pstmt.executeUpdate();

						} catch (SQLException e1) {
							e1.printStackTrace();

						}

					}

					setVisible(false);

				}
			}
		});
		c.add(btnNewButton);

		setVisible(true);
		setSize(300, 580);
	}

} // class