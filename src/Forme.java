package src;

public class Forme {
    public FormeEnum type;
    public boolean male;

    Forme(Character forme) throws Exception {
        switch (forme) {
            case 'T':
                type = FormeEnum.TRIANGLE;
                male = true;
                break;
            case 'A':
                type = FormeEnum.TRIANGLE;
                male = false;
                break;
            case 'C':
                type = FormeEnum.CARREE;
                male = true;
                break;
            case 'G':
                type = FormeEnum.CARREE;
                male = false;
                break;
            case 'Z':
                type = FormeEnum.SANS;
                break;
            default:
                throw new Exception("forme non valide : " + forme);
        }
    }

    boolean emboite(Forme forme) {
        return this.type == forme.type && (this.type == FormeEnum.SANS || this.male != forme.male);
    }

    @Override
    public String toString() {
        if (type == FormeEnum.TRIANGLE)
            return male ? "T" : "A";
        if (type == FormeEnum.CARREE)
            return male ? "C" : "G";
        return "Z";
    }
}