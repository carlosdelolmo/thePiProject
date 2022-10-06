package main_program;

import pi_files.BufferedReaderFactory;
import pi_files.SearchFileSelection;
import tools.NumberFormatter;
import tools.StringToNumberConversor;
import tools.Timer;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static int minPos = -1;

    public static void main(String[] args){
        // Pedimos al usuario la cadena a buscar
        Scanner sc = new Scanner(System.in);
        String wantedString = selectWantedString(sc);

        // Mostramos los distintos tamaños de fichero posibles
        int selection = displayFileTypes(sc);

        // Comenzamos el programa
        Timer.setProgramStartTime();
        StringToNumberConversor stringConversor = new StringToNumberConversor();
        BufferedReaderFactory brf= new BufferedReaderFactory();
        NumberFormatter nf = new NumberFormatter();
        int fileSize = SearchFileSelection.getSize(selection); // Obtenemos el numero de elementos del fichero
        String numberizedString = stringConversor.numberize(wantedString); // Pasamos la cadena de texto a numeros

        // Creamos hilos en función del tamano del fichero
        int numberThreads = calculateThreads(fileSize);
        // System.out.println(numberThreads);
        int calcPerThread = fileSize/numberThreads; // Cantidad de numeros que tratará cada hilo
        // System.out.println(calcPerThread);
        PiThread[] piThreads = new PiThread[numberThreads];

        // Creamos los hilos de busqueda
        createThreads(numberThreads, calcPerThread, numberizedString, brf, selection, piThreads);

        // Mostramos los resultados obtenidos
        showResult(wantedString, numberizedString, nf);
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

    private static int calculateThreads(int fileSize){
        return fileSize<1000000?1:fileSize<1000000000?10:100; // Calcula la cantidad de hilos que sera necesaria
    }

    private static void createThreads(int numberThreads, int calcPerThread, String numberizedString, BufferedReaderFactory brf, int fileSelection, PiThread[] piThreads) {
        Timer.setSearchStartTime();
        try {
            for (int i = 0; i < numberThreads; i++) {
                piThreads[i] = new PiThread(i * calcPerThread, calcPerThread, numberizedString, brf.getBufferedReader(fileSelection));
                piThreads[i].start();
            }
            for (int i = 0; i < numberThreads; i++) {
                piThreads[i].join();
            }
        }catch(Exception e){
            System.out.println("Error al crear los hilos");
            exit(-1);
        }
    }


    private static void showResult(String wantedString, String numberizedString, NumberFormatter nf){
        System.out.print("\n");
        System.out.println("First seen position for \"" + wantedString + "\" (" + numberizedString + ") : " + nf.format(minPos));
        System.out.println("Searching time: " + Timer.getSearchTime() + "ms");
        System.out.println("Memory accessing time: " + Timer.getMemoryAccessTime() + "ms");
    }

    public static void foundString(int pos){
        if(minPos == -1 || pos < minPos)
            minPos = pos;
    }
}