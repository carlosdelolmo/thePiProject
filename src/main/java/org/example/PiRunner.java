import java.io.*;

public class PiRunner {
    private String wantedSequence;

    public PiRunner(String wantedString) {
        this.wantedSequence = wantedString;
    }

    public void setWantedSequence(String newWantedString){
        this.wantedSequence = newWantedString;
    }

    public int search() throws IOException {
        File file = SingletonPiFile.getMFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int firstPos = -1;
        int posInComp = 0;
        int currentPos = 0;
        int next;
        for(int i = 0; i < 2; i++) br.read();
        while((next = br.read()) != -1){
            char currentNumber = (char) next;
            if(currentNumber == wantedSequence.charAt(posInComp)){
                // System.out.println("En pos "+ currentPos + " se compara y se ve que es igual " + currentNumber);
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
