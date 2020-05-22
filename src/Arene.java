package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Arene {
    ArrayList<Piece> piecesRestantes;
    ArrayList<Piece> piecesPosees;
    Piece arene[][];
    int hauteur;
    int largeur;
    GrandCote grandCotes[];
    int points;

    Arene(ArrayList<Piece> piecesRestantes) throws Exception {
        this.piecesRestantes = piecesRestantes;
        piecesPosees = new ArrayList<>();
        points = 0;

        Collections.shuffle(piecesRestantes);

        Piece centre = piecesRestantes.get(0);
        piecesRestantes.remove(0);
        grandCotes = new GrandCote[4];
        for (int i = 0; i < 4; i++)
            grandCotes[i] = new GrandCote(new Piece[] { centre }, i);
        piecesPosees.add(centre);
        hauteur = 1;
        largeur = 1;
        while (ajouteRangee())
            ;
        render();
    }

    void render() {
        arene = new Piece[hauteur][largeur];
        int decalageH = -grandCotes[0].distanceDuCentreH;
        int decalageL = -grandCotes[3].distanceDuCentreL;
        for (Piece piecePosee : piecesPosees) {
            int h = piecePosee.distanceDuCentreH + decalageH;
            int l = piecePosee.distanceDuCentreL + decalageL;
            if (h < 0 || h >= hauteur)
                continue;
            if (l < 0 || l >= largeur)
                continue;
            arene[hauteur - h - 1][l] = piecePosee;
        }
    }

    boolean ajouteRangee() throws Exception {
        System.out.println("ajouteRangee " + largeur + "*" + hauteur);
        GrandCote[] ajouts = minCote();
        for (GrandCote ajout : ajouts) {
            if (ajouteRangee(ajout))
                return true;
        }
        return false;
    }

    boolean ajouteRangee(GrandCote ajout) throws Exception {
        Piece[] nouveau = new Piece[ajout.pieces.length];
        ArrayList<Piece> piecesRestantes = new ArrayList<>(this.piecesRestantes);
        ArrayList<Piece> piecesPosees = new ArrayList<>(this.piecesPosees);

        for (int i = 0; i < ajout.pieces.length; i++) {
            int j = -1;
            for (Piece piece : piecesRestantes) {
                j++;
                // rotation
                if (!piece.emboite(ajout.pieces[i], ajout.orientation))
                    continue;
                if (i > 0 && !piece.emboite(nouveau[i - 1], ajout.orientation + 1))
                    continue;
                nouveau[i] = piece;
                break;
            }
            if (nouveau[i] == null)
                return false;
            piecesRestantes.remove(j);
            piecesPosees.add(nouveau[i]);
        }
        this.piecesRestantes = piecesRestantes;
        this.piecesPosees = piecesPosees;
        ajout.setPieces(nouveau);
        if (ajout.orientation % 2 == 0)
            hauteur++;
        else
            largeur++;
        for (GrandCote grandCote : grandCotes)
            grandCote.addPieces(ajout);
        render();
        System.out.println(this);
        for (GrandCote grandCote : grandCotes)
            System.out.println(grandCote);

        return true;
    }

    GrandCote[] minCote() {
        GrandCote grandCotesTri[] = grandCotes.clone();
        Arrays.sort(grandCotesTri, new Comparator<GrandCote>() {
            public int compare(GrandCote a, GrandCote b) {
                return b.nbNonLisse - a.nbNonLisse;
            }
        });
        return grandCotesTri;
    }

    @Override
    public String toString() {
        String string = largeur + " " + hauteur + "\n";
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                string += arene[i][j] + "\n";
            }
        }
        return string;
    }
}