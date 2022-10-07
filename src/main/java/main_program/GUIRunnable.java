package main_program;

public class GUIRunnable implements Runnable{
    private GUIPiProject guiPiProject;
    public GUIRunnable(GUIPiProject guiPiProject){
        this.guiPiProject = guiPiProject;
    }
    @Override
    public void run() {
        FastSearcher fastSearcher = new FastSearcher();
        guiPiProject.gotAnswered(fastSearcher.search(guiPiProject.getTextfieldText()));
    }
}
