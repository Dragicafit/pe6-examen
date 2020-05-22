package src;

public class Piece {
    public Cote cotes[];
    int hauteur;
    int largeur;
    int orientation;
    int id;
    int distanceDuCentreH;
    int distanceDuCentreL;

    Piece(String ligne, int hauteur, int largeur, int id) throws Exception {
        if (ligne.length() != hauteur * 2 + largeur * 2)
            throw new Exception("piece non valide : " + ligne + ", " + hauteur + "*" + largeur);
        this.id = id;
        this.hauteur = hauteur;
        this.largeur = largeur;
        int precedent = 0;
        int suivant = precedent + largeur;
        cotes = new Cote[4];
        cotes[0] = new Cote(ligne.substring(0, suivant), 0);
        precedent = suivant;
        suivant = precedent + hauteur;
        cotes[1] = new Cote(ligne.substring(precedent, suivant), 1);
        precedent = suivant;
        suivant = precedent + largeur;
        cotes[2] = new Cote(ligne.substring(precedent, suivant), 2);
        precedent = suivant;
        suivant = precedent + hauteur;
        cotes[3] = new Cote(ligne.substring(precedent, suivant), 3);

    }

    boolean emboite(Piece piece, int orientation) throws Exception {
        Cote cote1 = this.getCote(orientation + 2);
        Cote cote2 = piece.getCote(orientation);
        return cote1.emboite(cote2);
    }

    Cote getCote(int orientation) {
        return cotes[orientation % 4];
    }

    @Override
    public String toString() {
        return "" + id + " " + orientation;
    }

}