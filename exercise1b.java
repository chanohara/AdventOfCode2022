import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exercise1b{

    public static void main( String[] args){
        exercise1b ex1b = new exercise1b();
        ex1b.run();
    }

    public void run(){
        ArrayList<Integer> calorieCounts = new ArrayList<Integer>();
        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex1_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int currentFood = 0;
        for (String line : fileContent){
            if (line.trim().isEmpty()){
                calorieCounts.add(currentFood);
                currentFood = 0;
            } else {
                currentFood += Integer.parseInt(line);
            }
        }
        
        Collections.sort(calorieCounts);
        Collections.reverse(calorieCounts);

        int foodSum = 0;
        for(int i = 0;i<3;i++){
            foodSum += calorieCounts.get(i);
        }

        System.out.println(foodSum);
    }

    
}

