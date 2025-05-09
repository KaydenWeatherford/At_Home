package Home.Sudoku;
import Home.Sudoku.Sudoku;

public class PlaySudoku{
    public static void main(String[] args){
        Sudoku s = new Sudoku();
        s.generateBoard(3);  // 3 = Hard
        s.displayBoard();
    }
}