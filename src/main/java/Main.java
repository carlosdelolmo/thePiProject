import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Introduce la palabra a buscar: ");
        String wantedString= sc.nextLine();
        System.out.println();
        Timer.setProgramStartTime();
        StringToNumberConversor stringConversor = new StringToNumberConversor();
        PiRunner piRunner = new PiRunner(stringConversor.numberize(wantedString));
        System.out.println("Posición de \"" + wantedString + "\": " + piRunner.search());
        System.out.println("Tiempo de búsqueda: " + Timer.getSearchTime() + "ms");
        System.out.println("Tiempo de acceso a ficheros: " + Timer.getMemoryAccessTime() + "ms");
    }
}