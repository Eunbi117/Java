import java.util.Scanner;

public class Order {
   
   int com_price = 0;//컴퓨터 가격 변수을 선언합니다
   int phone_price = 0;//핸드폰 가격 변수를 선언합니다
   int TV_price = 0;//TV 가격 변수를 선언합니다
   
   
   Scanner sc = new Scanner(System.in);
   
   //컴퓨터, 핸드폰, TV 가격을 지정해 주는 메소드입니다.
   void setPrice(String item, int price){
      if(item.equals("컴퓨터")){
    	  com_price = price;
      }
      
   }//메소드를 종료합니다

   
   
   //지정된 가격을 보여주는 메소드입니다.
   void showMenu(){
      System.out.println("상품을 선택하세요");
      System.out.println("1. 컴퓨터 : " + com_price);
      System.out.println("2. 핸드폰 : " + phone_price);
      System.out.println("3. TV : " + TV_price);
      
   }//메소드 종료를 종료합니다.
   
   //선택한 상품과 남은 돈을 보여주는 메소드입니다.
   void Result(int money, int menu){
      
      int money_left;
      
      if(menu == 1){
         System.out.println("선택한 상품은 컴퓨터 입니다.");
         money_left = money - com_price;
         System.out.println("남은 돈은 " + money_left + "입니다.");
      }
      
      if(menu == 2){
         System.out.println("선택한 상품은 핸드폰 입니다.");
         money_left = money - phone_price;
         System.out.println("남은 돈은 " + money_left + "입니다.");
      }
      
      if(menu == 3){
         System.out.println("선택한 상품은 TV 입니다.");
         money_left = money - TV_price;
         System.out.println("남은 돈은 " + money_left + "입니다.");
      }
   }//메소드 종료합니다.
   
   
}//class 종료를 종료합니다.

