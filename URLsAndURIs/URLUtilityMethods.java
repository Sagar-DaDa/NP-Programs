import java.net.MalformedURLException;
import java.net.URL;

public class URLUtilityMethods {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")
            URL url1 = new URL ("http://www.ncsa.uiuc.edu/HTMLPrimer.html#GS");
            @SuppressWarnings("deprecation")
            URL url2 = new URL ("http://www.ncsa.uiuc.edu/HTMLPrimers.html#HD");

            if (url1.sameFile(url2)) {
                System.out.println("Both url1 and url2 pointing to the same file");
                System.out.println("URL1: " + url1.toExternalForm());
                System.out.println("URL2: " + url2.toExternalForm());
            }else{
                System.out.println("Both url1 and url2 is not pointing to the same file");
                System.out.println("URL1: " + url1.toExternalForm());
                System.out.println("URL2: " + url2.toExternalForm());
            }
        }catch(MalformedURLException malformedURLException){
            System.err.println(malformedURLException);
        }
    }
}