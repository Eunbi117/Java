import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

public class Server {

   

  HashMap<String, DataOutputStream> clients = new HashMap<String, DataOutputStream>();

  Server(){

   Collections.synchronizedMap(clients);

   try{

   ServerSocket server = new ServerSocket(7777);

   

   while(true){

    Socket client = server.accept();

    ServerReceive th = new ServerReceive(client);

    th.start();

   }

   }catch(Exception e){}

  }

  

  

  class ServerReceive extends Thread{

   Socket socket;

   DataInputStream in;

   DataOutputStream out;

   

   public ServerReceive(Socket socket){

    this.socket = socket;

    

    try{

    in = new DataInputStream(socket.getInputStream());

    out = new DataOutputStream(socket.getOutputStream());

    }catch(Exception e){}

  }

   

   public void run(){

    String name  ="";

    try{

     name = in.readUTF();

     clients.put(name, out);

     

     while(in!=null){

      String msg = in.readUTF();

      String chk="";

      String user="";

      int SubString_first=0;

      int SubString_last=0;

      

      if(msg.contains("�ͼӸ�")) //��Ÿ�Դϴ�. 

      chk = msg.substring(0, 3);

      System.out.println("server : "+msg);

      

      if(msg.equals("getWhisperMem")){  

       System.out.println("getWhisperMem : "+msg);

       for(String names : clients.keySet()){

       sendtoAll("�մ� "+names);

       }

      }else if(chk.equals("�ͼӸ�")){

        //���� ���� �޼ҵ� : ��� ������ 

        SubString_first = msg.lastIndexOf("(")+1;

        SubString_last = msg.lastIndexOf(",");

           user =  msg.substring(SubString_first,SubString_last);

        sendPrivate(msg,user);

           

        //���� ���� �޼ҵ� : ��� �޴���

        SubString_first = msg.lastIndexOf(",")+1;

        SubString_last = msg.lastIndexOf(")");

        user = msg.substring(SubString_first,SubString_last);

        sendPrivate(msg,user);

      }else{

       //���� ���� �޼ҵ� 

       sendtoAll(name+" : "+msg);

      }

     }

    }catch(Exception e){}

    finally{

     sendtoAll(name+"�� �����ϼ̽��ϴ�.");

     clients.remove(name);

    }

   }

  }

  

  //��� ���� ��ҵ� 

  void sendtoAll(String msg){

   Iterator it = clients.keySet().iterator();

   while(it.hasNext()){

    DataOutputStream out = (DataOutputStream)clients.get(it.next());

    try{

     out.writeUTF(msg);

    }catch(Exception e){};

   }

  }

  

  //���� ���� �޼ҵ� 

  void sendPrivate(String msg, String id){

   Iterator it = clients.entrySet().iterator();

   

   while(it.hasNext()){

    Map.Entry e = (Entry) it.next();

    System.out.println(e.getKey()+", "+e.getValue());

    

    if(id.equals(e.getKey())){

     DataOutputStream out = (DataOutputStream)e.getValue();

     try{

      out.writeUTF(msg);

     }catch(Exception e2){};

     }

    }

     }

    

  public static void main(String [] args){

   new Server();

  }

} 


