import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class exercise1{

    public static void main( String[] args){
        exercise1 ex1 = new exercise1();
        ex1.run();
    }

    public void run(){
        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex1_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        int mostFood = 0;
        int currentFood = 0;
        for (String line : fileContent){
            if (line.trim().isEmpty()){
                if (currentFood > mostFood){
                    mostFood = currentFood;
                }
                currentFood = 0;
            } else {
                currentFood += Integer.parseInt(line);
            }
        }

        System.out.println(mostFood);
    }

    
}

