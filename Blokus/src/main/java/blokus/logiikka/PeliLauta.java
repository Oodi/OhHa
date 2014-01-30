package blokus.logiikka;


import java.util.HashMap;

public class PeliLauta {

    public int[][] lauta;
    private HashMap<Integer, TarkastusLauta> tarkastusLaudat;

    public PeliLauta() {
        lauta = new int[20][20];
        alusta();
        tarkastusLaudat = new HashMap<>();

    }
    
        public void lisaaLaattaLaudalle(int pelaajaId, Laatta laatta, int y, int x) {
            TarkastusLauta kasiteltava = tarkastusLaudat.get(pelaajaId);
        if (kasiteltava.tarkistaVoikoLisata(laatta, y, x)) {
            lisaaLaatta(kasiteltava, laatta, y, x);
        } else {
            System.out.println("Et voi asettaa laattaa tähän");
        }

    }
        
        private void lisaaLaatta(TarkastusLauta kasiteltava, Laatta laatta, int y, int x) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (laatta.getMuoto()[i][j] == 3) {
                    kasiteltava.lisaaLaatta(2,y+i-3, x+j-3);
                    muutaRuudunOmistaja(laatta.getVari(), y+i-3, x+j-3);                                     
                } else if (laatta.getMuoto()[i][j] == 1 && y+i-3 >=0 && y+i-3 <20 && x+j-3 >= 0 && x+j-3 < 20) {
                    kasiteltava.lisaaLaatta(1,y+i-3, x+j-3);
                }
            }
        }
    }
    
    public void muutaRuudunOmistaja(int pelaajaId, int y, int x) {
        this.lauta[y][x] = pelaajaId;
    }

    public void lisaaTarkastusLauta(int id, TarkastusLauta l) {
        tarkastusLaudat.put(id, l);
    }
    
    

    public void alusta() {
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                lauta[i][j] = 0;
            }
        }
        lauta[0][0] = 1;
        lauta[0][19] = 2;
        lauta[19][0] = 3;
        lauta[19][19] = 4;
    }
    
    public void tulosta() {
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                System.out.print(lauta[i][j]);
            }
            System.out.println("");
        }
    }
}
