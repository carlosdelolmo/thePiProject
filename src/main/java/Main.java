import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search word: ");
        String wantedString= sc.nextLine();
        System.out.println(SearchFileSelection.getOpciones());
        int selection = sc.nextInt();
        System.out.println();
        Timer.setProgramStartTime();
        StringToNumberConversor stringConversor = new StringToNumberConversor();
        BufferedReaderFactory brf= new BufferedReaderFactory();
        PiRunner piRunner = new PiRunner(stringConversor.numberize(wantedString));
        System.out.println("Posición de \"" + wantedString + "\": " + piRunner.search(brf.getBufferedReader(selection)));
        System.out.println("Tiempo de búsqueda: " + Timer.getSearchTime() + "ms");
        System.out.println("Tiempo de acceso a ficheros: " + Timer.getMemoryAccessTime() + "ms");
    }
}