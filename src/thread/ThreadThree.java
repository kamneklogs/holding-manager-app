package thread;

import ui.MainControllerGUI;

import java.io.IOException;

import model.Holding;

public class ThreadThree extends Thread {

    private Holding theHolding;
    private MainControllerGUI controllerGUI;

    /**
     * 
     */
    public ThreadThree(Holding theHolding) {

        setDaemon(true);

        this.theHolding = theHolding;

    }

    @Override
    public void run() {

        while (!theHolding.isStateCharge()) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        while (theHolding.isStateCharge()) {

            try {
                theHolding.updateSave();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}