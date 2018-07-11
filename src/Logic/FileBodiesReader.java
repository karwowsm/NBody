package Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateusz
 */
public class FileBodiesReader {

    public static ArrayList<Body> readFile(File f) throws IOException {
        if (f == null) {
            throw new IOException("Nie wybrałeś pliku z danymi wejściowymi.");
        }
        FileReader fr = new FileReader(f);
        BufferedReader b = new BufferedReader(fr);
        String line = null;

        int b_number = 0;   //liczba cial
        if ((line = b.readLine()) != null) {
            try {
                b_number = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Zly format pliku z danymi: Nie odczytano liczby cial.");
            }
        }
        if (b_number <= 0) {
            throw new IllegalArgumentException("Błąd! Liczba ciał równa " + b_number + ", nie jest poprawna!");
        }

        ArrayList<Body> bodies = new ArrayList<>(b_number);
        String[] lines = new String[3];
        for (int i = 0; i < b_number; i++) {
            for (int j = 0; j < 3; j++) {
                lines[j] = b.readLine();
                if (lines[j] == null) {
                    throw new IllegalArgumentException("Zly format pliku z danymi: Podana liczba ciał niezgodna z dalsza iloscia danych.\n\tBrak linii " + (2 + i * 3) + " - " + (1 + (i + 1) * 3));
                }
            }
            String[] pos = lines[1].split("\\s+");
            String[] vel = lines[2].split("\\s+");
            if (pos.length == 3 && vel.length == 3) {
                try {
                    bodies.add(i, new Body(Double.parseDouble(lines[0]), new Vector(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2])), new Vector(Double.parseDouble(vel[0]), Double.parseDouble(vel[1]), Double.parseDouble(vel[2]))));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Zly format pliku z danymi: \n\tBlad pomiedzy liniami " + (2 + i * 3) + " - " + (1 + (i + 1) * 3));
                }
                if (bodies.get(i).mass <= 0) {
                    throw new IllegalArgumentException("Zły format pliku z danymi: Masa ciała musi być dodatnia.\n\tBlad w linii " + (2 + i * 3));
                }
            } else {
                throw new IllegalArgumentException("Zly format pliku z danymi: \n\tBlad pomiedzy liniami " + (2 + i * 3) + " - " + (1 + (i + 1) * 3));
            }
        }
        return bodies;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Body> bs = readFile(new File("C:\\Users\\Mateusz\\Desktop\\reader_test1.txt"));
            for (Body b : bs) {
                System.out.println(b);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileBodiesReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
