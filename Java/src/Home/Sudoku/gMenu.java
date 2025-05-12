package Home.Sudoku;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class gMenu{
    
    private Object[] options = {"new", "info", "help", "quit",};
    private int[] choices;
    
    public gMenu(){
        
    }
    
    public void disOptions(){

        for (int i = 1; i < options.size(); i++){
            System.out.println(options.get(i) + ") - " + findKey(options.get(i)));
        }
        System.out.println("\n" + options.get(0) + ") - " + findKey(options.get(0)));
    }
    
}