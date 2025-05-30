package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Beolvaso {
    private static final String PATH = "chef_koltsegek_2024.csv";
    public static ArrayList<Adattipus> beolvas() throws FileNotFoundException{
        ArrayList<Adattipus> adatok = new ArrayList<>();
        File file = new File(PATH);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNextLine()){
            adatok.add(new Adattipus(sc.nextLine()));
        }
        sc.close();
        return adatok;
    }

    public static void saveToCSV(Adattipus adat) {
        try {
            File file = new File(Beolvaso.PATH);
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String newLine = adat.getId() + ";" + adat.getChefname() + ";" + adat.getDatum() + ";" + adat.getKategoria() + ";" + adat.getOsszeg() + ";" + (adat.getMegjegyzes().isEmpty() ? "" : adat.getMegjegyzes()) + "\n";
            bufferedWriter.write(newLine);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
