import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConnectingServerSideWithGet {
    public static void main(String[] args) {
        String inputQuery = "";
        String encodedQuery = "";
        for(String arg : args){
            inputQuery += arg + " ";
        }
        inputQuery = inputQuery.trim();
        try{
            encodedQuery = URLEncoder.encode(inputQuery, "UTF-8");
            @SuppressWarnings("deprecation")
            URL serverURL = new URL("http://universities.hipolabs.com/search?country=" + encodedQuery);
            InputStream inputStream = new BufferedInputStream(serverURL.openStream());
            InputStreamReader fetchedResult = new InputStreamReader(inputStream);

            int c;
            while ((c = fetchedResult.read()) != -1) {
                System.out.print((char) c);
            }
        }catch(UnsupportedEncodingException unsupportedEncodingException){
            System.err.println(unsupportedEncodingException);
        }catch(MalformedURLException malformedURLException){
            System.err.println(malformedURLException);
        }catch(IOException ioException){
            System.err.println(ioException);
        }
    }
}
