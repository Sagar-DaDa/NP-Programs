import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoder {
    public static void main(String[] args) {
        try{
            // String asterisksString = "This*sentence*contains*asterisks.";
            // String percentString = "This%sentence%contains%spaces.";
            // String colonString = "This:sentence:contains:spaces.";
            // String equalString = "This=sentence=contains=spaces.";
            // String hashString = "This#sentence#contains#spaces.";
            
            String plainString = args[0];
            String encodedString = URLEncoder.encode(plainString, "UTF-8");
            String decodedString = URLDecoder.decode(encodedString, "UTF-8");

            System.out.println("Plain string: " + plainString);
            System.out.println("Encoded string using UTF-8: " + encodedString);
            System.out.println("Decoded string using UTF-8: " + decodedString);
        }catch(UnsupportedEncodingException unsupportedEncodingException){
            System.err.println(unsupportedEncodingException);
        }
    }
}
