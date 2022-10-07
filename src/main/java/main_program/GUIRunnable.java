package main_program;

import tools.Timer;

public class GUIRunnable implements Runnable{
    private GUIPiProject guiPiProject;
    public GUIRunnable(GUIPiProject guiPiProject){
        this.guiPiProject = guiPiProject;
    }
    @Override
    public void run() {
        Timer.setProgramStartTime();
        FastSearcher fastSearcher = new FastSearcher();
        guiPiProject.gotAnswered(fastSearcher.search(guiPiProject.getTextfieldText()));
    }
}
