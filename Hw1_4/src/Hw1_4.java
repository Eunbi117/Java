import java.util.Scanner;

public class Hw1_4 {
   
   

   public static void main(String[] args){
      System.out.println("===========================");
      System.out.println("학번  : 201604013");
      System.out.println("이름 : 남궁찬");
      System.out.println("===========================");
   
      int com_price = 0;//컴퓨터 가격 변수을 선언합니다
      int phone_price = 0;//핸드폰 가격 변수를 선언합니다
      int TV_price = 0;//TV 가격 변수를 선언합니다
      
      int set_product = 0;
      
      String reply;//반복을 위한 변수를 선업합니다.
   
      
      
      //스케너를 sc로 생성하겠습니다.
      Scanner sc = new Scanner(System.in);
      
      //new_price변수로 Order객체를 생성 합니다.
      Order order = new Order();
      
      System.out.println("상품의 가격을 정해주세요");
      System.out.println("컴퓨터" + " :" );
      com_price = sc.nextInt();
      
      order.setPrice("컴퓨터" , com_price);
      order.setPrice("핸드폰", phone_price);
      order.setPrice("TV", phone_price);
      
      do{
         
      System.out.println("돈을 입력해주새요");
      int money = sc.nextInt();//돈을 입력하는 변수
      
      order.showMenu();

      set_product = sc.nextInt();
      order.Result(money, set_product);
      
      System.out.println("계속하시겠습니까?");
      reply = sc.nextLine();
      
      }while(reply.equalsIgnoreCase("Y"));
       
      
      
      
   }
}