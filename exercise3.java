import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class exercise3{

    public static void main( String[] args){
        exercise3 ex3 = new exercise3();
        ex3.run();
    }

    public void run(){

        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex3_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalPrio = 0;
        for(String line : fileContent){
            int midPoint = line.length() / 2;
            totalPrio += determineItemPrio( findComonItem(line.substring(0, midPoint), line.substring(midPoint)));
        }   
        System.out.println(totalPrio);
    }



    private char findComonItem(String partA, String partB){
        char commonItem = ' ';
        for(char c : partA.toCharArray()){
            if(partB.indexOf(c) >= 0){
                commonItem = c;
            }
        }

        return commonItem;
    }

    private int determineItemPrio(char item){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(item) + 1;
    }
    
}

