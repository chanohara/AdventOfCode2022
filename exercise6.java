import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class exercise6{

    static final int messageLength = 4;

    public static void main( String[] args){
        exercise6 ex6 = new exercise6();
        ex6.run();
    }

    public void run(){
        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex6_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = fileContent.get(0);
        HashSet set = new HashSet();
        for(int i=0;i<input.length()-messageLength;i++){
            set.clear();
            for(int j=0;j<messageLength;j++){
                set.add(input.charAt(i+j));
            }

            if(set.size() == messageLength){
                System.out.println(i+messageLength);
                return;
            }

        }
    }

}

