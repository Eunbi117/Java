import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Enroll_Test extends JFrame {



   public Enroll_Test() {
      Container c = getContentPane();
      JTextField[] jtf_2_13 = new JTextField[12];

      c.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
      c.add(new JLabel("*���͵���*"));

      JPanel panel = new JPanel();
      c.add(panel);
      panel.setLayout(new GridLayout(5, 4, 0, 0));

      panel.add(new JLabel("���͵� ����"));

      JComboBox stdComboBox = new JComboBox(new String[] {"����","CIS","STUDY_1","STUDY_2","STUDY_3" });
      panel.add(stdComboBox);

      panel.add(new JLabel("�� ���̵�"));

      JTextField idText = new JTextField(10);
      panel.add(idText);

      panel.add(new JLabel("�� ��й�ȣ"));

      JPasswordField pwText = new JPasswordField(10);
      panel.add(pwText);
      pwText.getPassword();
      panel.add(new JLabel("�ο� ��"));

      JComboBox studentComboBox = new JComboBox(new String[] { "����", "2", "3", "4", "5", "6" });
      panel.add(studentComboBox);

      JLabel btnNewButton3 = new JLabel("");
      JButton btnNewButton2 = new JButton("�ߺ�üũ");
      btnNewButton2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "��밡���� ���̵� �Դϴ�.");
            //setVisible(false);

         }
      });
      panel.add(btnNewButton3);
      panel.add(btnNewButton2);
      
      
      
      JPanel panel_1 = new JPanel();
      panel_1.setLayout(new GridLayout(0, 2, 0, 0));
      c.add(new JLabel("*���� ���*"));
      c.add(panel_1);

      panel_1.add(new JLabel("�̸�"));

      panel_1.add(new JLabel("�й�"));

      studentComboBox.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e){
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

      JButton btnNewButton = new JButton("����ϱ�2");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
            setVisible(false);

         }
      });
      c.add(btnNewButton);

      
      setVisible(true);
      setSize(300, 550);
   }


} //class