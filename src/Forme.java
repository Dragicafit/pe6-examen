package src;

public class Forme {
    public FormeEnum type;
    public boolean male;

    Forme(Character forme) {
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
                type = FormeEnum.TRIANGLE;
                male = true;
                break;
            case 'G':
                type = FormeEnum.TRIANGLE;
                male = false;
                break;
            case 'Z':
                type = FormeEnum.SANS;
                break;
        }
    }
}