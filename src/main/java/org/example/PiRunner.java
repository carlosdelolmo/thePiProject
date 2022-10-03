package org.example;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class PiRunner {
    private String wantedSequence;

    public PiRunner(String wantedString) {
        this.wantedSequence = wantedString;
    }

    public void setWantedSequence(String newWantedString){
        this.wantedSequence = newWantedString;
    }

    public void search() throws IOException {
        File file = SingletonPiFile.getTFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        // Scanner reader = new Scanner(file);
        boolean found = false;
        int firstPos = -1;
        int posInComp = 0;
        int currentPos = 0;
        char currentNumber;
        while(!found && (currentNumber = (char) br.read()) != 0){
            if(currentNumber == wantedSequence.charAt(posInComp)){
                if(posInComp == 0) firstPos = currentPos;
                posInComp++;
            } else {
                if(posInComp > 0){
                    firstPos = -1;
                    posInComp = 0;
                }
            }
            currentPos++;

        }
    }
}
