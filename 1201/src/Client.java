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

  //채팅 내용 전송 

  cv.tf.addActionListener(this);

  

  //이모티콘 / 귓속말 전송 버튼

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

 

   //처음 아이디 등록할 때, FirstFlag는 이모티콘 버튼과 귓속말 버튼을 무효화시킨다. 

   if(cv.firstFlag==false){

    this.name=cv.tf.getText();

    cv.ta.append(cv.tf.getText()+"님 환영합니다.\n");

    cv.firstFlag=true;

    

    for(int i=0; i<cv.btn.length;i++){

     cv.btn[i].setEnabled(true);

    }

   }

   

   //귓속말 기능은 한명씩만 가능하다. 다중 귓속말 전송 방식은 구현하지 못했다. 

   //따라서 귓속말 대상과 귓속말을 허용하는 whisperId와 whisperFlag가 귓속말 대상자를 가려내는 역할을 한다. 

   for(int i=0; i<cv.memCheck.length;i++){

     if(cv.memCheck[i].getLabel().equals(cv.whisperId)&&cv.whisperFlag.equals("true")){

      System.out.println("whispering : "+cv.whisperId);

      WhisperMem ="귀속말("+cv.whisperId+","+this.name+")";

     }

       }   

   msg= cv.tf.getText();

   

   //귓속말로 전송 

   if(!WhisperMem.equals("")){

    out.writeUTF(WhisperMem+" : "+msg);

   //일반 전송  

   }else{

    out.writeUTF(msg);

   }

   //입력상태 초기화

   cv.tf.setText("");

   cv.tf.setFocusable(true);

  }

  }catch(Exception e2){}

    

  //버튼 입력 했을 시 

  String cmd = e.getActionCommand();

  

  //이모티콘 버튼 

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

  

  //귓속말 버튼 

  if(cmd.equals("Whisper")){

   cv.members.clear(); //귓속말을 전달하는 대상인원을 개별 Client의 HashMap으로 저장했다. 

 

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

 

     //Checkbox가 Frame새로고침에도 오류 없이 작동하려면 ItemListener를 사용해야 한다. 

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

    //귓속말 대상 인원들의 정보를 받는 버튼 

    String msg = in.readUTF();    

    if(msg.substring(0, 2).equals("손님")){

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

  cv.ta.setText("환영합니다. 먼저 다중채팅을 위해선 HashMap에 고유 Key를 등록해야 하니\nKey값을 입력해주십시오.\n");

  

  Sender ss = new Sender(client, cv);

  Receiver rr = new Receiver(client, cv);

 

  rr.start();

  ss.start();

 }

}

