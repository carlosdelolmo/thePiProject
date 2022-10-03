public class Cronometer {
    private long startTime;
    public Cronometer(){
        startTime = System.nanoTime();
    }
    public long stopTimer(){
        return (System.nanoTime() - startTime)/1000000;
    }
}
