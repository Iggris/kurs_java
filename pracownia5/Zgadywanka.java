import rozgrywka.Gra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Zgadywanka {
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("logging.properties")
            );
        } catch (IOException e) {
            System.err.println("Nie udało się wczytać logging.properties: " + e.getMessage());
        }
        Gra gra = new Gra();
        gra.start(10);
        gra.graj();
    }
}
