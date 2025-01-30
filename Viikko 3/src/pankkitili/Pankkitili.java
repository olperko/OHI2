package pankkitili;

import java.util.Date;

public class Pankkitili {
    private int id;
    private double saldo;
    private static double vuosiKorko = 0;
    private Date luontiPaiva; // olion voi luoda myös tässä = new Date() tai new LocalDate()


    public Pankkitili() {
        this.id = 0;
        this.saldo = 0;
        this.luontiPaiva = new Date();
    }

    public Pankkitili(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
        this.luontiPaiva = new Date();
    }

    public Pankkitili(Pankkitili p) {
        this.id = p.id;
        this.saldo = p.saldo;
        this.luontiPaiva = new Date();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static double getVuosiKorko() {
        return vuosiKorko;
    }
    public static void setVuosiKorko(double vuosiKorko) {
        Pankkitili.vuosiKorko = vuosiKorko;
    }

    public Date getLuontiPaiva() {

        return luontiPaiva;
    }

    public double getKuukausiKorkoProsentti() {

        return getVuosiKorko() / 12;
    }
    public double getKuukausiKorko() {

        return saldo * getKuukausiKorkoProsentti()/100;
    }

    public void nosta(double summa) { // rahan riittävyyttä ei tarvitse tarkastaa

        if (summa <= saldo) {
            saldo = saldo - summa;
        }
        else {
            System.out.println("nostettiin " + saldo + "euroa. Tili tyhjä.");
            saldo = 0;
        }
    }
    public void talleta(double summa) { // negatiivista rahamäärää ei tarvitse tarkastaa

        if (summa > 0) {
            saldo += summa;
        }
        else {
            System.out.println("ei voida tallettaa negatiivista summaa. ");
        }
    }

    public boolean equals(Pankkitili p1, Pankkitili p2) {

        return p1.equals(p2);
    }

    public boolean enemmanRahaa(Pankkitili p1, Pankkitili p2) {

        return p1.getSaldo() > p2.getSaldo();
    }

    public static void main2(String[] args) {

        Pankkitili pankkitili1 = new Pankkitili(112233, 25000);
        Pankkitili.setVuosiKorko(1.5);

        pankkitili1.nosta(2300);
        pankkitili1.talleta(3500);

        System.out.println("Tilin " + pankkitili1.getId() + " saldo on " + pankkitili1.getSaldo()
                + ", tilin kuukausikorko on " + pankkitili1.getKuukausiKorko()
                + ". Tili on luotu " + pankkitili1.getLuontiPaiva());
    }

    public void main(String[] args) {

        Pankkitili pankkitili2 = new Pankkitili(123456, 1000);
        Pankkitili pankkitili3 = new Pankkitili(789123, 2000);
        Pankkitili pankkitili4 = new Pankkitili(pankkitili2);

        System.out.println(pankkitili2.toString());
        System.out.println(pankkitili3.toString());
        System.out.println(pankkitili4.toString());

        System.out.println(equals(pankkitili2, pankkitili3));
        System.out.println(equals(pankkitili2, pankkitili4));
        System.out.println(equals(pankkitili2, pankkitili2));

        System.out.println(enemmanRahaa(pankkitili2, pankkitili2));
        System.out.println(enemmanRahaa(pankkitili2, pankkitili4));

    }
}
