package postgresqlProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getHtml {

	   private String u;
	    private String encoding;
	  
	    public getHtml(String u, String encoding) {
	        this.u = u;
	        this.encoding = encoding;
	    }
	    public BufferedReader getContent() throws Exception {
	        URL url = new URL(u);  
	        HttpURLConnection urlConnection = (HttpURLConnection) url
	                .openConnection();
	        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                urlConnection.getInputStream(), encoding));
	       
	       return reader;
	    }

}
