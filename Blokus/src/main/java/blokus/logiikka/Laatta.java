package blokus.logiikka;

public class Laatta {

    private int koko;
    private int[][] muoto;
    private int id;
    private int ruudukonKoko = 7; // 7x7
    public int vari;

    public Laatta(int koko, int[][] muoto, int id, String vari) {
        this.koko = koko;
        this.muoto = muoto;
        this.id = id;
        this.vari = haeVari(vari);
        
    }

    public void kaannaVasempaan() {
        int[][] kaannos = new int[muoto.length][muoto.length];

        for (int i = 0; i < kaannos.length; i++) {
            for (int j = 0; j < kaannos.length; j++) {
                kaannos[muoto.length - j - 1][i] = muoto[i][j];
            }
        }
        muoto = kaannos;
    }

    public void kaannaOikeaan() {
        int[][] kaannos = new int[muoto.length][muoto.length];

        for (int i = 0; i < kaannos.length; i++) {
            for (int j = 0; j < kaannos.length; j++) {
                kaannos[j][muoto.length - i - 1] = muoto[i][j];
            }
        }
        muoto = kaannos;


    }

    public void kaannaYmpari() {
        int[][] kaannos = new int[muoto.length][muoto.length];

        for (int i = 0; i < kaannos.length; i++) {
            for (int j = 0; j < kaannos.length; j++) {
                kaannos[muoto.length - i - 1][j] = muoto[i][j];
            }
        }
        muoto = kaannos;
    }

    public int getKoko() {
        return koko;
    }

    public int[][] getMuoto() {
        return muoto;
    }
    
    public void tulosta() {
        for (int i = 0; i < muoto.length; i++) {
            for (int j = 0; j < muoto.length; j++) {
                System.out.print(muoto[i][j]);
                
            }
            System.out.println("");
        }
    }

    public void visualisoi() {
        String apu = "";
        for (int i = 0; i < muoto.length; i++) {
            for (int j = 0; j < muoto.length; j++) {
                if (muoto[i][j] == 3) {
                    apu += "#";
                } else {
                    apu += " ";
                }

            }
            if (!apu.equals("       ")) {
                System.out.println(apu);
                
            }
            apu = "";
        }

    }

    private int haeVari(String vari) {
        switch (vari) {
            case "sininen": return 1;
            case "keltainen": return 2;
            case "punainen": return 3;    
            default: return 4;   
                    
        }
                
    }
}
