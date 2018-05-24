import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBC_Ex1 {

	public static void main(String[] args) {
		 Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      PreparedStatement pstmt = null;
	      ArrayList<member> list = new ArrayList<member>();
	      Scanner scan = new Scanner(System.in);
	      /*
	       * 
	       * 
	       * 
	       * url, dbid(계정아이디), dbpw(계정비밀번호) 설정
	       * 
	       * 
	       * 
	       * url설정 -> "jdbc:mysql://localhost:3306/DB명";
	       * 
	       * 
	       * 
	       * 
	       * 
	       * 
	       * 
	       */
	      String url = "jdbc:mysql://203.255.177.208:3306/java7";
	      String dbId = "java7";
	      String dbPw = "test1234";
	      String selectSql = "select * from member"; // Select문
	      String insertSql = "insert member(type, id, pwd, email, name1, studentnum1, name2, studentnum2, name3, studentnum3, name4, studentnum4, name5, studentnum5, name6, studentnum6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	      member member = null;
	      try {
	          Class.forName("com.mysql.jdbc.Driver");
	          conn = DriverManager.getConnection(url, dbId, dbPw);
	          pstmt = conn.prepareStatement(insertSql);
	          //pstmt.setInt(1, 2);
	          System.out.println("아이디 입력");
	          pstmt.setString(1, scan.next());
	          System.out.println("비밀번호 입력");
	          pstmt.setString(2, scan.next());
	          pstmt.executeUpdate();// Insert문 실행
	          stmt = conn.createStatement();
	          rs = stmt.executeQuery(selectSql); // Select문 실행
	          while (rs.next()) {
	             member = new member();
	             //member.setIdnum(rs.getInt("IdNum"));
	             member.setId(rs.getString("Id"));
	             member.setPwd(rs.getString("Pwd"));
	             list.add(member);

	          }

	          for (member m : list) { // 출력문 실행
	             System.out.println(m.toString());
	          }
	       } catch (Exception e) {
	          e.printStackTrace();
	       } finally {

	          try {
	             rs.close();
	             stmt.close();
	             conn.close();         
	          } catch (SQLException e) {
	             e.printStackTrace();

	          }

	       }

	    }

}