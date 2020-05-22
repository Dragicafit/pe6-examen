package src;

public class Test {
    public static void main(String[] args) throws Exception {
        testForme();
        testCote();
        testPiece();
    }

    static void testForme() throws Exception {
        Forme formeA = new Forme('A');
        Forme formeT = new Forme('T');
        Forme formeC = new Forme('C');
        Forme formeG = new Forme('G');
        Forme formeZ1 = new Forme('Z');
        Forme formeZ2 = new Forme('Z');
        try {
            new Forme('J');
            System.out.println("erreur forme non valide");
        } catch (Exception e) {
        }
        if (!formeA.emboite(formeT))
            System.out.println("erreur A emboite T");
        if (!formeC.emboite(formeG))
            System.out.println("erreur C emboite G");
        if (!formeT.emboite(formeA))
            System.out.println("erreur T emboite A");
        if (!formeG.emboite(formeC))
            System.out.println("erreur G emboite C");
        if (!formeZ1.emboite(formeZ2))
            System.out.println("erreur Z emboite Z");

        if (formeG.emboite(formeA))
            System.out.println("erreur G emboite A");
        if (formeG.emboite(formeT))
            System.out.println("erreur G emboite T");
        if (formeZ1.emboite(formeC))
            System.out.println("erreur Z emboite C");
        if (formeZ1.emboite(formeA))
            System.out.println("erreur Z emboite A");
        if (formeG.emboite(formeZ1))
            System.out.println("erreur G emboite Z");
        if (formeA.emboite(formeZ2))
            System.out.println("erreur A emboite Z");
    }

    static void testCote() throws Exception {
        Cote coteAC0 = new Cote("AC");
        Cote coteAC2 = new Cote("AC");
        Cote coteCA0 = new Cote("CA");
        Cote coteCA2 = new Cote("CA");
        Cote coteTG0 = new Cote("TG");
        Cote coteTG2 = new Cote("TG");
        Cote coteGT0 = new Cote("GT");
        Cote coteGT2 = new Cote("GT");
        try {
            new Cote("ACTGJ");
            System.out.println("erreur coteACTGJ non valide");
        } catch (Exception e) {
        }

        if (!coteCA2.emboite(coteTG0))
            System.out.println("erreur coteCA2 emboite coteTG0");
        if (!coteTG0.emboite(coteCA2))
            System.out.println("erreur coteTG0 emboite coteCA2");
        if (!coteAC0.emboite(coteGT2))
            System.out.println("erreur coteAC0 emboite coteGT2");
        if (!coteCA0.emboite(coteTG2))
            System.out.println("erreur coteCA0 emboite coteTG2");

        if (coteAC0.emboite(coteTG2))
            System.out.println("erreur coteAC0 emboite coteTG2");
        if (coteAC2.emboite(coteTG0))
            System.out.println("erreur coteAC2 emboite coteTG0");
        if (coteCA2.emboite(coteAC0))
            System.out.println("erreur coteCA2 emboite coteAC0");
        if (coteAC0.emboite(coteCA2))
            System.out.println("erreur coteAC0 emboite coteCA2");
        if (coteCA0.emboite(coteAC2))
            System.out.println("erreur coteCA0 emboite coteAC2");
        if (coteAC0.emboite(coteAC2))
            System.out.println("erreur coteAC0 emboite coteAC2");
        if (coteAC2.emboite(coteAC0))
            System.out.println("erreur coteAC2 emboite coteAC0");

        if (coteAC0.emboite(coteAC0))
            System.out.println("erreur coteAC0 emboite coteAC0");
    }

    static void testPiece() throws Exception {
        Piece pieceACGCZAGG = new Piece("ACGCZAGG", 2, 2, 0);
        Piece pieceTZCCGTGC = new Piece("TZCCGTGC", 2, 2, 0);
        Piece AAAAAAAC = new Piece("AAAAAAAC", 2, 2, 0);
        Piece AAGTAAAA = new Piece("AAGTAAAA", 2, 2, 0);
        try {
            new Piece("ACGCZAGJ", 2, 2, 0);
            System.out.println("erreur pieceACGCZAGJ non valide");
        } catch (Exception e) {
        }
        try {
            new Piece("ACGCZAGC", 2, 3, 0);
            System.out.println("erreur pieceACGCZAGC non valide");
        } catch (Exception e) {
        }
        try {
            new Piece("ACGCZAC", 2, 2, 0);
            System.out.println("erreur pieceACGCZAC non valide");
        } catch (Exception e) {
        }
        try {
            new Piece("ACGCZACGC", 2, 2, 0);
            System.out.println("erreur pieceACGCZACGC non valide");
        } catch (Exception e) {
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                pieceACGCZAGG.orientation = j;
                for (int k = 0; k < 4; k++) {
                    pieceTZCCGTGC.orientation = k;
                    if ((pieceACGCZAGG.emboite(pieceTZCCGTGC,
                            i)) != (pieceACGCZAGG.orientation == pieceTZCCGTGC.orientation))
                        System.out.println("erreur pieceACGCZAGG emboite pieceTZCCGTGC " + i);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (pieceACGCZAGG.emboite(pieceACGCZAGG, i))
                System.out.println("erreur pieceACGCZAGG emboite pieceACGCZAGG " + i);
        }
        AAAAAAAC.orientation = 0;
        AAGTAAAA.orientation = 0;
        for (int i = 0; i < 4; i++) {
            if (AAAAAAAC.emboite(AAGTAAAA, i) && i != 1)
                System.out.println("erreur AAAAAAAC emboite AAGTAAAA " + i);
            if (!AAAAAAAC.emboite(AAGTAAAA, i) && i == 1)
                System.out.println("erreur AAAAAAAC emboite AAGTAAAA " + i);
        }
    }
}