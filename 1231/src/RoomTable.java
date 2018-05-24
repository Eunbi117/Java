import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomTable extends JFrame {

	private JPanel contentPane;

	public RoomTable() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("시간대를확인해주세요!!!");
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel1_1 = new JLabel("*****************************************");
		contentPane.add(lblNewLabel1_1);
		lblNewLabel.setFont(new Font("돋움체",Font.BOLD,15));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("1.  (9:00~10:15)     ");
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("예약");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "예약완료되었습니다.");
				btnNewButton.setEnabled(false);
				//setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("2.  (10:25~11:40)    ");
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("예약");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "예약완료되었습니다.");
				btnNewButton_2.setEnabled(false);
			}
		});
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("3.  (13:30~14:45)    ");
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("예약");
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("4.  (14:55~16:10)    ");
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("예약");
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("5.  (16:20~17:35)    ");
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("예약");
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("6.  (17:45~19:00)    ");
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("예약");
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("7.  (19:10~20:25)    ");
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton_6 = new JButton("예약");
		panel.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("8.  (20:35~21:50)    ");
		panel.add(lblNewLabel_8);
		
		JButton btnNewButton_9 = new JButton("예약");
		panel.add(btnNewButton_9);
		
		
		JButton btnNewButton_7 = new JButton("예약취소하기");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "예약취소되었습니다.");
				btnNewButton.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				//setVisible(false);
			}
		});
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("이메일받기");
		contentPane.add(btnNewButton_8);
		
		setVisible(true);
		setSize(309, 357);
	}

}
