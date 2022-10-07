package main_program;

import java.io.BufferedReader;
import java.io.IOException;

public class PiThread extends Thread {
    private final int START;
    private final int AMOUNT;
    private final String WANTED_SEQUENCE;
    private final BufferedReader BR;
    private final FastSearcher FS;
    private boolean canContinue = true;

    protected PiThread(int start, int amount, String wantedSequence, BufferedReader br, FastSearcher fs) {
        this.START = start;
        this.AMOUNT = amount;
        this.WANTED_SEQUENCE = wantedSequence;
        this.BR = br;
        this.FS = fs;
    }

    public void run() {
        try {
            search();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void kill(){
        canContinue = false;
    }

    private void search() throws IOException {
        int firstPos = -1;
        int posInComp = 0;
        int currentPos = START;
        int next;
        BR.skip(START + 2);
        int end = START + AMOUNT + WANTED_SEQUENCE.length() - 1;
        while (canContinue && (next = BR.read()) != -1 && currentPos < end) {
            char currentNumber = (char) next;
            if (currentNumber == WANTED_SEQUENCE.charAt(posInComp)) {
                if (posInComp == 0) firstPos = currentPos;
                if (++posInComp == WANTED_SEQUENCE.length()) {
                    FS.foundString(START/AMOUNT, firstPos);
                    return;
                }
            } else {
                if (posInComp > 0) {
                    firstPos = -1;
                    posInComp = 0;
                }
            }
            currentPos++;
        }
    }
}
