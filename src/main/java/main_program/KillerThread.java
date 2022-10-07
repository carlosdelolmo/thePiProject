package main_program;

public class KillerThread extends Thread{
    private final int id, maxRunningThreadId;
    private final PiThread[] piThreads;
    public KillerThread(int id, int maxRunningThreadId, PiThread[] piThreads){
        this.id = id;
        this.maxRunningThreadId = maxRunningThreadId;
        this.piThreads = piThreads;
    }
    @Override
    public void run() {
        kill();
    }

    // Mata todos los hilos con id superior a un id dado
    protected void kill(){
        for(int i = maxRunningThreadId; i > id; i--){
            try {
                piThreads[i].kill();
            }catch(NullPointerException ignored){}
        }
    }
}
