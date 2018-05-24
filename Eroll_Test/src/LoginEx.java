import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginEx extends JFrame {

	private JPanel contentPane;
	
	public LoginEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Label_1 = new JLabel("**스터디예약 프로그램**");
		contentPane.add(Label_1);
		
		JButton eroll_btn = new JButton("등록하기1");
		eroll_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Enroll_Test();	
			}
		});
		contentPane.add(eroll_btn);
		
		JButton login_btn = new JButton("로그인하기");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join_Test();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(false);
			}
		});
		
		contentPane.add(login_btn);
	setSize(250,150);
	setVisible(true);
	
	}
	public static void main(String[] args) {
		new LoginEx();
		 JFrame f = new JFrame("Calendar");
	        Container c = f.getContentPane();
	        c.setLayout(new FlowLayout());
	        // for this test driver, hardcode 1995/02/10.
	        //c.add(new Cal(1995, 2 - 1, 10));
	        // and beside it, the current month.
	        CalendarDialog dal = new  CalendarDialog();
	        c.add(dal);
	        
	}
}
