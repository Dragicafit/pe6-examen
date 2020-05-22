package src;

import java.io.File;
import java.util.Scanner;

public class App {
    int nbPiece;
    int hauteur;
    int largeur;
    Piece pieces[];

    public static void main(String[] args) throws Exception {

        new App(args[0]);
    }

    public App(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            nbPiece = Integer.parseInt(line);
            pieces = new Piece[nbPiece];
            line = sc.nextLine();
            String[] buff = line.split(" ");
            largeur = Integer.parseInt(buff[0]);
            hauteur = Integer.parseInt(buff[1]);
            for (int i = 0; i < nbPiece; i++) {
                pieces[i] = new Piece(sc.nextLine(), hauteur, largeur, i);
            }
            System.out.println(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String string = "2" + " " + "2" + "\n";
        for (Piece piece : pieces) {
            string += piece + "\n";
        }
        return string;
    }
}
