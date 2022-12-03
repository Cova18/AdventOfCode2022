package main;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dayOne {
    public static void main(String[] args) {
        HashMap<String,Integer> elfsAndCalories = (HashMap<String, Integer>) readFile();
        HashMap<String,Integer> topThreeElfs= new HashMap<>();
        String firstElf=Collections.max(elfsAndCalories.entrySet(), Map.Entry.comparingByValue()).getKey();
        int firstElfCalories = elfsAndCalories.get(firstElf);
        System.out.println("l'elfo che porta più calorie " + firstElf + " = " + firstElfCalories);

        int i=1;
        while (i<4){
            String newMaxValue=Collections.max(elfsAndCalories.entrySet(), Map.Entry.comparingByValue()).getKey();
            topThreeElfs.put(newMaxValue,elfsAndCalories.get(newMaxValue));
            elfsAndCalories.remove(newMaxValue);
            i+=1;
        }

        //top 3 total
        System.out.println("top three total calories "+topThreeElfs.values().stream().mapToInt(d->d).sum());

    }
    public static Map<String,Integer> readFile(){
        File myFile = new File("src/inputs/dayOnePuzzleInput");
        HashMap<String, Integer> elfs = new HashMap<>();
        try(Scanner myReader = new Scanner(myFile)) {
            String nameElf = "elf";
            int n=0;
            int total =0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                if(!data.trim().isBlank()) {
                    total += Integer.parseInt(data);
                    elfs.put(nameElf + n, total);
                }
                else {
                    n+=1;
                    total=0;
                }
            }
            System.out.println(elfs);
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return elfs;
    }

}

