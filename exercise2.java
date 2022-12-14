import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

        int totalScore = 0;
        for(String line : fileContent){
            char opponentMove = line.charAt(0);
            char yourMove = line.charAt(2);
            totalScore += calcScore(opponentMove, yourMove);
        }
        System.out.println(totalScore);
    }

    private int calcScore( char opponentMove, char yourMove){
        int score = 0;

        switch(yourMove){
            case 'X': 
                score += 1;
                break;
            case 'Y': 
                score += 2;
                break;
            case 'Z': 
                score += 3;
                break;
        }

        if(yourMove == 'X' && opponentMove == 'A' ||
           yourMove == 'Y' && opponentMove == 'B' ||
           yourMove == 'Z' && opponentMove == 'C'){
            score += 3;
        } else if(yourMove == 'X' && opponentMove == 'C' || 
                  yourMove == 'Y' && opponentMove == 'A' ||
                  yourMove == 'Z' && opponentMove == 'B'){
            score += 6;
        }

        return score;
    }

    
}

