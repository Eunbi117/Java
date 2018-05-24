import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Excute extends JFrame {
	
	private JPanel contentPane;

	public Excute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// ImageIcon normalIcon = new ImageIcon("images/apple");
		JLabel Label_1 = new JLabel("**스터디 등록**");
		ImageIcon cherryIcon = new ImageIcon("images/en.gif");
		JCheckBox cherry = new JCheckBox(cherryIcon);
		//cherry.setBorderPainted(true);
		contentPane.add(Label_1);
		Label_1.setFont(new Font("고딕체", Font.BOLD, 20));
		Label_1.setForeground(Color.ORANGE);
		contentPane.add(cherry);

		JButton eroll_btn = new JButton("등록하기1");
		eroll_btn.setForeground(Color.MAGENTA);
		// eroll_btn.setBackground(Color.PINK);
		eroll_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Enroll_Test();
			}
		});
		contentPane.add(eroll_btn);

		JButton login_btn = new JButton("로그인하기");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(false);
			}
		});

		contentPane.add(login_btn);
		setSize(340, 430);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Excute();
		
	}

}
