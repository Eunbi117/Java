import java.sql.*;
import java.util.ArrayList;

public class ex {

	public static void main(String[] args) {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		PreparedStatement pstmt = null;

		ArrayList<member> list = new ArrayList<member>();

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

		String url = "jdbc:mysql://localhost:3306/test";

		String dbId = "bb";

		String dbPw = "0117";

		String selectSql = "select * from member"; // Select��

		String insertSql = // Insert��

		"insert member(Id, Pwd) values(?,?)";

		member member = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, dbId, dbPw);

			pstmt = conn.prepareStatement(insertSql);

			//pstmt.setInt(1, 2);

			pstmt.setString(1, "yy"); //ID

			pstmt.setString(2, "tt"); //PW


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
