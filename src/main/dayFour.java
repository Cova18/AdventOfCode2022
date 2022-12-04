package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class dayFour {
    public static void main(String[] args){
        File myFile = new File("src/inputs/dayFourPuzzleInput");
        int pairsFullyContain = 0;
        int pairsOverlap = 0;
        try(Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String data =myReader.nextLine().trim();
                Scanner dataScan = new Scanner(data);
                dataScan.useDelimiter("[-,]");
                ArrayList<Integer> firstRange = new ArrayList<>();
                firstRange.add(Integer.valueOf(dataScan.next()));
                firstRange.add(Integer.valueOf(dataScan.next()));
                ArrayList<Integer> secondRange = new ArrayList<>();
                secondRange.add(Integer.valueOf(dataScan.next()));
                secondRange.add(Integer.valueOf(dataScan.next()));


                if((firstRange.get(0) <= secondRange.get(0) && secondRange.get(0)<= firstRange.get(1)) && (firstRange.get(0) <= secondRange.get(1) && secondRange.get(1)<= firstRange.get(1))){
                    pairsFullyContain+=1;
                } else if ((secondRange.get(0) <= firstRange.get(0)  && firstRange.get(0)<= secondRange.get(1)) && (secondRange.get(0) <= firstRange.get(1)  && firstRange.get(1)<= secondRange.get(1))) {
                    pairsFullyContain+=1;
                }

                if ((firstRange.get(0) <= secondRange.get(0) && secondRange.get(0)<= firstRange.get(1)) || (firstRange.get(0) <= secondRange.get(1) && secondRange.get(1)<= firstRange.get(1))){
                    pairsOverlap+= 1;
                }else if ((secondRange.get(0) <= firstRange.get(0)  && firstRange.get(0)<= secondRange.get(1)) && (secondRange.get(0) <= firstRange.get(1) || firstRange.get(1)<= secondRange.get(1))) {
                    pairsOverlap+=1;
                }
            }
            System.out.println("total of pairs fully contain other: "+ pairsFullyContain);
            System.out.println("total of pairs overlapping: "+ pairsOverlap);
        }catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
