package postgresqlProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WriteLog {
	String logFile;

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	FileWriter fw = null;
	PrintWriter pw;

	public void openFile() {

		try {
			File f = new File(logFile);
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logContext(String context) {
		Date nowTime = new Date(System.currentTimeMillis());
		pw.println(nowTime+":"+context);
	}

	public void flushPrint() {
		pw.flush();
	}

	public void flushFile() throws IOException {
		fw.flush();
	}

	public void closeAll() throws IOException {
		pw.flush();
		fw.flush();
		pw.close();
		fw.close();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date nowTime = new Date(System.currentTimeMillis());
		System.out.println(nowTime+":");
	}

}
