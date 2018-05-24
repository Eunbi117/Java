import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class Login extends JFrame {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:mysql://203.255.177.208:3306/java7";
	String dbId = "java7";
	String dbPw = "test1234";

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

	public Login() {
		JPanel contentPane;
		JTextField textField;
		JPasswordField JPasswordField_1;

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		JLabel lblNewLabel = new JLabel("**로그인을 해주세요!!**");
		lblNewLabel.setFont(new Font("돋움체", Font.BOLD, 17));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 4, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("아이디");
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		panel.add(lblNewLabel_2);

		JPasswordField_1 = new JPasswordField(10);
		panel.add(JPasswordField_1);

		JButton btnNewButton = new JButton("로그인");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// boolean t = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url, dbId, dbPw);
					String sql = "select pwd from member where id = ?";

					// JOptionPane.showMessageDialog(this, "접속완료");
					if (textField.getText().trim().equals("") || JPasswordField_1.getText().trim().equals("")) {
						// t = true;
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.");
						setVisible(true);
					} else {

						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, textField.getText());
						rs = pstmt.executeQuery();
						if (rs.next()) {
							if (rs.getString("pwd").equals(new String(JPasswordField_1.getPassword()))) {
								new Main();
								setVisible(false);
								// break;
							} else {
								// t = true;
								JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.");
							}
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

		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("로그인취소");
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Excute();
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton_1);

		setVisible(true);
		setSize(300, 200);
	}

}
