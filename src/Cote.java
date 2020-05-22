package src;

public class Cote {
    public Forme formes[];
    int cote;

    Cote(String lines[], int cote) {
        formes = new Forme[lines.length];
        for (int i = 0; i < lines.length; i++) {
            formes[i] = new Forme(lines[i].charAt(0));
        }
        this.cote = cote;
    }

}