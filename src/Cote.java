package src;

public class Cote {
    public Forme formes[];
    boolean coteLisse;

    Cote(String ligne) throws Exception {
        formes = new Forme[ligne.length()];
        coteLisse = true;
        for (int i = 0; i < ligne.length(); i++) {
            formes[i] = new Forme(ligne.charAt(i));
            if (formes[i].type != FormeEnum.SANS)
                coteLisse = false;
        }
    }

    boolean emboite(Cote cote) throws Exception {
        if (this.formes.length != cote.formes.length)
            return false;
        if (coteLisse)
            return false;
        for (int i = 0; i < this.formes.length; i++) {
            if (!this.formes[i].emboite(cote.formes[formes.length - i - 1]))
                return false;
        }
        // System.out.println("emboite");
        // System.out.println(this);
        // System.out.println(cote);
        return true;
    }

    @Override
    public String toString() {
        String string = "";
        for (Forme forme : formes)
            string += forme + " ";
        return string;
    }

}