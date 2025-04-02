import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class RetrievingDataFromUrl {
    public static void main(String[] args) {
        String urlString = args[0];
        try{
            URL url = new URL(urlString);

            InputStream inputStream = url.openStream();
            Reader reader = new InputStreamReader(inputStream);
            int content;
            while((content = reader.read()) != -1){
                System.out.print((char)content);
            }
        }catch(MalformedURLException malformedURLException){
            System.out.println(args[0] + " is not a parseable URL.");
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
}
