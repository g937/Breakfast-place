
package reggelizohely;
import java.util.List;

public class Limonade extends Termek {

    private boolean buborekos;

    public Limonade(String nev, double ar, List<HozzavaloTulajdonsag> hozzavalok, boolean buborekos) {
        super(nev, ar, hozzavalok);
        this.buborekos = buborekos;
    }

    public boolean isBuborekos() {
        return buborekos;
    }

    public void setBuborekos(boolean buborekos) {
        this.buborekos = buborekos;
    }

    @Override
    public String toString() {
       return String.format("\n" + (buborekos ? "buborékos " : "mentes ") 
               + "%s termék\nára: %.0f", getNev(),getAr());
    }
    
}
