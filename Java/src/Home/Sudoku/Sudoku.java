package Home.Sudoku;

import java.util.Random;

public class Sudoku {
    private static int[][] board = new int[9][9];
    private static int[][] hiddenBoard = new int[9][9];

    public Sudoku() {
        // generates a random board
        board = generateBoard(0);
    }

    // board with difficulty
    public Sudoku(int dif) {
        board = generateBoard(dif);
    }

    // custom board
    public Sudoku(int[][] customBoard) {
        if (customBoard.length == 9 && customBoard[0].length == 9) {
            board = customBoard;
        } else {
            throw new IllegalArgumentException("Board must be 9x9.");
        }
    }

    // Checks if valid and completed Sudoku
    public boolean checkBoard() {
        // check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int val = board[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check 3x3
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] seen = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int val = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (val < 1 || val > 9 || seen[val]) return false;
                        seen[val] = true;
                    }
                }
            }
        }

        
        return true;
    }

    public int[][] generateBoard(int difficulty) {
        int[][] newBoard = new int[9][9];
        fillBoard(newBoard);
        hiddenBoard = newBoard;
        // Number of cells to remove based on difficulty
        int cellsToRemove = >switch (difficulty) {
            case 1 -> 35; // Easy
            case 2 -> 45; // Medium
            case 3 -> 55; // Hard
            default -> 45; // Default to medium if out of range
        }; // thanks gpt

        removeCells(newBoard, cellsToRemove);
        board = newBoard;
        return newBoard;
    }


    private void removeCells(int[][] board, int cellsToRemove) {
        Random rand = new Random();
        while (cellsToRemove > 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    private boolean fillBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num : getShuffledNumbers()) {
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false; // goback
                }
            }
        }
        return true; // Board is filled
    }

    // checks if a number can be placed
    private boolean isValidPlacement(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // thanks gpt for getting me suffled numbers
    private java.util.List<Integer> getShuffledNumbers() {
        java.util.List<Integer> nums = new java.util.ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        java.util.Collections.shuffle(nums);
        return nums;
    }

    // displays the  board to the console
    public void displayBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // in case I need it
    public static int[][] getBoard() {
        return board;
    }
}
