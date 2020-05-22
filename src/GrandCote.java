package src;

public class GrandCote {
    Piece pieces[];
    int orientation;
    int nbNonLisse;
    int distanceDuCentreH;
    int distanceDuCentreL;

    GrandCote(Piece pieces[], int orientation) throws Exception {
        this.orientation = orientation;
        switch (orientation % 4) {
            case 0:
                distanceDuCentreH++;
                break;
            case 1:
                distanceDuCentreL--;
                break;
            case 2:
                distanceDuCentreH--;
                break;
            case 3:
                distanceDuCentreL++;
                break;
            default:
                break;
        }
        setPieces(pieces);
    }

    public void setPieces(Piece[] pieces) {
        // System.out.println("setPieces " + orientation);
        this.pieces = pieces;
        switch (orientation % 4) {
            case 0:
                distanceDuCentreH--;
                break;
            case 1:
                distanceDuCentreL++;
                break;
            case 2:
                distanceDuCentreH++;
                break;
            case 3:
                distanceDuCentreL--;
                break;
            default:
                break;
        }
        for (int i = 0; i < pieces.length; i++) {
            if (!pieces[i].getCote(orientation).coteLisse)
                nbNonLisse++;
            if (orientation % 2 == 0) {
                pieces[i].distanceDuCentreH = distanceDuCentreH;
                pieces[i].distanceDuCentreL = Integer.signum(distanceDuCentreL) * (Math.abs(distanceDuCentreL) - i);
            } else {
                pieces[i].distanceDuCentreL = distanceDuCentreL;
                pieces[i].distanceDuCentreH = Integer.signum(distanceDuCentreH) * (Math.abs(distanceDuCentreH) - i);
            }
        }
    }

    void addPieces(GrandCote ajout) {
        if (this.orientation % 2 == ajout.orientation % 2)
            return;
        Piece newPieces[] = new Piece[pieces.length + 1];
        if ((ajout.orientation + 3) % 4 == this.orientation) {
            for (int i = 0; i < pieces.length; i++)
                newPieces[i] = pieces[i];
            newPieces[pieces.length] = ajout.pieces[0];

        } else {
            for (int i = 0; i < pieces.length; i++)
                newPieces[i + 1] = pieces[i];
            newPieces[0] = ajout.pieces[ajout.pieces.length - 1];
            switch (ajout.orientation % 4) {
                case 0:
                    distanceDuCentreH--;
                    break;
                case 1:
                    distanceDuCentreL++;
                    break;
                case 2:
                    distanceDuCentreH++;
                    break;
                case 3:
                    distanceDuCentreL--;
                    break;
                default:
                    break;
            }
        }
        pieces = newPieces;
    }

    @Override
    public String toString() {
        String string = "";
        for (Piece piece : pieces) {
            string += piece + " ";
        }
        string += " ";
        return string + "orientation : " + orientation + ", non lisse : " + nbNonLisse + ", " + distanceDuCentreL + "*"
                + distanceDuCentreH;
    }
}