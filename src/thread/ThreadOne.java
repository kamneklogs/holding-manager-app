package thread;

import javafx.application.Platform;
import ui.MainControllerGUI;

public class ThreadOne extends Thread {

    private MainControllerGUI controllerGUI;

    /**
     * 
     */
    public ThreadOne(MainControllerGUI controllerGUI) {

        setDaemon(true);
        this.controllerGUI = controllerGUI;

    }

    @Override
    /**
     * 
     */
    public void run() {

        while (true) {
            Platform.runLater(new Thread() {
                public void run() {
                    controllerGUI.updateTimeLabel();
                    ;
                }
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}