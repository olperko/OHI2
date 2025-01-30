package pankkitili;

import java.util.Scanner;

public class PankkitiliValikko {

    private static final String menu =
            """
            1. Tilin valinta
            2. Saldon tarkistus
            3. Rahan nosto tililtä
            4. Rahan tallennus tilille
            5. Poistuminen ohjelmasta
            """;

    private Pankkitili[] tilit;
    private Pankkitili valittuTili;
    private Scanner scanner;

    public PankkitiliValikko() {
        tilit = new Pankkitili[9];
        tilit[0] = new Pankkitili(123, 5000);
        tilit[1] = new Pankkitili(456, 5000);
        tilit[2] = new Pankkitili(789, 5000);
        scanner = new Scanner(System.in);
    }

    public void kaynnista() {
        int valinta = 0;
        while (valinta != 5) {
            System.out.println(menu);
            System.out.println("Syötä numero valikosta: ");

            try {
                valinta = Integer.parseInt(scanner.nextLine());
                kasitteleValinta(valinta);
            } catch (NumberFormatException e) {
                System.out.println("Virheellinen syöte. Anna numero.");
            }
        }
    }

    private void kasitteleValinta(int valinta) {
        switch (valinta) {
            case 1 -> valitseTili();
            case 2 -> tarkistaSaldo();
            case 3 -> nostaRahaa();
            case 4 -> talletaRahaa();
            case 5 -> {}
            default -> System.out.println("Valinnan on oltava numero väliltä 1 - 5.");
        }
    }

    private void valitseTili() {
        System.out.println("Syötä tilinumero: ");
        try {
            int tilinumero = Integer.parseInt(scanner.nextLine());
            for (Pankkitili tili : tilit) {
                if (tili != null && tili.getId() == tilinumero) {
                    valittuTili = tili;
                    System.out.println("Tili valittu.");
                    return;
                }
            }
            System.out.println("Tiliä ei löytynyt.");
        } catch (NumberFormatException e) {
            System.out.println("Virheellinen tilinumero.");
        }
    }

    private void tarkistaSaldo() {
        if (valittuTili == null) {
            System.out.println("Valitse ensin tili.");
            return;
        }
        System.out.println("Tilin saldo: " + valittuTili.getSaldo());
    }

    private void nostaRahaa() {
        if (valittuTili == null) {
            System.out.println("Valitse ensin tili.");
            return;
        }
        System.out.println("Syötä nostettava summa: ");
        try {
            double summa = Double.parseDouble(scanner.nextLine());
            valittuTili.nosta(summa);
            System.out.println("Nosto onnistui. Uusi saldo: " + valittuTili.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Virheellinen summa.");
        }
    }

    private void talletaRahaa() {
        if (valittuTili == null) {
            System.out.println("Valitse ensin tili.");
            return;
        }
        System.out.println("Syötä talletettava summa: ");
        try {
            double summa = Double.parseDouble(scanner.nextLine());
            valittuTili.talleta(summa);
            System.out.println("Talletus onnistui. Uusi saldo: " + valittuTili.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Virheellinen summa.");
        }
    }

    public static void main(String[] args) {
        new PankkitiliValikko().kaynnista();
    }
}
