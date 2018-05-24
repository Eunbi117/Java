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
	       * url, dbid(�������̵�), dbpw(������й�ȣ) ����
	       * 
	       * 
	       * 
	       * url���� -> "jdbc:mysql://localhost:3306/DB��";
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
	      String selectSql = "select * from member"; // Select��
	      String insertSql = "insert member(type, id, pwd, email, name1, studentnum1, name2, studentnum2, name3, studentnum3, name4, studentnum4, name5, studentnum5, name6, studentnum6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	      member member = null;
	      try {
	          Class.forName("com.mysql.jdbc.Driver");
	          conn = DriverManager.getConnection(url, dbId, dbPw);
	          pstmt = conn.prepareStatement(insertSql);
	          //pstmt.setInt(1, 2);
	          System.out.println("���̵� �Է�");
	          pstmt.setString(1, scan.next());
	          System.out.println("��й�ȣ �Է�");
	          pstmt.setString(2, scan.next());
	          pstmt.executeUpdate();// Insert�� ����
	          stmt = conn.createStatement();
	          rs = stmt.executeQuery(selectSql); // Select�� ����
	          while (rs.next()) {
	             member = new member();
	             //member.setIdnum(rs.getInt("IdNum"));
	             member.setId(rs.getString("Id"));
	             member.setPwd(rs.getString("Pwd"));
	             list.add(member);

	          }

	          for (member m : list) { // ��¹� ����
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