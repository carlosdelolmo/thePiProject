import java.io.BufferedReader;
import java.io.IOException;

public class PiThread extends Thread{
    private int start;
    private int amount;
    private String wantedSequence;
    private BufferedReader br;
    public PiThread(int start, int amount, String wantedSequence, BufferedReader br){
        this.start = start;
        this.amount = amount;
        this.wantedSequence = wantedSequence;
        this.br = br;
    }
    public void run(){
        try {
            search();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void search() throws IOException {
        int firstPos = -1;
        int posInComp = 0;
        int currentPos = start;
        int next;
        //for(int i = 0; i < start; i++)
        br.skip(start + 2);
        int end = start + amount + wantedSequence.length() - 1;
        while((next = br.read()) != -1 && currentPos < end){
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
        System.out.println(currentPos);
        // Main.muestra(firstPos);
    }
}
