import java.net.URI;
import java.net.URISyntaxException;

public class ResolvingRelativeUri {
    public static void main(String[] args) {
        try{
            // public URI resolve(URI uri)
            URI baseOne = new URI("http://example.com/path/");
            URI relativeOne = new URI("file.txt");
            URI resolvedOne = baseOne.resolve(relativeOne);
            System.out.println("Resolved using [resolve(URI uri)]: " + resolvedOne);

            // public URI resolve(String uri)
            URI baseTwo = new URI("http://example.com/path/");
            URI resolvedTwo = baseTwo.resolve("file.txt");
            System.out.println("Resolved using [resolve(String uri)]: " + resolvedTwo);

            // public URI relativize(URI uri)
            URI absoluteUri = new URI("http://example.com/path/file.txt");
            URI resolvedRelative = baseOne.relativize(absoluteUri);
            System.out.println("Resolved using [relativize(URI uri)]: " + resolvedRelative);

        }catch(URISyntaxException uriSyntaxException){
            System.err.println(uriSyntaxException);
        }
    }
}
