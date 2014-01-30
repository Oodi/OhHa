package blokus.logiikka;

public class TarkastusLauta {

    int[][] tLauta;

    public TarkastusLauta(int pelaajanId) {
        tLauta = new int[20][20];
        alusta(pelaajanId);
    }

    public boolean tarkistaVoikoLisata(Laatta laatta, int y, int x) {
        boolean laattaSalKohtaan = false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

                if ((y + i - 3 < 0 || x + j - 3 < 0 || y + i - 3 > 19 || x + j - 3 > 19) && laatta.getMuoto()[i][j] == 3) {
                    return false;
                } else if (y + i - 3 >= 0 && x + j - 3 >= 0 && y + i - 3 < 20 && x + j - 3 < 20) {
                    if (laatta.getMuoto()[i][j] == 2 && tLauta[y + i - 3][x + j - 3] == 2) {
                        return false;
                    } else if (laatta.getMuoto()[i][j] == 3 && tLauta[y + i - 3][x + j - 3] == 2) {
                        return false;
                    }
                    if (laatta.getMuoto()[i][j] == 3 && tLauta[y + i - 3][x + j - 3] == 1) {
                        laattaSalKohtaan = true;
                    }
                }
            }
        }
        return laattaSalKohtaan;
    }

    public void lisaaLaatta(int koodi,int y, int x) {
        if (!(y< 0 || x < 0 || y > 19 || x  > 19)) {
            tLauta[y][x] = koodi;
        }
        
    }

    private void alusta(int id) {
        for (int i = 0; i < tLauta.length; i++) {
            for (int j = 0; j < tLauta.length; j++) {
                tLauta[i][j] = 0;
            }
        }
        tLauta[0][0] = 2;
        tLauta[0][19] = 2;
        tLauta[19][0] = 2;
        tLauta[19][19] = 2;
        if (id == 1) {
            tLauta[0][0] = 1;
        } else if (id == 2) {
            tLauta[0][19] = 1;
        } else if (id == 3) {
            tLauta[19][0] = 1;
        } else if (id == 4) {
            tLauta[19][19] = 1;
        } else {
        }

    }
    public void tulosta() {
        for (int i = 0; i < tLauta.length; i++) {
            for (int j = 0; j < tLauta.length; j++) {
                System.out.print(tLauta[i][j]);
            }
            System.out.println("");
        }
    }
}
