package w29_03_26;

import java.util.Scanner;

public class Tic_tac_toe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] tac = new char[3][3];

        // Initialize board
        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                tac[rows][cols] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {

            print_board(tac);
            System.out.println("Player " + player + ", enter row and column (0-2):");

            int row = sc.nextInt();
            int col = sc.nextInt();

            // Input validation
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid coordinates! Try again.");
                continue;
            }

            // Check if cell is empty
            if (tac[row][col] != ' ') {
                System.out.println("Cell already occupied! Try again.");
                continue;
            }

            // Make move
            tac[row][col] = player;

            // Check win
            if (winning(tac, player)) {
                print_board(tac);
                System.out.println("🎉 Player " + player + " has won!");
                gameOver = true;
                break;
            }

            // Check draw
            if (isDraw(tac)) {
                print_board(tac);
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    public static void print_board(char[][] tac) {
        System.out.println();

        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                System.out.print(tac[rows][cols]);
                if (cols < 2) System.out.print(" | ");
            }
            System.out.println();

            if (rows < 2) {
                System.out.println("---------");
            }
        }

        System.out.println();
    }

    public static boolean winning(char[][] tac, char player) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (tac[i][0] == player && tac[i][1] == player && tac[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (tac[0][i] == player && tac[1][i] == player && tac[2][i] == player) {
                return true;
            }
        }

        // Diagonals
        if (tac[0][0] == player && tac[1][1] == player && tac[2][2] == player) {
            return true;
        }

        if (tac[0][2] == player && tac[1][1] == player && tac[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isDraw(char[][] tac) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tac[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}