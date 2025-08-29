package oblig1;
import java.util.*;
import java.util.function.*;

public class Oppg2 {
    public static void main(String[] args) {
        Ansatt kåre = new Ansatt("Kåre", "Pedersen", Kjonn.MANN, "CTO", 5000000); 
        Ansatt karina = new Ansatt("Karina", "Pedersen", Kjonn.KVINNE, "CEO", 99999999);
        Ansatt jakob = new Ansatt("Jakob", "Knudsen", Kjonn.MANN, "Vaktmester", 486000);
        Ansatt leah = new Ansatt("Leah", "Yeah", Kjonn.KVINNE, "Artist", 325000); 
        Ansatt peder = new Ansatt("Peder", "Kåresen", Kjonn.MANN, "Økonom", 965000);

        List<Ansatt> ansatte = new ArrayList<>();
        ansatte.add(kåre);
        ansatte.add(karina);
        ansatte.add(jakob);
        ansatte.add(leah);
        ansatte.add(peder);

        System.out.println("Ansatte før oppgjør:");
        skrivUtAlleAnsatte(ansatte);

        // i
        System.out.println("Ansatte etter fast kronetillegg:");
        lonnsoppgjor(ansatte, a -> a.aarslonn + 5);
        skrivUtAlleAnsatte(ansatte);

        // ii
        System.out.println("Ansatte etter prosentøkning:");
        lonnsoppgjor(ansatte, a -> (int) (a.aarslonn * 1.05));
        skrivUtAlleAnsatte(ansatte);

        // iii
        System.out.println("Ansatte etter fast økning for alle under 500,000:");
        lonnsoppgjor(ansatte, a -> a.aarslonn < 500000 ? a.aarslonn + 1 : a.aarslonn);
        skrivUtAlleAnsatte(ansatte);

        // iii
        System.out.println("Ansatte etter prosentøkning for alle under 500,000:");
        lonnsoppgjor(ansatte, a -> a.aarslonn < 500000 ? (int)(a.aarslonn * 1.01) : a.aarslonn);
        skrivUtAlleAnsatte(ansatte);
    }

    public static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
        for (Ansatt a : ansatte) {
            a.aarslonn = f.apply(a);
        }
    }

    public static void skrivUtAlleAnsatte(List<Ansatt> ansatte) {
        ansatte.forEach(System.out::println);
        System.out.println();
    }


}

class Ansatt {
    public String fornavn;
    public String etternavn;
    public Kjonn kjonn;
    public String stilling;
    public int aarslonn;
    public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }


    @Override 
    public String toString() {
        return fornavn + etternavn + " | " + stilling + " | " + Integer.toString(aarslonn) + "kr";
    }
}

enum Kjonn {
    MANN, 
    KVINNE,
    ANNET
}
