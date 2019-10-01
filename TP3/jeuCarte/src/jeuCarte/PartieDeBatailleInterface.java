package jeuCarte;

import java.awt.EventQueue;

public class PartieDeBatailleInterface {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BatailleInterface window = new BatailleInterface("Anna Tomie", "Guy de Michelin");
                    window.frameJeuDeBataille.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }});
    }
}
