package Home.Sudoku;
import Home.Sudoku.Sudoku;
import java.util.Scanner;

public class PlaySudoku{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        Object ans = "";
        Boolean playingGame = false;
        gMenu gm = new gMenu();
        Sudoku sudoku = new Sudoku;

        System.out.println("Welcome to Sudoku!");
        gm.help();
        
        ans = inp.next();
        
        boolean running = true;
        while (running == true){
            if (ans.equals("quit")) {return;}
            else if (ans.equals("help")){
                gm.help();
                ans = "";
            }
            else if (ans.equals("info")){
                gm.info();
                ans = "";
            }
            else if (ans.equals("board")){
                if (!playingGame){
                    System.out.pringln("\nThere is no active game. Try starting one with the \"new\" command.\n")
                }
                else {
                    sudoku.displayBoard();
                }
                ans = "";
            }
            else if (ans.equals("new")){
                System.out.println("Would you like to start a new game? (y/n)\n")
                ans = inp.Next();
                if (ans.equals("y") || ans.equals("Y")){
                    System.out.println("Select difficulty: 1-3 \t (1 is Easy, 3 is Hard)")
                    ans=inp.Next();
                    int diff = Integer.parseInt(ans); 
                    sudoku.generateBoard(diff);
                    sudoku.displayBoard();
                    playingGame=true;
                }
                ans = "";
            }
            else {
                if (Integer.parseInt(ans.substring(0,1)) > 0){
                    int r = ans.substring(0,1);
                }
                if (Integer.parseInt(ans.substring(2,3)) > 0){
                    int c = ans.substring(2,3);
                }
                if (Integer.parseInt(ans.substring(4,5) > 0){
                    int num = parseInt(ans.substring(4,5);
                }
                sudoku.setNum(r,c,num);
                ans = "";
            }
            ans = Next();
        }

    }
}