package pankkitili;

public class PankkitilitTaulukko {
    public static void main(String[] args) {

        Pankkitili[] pankkitili = new Pankkitili[10];

        pankkitili[0] = new Pankkitili(123, 5000);
        pankkitili[1] = new Pankkitili(456, 5000);
        pankkitili[2] = new Pankkitili(789, 5000);

        pankkitili[0].setSaldo(1000);
        pankkitili[1].setSaldo(1000);
        pankkitili[2].setSaldo(1000);

        pankkitili[0].talleta(5000.00);
        pankkitili[1].talleta(50000.00);
        pankkitili[2].talleta(500000.00);

        pankkitili[0].nosta(2500);
        pankkitili[1].nosta(25000);
        pankkitili[2].nosta(250000);

        for (Pankkitili value : pankkitili) {
            if (value != null) {
                System.out.println(value.getSaldo());
            }
        }
    }
}