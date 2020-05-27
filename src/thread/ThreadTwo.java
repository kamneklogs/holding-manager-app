package thread;

import javafx.application.Platform;
import ui.MainControllerGUI;
import model.Holding;

public class ThreadTwo extends Thread {

    private Holding theHolding;
    private MainControllerGUI controllerGUI;

    /**
     * 
     */
    public ThreadTwo(MainControllerGUI controllerGUI, Holding theHolding) {
        setDaemon(true);
        this.controllerGUI = controllerGUI;
        this.theHolding = theHolding;

    }

    @Override
    /**
     * 
     */
    public void run() {

        while (!theHolding.isStateCharge()) {
            Platform.runLater(new Thread() {
                public void run() {
                    controllerGUI.loadingDataAnimation();
                    ;
                }
            });
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        controllerGUI.cleanLoadingInfo();

    }
}