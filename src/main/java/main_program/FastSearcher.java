package main_program;

import pi_files.BufferedReaderFactory;
import pi_files.SearchFileEnum;
import tools.NumberFormatter;
import tools.StringToNumberConversor;
import tools.Timer;

import java.util.Stack;

import static java.lang.System.exit;

public class FastSearcher {
    private int minPos;
    private PiThread[] piThreads;
    private int maxRunningThreadId;

    protected String search(String wantedString){
        Timer.rebootTime();
        minPos = -1;
        StringToNumberConversor stringConversor = new StringToNumberConversor();
        BufferedReaderFactory brf= new BufferedReaderFactory();
        Stack<Integer> filesStack = generateFileStack();
        while(minPos < 0 && ! filesStack.isEmpty()){
            int selection = filesStack.pop();
            int fileSize = SearchFileEnum.getSize(selection); // Obtenemos el numero de elementos del fichero
            String numberizedString = stringConversor.numberize(wantedString); // Pasamos la cadena de texto a numeros

            // Creamos hilos en función del tamano del fichero
            int numberThreads = calculateThreads(fileSize);
            maxRunningThreadId = numberThreads - 1;
            int calcPerThread = fileSize/numberThreads; // Cantidad de numeros que tratará cada hilo
            piThreads = new PiThread[numberThreads];

            // Creamos los hilos de busqueda
            createThreads(numberThreads, calcPerThread, numberizedString, brf, selection, piThreads);
        }
        NumberFormatter nf = new NumberFormatter();
        return nf.format(minPos);
    }
    private int calculateThreads(int fileSize){
        return fileSize<1000000?1:fileSize<1000000000?10:50; // Calcula la cantidad de hilos que sera necesaria
    }
    private Stack<Integer> generateFileStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(SearchFileEnum.getIndex(SearchFileEnum.ONEBILLIONFILE));
        stack.push(SearchFileEnum.getIndex(SearchFileEnum.ONEMILLIONFILE));
        stack.push(SearchFileEnum.getIndex(SearchFileEnum.ONETHOUSANDFILE));
        return stack;
    }
    private void createThreads(int numberThreads, int calcPerThread, String numberizedString, BufferedReaderFactory brf, int fileSelection, PiThread[] piThreads) {
        Timer.setSearchStartTime();
        try {
            for (int i = 0; i < numberThreads; i++) {
                piThreads[i] = new PiThread(i * calcPerThread, calcPerThread, numberizedString, brf.getBufferedReader(fileSelection), this);
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
    protected void foundString(int id, int pos){
        if(minPos == -1 || pos < minPos){
            minPos = pos;
            if(id < maxRunningThreadId) {
                KillerThread kt = new KillerThread(id, maxRunningThreadId, piThreads);
                maxRunningThreadId = id - 1;
                kt.start();
            }
        }
    }

}
