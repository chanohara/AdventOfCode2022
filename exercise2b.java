import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class exercise2b{

    public static void main( String[] args){
        exercise2b ex2b = new exercise2b();
        ex2b.run();
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
            char yourMove = determineYourMove(line.charAt(2), opponentMove);
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

    private char determineYourMove(char result, char opponentMove){
        char yourMove = ' ';

        if(result == 'Y'){ // Draw
            switch(opponentMove){
                case 'A':
                    yourMove = 'X';
                    break;
                case 'B':
                    yourMove = 'Y';
                    break;
                case 'C':
                    yourMove = 'Z';
                    break;
            }
        } else if(result == 'Z'){ // Win
            switch(opponentMove){
                case 'A':
                    yourMove = 'Y';
                    break;
                case 'B':
                    yourMove = 'Z';
                    break;
                case 'C':
                    yourMove = 'X';
                    break;
            }            
        } else if(result == 'X'){ // Loss
            switch(opponentMove){
                case 'A':
                    yourMove = 'Z';
                    break;
                case 'B':
                    yourMove = 'X';
                    break;
                case 'C':
                    yourMove = 'Y';
                    break;
            }
        }

        return yourMove;
    }

    
}

