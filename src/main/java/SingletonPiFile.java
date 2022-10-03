import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SingletonPiFile {
    private static final SingletonPiFile Singleton = new SingletonPiFile();
    private static URL oneThousandPiDigitsInternet;
    private static URL oneMillionPiDigitsInternet;
    private static URL oneBillionPiDigitsInternet;

    private SingletonPiFile() {
        String sep = System.getProperty("file.separator");
        try {
            oneThousandPiDigitsInternet = new URL("https://www.angio.net/pi/digits/1000.txt");
            oneMillionPiDigitsInternet = new URL("https://www.angio.net/pi/digits/pi1000000.txt");
            oneBillionPiDigitsInternet = new URL("https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedReader getThPiDigits() throws IOException {
        return new BufferedReader(new InputStreamReader(oneThousandPiDigitsInternet.openStream()));
    }
    public static BufferedReader getMPiDigits() throws IOException {
        return new BufferedReader(new InputStreamReader(oneMillionPiDigitsInternet.openStream()));
    }
    public static BufferedReader getBPiDigits() throws IOException {
        return new BufferedReader(new InputStreamReader(oneBillionPiDigitsInternet.openStream()));
    }
}