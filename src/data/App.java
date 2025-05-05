package data;

import GUI.VPal;

/**
 *
 * @author alber
 */
public class App extends Thread{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new App().run();
    }

    @Override
    public void run() {
        new VPal("3 EN RAYA").setVisible(true);
        //HOLA
    }

}
