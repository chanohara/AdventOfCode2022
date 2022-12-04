import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class exercise3b{

    public static void main( String[] args){
        exercise3b ex3b = new exercise3b();
        ex3b.run();
    }

    public void run(){

        List<String> fileContent = new ArrayList<String>();
        try {
            fileContent = Files.readAllLines(Paths.get("/Users/dennisgauss/Documents/Coding/AdventOfCode2022/ex3_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalPrio = 0;
        ArrayList<String> listBuffer = new ArrayList<String>();
        for(int i=1; i<=fileContent.size();i++){
            if(i%3 == 0){
                totalPrio += determineItemPrio( findComonItem(listBuffer.get(0), listBuffer.get(1), fileContent.get(i-1)));
                listBuffer.clear();
            } else {
                listBuffer.add(fileContent.get(i-1));
            }
        }   
        System.out.println(totalPrio);
    }



    private char findComonItem(String partA, String partB, String partC){
        char commonItem = ' ';

        HashSet<Character> set1 = new HashSet<Character>(convertToList(partA));
        HashSet<Character> set2 = new HashSet<Character>(convertToList(partB));
        HashSet<Character> set3 = new HashSet<Character>(convertToList(partC));
        
        set1.retainAll(set2);
        set1.retainAll(set3);

        Iterator<Character> iter = set1.iterator();
        while(iter.hasNext()){
            commonItem = iter.next();
        }
        return commonItem;
    }

    private int determineItemPrio(char item){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.indexOf(item) + 1;
    }
    
    private List<Character> convertToList(String str) {
        List<Character> tempList = new ArrayList<Character>();
        char[] arr = str.toCharArray();
        for (char a : arr) {
            tempList.add(a);
        }
        return tempList;
    }
}

