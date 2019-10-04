package jeuCarte;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PartieDeBatailleTexte
{
    public static void main(String[] args) {
        BatailleText bataille = new BatailleText("Anna Tomie", "Guy de Michelin");
        String reponse = "non";
        do {
            bataille.tour();

            System.out.println("Voulez-vous rejouer ? (o/n ou oui/non)");
            Scanner scanner = new Scanner(System.in);
            reponse = scanner.next();
        } while (reponse.toLowerCase().contains("o"));
    }
}
