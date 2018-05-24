import javax.swing.JFrame;
import javax.swing.JToolBar;

//import GraphicsDrawImageEx3.MyPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main extends JFrame {
	Container c = getContentPane();
	
	public Main() {
		setVisible(true);
		setSize(400, 400);

		// MyPanel panel = new MyPanel();
		// contentPane.add(panel, BorderLayout.CENTER);

		// c.add(imageIcon);
		// Container c = getContentPane();
		 ImageIcon cherryIcon = new ImageIcon("images/image01.png");
		 JCheckBox cherry = new JCheckBox(cherryIcon);
		//c.add(cherryIcon);
		//
		JButton btnNewButton = new JButton("스터디등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// cherryIcon = true;
				// JFrame f = new JFrame("Cal");
				// c.setLayout(new FlowLayout());
				// // and beside it, the current month.
				c.add(new Cal());

				JLabel lblNewLabe2 = new JLabel("(원하는 날짜를선택해주세요~!!)");
				getContentPane().add(lblNewLabe2);
				// lblNewLabel.setFont(new Font("돋움체",Font.BOLD,15));
				lblNewLabe2.setFont(new Font("돋움체", Font.BOLD, 13));
				lblNewLabe2.setForeground(Color.MAGENTA);

				pack();
				setVisible(true);
				setSize(400, 400);
			}
		});

		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("출석현황");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabe3 = new JLabel("(원하시는 버튼을 눌러주세요↑↑)");
		getContentPane().add(lblNewLabe3);
		lblNewLabe3.setFont(new Font("돋움체", Font.BOLD, 13));
		JLabel lblNewLabel = new JLabel("*안녕하세요! 스터디예약프로그램입니다.*");
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("돋움체", Font.BOLD, 15));

		
	}
	/////////////////////////////////////////////////////////////////////////

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
