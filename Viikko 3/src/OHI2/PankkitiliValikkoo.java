package OHI2;

import java.util.Scanner;

public class PankkitiliValikkoo {
    private static final String MENU =
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

    public PankkitiliValikkoo() {
        tilit = new Pankkitili[10];
        tilit[0] = new Pankkitili(123, 5000);
        tilit[1] = new Pankkitili(456, 5000);
        tilit[2] = new Pankkitili(789, 5000);
        scanner = new Scanner(System.in);
    }

    public void kaynnista() {
        int valinta;
        do {
            System.out.println(MENU);
            System.out.print("Syötä numero valikosta: ");
            valinta = scanner.nextInt();

            switch (valinta) {
                case 1 -> {
                    System.out.print("Syötä tilinumero: ");
                    int tilinumero = scanner.nextInt();
                    for (Pankkitili tili : tilit) {
                        if (tili != null && tili.getId() == tilinumero) {
                            valittuTili = tili;
                            System.out.println("Tili valittu.");
                            break;
                        }
                    }
                    if (valittuTili == null) {
                        System.out.println("Tiliä ei löytynyt.");
                    }
                }
                case 2 -> {
                    if (valittuTili != null) {
                        System.out.println("Saldo: " + valittuTili.getSaldo());
                    } else {
                        System.out.println("Valitse ensin tili.");
                    }
                }
                case 3 -> {
                    if (valittuTili != null) {
                        System.out.print("Syötä nostettava summa: ");
                        double summa = scanner.nextDouble();
                        valittuTili.nosta(summa);
                    } else {
                        System.out.println("Valitse ensin tili.");
                    }
                }
                case 4 -> {
                    if (valittuTili != null) {
                        System.out.print("Syötä talletettava summa: ");
                        double summa = scanner.nextDouble();
                        valittuTili.talleta(summa);
                    } else {
                        System.out.println("Valitse ensin tili.");
                    }
                }
                case 5 -> System.out.println("Kiitos käynnistä. Näkemiin!");
                default -> System.out.println("Virheellinen valinta.");
            }
        } while (valinta != 5);
    }

    public static void main(String[] args) {
        new PankkitiliValikkoo().kaynnista();
    }
}
