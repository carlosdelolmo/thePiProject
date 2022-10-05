package main_program;

import pi_files.BufferedReaderFactory;
import pi_files.SearchFileSelection;
import tools.NumberFormatter;
import tools.StringToNumberConversor;
import tools.Timer;

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
        // System.out.println(stringConversor.numberize(wantedString));
        // sergiodl 195187915412     999999998
        // informa   91461518131     999999999
        NumberFormatter nf = new NumberFormatter();
        System.out.println("Posición de \"" + wantedString + "\": " + nf.format(piRunner.search(brf.getBufferedReader(selection))));
        System.out.println("Tiempo de búsqueda: " + Timer.getSearchTime() + "ms");
        System.out.println("Tiempo de acceso a ficheros: " + Timer.getMemoryAccessTime() + "ms");
    }
}