package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class dayThree {
    public static void main(String[] args) {
        File myFile = new File("src/inputs/dayThreePuzzleInput");
        ArrayList<Integer> val = new ArrayList<>();
        ArrayList<Integer> valTwo = new ArrayList<>();
        ArrayList<String> strArray = new ArrayList<>();
        try(Scanner myReader= new Scanner(myFile)) {
            while(myReader.hasNextLine()){
                String data=myReader.nextLine().trim();
                strArray.add(data);
                int mid = data.length()/2;
                String stringOne = data.substring(0,mid);
                String stringTwo = data.substring(mid);
                for(int i=0 ; i< stringOne.length(); i++){
                    if (stringTwo.contains(stringOne.substring(i,i+1))) {
                        char chr= stringOne.substring(i).toCharArray()[0];
                        if(chr >= 97){
                            val.add(chr-96);
                        }else{
                            val.add(chr-64+26);
                        }
                        break;
                    }
                }
            }
            for(int i=0; i<strArray.size();i+=3){
                ArrayList<String> chr =new ArrayList<>();
                for (int f=0; f<strArray.get(i).length();f++) {
                    if (strArray.get(i + 1).contains(strArray.get(i).substring(f, f + 1))) {
                        chr.add(strArray.get(i).substring(f, f + 1));
                    }
                }
                for (String s : chr) {
                    if (strArray.get(i + 2).contains(s)) {
                        char chrTemp = s.toCharArray()[0];
                        if (chrTemp >= 97) {
                            valTwo.add(chrTemp - 96);
                        } else {
                            valTwo.add(chrTemp - 64 + 26);
                        }
                        break;
                    }
                }
                }



            System.out.println("totale: " + val.stream().mapToInt(d->d).sum());
            System.out.println("totale seconda parte: " + valTwo.stream().mapToInt(d->d).sum());

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
