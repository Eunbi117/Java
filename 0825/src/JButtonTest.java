import java.awt.*;
import javax.swing.*;

 

public class JButtonTest extends JFrame {

public JButtonTest() {

  JButton bt1 = new JButton("Hello Swing North");
  JButton bt2 = new JButton("Hello Swing Center");

  Container cp = getContentPane();

 

  // cp.add(bt1, "North");  
  add(bt1, "North");  // 버전업으로 가능
  add(bt2, "Center");
  bt2.setBackground(new Color(255, 0, 0));

 

  setLocation(650, 200);
  setSize(200, 200);
  setVisible(true);

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 

 public static void main(String[] args) {
  JButtonTest jbt = new JButtonTest();
 }
} 


