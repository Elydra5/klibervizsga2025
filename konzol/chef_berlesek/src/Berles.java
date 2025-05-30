import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Berles {

    public static void haviBevetel() throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy hónapot (1-12): ");
        int month = sc.nextInt();
        int totalPrice = 0;
        for (Adattipus berles : Beolvaso.beolvas()) {
            if (berles.getStartdate().getMonth() + 1 == month) {
                totalPrice += berles.getDaily_rate();
            }
        }
        sc.close();
        System.out.println("Összes bérlési díj az adott hónapban: " + totalPrice);
    }

    public static void TotalPrice() throws FileNotFoundException{
        int totalPrice = 0;
        for (Adattipus berles : Beolvaso.beolvas()) {
            totalPrice += berles.getDaily_rate();
        }
        System.out.println("Összes bérlési díj: " + totalPrice);
    }

    public static void osszBevetel() throws FileNotFoundException{
        int totalIncome = 0;
        for (Adattipus berles : Beolvaso.beolvas()) {
            totalIncome += berles.getDaily_rate();
        }
        System.out.println("Összes bevétel: " + totalIncome);
    }

    public static void legdragabbBerles() throws FileNotFoundException{
        Adattipus legdragabb = null;
        for (Adattipus berles : Beolvaso.beolvas()) {
            if (legdragabb == null || berles.getDaily_rate() > legdragabb.getDaily_rate()) {
                legdragabb = berles;
            }
        }
        if (legdragabb != null) {
            System.out.println("A legdrágább bérlés adatai:");
            System.out.println("Teljes díj: " + (legdragabb.getDaily_rate() * ((legdragabb.getEnddate().getTime() - legdragabb.getStartdate().getTime()) / (1000 * 60 * 60 * 24))));
            System.out.println("Név: " + legdragabb.getName());
        } else {
            System.out.println("Nincs adat.");
        }
    }

    public static void bereltSefekSzama() throws FileNotFoundException{
        int chefCount = 0;
        ArrayList<Integer> chefIds = new ArrayList<>();
        for (Adattipus berles : Beolvaso.beolvas()) {
            if (!chefIds.contains(berles.getChefid())) {
                chefIds.add(berles.getChefid());
                chefCount++;
            }
        }
        System.out.println("Béreltek séfek száma: " + chefCount);
    }

    public static void leggyakrabbanBereltSef() throws FileNotFoundException{
        ArrayList<Adattipus> berlesek = Beolvaso.beolvas();
        HashMap<String, Integer> chefCountMap = new HashMap<>();
        for (Adattipus berles : berlesek) {
            String chefName = berles.getName();
            chefCountMap.put(chefName, chefCountMap.getOrDefault(chefName, 0) + 1);
        }
        int maxCount = 0;
        String mostFrequentChefName = null;
        for (String chefName : chefCountMap.keySet()) {
            int count = chefCountMap.get(chefName);
            if (count > maxCount) {
                maxCount = count;
                mostFrequentChefName = chefName;
            }
        }
            System.out.println("A leggyakrabban bérelt séf neve: " + mostFrequentChefName);
            System.out.println("Bérlések száma: " + maxCount);
    }

    public static void berlesKonyhatipusSzerint() throws FileNotFoundException{
        ArrayList<Adattipus> berlesek = Beolvaso.beolvas();
        HashMap<String, Integer> cuisineCountMap = new HashMap<>();
        for (Adattipus berles : berlesek) {
            String cuisine = berles.getCuisine();
            cuisineCountMap.put(cuisine, cuisineCountMap.getOrDefault(cuisine, 0) + 1);
        }
        System.out.println("Bérlés konyhatípusok szeirnt:");
        for (String cuisine : cuisineCountMap.keySet()) {
            System.out.println(cuisine + ": " + cuisineCountMap.get(cuisine));
        }
    }

    public static void atlagosBerlesiIdo() throws FileNotFoundException{
        ArrayList<Adattipus> berlesek = Beolvaso.beolvas();
        int totalDays = 0;
        for (Adattipus berles : berlesek) {
            long duration = berles.getEnddate().getTime() - berles.getStartdate().getTime();
            totalDays += duration / (1000 * 60 * 60 * 24);
        }
        double averageDays = (double) totalDays / berlesek.size();
        System.out.println(String.format("Átlagos bérlési idő %.2f nap", averageDays));
    }
}
