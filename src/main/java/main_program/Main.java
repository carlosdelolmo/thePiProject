package main_program;
import pi_files.SearchFileEnum;
import tools.Timer;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args){
        while(true) {
            // Pedimos al usuario la cadena a buscar
            Scanner sc = new Scanner(System.in);
            String wantedString = selectWantedString(sc);

            // Mostramos los distintos tamaños de fichero posibles
            // int selection = displayFileTypes(sc);

            FastSearcher fastSearcher = new FastSearcher();
            String minPos = fastSearcher.search(wantedString);

            // Mostramos los resultados obtenidos
            showResult(wantedString, minPos);
        }
    }

    private static int displayFileTypes(Scanner sc){
        System.out.println(SearchFileEnum.getOpciones());
        int selection = sc.nextInt();
        System.out.println();
        return selection;
    }

    private static String selectWantedString(Scanner sc){
        System.out.print("Enter search word or \"/exit\" to finish:\n");
        String selection = sc.nextLine();
        if(selection.equals("/exit")) exit(0);
        return selection;
    }

    private static void showResult(String wantedString, String minPos){
        System.out.print("\n");
        System.out.println("First seen position for \"" + wantedString + "\": " + minPos);
        System.out.println("Searching time: " + Timer.getSearchTime() + "ms");
        System.out.println("Memory accessing time: " + Timer.getMemoryAccessTime() + "ms");
        System.out.println("Total program time: " + Timer.getProgramTime() + "ms\n======================");
    }
}