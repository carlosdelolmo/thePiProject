import java.io.*;

public class PiRunner {
    private String wantedSequence;

    public PiRunner(String wantedString) {
        this.wantedSequence = wantedString;
    }

    public void setWantedSequence(String newWantedString){
        this.wantedSequence = newWantedString;
    }

    public int search(BufferedReader br) throws IOException {
        // BufferedReader br = SingletonPiFile.getBPiDigitsFromFile();
        Timer.setSearchStartTime();
        int firstPos = -1;
        int posInComp = 0;
        int currentPos = 0;
        int next;
        for(int i = 0; i < 2; i++) br.read();
        while((next = br.read()) != -1){
            char currentNumber = (char) next;
            if(currentNumber == wantedSequence.charAt(posInComp)){
                if(posInComp == 0) firstPos = currentPos;
                if(++posInComp == wantedSequence.length()){
                    break;
                }
            } else {
                if(posInComp > 0){
                    firstPos = -1;
                    posInComp = 0;
                }
            }
            currentPos++;
        }
        return firstPos;
    }
}