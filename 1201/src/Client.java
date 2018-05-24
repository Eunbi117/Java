import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;

class ChatView extends Frame{

 

 TextArea ta = new TextArea();

 TextField tf = new TextField();

 Button []btn = new Button[2];

 String btnName[] ={"Imoticon", "Whisper"};

 

 Panel imoticon = new Panel();

 String []imoticonName = {" :p  ","/ 0 /"," ^_^ "," *_* "};

 Button [] imoticonBtn = new Button[4];

 

 Panel whisper = new Panel();

 Panel backy = new Panel();

 

 String whisperFlag = "";

 String whisperId ="";

 

 HashMap<String, String> members;

 Checkbox []memCheck;

 

 boolean firstFlag = false;

 

 ChatView(HashMap<String, String>members, Checkbox[]memCheck){ 

  this.members = members;

  this.memCheck = memCheck;

  

  setBounds(0,0,520,600);

  setLayout(new FlowLayout(FlowLayout.LEFT));

  ta.setPreferredSize(new Dimension(500,400));

  tf.setPreferredSize(new Dimension(300,40));

  add(ta);

  ta.setEditable(false);

  add(tf);

  

  for(int i=0; i<btn.length; i++){

   btn[i]= new Button(btnName[i]);

   btn[i].setEnabled(false);

   btn[i].setPreferredSize(new Dimension(98,40)); //width 88 for Windows, width 98 for Mac 

   add(btn[i]);

  }

  

  add(whisper);

  add(imoticon);

 

  setVisible(true);

  

  this.addWindowListener(new WindowAdapter(){

   public void windowClosing(WindowEvent e){

    System.exit(0);

   }

  });

 }

}

 

class Sender extends Thread implements ActionListener{

 

 Socket socket;

 DataOutputStream out;

 String name;

 ChatView cv;

 

 Sender(Socket socket, ChatView cv){

  this.socket = socket;

  this.cv = cv;

  try{

   out = new DataOutputStream(socket.getOutputStream());

  }catch(Exception e){  

  }

 }

 

 public void run(){

  //ä�� ���� ���� 

  cv.tf.addActionListener(this);

  

  //�̸�Ƽ�� / �ӼӸ� ���� ��ư

  for(int i=0; i<cv.btn.length; i++){

      cv.btn[i].setActionCommand(cv.btnName[i]);

   cv.btn[i].addActionListener(this);

  }  

 }

 

 

 @Override

 public void actionPerformed(ActionEvent e) {

  try{

  if(!cv.tf.getText().equals("")){

   String WhisperMem="";

   String msg ="";

 

   //ó�� ���̵� ����� ��, FirstFlag�� �̸�Ƽ�� ��ư�� �ӼӸ� ��ư�� ��ȿȭ��Ų��. 

   if(cv.firstFlag==false){

    this.name=cv.tf.getText();

    cv.ta.append(cv.tf.getText()+"�� ȯ���մϴ�.\n");

    cv.firstFlag=true;

    

    for(int i=0; i<cv.btn.length;i++){

     cv.btn[i].setEnabled(true);

    }

   }

   

   //�ӼӸ� ����� �Ѹ��� �����ϴ�. ���� �ӼӸ� ���� ����� �������� ���ߴ�. 

   //���� �ӼӸ� ���� �ӼӸ��� ����ϴ� whisperId�� whisperFlag�� �ӼӸ� ����ڸ� �������� ������ �Ѵ�. 

   for(int i=0; i<cv.memCheck.length;i++){

     if(cv.memCheck[i].getLabel().equals(cv.whisperId)&&cv.whisperFlag.equals("true")){

      System.out.println("whispering : "+cv.whisperId);

      WhisperMem ="�ͼӸ�("+cv.whisperId+","+this.name+")";

     }

       }   

   msg= cv.tf.getText();

   

   //�ӼӸ��� ���� 

   if(!WhisperMem.equals("")){

    out.writeUTF(WhisperMem+" : "+msg);

   //�Ϲ� ����  

   }else{

    out.writeUTF(msg);

   }

   //�Է»��� �ʱ�ȭ

   cv.tf.setText("");

   cv.tf.setFocusable(true);

  }

  }catch(Exception e2){}

    

  //��ư �Է� ���� �� 

  String cmd = e.getActionCommand();

  

  //�̸�Ƽ�� ��ư 

  if(cmd.equals("Imoticon")){

   for(int i=0; i<cv.memCheck.length; i++){

     cv.memCheck[i].setState(false);

   }   

   cv.whisper.setVisible(false);

   cv.imoticon.setSize(500,100);

 

   for(int i=0; i<cv.imoticonName.length; i++){

    imoticonPanel(cv.imoticonBtn[i],cv.imoticonName[i], i);

   }

   cv.imoticon.setVisible(true);

   }

  

  for(int i=0; i<cv.imoticonBtn.length; i++){

  if(cmd.equals(cv.imoticonName[i])){

   try {

    

    out.writeUTF(cv.imoticonName[i]);

   } catch (IOException e1) {

    // TODO Auto-generated catch block

    e1.printStackTrace();

   }

   }

  }

  

  //�ӼӸ� ��ư 

  if(cmd.equals("Whisper")){

   cv.members.clear(); //�ӼӸ��� �����ϴ� ����ο��� ���� Client�� HashMap���� �����ߴ�. 

 

   cv.whisper.removeAll();

   System.out.println(cv.members);

   for(int i=0; i<cv.memCheck.length; i++){

    cv.memCheck[i].setState(false);

   }   

   

   cv.imoticon.setVisible(false);

   cv.whisper.setSize(500,100);

   cv.whisper.setLayout(null);

   

   try{

   out.writeUTF("getWhisperMem");

   sleep(1000);

   }catch(Exception e2){

   }

   

   this.cv.memCheck = new Checkbox[cv.members.size()];

   Iterator<String> it = cv.members.keySet().iterator();

   

   for(int i=0; i<cv.members.size(); i++){ 

    String client = it.next();

    cv.memCheck[i] = new Checkbox(client);

    cv.memCheck[i].setBounds(10+(i*100),10,100,30);

    cv.memCheck[i].addItemListener(new ItemListener(){

 

     //Checkbox�� Frame���ΰ�ħ���� ���� ���� �۵��Ϸ��� ItemListener�� ����ؾ� �Ѵ�. 

     public void itemStateChanged(ItemEvent e) {

      String temp;

      int subString_first;

      int subString_last;

      

      temp=e.getItemSelectable().toString();

      subString_first = temp.lastIndexOf("state=");

      subString_last = temp.lastIndexOf("]");

      cv.whisperFlag = temp.substring(subString_first+6, subString_last);

 

      subString_first = temp.lastIndexOf("label=");

      subString_last= temp.lastIndexOf(",state");

      cv.whisperId=temp.substring(subString_first+6,subString_last);      

      

      for(int i=0; i<cv.memCheck.length; i++){

       if(!cv.memCheck[i].getLabel().equals(cv.whisperId)){

        cv.memCheck[i].setState(false);

       }

      }      

     }

    });

    cv.whisper.add(cv.memCheck[i]);

   }

   cv.whisper.setVisible(true);

  } 

 }

 

 

 private void imoticonPanel(Button btn, String name, int i) {

  btn = new Button(name);

  btn.setBounds(10+(i*100), 10, 100, 80);

  btn.setActionCommand(name);

  btn.addActionListener(this);

  cv.imoticon.add(btn);

 }

}

 

 

class Receiver extends Thread{

 Socket socket;

 DataInputStream in;

 ChatView cv;

 

 public Receiver(Socket socket, ChatView cv){

  this.socket = socket;

  this.cv = cv;

  try{

  in = new DataInputStream(socket.getInputStream());

  }catch(Exception e){}

 }

 

 public void run(){

  while(in!=null){

   try{

    //�ӼӸ� ��� �ο����� ������ �޴� ��ư 

    String msg = in.readUTF();    

    if(msg.substring(0, 2).equals("�մ�")){

     cv.members.put(msg.substring(3), msg.substring(3));

    }else{

     cv.ta.append(msg+"\n");    

    }

   }catch(Exception e){}

  }

 } 

}

 

 

public class Client {

 

 public static void main(String [] args) throws Exception{

  HashMap<String, String> members = new HashMap<String, String>();

  Checkbox[] chkBox = new Checkbox[members.size()];

  

  ChatView cv = new ChatView(members, chkBox);

  Socket client = new Socket("localhost",7777);

  cv.ta.setText("ȯ���մϴ�. ���� ����ä���� ���ؼ� HashMap�� ���� Key�� ����ؾ� �ϴ�\nKey���� �Է����ֽʽÿ�.\n");

  

  Sender ss = new Sender(client, cv);

  Receiver rr = new Receiver(client, cv);

 

  rr.start();

  ss.start();

 }

}

