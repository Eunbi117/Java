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

      

      if(msg.contains("귀속말")) //오타입니다. 

      chk = msg.substring(0, 3);

      System.out.println("server : "+msg);

      

      if(msg.equals("getWhisperMem")){  

       System.out.println("getWhisperMem : "+msg);

       for(String names : clients.keySet()){

       sendtoAll("손님 "+names);

       }

      }else if(chk.equals("귀속말")){

        //개별 전송 메소드 : 대상 보낸이 

        SubString_first = msg.lastIndexOf("(")+1;

        SubString_last = msg.lastIndexOf(",");

           user =  msg.substring(SubString_first,SubString_last);

        sendPrivate(msg,user);

           

        //개별 전송 메소드 : 대상 받는이

        SubString_first = msg.lastIndexOf(",")+1;

        SubString_last = msg.lastIndexOf(")");

        user = msg.substring(SubString_first,SubString_last);

        sendPrivate(msg,user);

      }else{

       //전원 전송 메소드 

       sendtoAll(name+" : "+msg);

      }

     }

    }catch(Exception e){}

    finally{

     sendtoAll(name+"이 퇴장하셨습니다.");

     clients.remove(name);

    }

   }

  }

  

  //모두 전송 멤소드 

  void sendtoAll(String msg){

   Iterator it = clients.keySet().iterator();

   while(it.hasNext()){

    DataOutputStream out = (DataOutputStream)clients.get(it.next());

    try{

     out.writeUTF(msg);

    }catch(Exception e){};

   }

  }

  

  //개별 전송 메소드 

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


