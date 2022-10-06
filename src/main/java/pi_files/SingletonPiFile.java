package pi_files;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SingletonPiFile {
    private static final SingletonPiFile Singleton = new SingletonPiFile();
    private static URL oneThousandPiDigitsInternet;
    private static URL oneMillionPiDigitsInternet;
    private static URL oneBillionPiDigitsInternet;
    private static File oneBillionPiDigitsFile;
    private static File oneMillionPiDigitsFile;

    private SingletonPiFile() {
        String sep = System.getProperty("file.separator");
        try {
            oneThousandPiDigitsInternet = new URL("https://www.angio.net/pi/digits/1000.txt");
            oneMillionPiDigitsInternet = new URL("https://www.angio.net/pi/digits/pi1000000.txt");
            oneMillionPiDigitsFile = new File("src" + sep + "main"+ sep + "resources" + sep + "piM.txt");
            oneBillionPiDigitsInternet = new URL("https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt");
            oneBillionPiDigitsFile = new File("src" + sep + "main"+ sep + "resources" + sep + "piB.txt");
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
    public static BufferedReader getBPiDigitsFromFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(oneBillionPiDigitsFile));
    }
    public  static BufferedReader getMPiDigitsFromFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(oneMillionPiDigitsFile));
    }
}