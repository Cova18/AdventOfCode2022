package main;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class dayTwo {
    public static void main(String[] args) {
        File myFile = new File("src/inputs/dayTwoPuzzleInput");
        HashMap<String, Integer> combo = new HashMap<>();
        HashMap<String, Integer> comboTwo = new HashMap<>();
        /*
        * A X rock   1
        * B Y paper  2
        * C Z scisor 3
        * */
        combo.put("A X",4);
        combo.put("B Y",5);
        combo.put("C Z",6);
        combo.put("A Y",8);
        combo.put("A Z",3);
        combo.put("B X",1);
        combo.put("B Z",9);
        combo.put("C Y",2);
        combo.put("C X",7);
        comboTwo.put("A X",3);
        comboTwo.put("B Y",5);
        comboTwo.put("C Z",7);
        comboTwo.put("A Y",4);
        comboTwo.put("A Z",8);
        comboTwo.put("B X",1);
        comboTwo.put("B Z",9);
        comboTwo.put("C Y",6);
        comboTwo.put("C X",2);

        int total = 0;
        int totalTwo =0;

        try(Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String data= myReader.nextLine().trim();
                total += combo.get(data);
                totalTwo+=comboTwo.get(data);
            }
            System.out.println("il punteggio totale è: "+ total);
            System.out.println("il punteggio totale parte due è: "+ totalTwo);
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}