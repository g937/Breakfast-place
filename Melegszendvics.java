
package reggelizohely;
import java.util.List;

public class Melegszendvics extends Termek{
    private double elkeszido;

    public Melegszendvics(String nev, double ar, List<HozzavaloTulajdonsag> hozzavalok, double elkeszido) {
        super(nev, ar, hozzavalok);
        this.elkeszido = elkeszido;
    }

    public double getElkeszido() {
        return elkeszido;
    }

    public void setElkeszido(int elkeszido) {
        this.elkeszido = elkeszido;
    }

    @Override
    public String toString() {
        return String.format("\n%s termék\nára: %.0f\nelkészítési ideje: %.2f", getNev(),getAr(), elkeszido);
    }
}
