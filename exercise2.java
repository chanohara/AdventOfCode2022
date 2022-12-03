import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exercise2{

    public static void main( String[] args){
        exercise2 ex2 = new exercise2();
        ex2.run();
    }

    public void run(){

        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex2_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

    
}

