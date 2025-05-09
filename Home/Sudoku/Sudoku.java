public class Sudoku {
    private static int[][] board = new int[9][9];

    // Default constructor
    public Sudoku() {
        // Optionally, generate a random board on instantiation
        board = generateBoard();
    }

    // Constructor with custom board
    public Sudoku(int[][] customBoard) {
        if (customBoard.length == 9 && customBoard[0].length == 9) {
            board = customBoard;
        } else {
            throw new IllegalArgumentException("Board must be 9x9.");
        }
    }

    // Checks if the current board is a valid, completed Sudoku
    public boolean checkBoard() {
        // Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int val = board[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check 3x3 subgrids
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

    // Generates a placeholder board (you can later add a backtracking generator)
    public int[][] generateBoard(int difficulty) {
    int[][] newBoard = new int[9][9];
    fillBoard(newBoard);

    // Number of cells to remove based on difficulty
    int cellsToRemove = switch (difficulty) {
        case 1 -> 35; // Easy
        case 2 -> 45; // Medium
        case 3 -> 55; // Hard
        default -> 45; // Default to medium if out of range
    };

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

    // Displays the current board to the console
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

    // Optional: getter to access the board
    public static int[][] getBoard() {
        return board;
    }
}
