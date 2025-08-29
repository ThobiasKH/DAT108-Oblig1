package oblig1;
import java.util.*;
import java.util.stream.*;

public class Oppg3 {
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

        System.out.println("Ansatte:");
        skrivUtAlleAnsatte(ansatte);

        // a
        System.out.println("Etternavn:");
        List<String> etternavn = ansatte.stream().map(Ansatt::getEtternavn).toList();

        for (String e : etternavn) {
            System.out.println(e);
        }
        System.out.println();

        // b
        int antallKvinner = (int) ansatte.stream().filter(a -> a.kjonn == Kjonn.KVINNE).count();
        System.out.println("Antall kvinner = " + antallKvinner);

        // c 
        double snittKvinner = ansatte.stream().filter(a -> a.kjonn == Kjonn.KVINNE)
            .mapToInt(Ansatt::getLonn)
            .average()
            .orElse(0);
        System.out.println("Snitt lønn kvinner = " + snittKvinner);

        // d 
        ansatte.stream()
            .filter(a -> a.stilling.toLowerCase().contains("ceo"))
            .forEach(a -> a.aarslonn = (int)(a.aarslonn * 1.07));
        System.out.println("Lønn etter sjef-økning: ");
        skrivUtAlleAnsatte(ansatte);

        // e 
        boolean noenOver800k = ansatte.stream()
            .anyMatch(a -> a.aarslonn > 800000);
        System.out.println(noenOver800k ? "Ja, noen har over 800k i lønn" : "Nei, alle har 800k eller mindre i lønn");

        // f 
        int minLonn = ansatte.stream()
            .mapToInt(Ansatt::getLonn)
            .min()
            .orElse(Integer.MAX_VALUE); 
        List<Ansatt> lavestLonn = ansatte.stream()
            .filter(a -> a.aarslonn == minLonn).toList();
        System.out.println("Ansatt(e) med lavest lønn: " + lavestLonn);
        System.out.println();

        // e
        int sumDivisible = IntStream.range(1, 1000)
            .filter(n -> n % 3 == 0 || n % 5 == 0)
            .sum();
        System.out.println("h) Sum [1,1000) delelig med 3 eller 5: " + sumDivisible);

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

    public String getEtternavn() {return etternavn;}
    public int getLonn() {return aarslonn;}

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
