package tools;

public class Timer {
    private static long programStartTime;
    private static long searchStartTime;
    private Timer crono = new Timer();
    private Timer(){
        programStartTime = System.nanoTime();
    }
    public static void setProgramStartTime(){
        programStartTime = System.nanoTime();
    }
    public static void setSearchStartTime(){
        if(searchStartTime == 0)
            searchStartTime = System.nanoTime();
    }
    public static void rebootTime(){
        programStartTime = System.nanoTime();
        searchStartTime = 0;
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