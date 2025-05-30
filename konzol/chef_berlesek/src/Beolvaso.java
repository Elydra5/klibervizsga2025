import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Beolvaso {
    private static final String PATH = "chef_berlesek_2024.csv";
    public static ArrayList<Adattipus> beolvas() throws FileNotFoundException{
        ArrayList<Adattipus> berlesek = new ArrayList<>();
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while (scanner.hasNextLine()){
            berlesek.add(new Adattipus(scanner.nextLine()));
        }
        scanner.close();
        return berlesek;
    }
}
