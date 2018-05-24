import java.util.Scanner;

public class SumTest {

   public static void main(String[] args) {

      Scanner s=new Scanner(System.in);
      int a=s.nextInt();
      for(int i=1;i<=a;i++)
      {
         int sum=0;
         for(int j=1;j<=i;j++)
         {
            if(i%j==0)
            {
               sum+=j;
               if(j==i)
               {
            	   if(sum-i == i){
            		   System.out.print(sum+" ");
                       System.out.print(i);
                       System.out.println();
            	   }
               }
            }      
         }   
      }
   }
}