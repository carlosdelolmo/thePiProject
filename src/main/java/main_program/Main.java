package main_program;

import pi_files.BufferedReaderFactory;
import pi_files.SearchFileSelection;
import tools.NumberFormatter;
import tools.StringToNumberConversor;
import tools.Timer;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static String minPos;

    public static void main(String[] args){

        // Pedimos al usuario la cadena a buscar
        Scanner sc = new Scanner(System.in);
        String wantedString = selectWantedString(sc);

        // Mostramos los distintos tamaños de fichero posibles
        // int selection = displayFileTypes(sc);

        FastSearcher fastSearcher = new FastSearcher();
        minPos = fastSearcher.search(wantedString);

        // Mostramos los resultados obtenidos
        showResult(wantedString);
    }

    private static int displayFileTypes(Scanner sc){
        System.out.println(SearchFileSelection.getOpciones());
        int selection = sc.nextInt();
        System.out.println();
        return selection;
    }

    private static String selectWantedString(Scanner sc){
        System.out.print("Search word: ");
        return sc.nextLine();
    }

    private static void showResult(String wantedString){
        System.out.print("\n");
        System.out.println("First seen position for \"" + wantedString + "\": " + minPos);
        System.out.println("Searching time: " + Timer.getSearchTime() + "ms");
        System.out.println("Memory accessing time: " + Timer.getMemoryAccessTime() + "ms");
    }
}