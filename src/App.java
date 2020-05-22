package src;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    int nbPiece;
    int hauteur;
    int largeur;
    ArrayList<Piece> pieces;
    Arene arene;

    public static void main(String[] args) throws Exception {
        for (String arg : args) {
            new Thread() {
                public void run() {
                    try {
                        new App(arg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public App(String filename) throws Exception {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            String ligne = sc.nextLine();
            nbPiece = Integer.parseInt(ligne);
            pieces = new ArrayList<>();
            ligne = sc.nextLine();
            String[] buff = ligne.split(" ");
            largeur = Integer.parseInt(buff[0]);
            hauteur = Integer.parseInt(buff[1]);
            for (int i = 0; i < nbPiece; i++) {
                pieces.add(new Piece(sc.nextLine().replace(" ", ""), hauteur, largeur, i));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        arene = new Arene(pieces);
        PrintWriter writer = new PrintWriter(filename + ".out", "UTF-8");
        writer.print(arene);
        writer.close();
    }

    @Override
    public String toString() {
        String string = "2" + " " + "2" + "\n";
        for (Piece piece : pieces) {
            string += piece + "\n";
        }
        return string;
    }

    static void shuffleArray(Object[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Object a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
