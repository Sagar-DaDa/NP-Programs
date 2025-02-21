import java.net.MalformedURLException;
import java.net.URL;

public class RelativeUrls {
    public static void main(String[] args) {
        try{
            URL baseUrl = new URL("https://www.w3schools.com/html/");
            String relativeUrlOne = "html_tables.asp";
            String relativeUrlTwo = "html_forms.asp";

            URL absoluteUrlOne = new URL(baseUrl, relativeUrlOne);
            URL absoluteUrlTwo = new URL(baseUrl, relativeUrlTwo);

            System.out.println("First URL: " + absoluteUrlOne);
            System.out.println("Second URL: " + absoluteUrlTwo);
        } catch(MalformedURLException malformedURLException){
            System.err.println(malformedURLException);
        }
    }
}
