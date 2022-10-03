public class Cronometer {
    private static long programStartTime;
    private static long searchStartTime;
    private Cronometer crono = new Cronometer();
    private Cronometer(){
        programStartTime = System.nanoTime();
    }
    public static void setProgramStartTime(){
        programStartTime = System.nanoTime();
    }
    public static void setSearchStartTime(){
        searchStartTime = System.nanoTime();
    }
    public static long getProgramTime(){
        return (System.nanoTime() - programStartTime)/1000000;
    }
    public static long getSearchTime(){
        return (System.nanoTime() - searchStartTime)/1000000;
    }
    public static long getMemoryAccessTime(){
        return(getProgramTime() - getSearchTime());
    }
}