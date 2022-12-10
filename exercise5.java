import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class exercise5{

    public static void main( String[] args){
        exercise5 ex5 = new exercise5();
        ex5.run();
    }

    public void run(){

        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex5_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Deque> stackList = builtStackList(fileContent);

        for(int i=10;i<fileContent.size();i++){
            executeMove(fileContent.get(i), stackList);
        }
        
        for(Deque stack : stackList){
            System.out.println(stack.getFirst());
        }
    }

    private ArrayList<Deque> builtStackList(List<String> fileContent){
        ArrayList<Deque> stackList = new ArrayList<Deque>();
        for(int i=0; i<9; i++){
            stackList.add(new ArrayDeque<String>());
        }
        
        for(int i=7;i>= 0;i--){
            String line = fileContent.get(i);
            for(int j = 0;j <= 8;j++){
                String element = "";
                if(j==0){
                    element = line.substring(0,3);
                } else {
                    element = line.substring(j*4,j*4+3);
                }
                if(!element.trim().isEmpty()){
                    stackList.get(j).push(element);
                }
                
            }
        }

        return stackList;
    }
    
    private void executeMove(String move, ArrayList<Deque> stackList){
        int[] moveArray = parseMove(move);

        for(int i = 0;i<moveArray[0];i++){
            String elem = (String) stackList.get(moveArray[1]-1).pop();
            stackList.get(moveArray[2]-1).push(elem);
        }
    }

    private int[] parseMove(String move){
        int[] moves = new int[3];
        
        String[] arr = move.split(" ");
        moves[0] = Integer.parseInt(arr[1]);
        moves[1] = Integer.parseInt(arr[3]);
        moves[2] = Integer.parseInt(arr[5]);

        return moves;
    }
}

