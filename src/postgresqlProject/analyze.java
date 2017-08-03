package postgresqlProject;

import java.io.BufferedReader;
import java.util.ArrayList;

public class analyze {
	public static void main(String[] args) throws Exception {
    	String Str="";
    	BufferedReader li;
    	
    	String line=""; 
    	li=new pullWord(Str).analysisWords();
    	
       	 ArrayList<wordObject> list = new  ArrayList<wordObject>();
	     while ((line = li.readLine()) != null) {
	    	 if (line!=""&&line.length()!=0) {
	    	    	System.out.println(line);

	    		 wordObject word=new wordObject();
	    		 String[] sourceStrArray = line.split(":");
	    	     	word.setWord(sourceStrArray[0]);
		    	    word.setRate(Float.parseFloat(sourceStrArray[1]));
		    	    list.add(word);
	    	 }

	        }
	      new insertData().insertWord(list);
    }
}
