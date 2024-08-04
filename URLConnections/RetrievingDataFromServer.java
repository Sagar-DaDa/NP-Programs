import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RetrievingDataFromServer {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL("https://google.com");
            URLConnection urlConnection = url.openConnection();

            InputStream rawInputStream = urlConnection.getInputStream();
            InputStream bufferInputStream = new BufferedInputStream(rawInputStream);

            Reader reader = new InputStreamReader(bufferInputStream);

            int content;
            while((content = reader.read()) != -1){
                System.out.print((char) content);
            }
            
        }catch(MalformedURLException malformedURLException){
            System.out.println(args[0] + " is not a parseable URL.");
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
}
