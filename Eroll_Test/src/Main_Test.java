import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main_Test extends JFrame {
	public Main_Test() {
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("스터디 예약하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CalendarDialog();
			}
		});
		getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("출석 현황");
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("*안녕하세요 스터디 예약 프로그램입니다*");
		getContentPane().add(lblNewLabel);
		
		setVisible(true);
		setSize(500,400);
	}
	

}
