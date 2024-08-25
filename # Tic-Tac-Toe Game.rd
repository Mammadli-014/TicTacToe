# Tic-Tac-Toe Game

This is a simple console-based Tic-Tac-Toe game implemented in Java. The game allows two players to take turns selecting their moves on a 3x3 grid. The first player to align three of their symbols (either 'X' or 'O') in a row, column, or diagonal wins the game.

## Project Structure

The project is organized into three main classes:

1. **TicTacToe**: This class contains the game logic, including the methods to initialize the board, handle player turns, and check if the game has ended.
2. **Main**: This is the entry point of the application. It creates an instance of the `TicTacToe` class and starts the game.
3. **TicTacToeException**: This class defines a custom exception used to handle invalid player moves (e.g., selecting a position that has already been taken).

## How to Run the Game

To run the game, follow these steps:

1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/your-username/tic-tac-toe.git
    ```
2. Navigate to the project directory:
    ```bash
    cd tic-tac-toe
    ```
3. Compile the Java files:
    ```bash
    javac -d out src/util/TicTacToe.java src/Main.java src/exceptions/TicTacToeException.java
    ```
4. Run the game:
    ```bash
    java -cp out Main
    ```

## How to Play

1. The game prompts each player to enter their name.
2. The board is displayed with numbers from 1 to 9 representing the available positions.
3. Players take turns selecting a position by entering the corresponding number.
4. The game checks for a win after each move. If a player wins, a message is displayed and the game ends.
5. If all positions are filled and no player has won, the game ends in a draw.

## Example Gameplay

