package Home.Sudoku;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class gMenu{
    
    private LinkedHashMap<Integer, String> options;
    
    public gMenu(String[] args){
        for (int i = 1; i <= args.length; i++){
            options.put(i, args[i-1]);
        }
        options.put(0, "Exit");
    }
    
    public void disOptions(){

        for (int i = 1; i < options.size(); i++){
            System.out.println(options.get(i) + ") - " + findKey(options.get(i)));
        }
        System.out.println("\n" + options.get(0) + ") - " + findKey(options.get(0)));
    }

    private int findKey(String targetValue){
        int key = -1;
        for (Map.Entry<Integer, String> x : options.entrySet()) {
            if (x.getValue().equals(targetValue)) {
                key = x.getKey();
                break;
            }
        }
        return key;
    }

    
}