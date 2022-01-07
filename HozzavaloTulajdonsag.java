//KÉSZÍTETTE GECSEG DORINA - U0PSBY
package reggelizohely;
public class HozzavaloTulajdonsag {
    private double mennyiseg;
    private String mertekegyseg;
    private String alapanyag;
    private String armertekegyseg;
    private int ar;

    public HozzavaloTulajdonsag(double mennyiseg, String mertekegyseg, String alapanyag, String armertekegyseg, int ar) {
        this.mennyiseg = mennyiseg;
        this.mertekegyseg = mertekegyseg;
        this.alapanyag = alapanyag;
        this.armertekegyseg = armertekegyseg;
        this.ar = ar;
    }

    public double getMennyiseg() {
        return mennyiseg;
    }

    public String getMertekegyseg() {
        return mertekegyseg;
    }

    public String getAlapanyag() {
        return alapanyag;
    }

    public String getArmertekegyseg() {
        return armertekegyseg;
    }

    public int getAr() {
        return ar;
    }

    public void setMennyiseg(double mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public void setMertekegyseg(String mertekegyseg) {
        this.mertekegyseg = mertekegyseg;
    }

    public void setAlapanyag(String alapanyag) {
        this.alapanyag = alapanyag;
    }

    public void setArmertekegyseg(String armertekegyseg) {
        this.armertekegyseg = armertekegyseg;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "HozzavaloTulajdonsag{" + "mennyiseg=" + mennyiseg + ", mertekegyseg=" + mertekegyseg + ", alapanyag=" + alapanyag + ", armertekegyseg=" + armertekegyseg + ", ar=" + ar + '}';
    }
    
    
    
    
    
}
