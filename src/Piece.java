package src;

import java.util.Arrays;

public class Piece {
    public Cote cotes[];
    int hauteur;
    int largeur;
    int orientation;
    int id;

    Piece(String line, int hauteur, int largeur, int id) {
        this.id = id;
        this.hauteur = hauteur;
        this.largeur = largeur;
        String split[] = line.split(" ");
        int precedent = 0;
        cotes = new Cote[4];
        cotes[0] = new Cote(Arrays.copyOfRange(split, 0, precedent + largeur), 0);
        precedent = largeur;
        cotes[1] = new Cote(Arrays.copyOfRange(split, largeur, precedent + hauteur), 1);
        precedent = hauteur;
        cotes[2] = new Cote(Arrays.copyOfRange(split, hauteur, precedent + largeur), 2);
        precedent = largeur;
        cotes[3] = new Cote(Arrays.copyOfRange(split, largeur, precedent + hauteur), 3);

    }

    @Override
    public String toString() {
        return "" + id + " " + orientation;
    }

}