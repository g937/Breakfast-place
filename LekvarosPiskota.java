//KÉSZÍTETTE GECSEG DORINA - U0PSBY
package reggelizohely;
import java.util.List;

public class LekvarosPiskota extends Termek{
    int kaloriaszam;

    public LekvarosPiskota(String nev, double ar, List<HozzavaloTulajdonsag> hozzavalok, int kaloriaszam) {
        super(nev, ar, hozzavalok);
        this.kaloriaszam = kaloriaszam;
    }

    public int getKaloriaszam() {
        return kaloriaszam;
    }

    public void setKaloriaszam(int kaloriaszam) {
        this.kaloriaszam = kaloriaszam;
    }
    
    @Override
    public String toString() {
        return String.format("\n%s termék\nára: %.0f\nkalória száma: %d", getNev(),getAr(), kaloriaszam);
    }
    
}
