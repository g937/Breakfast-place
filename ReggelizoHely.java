//KÉSZÍTETTE GECSEG DORINA - U0PSBY
package reggelizohely;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ReggelizoHely implements Afa {

    //termék előállítási költség
    private static Map<Termek, Double> eloallitasiKoltseg = new HashMap<>();

    private final static String MELEGSZENDVICS = "melegszendvics";
    private final static String LIMONADE = "limonádé";
    private final static String LEKVAROS_PISKOTA = "lekváros piskóta";

    public static void legdragabbAdag(List<Termek> termekek) {
        double szendvicsktg = 0;
        double limonadektg = 0;
        double piskotaktg = 0;

        for (Termek termek : termekek) {
            System.out.println(String.format("%s termék", termek.getNev()));
            double adagar = 0;
            for (HozzavaloTulajdonsag hozzavalo : termek.getHozzavalok()) {
                double hozzvaloAra = 0;
                //System.out.println(String.format("%s hozzávaló", hozzavalo.getAlapanyag()));
                if (hozzavalo.getMertekegyseg().equals(hozzavalo.getArmertekegyseg())) {
                    hozzvaloAra = hozzavalo.getMennyiseg() * hozzavalo.getAr();
                } else {
                    switch (hozzavalo.getMertekegyseg()) {
                        case "dkg":
                            hozzvaloAra = hozzavalo.getMennyiseg() * (hozzavalo.getAr() / 100.0);
                            break;
                        case "gramm":
                            hozzvaloAra = hozzavalo.getMennyiseg() * (hozzavalo.getAr() / 1000.0);
                            break;
                    }
                }
                System.out.println(String.format("%s hozzávaló ára: %.2f", hozzavalo.getAlapanyag(), hozzvaloAra));

                adagar += hozzvaloAra;
            }
            switch (termek.getNev()) {
                case MELEGSZENDVICS:
                    szendvicsktg = adagar;
                    break;
                case LIMONADE:
                    limonadektg = adagar;
                    break;
                case LEKVAROS_PISKOTA:
                    piskotaktg = adagar;
                    break;
            }
            System.out.println();
            eloallitasiKoltseg.put(termek, adagar);
        }

        List<Double> koltsegek = new ArrayList<>();
        koltsegek.add(szendvicsktg);
        koltsegek.add(limonadektg);
        koltsegek.add(piskotaktg);
        double maxktg = 0;
        for (Double aDouble : koltsegek) {
            if (aDouble > maxktg) {
                maxktg = aDouble;
            }
        }

        for (Map.Entry<Termek, Double> entry : eloallitasiKoltseg.entrySet()) {
            Termek termek = entry.getKey();
            Double eloallitasiKoltseg = entry.getValue();

            if (maxktg == eloallitasiKoltseg) {
                String termekNev = termek.getNev();
                if (termekNev.equals(LIMONADE)) {
                    Limonade limonade = (Limonade) termek;
                    String buborekos = limonade.isBuborekos() ? "buborékos" : "mentes";
                    System.out.println(String.format("A legdrágább termék: %s (%s), előállítási költség: %.2f Ft", termekNev, buborekos, eloallitasiKoltseg));
                } else {
                    System.out.println(String.format("A legdrágább termék: %s, előállítási költség: %.2f Ft", termekNev, eloallitasiKoltseg));
                }
                break;
            }
        }

    }

    public static void legnagyobbHaszon() {
        Map<Termek, Double> hasznok = new HashMap<>();

        for (Map.Entry<Termek, Double> entry : eloallitasiKoltseg.entrySet()) {
            Termek termek = entry.getKey();
            Double eloallitasiKoltseg = entry.getValue();

            double haszon = termek.getAr() - eloallitasiKoltseg;
            hasznok.put(termek, haszon);
        }

        Collection<Double> values = hasznok.values();
        double maxHaszon = Collections.max(values);

        for (Map.Entry<Termek, Double> entry : hasznok.entrySet()) {
            Termek termek = entry.getKey();
            double haszon = entry.getValue();

            if (haszon == maxHaszon) {
                String termekNev = termek.getNev();
                if (termekNev.equals(LIMONADE)) {
                    Limonade limonade = (Limonade) termek;
                    String buborekos = limonade.isBuborekos() ? "buborékos" : "mentes";
                    System.out.println(String.format("A legnagyobb haszon a(z) %s (%s) terméken van, haszon: %.2f Ft", termekNev, buborekos, haszon));
                } else {
                    System.out.println(String.format("A legnagyobb haszon a(z) %s terméken van, haszon: %.2f Ft", termekNev, haszon));
                }
                break;
            }
        }

    }

    public static void egyszerusitettSzamla(List<Termek> termekek) {
        System.out.println("\nEgyszerűsített számla: ");
        System.out.println(String.format("%5s %8s %25s %54s", "mennyiség", "egység", "terméknév", "ár (Ft)"));
        double vegosszeg = 0;
        Map<Termek, Integer> termekmennyiseg = new HashMap<>();
        for (Termek termek : termekek) {
            if (termekmennyiseg.containsKey(termek)) {
                for (Map.Entry<Termek, Integer> entry : termekmennyiseg.entrySet()) {
                    if (entry.getKey().equals(termek)) {
                        int ujmenny = entry.getValue() + 1;
                        termekmennyiseg.remove(entry);
                        termekmennyiseg.put(termek, ujmenny);
                    }
                }
            } else {
                termekmennyiseg.put(termek, 1);
            }
            vegosszeg += (termek.getAr() * (1 + AFAERTEK));
        }
        for (Map.Entry<Termek, Integer> entry : termekmennyiseg.entrySet()) {
            Termek termek = entry.getKey();
            String termekNev = termek.getNev();
            if (termekNev.equals(LIMONADE)) {
                Limonade limonade = (Limonade) termek;
                String buborekos = limonade.isBuborekos() ? "buborékos" : "mentes";
                System.out.println(String.format("%5d %10s %21s %-15s %43.2f", entry.getValue(), "db", buborekos, termekNev, (entry.getValue() * entry.getKey().getAr() * (1 + AFAERTEK))));
            } else {
                System.out.println(String.format("%5d %10s %30s %50.2f", entry.getValue(), "db", termekNev, (entry.getValue() * entry.getKey().getAr() * (1 + AFAERTEK))));
            }
        }
        System.out.println(String.format("%80s %17.2f", "Végösszeg: ", vegosszeg));
        System.out.println("\n");
    }

    public static void hozzavalobolTermek(List<Termek> termekek, HozzavaloTulajdonsag hozzavalo) {
        List<Termek> tartalmazza = new ArrayList();
        System.out.println("A " + hozzavalo.getAlapanyag() + " hozzávaló az alábbi termék(ek)ben található meg: ");
        for (Termek termek : termekek) {
            List<HozzavaloTulajdonsag> hozzavalok = termek.getHozzavalok();
            for (HozzavaloTulajdonsag adotthozzavalo : hozzavalok) {
                if (adotthozzavalo.getAlapanyag().equals(hozzavalo.getAlapanyag())) {
                    tartalmazza.add(termek);
                }
            }
        }
        for (Termek termek : tartalmazza) {
            if (termek.getNev().equals(LIMONADE)) {
                Limonade limonade = (Limonade) termek;
                String buborekos = limonade.isBuborekos() ? "buborékos" : "mentes";
                System.out.println(buborekos + " " + termek.getNev());
            } else {
                System.out.println(termek.getNev());
            }
        }
    }

    public static void Recept(List<Termek> termekek, List<HozzavaloTulajdonsag> hozzavalok) throws IOException {
        boolean vanrecept = false;
        for (Termek termek : termekek) {
            int szamlalo = 0;
            StringBuffer recept = new StringBuffer();
            recept.append("\n" + termek.getNev()).append(" receptje: \n");
            for (HozzavaloTulajdonsag termekhozzavalo : termek.getHozzavalok()) {
                for (HozzavaloTulajdonsag hozzavalo : hozzavalok) {
                    if ((hozzavalo.getAlapanyag().equals(termekhozzavalo.getAlapanyag()))
                            && (hozzavalo.getMennyiseg() >= termekhozzavalo.getMennyiseg())
                            && (hozzavalo.getMertekegyseg().equals(termekhozzavalo.getMertekegyseg()))) {
                        szamlalo++;
                        recept.append(termekhozzavalo.getMennyiseg() + " ");
                        recept.append(termekhozzavalo.getMertekegyseg() + " ");
                        recept.append(termekhozzavalo.getAlapanyag() + "\n");
                        if (szamlalo == termek.getHozzavalok().size()) {
                            PrintWriter pw = new PrintWriter(new FileWriter("recept.txt"));
                            pw.print(recept);
                            pw.close();
                            //System.out.println(recept);
                            vanrecept = true;
                        }
                    }
                }
            }
        }
        if (vanrecept == false) {
            System.out.println("\nA megadott hozzávalókból egy termékhez sem lehet receptet előállítani!");
        }
    }

    public static void main(String[] args) throws IOException {
        HozzavaloTulajdonsag melgszendvicshozzavalo1 = new HozzavaloTulajdonsag(30, "dkg", "bagett", "kg", 500);
        HozzavaloTulajdonsag melgszendvicshozzavalo2 = new HozzavaloTulajdonsag(10, "dkg", "bacon", "kg", 3000);
        HozzavaloTulajdonsag melgszendvicshozzavalo3 = new HozzavaloTulajdonsag(1, "db", "lilahagyma", "db", 50);
        HozzavaloTulajdonsag melgszendvicshozzavalo4 = new HozzavaloTulajdonsag(1, "dl", "tejföl", "dl", 200);

        HozzavaloTulajdonsag limonadehozzavalo1 = new HozzavaloTulajdonsag(1, "db", "citrom", "db", 80);
        HozzavaloTulajdonsag limonadehozzavalo2 = new HozzavaloTulajdonsag(0.5, "liter", "mentes viz", "liter", 150);
        HozzavaloTulajdonsag limonadehozzavalo3 = new HozzavaloTulajdonsag(0.5, "liter", "buborékos viz", "liter", 200);
        HozzavaloTulajdonsag limonadehozzavalo4 = new HozzavaloTulajdonsag(5, "gramm", "cukor", "kg", 500);

        HozzavaloTulajdonsag piskotahozzavalo1 = new HozzavaloTulajdonsag(1, "adag", "piskóta tészta", "adag", 300);
        HozzavaloTulajdonsag piskotahozzavalo2 = new HozzavaloTulajdonsag(100, "gramm", "cukor", "kg", 500);
        HozzavaloTulajdonsag piskotahozzavalo3 = new HozzavaloTulajdonsag(5, "dkg", "lekvár", "kg", 1000);

        List<HozzavaloTulajdonsag> melegszedvicshozzavalok = new ArrayList<HozzavaloTulajdonsag>();
        List<HozzavaloTulajdonsag> limonadehozzavalok = new ArrayList<HozzavaloTulajdonsag>();
        List<HozzavaloTulajdonsag> piskotahozzavalok = new ArrayList<HozzavaloTulajdonsag>();

        melegszedvicshozzavalok.add(melgszendvicshozzavalo1);
        melegszedvicshozzavalok.add(melgszendvicshozzavalo2);
        melegszedvicshozzavalok.add(melgszendvicshozzavalo3);
        melegszedvicshozzavalok.add(melgszendvicshozzavalo4);

        Random random = new Random();
        boolean buborekos = random.nextBoolean();
        limonadehozzavalok.add(limonadehozzavalo1);
        if (buborekos) {
            limonadehozzavalok.add(limonadehozzavalo3);
        } else {
            limonadehozzavalok.add(limonadehozzavalo2);
        }
        limonadehozzavalok.add(limonadehozzavalo4);

        piskotahozzavalok.add(piskotahozzavalo1);
        piskotahozzavalok.add(piskotahozzavalo2);
        piskotahozzavalok.add(piskotahozzavalo3);

        Melegszendvics melegszendvics = new Melegszendvics(MELEGSZENDVICS, 600, melegszedvicshozzavalok, 10);
        Limonade limonade = new Limonade(LIMONADE, 300, limonadehozzavalok, buborekos);
        LekvarosPiskota piskota = new LekvarosPiskota(LEKVAROS_PISKOTA, 400, piskotahozzavalok, 200);

        List<Termek> termekek = Arrays.asList(melegszendvics, limonade, piskota);
        legdragabbAdag(termekek);
        legnagyobbHaszon();

        List<HozzavaloTulajdonsag> menteslimonadehozzavalok = new ArrayList<HozzavaloTulajdonsag>();
        menteslimonadehozzavalok.add(limonadehozzavalo1);
        menteslimonadehozzavalok.add(limonadehozzavalo2);
        menteslimonadehozzavalok.add(limonadehozzavalo4);
        List<HozzavaloTulajdonsag> buborekoslimonadehozzavalok = new ArrayList<HozzavaloTulajdonsag>();
        buborekoslimonadehozzavalok.add(limonadehozzavalo1);
        buborekoslimonadehozzavalok.add(limonadehozzavalo3);
        buborekoslimonadehozzavalok.add(limonadehozzavalo4);
        Limonade menteslimonade = new Limonade(LIMONADE, 300, menteslimonadehozzavalok, false);
        Limonade buborekoslimonade = new Limonade(LIMONADE, 300, buborekoslimonadehozzavalok, true);
        List<Termek> fogyasztas = new ArrayList();
        //apuka elso melegszendvicse
        fogyasztas.add(melegszendvics);
        //apuka masodik melegszendvicse
        fogyasztas.add(melegszendvics);
        //anyuka melegszendvicse
        fogyasztas.add(melegszendvics);
        //gyermek melegszendvicse
        fogyasztas.add(melegszendvics);
        //apuka limonadeja
        fogyasztas.add(buborekoslimonade);
        //anyuka limonadeja
        fogyasztas.add(menteslimonade);
        //gyermek limonadeja
        fogyasztas.add(buborekoslimonade);
        //apuka piskotaja
        fogyasztas.add(piskota);
        //anyuka piskotaja
        fogyasztas.add(piskota);
        //gyermek piskotaja
        fogyasztas.add(piskota);
        egyszerusitettSzamla(fogyasztas);

        List<Termek> termekek2 = Arrays.asList(melegszendvics, menteslimonade, buborekoslimonade, piskota);
        hozzavalobolTermek(termekek2, limonadehozzavalo4);

        List<HozzavaloTulajdonsag> hozzavalok = new ArrayList();
        hozzavalok.add(melgszendvicshozzavalo1);
        hozzavalok.add(melgszendvicshozzavalo2);
        hozzavalok.add(melgszendvicshozzavalo3);
        hozzavalok.add(melgszendvicshozzavalo4);
        Recept(termekek2, hozzavalok);

    }

}
