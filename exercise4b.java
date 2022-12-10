import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class exercise4b{

    public static void main( String[] args){
        exercise4b ex4b = new exercise4b();
        ex4b.run();
    }

    public void run(){

        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex4_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int overlap = 0;
        for(String line : fileContent){
            if(isOverlap(parsePairAtPos(0, line), parsePairAtPos(1, line)) ||
               isCompleteOverlap(parsePairAtPos(0, line), parsePairAtPos(1, line))){
                overlap += 1;
            }
        }   
        System.out.println(overlap);
    }

    public int[] parsePairAtPos(int pos, String line) {
        String[] halfs = line.split( "," , 2);
        String[] pairs = halfs[pos].split("-", 2);

        int[] intPairs = new int[2];
        for(int i=0;i<2;i++){
            try{
                intPairs[i] = Integer.parseInt(pairs[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return intPairs;
    }

    public boolean isOverlap(int[] pairA , int[] pairB){

        if(pairA[0] <= pairB[0] && pairA[1] >= pairB[0] ||
           pairA[0] <= pairB[1] && pairA[1] >= pairB[1] ){
            return true;
           } else {
            return false;
           }
    }

    public boolean isCompleteOverlap(int[] pairA , int[] pairB){

        if(pairA[0] <= pairB[0] && pairA[1] >= pairB[1] ||
           pairB[0] <= pairA[0] && pairB[1] >= pairA[1] ){
            return true;
           } else {
            return false;
           }
    }
}

