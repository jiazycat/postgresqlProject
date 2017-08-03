package postgresqlProject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class insertData {
	private static Connection connection = null;
	private static Statement statement = null;
	private static CallableStatement produresql=null;
	private static String url="jdbc:postgresql://10.86.1.36:5432/postgres";
	private static String user="postgres";
	private static String password="postgres";
	private static String sql="insert into analysisWords values (?,?)";

	public  void insertWord(ArrayList<wordObject> wordlist) throws IOException {
		// TODO Auto-generated method stub
		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,user,password);	
			connection.setAutoCommit(true);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			Iterator<wordObject> it=wordlist.iterator();
			 wordObject word=new wordObject();
			while(it.hasNext()){
				word= it.next();
				pstmt.setString(1,word.getWord());
				pstmt.setFloat(2, word.getRate());
				pstmt.addBatch();
				} 
			 pstmt.executeBatch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				produresql.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
