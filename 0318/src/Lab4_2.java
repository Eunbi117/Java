import java.util.*;
public class Lab4_2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      
      Scanner sc = new Scanner(System.in);
      int i = 0, j = 3;
      int [][] score;//[몇사람][3개점수]

      
      //score[i][j] = sc.nextInt();
      
      int ko_total = 0;
      int math_total = 0;
      int en_total = 0;
      
     // int st = 0;

      System.out.println("<<평균계산기>>");
      System.out.println("총 학생 수를 입력하세요");
      
      i = sc.nextInt();
      score = new int[i][j];
      
      System.out.println("번호\t극어\t수학\t영어\t총점 \t평균");
      System.out.println("================================================");
      for( i = 0; i<score.length; i++){
         int sum = 0;
         double avg = 0.0;
         System.out.print(i+1+"\t");
         for( j = 0; j < score[i].length;j++){
        	 //여기다가 사용자한테 점수를 받아야겠징??ㅎㅎ
            System.out.print(score[i][j]+"\t");
            sum += score[i][j];
         }
         avg=sum/3.0;
         System.out.printf("%d\t%.2f\n",sum,avg);
         ko_total+=score[i][0];
         math_total+=score[i][1];
         en_total+=score[i][2];
         
      }
      
      System.out.println("================================================");
      System.out.printf("국어 평균 : %.2f \n",ko_total/3.0);
      System.out.printf("수학 평균 : %.2f \n",math_total/3.0);
      System.out.printf("영어 평균 : %.2f \n",en_total/3.0);

   }

}