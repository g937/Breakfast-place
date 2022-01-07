//KÉSZÍTETTE GECSEG DORINA - U0PSBY
package reggelizohely;
import java.util.List;


public abstract class Termek {
    private String nev;
    private double ar;
    private List<HozzavaloTulajdonsag> hozzavalok;

    public Termek(String nev, double ar, List<HozzavaloTulajdonsag> hozzavalok) {
        this.nev = nev;
        setAr(ar);
        this.hozzavalok = hozzavalok;
    }

    public String getNev() {
        return nev;
    }

    public double getAr() {
        return ar;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public List<HozzavaloTulajdonsag> getHozzavalok() {
        return hozzavalok;
    }

    public void setHozzavalok(List<HozzavaloTulajdonsag> hozzavalok) {
        this.hozzavalok = hozzavalok;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }
    
  
}
