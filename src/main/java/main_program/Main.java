package main_program;

import pi_files.BufferedReaderFactory;
import pi_files.SearchFileSelection;
import tools.NumberFormatter;
import tools.StringToNumberConversor;
import tools.Timer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int minPos = -1;

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
        NumberFormatter nf = new NumberFormatter();
        int fileSize = SearchFileSelection.getOpcion(selection).getSize();
        int numberThreads = 100;
        int calcAmount = fileSize/numberThreads;
        String numberizedString = stringConversor.numberize(wantedString);
        PiThread[] piThreads = new PiThread[numberThreads];
        Timer.setSearchStartTime();
        for(int i = 0; i < numberThreads; i++){
            piThreads[i] = new PiThread(i*calcAmount, calcAmount, numberizedString, brf.getBufferedReader(selection));
            piThreads[i].start();
        }
        for(int i = 0; i < numberThreads; i++){
            try {
                piThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("\n");
        System.out.println("First seen position for \"" + wantedString + "\" (" + numberizedString + ") : " + nf.format(minPos));
        System.out.println("Searching time: " + Timer.getSearchTime() + "ms");
        System.out.println("Memory accessing time: " + Timer.getMemoryAccessTime() + "ms");
    }
    public static void foundString(int pos){
        if(minPos == -1 || pos < minPos)
            minPos = pos;
    }
    public static void finishedThread(){
        System.out.print(".");
    }
}