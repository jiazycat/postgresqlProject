package postgresqlProject;

import java.io.BufferedReader;

public class pullWord {
    private String str;
    private String encoding="utf-8";
    
    public pullWord(String str) {
        this.str = str;
    } 
    public BufferedReader analysisWords() throws Exception {
     return  new getHtml("http://api.pullword.com/get.php?source="+str+"&param1=0&param2=1",encoding).getContent();      
    }

}
