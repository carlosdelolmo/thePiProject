package main_program;

public class KillerThread extends Thread{
    private int id, maxRunningThreadId;
    PiThread[] piThreads;
    public KillerThread(int id, int maxRunningThreadId, PiThread[] piThreads){
        this.id = id;
        this.maxRunningThreadId = maxRunningThreadId;
        this.piThreads = piThreads;
    }
    @Override
    public void run() {
        kill();
    }
    protected void kill(){
        for(int i = maxRunningThreadId; i > id; i--){
            try {
                piThreads[i].kill();
            }catch(NullPointerException ignored){}
        }
    }
}
