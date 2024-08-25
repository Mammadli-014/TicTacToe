package util;

import exceptions.TicTacToeException;

import java.util.Scanner;

public class TicTacToe {
    // Player names
    private String player1;
    private String player2;

    // Game board
    private String[][] board;

    // Player turn
    private int turn;

    // Constructor to initialize players and the board
    public TicTacToe(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // Instance initializer block to set up the initial game board
    {
        board = new String[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = String.valueOf(i * 3 + j + 1);
    }

    // Method to check if the game has ended
    private boolean isEnd() {
        boolean result = false;
        LOOP:
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int k = 0;
                if (board[j][k++].equals(board[j][k]) && board[j][k].equals(board[j][++k])) {
                    result = true;
                    break LOOP;
                }
                k = 0;
                if (board[k++][j].equals(board[k][j]) && board[k][j].equals(board[++k][j])) {
                    result = true;
                    break LOOP;
                }
                if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) ||
                        board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
                    result = true;
                    break LOOP;
                }
            }
        return result;
    }

    // Method to start the game
    public void start() {
        turn = 1;
        playTurn();
    }

    // Method to display the current state of the board
    private void display() {
        System.out.println("*  0.1.2.");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + ") ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to get player move
    private int[] selectPosition(int number) throws TicTacToeException {
        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(String.valueOf(number)))
                    return new int[]{i, j};
                else count++;
                {
                    TicTacToeException exception = new TicTacToeException();
                    if (count == 9) throw exception;
                }
            }
        return null;
    }

    // Method to handle player turn
    private void playTurn() {
        display();
        String playerName = (turn % 2 == 1) ? player1 : player2;
        if (isEnd()) {
            System.out.println(playerName + " WINS");
            display();
            System.exit(0);
        }
        String symbol = (turn % 2 == 1) ? "X" : "O";
        Scanner scanner = new Scanner(System.in);
        System.out.println(playerName + ", select your move");
        try {
            int[] position = selectPosition(scanner.nextInt());
            board[position[0]][position[1]] = symbol;
        } catch (TicTacToeException e) {
            System.out.println("Enter a valid number");
            playTurn();
        }
        if (isEnd()) {
            System.out.println(playerName + " WINS!");
            display();
            System.exit(0);
        }
        turn++;
        playTurn();
    }
}
