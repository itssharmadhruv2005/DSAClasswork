import java.util.*;

public class Main {

    // Check whether num can be placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Solve Sudoku using backtracking
    static boolean solve(int[][] board) {

        // Find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {

                    // Try numbers 1 to 9
                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(board, row, col, num)) {

                            // Place number
                            board[row][col] = num;

                            // Recursively solve
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        // No empty cells left
        return true;
    }

    // Print Sudoku
    static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] board = new int[9][9];

        System.out.println("Enter Sudoku (use 0 for empty cells):");

        // Take input
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // Solve
        if (solve(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}