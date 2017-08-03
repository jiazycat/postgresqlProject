package postgresqlProject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pgConn {
	private static Connection connection = null;
	private static Statement statement = null;
	private static CallableStatement produresql=null;
	private static String url="jdbc:postgresql://10.86.1.36:5432/postgres";
	private static String user="postgres";
	private static String password="postgres";
	//private static String sql="{?=call cs_fmt_browser_version(?,?,?)}";
	private static String sql="{call cursorfunction(?,?,?)}";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,user,password);	
			statement=connection.createStatement();
			produresql=connection.prepareCall(sql);
			ResultSet  cursor;
			//produresql.registerOutParameter(1,  java.sql.Types.VARCHAR);
			produresql.registerOutParameter(1,  java.sql.Types.REF_CURSOR);
			produresql.registerOutParameter(2,  java.sql.Types.REF_CURSOR);
			produresql.registerOutParameter(3,  java.sql.Types.REF_CURSOR);

			//produresql.setString(2, "1");
			//produresql.setString(3, "1");
			//produresql.setString(4, "1");
			connection.setAutoCommit(false);
			produresql.execute();
			cursor=(ResultSet) produresql.getObject(3);
			WriteLog wlog=new WriteLog();
			wlog.setLogFile("D:/abc.txt");
			wlog.openFile();
			if (cursor!=null){
				while(cursor.next()){
					System.out.println(cursor.getString(1)+","+cursor.getString(2));
			wlog.logContext(cursor.getString(1)+","+cursor.getString(2));}
			}
			wlog.closeAll();
			//System.out.println(s);
			/*
			ResultSet resultSet = statement.executeQuery(sql);	
			while (resultSet.next()){
				System.out.println(resultSet.getString(1));
			}*/
			
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
