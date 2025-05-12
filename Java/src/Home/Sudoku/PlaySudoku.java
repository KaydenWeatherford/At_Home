package Home.Sudoku;
import Home.Sudoku.Sudoku;
import java.util.Scanner;

public class PlaySudoku{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        Object ans = "";


        System.out.println("Welcome to Sudoku!");
        System.out.println("To start a new game, type \"new\" ");
        System.out.println("To see how to play, type \"info\" ");
        System.out.println("To see commands, type \"help\" ");
        System.out.println("To quit, type \"quit\"");
        
        ans = inp.next();
        
        boolean running = true;
        while (running == true){
            if (ans.equals("quit")) {return;}
            else if (ans.equals("help")){
                System.out.println("\nTo start a new game, type \"new\" ");
                System.out.println("To see how to play, type \"info\" ");
                System.out.println("To see commands, type \"help\"");
                System.out.println("To see the board, type \"board\"");
                System.out.println("To quit, type \"quit\"\n");
                ans = "";
            }
            else if (ans.equals("info")){
                System.out.println("\nA 9×9 square must be filled in with numbers from 1-9
                                    \nwith no repeated numbers in each line, horizontally or vertically.
                                    \nTo challenge you more, there are 3×3 squares marked out in the grid,
                                    \nand each of these squares can\'t have any repeat numbers either.\n");
            }



        }

    }
}