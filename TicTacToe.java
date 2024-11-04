import java.util.Scanner;

//need to make computer and non computer options
//need to make a loop to go through and ask moves
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;
        // take in what types the players will be
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        GameBoard startingGameBoard = new GameBoard();
        System.out.println("Game Board: ");
        GameBoard.printGameBoard();
        if (args.length == 0) {
            while (winner == false) {
                int filledCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (startingGameBoard.gameBoard[i][j] != '\u0000') {
                            filledCount++;
                        }
                    }
                }
                if (filledCount == 9) {
                    System.out.println("It's a tie! Please start a new game.");
                    winner = true;
                }
                if (winner == true) {
                    return;
                }
                System.out.println("Player 1, please enter a move (1-9): ");
                int nextMove = scanner.nextInt();
                while (!(nextMove <= 9 && nextMove >= 1)) {
                    System.out.println("Please enter a number between 1 and 9: ");
                    nextMove = scanner.nextInt();
                }
                winner = player1.playerRunChoice(nextMove, startingGameBoard);
                GameBoard.printGameBoard();
                filledCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (startingGameBoard.gameBoard[i][j] != '\u0000') {
                            filledCount++;
                        }
                    }
                }
                if (filledCount == 9) {
                    System.out.println("It's a tie! Please start new game.");
                    winner = true;
                }
                if (winner == true) {
                    return;
                }
                System.out.println("Player 2, please enter a move (1-9): ");
                nextMove = scanner.nextInt();
                winner = player2.playerRunChoice(nextMove, startingGameBoard);
                GameBoard.printGameBoard();
            }
        }

        else if (args.length == 1 && args[0].equals("-c")) {
            while (winner == false) {
                // System.out.println("Player 1, your turn.");
                winner = player1.computerRunChoice(startingGameBoard);
                GameBoard.printGameBoard();
                if (winner == true) {
                    return;
                }
                // System.out.println("Player 2, your turn");
                winner = player2.computerRunChoice(startingGameBoard);
                GameBoard.printGameBoard();
                int filledCount = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (startingGameBoard.gameBoard[i][j] != '\u0000') {
                            filledCount++;
                        }
                    }
                }
                if (filledCount == 9) {
                    System.out.println("It's a tie! Please start a new game.");
                    winner = true;
                }
                if (winner == true) {
                    return;
                }
            }
        }

        else if (args.length == 2 && args[0].equals("-c")) {
            if (args[1].equals("1")) {
                while (winner == false) {
                    // System.out.println("Player 1, your turn.");
                    winner = player1.computerRunChoice(startingGameBoard);
                    GameBoard.printGameBoard();
                    int filledCount = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (startingGameBoard.gameBoard[i][j] != '\u0000') {
                                filledCount++;
                            }
                        }
                    }
                    if (filledCount == 9) {
                        System.out.println("It's a tie! Please start a new game.");
                        winner = true;
                    }
                    if (winner == true) {
                        return;
                    }
                    System.out.println("Player 2, please enter a move (1-9): ");
                    int nextMove = scanner.nextInt();
                    winner = player2.playerRunChoice(nextMove, startingGameBoard);
                    GameBoard.printGameBoard();
                }
            } else if (args[1].equals("2")) {
                while (winner == false) {
                    System.out.println("Player 1, please enter a move (1-9): ");
                    int nextMove = scanner.nextInt();
                    winner = player1.playerRunChoice(nextMove, startingGameBoard);
                    GameBoard.printGameBoard();
                    int filledCount = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (startingGameBoard.gameBoard[i][j] != '\u0000') {
                                filledCount++;
                            }
                        }
                    }
                    if (filledCount == 9) {
                        System.out.println("It's a tie! Please start a new game.");
                        winner = true;
                    }
                    if (winner == true) {
                        return;
                    }

                    // System.out.println("Player 2, your turn");
                    winner = player2.computerRunChoice(startingGameBoard);
                    GameBoard.printGameBoard();
                }
            }
        }
    }
}
