import java.util.Random;
import java.util.Scanner;

public class Player {
    public int playerNumber;
    public char playingPiece;

    Player(int x) {
        playerNumber = x;
        if (x == 1) {
            playingPiece = 'X';
        } else {
            playingPiece = 'O';
        }
        return;
    }

    // need to write how computer figures out where the best place to go is if there
    // is no one about to win
    public boolean computerRunChoice(GameBoard gameBoard) {

        int filledCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.gameBoard[i][j] != '\u0000') {
                    filledCount++;
                }
            }
        }
        if (filledCount == 9) {
            System.out.println("It's a tie! Please start a new game.");
            return true;
        }

        Random rand = new Random();
        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[j][k] == playingPiece) {
                    count++;
                    if (count == 2) {
                        for (int w = 0; w < 3; w++) {
                            if (gameBoard.gameBoard[j][w] == '\u0000') {
                                gameBoard.gameBoard[j][w] = playingPiece;
                                System.out.println("Player " + playerNumber + " wins!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[k][j] == playingPiece) {
                    count++;
                    if (count == 2) {
                        for (int w = 0; w < 3; w++) {
                            if (gameBoard.gameBoard[w][j] == '\u0000') {
                                gameBoard.gameBoard[w][j] = playingPiece;
                                System.out.println("Player " + playerNumber + " wins!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (gameBoard.gameBoard[i][i] == playingPiece) {
                count++;
            }
        }
        if (count == 2) {
            for (int i = 0; i < 3; i++) {
                if (gameBoard.gameBoard[i][i] == '\u0000') {
                    gameBoard.gameBoard[i][i] = playingPiece;
                    System.out.println("Player " + playerNumber + " wins!");
                    return true;
                }
            }
        }
        count = 0;
        if (gameBoard.gameBoard[2][0] == playingPiece) {
            count++;
        }
        if (gameBoard.gameBoard[1][1] == playingPiece) {
            count++;
        }
        if (gameBoard.gameBoard[0][2] == playingPiece) {
            count++;
        }
        if (count == 2) {
            if (gameBoard.gameBoard[2][0] == '\u0000') {
                gameBoard.gameBoard[2][0] = playingPiece;
                System.out.println("Player " + playerNumber + " wins!");
                return true;
            }
            if (gameBoard.gameBoard[1][1] == '\u0000') {
                gameBoard.gameBoard[1][1] = playingPiece;
                System.out.println("Player " + playerNumber + " wins!");
                return true;
            }
            if (gameBoard.gameBoard[0][2] == '\u0000') {
                gameBoard.gameBoard[0][2] = playingPiece;
                System.out.println("Player " + playerNumber + " wins!");
                return true;
            }
        }
        // player to win

        for (int j = 0; j < 3; j++) {
            int countB = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[j][k] != playingPiece && gameBoard.gameBoard[j][k] != '\u0000') {
                    countB++;
                    if (countB == 2) {
                        for (int w = 0; w < 3; w++) {
                            if (gameBoard.gameBoard[j][w] == '\u0000') {
                                gameBoard.gameBoard[j][w] = playingPiece;
                                if (j == 0) {
                                    if (w == 0) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 1");
                                    }
                                    if (w == 1) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 4");
                                    }
                                    if (w == 2) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 7");
                                    }
                                }
                                if (j == 1) {
                                    if (w == 0) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 2");
                                    }
                                    if (w == 1) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 5");
                                    }
                                    if (w == 2) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 8");
                                    }
                                }
                                if (j == 2) {
                                    if (w == 0) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 3");
                                    }
                                    if (w == 1) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 6");
                                    }
                                    if (w == 2) {
                                        System.out.println("Player " + playerNumber + " (computer) chooses position 9");
                                    }
                                }

                                return false;
                            }
                        }
                    }
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            int countB = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[k][j] != playingPiece && gameBoard.gameBoard[k][j] != '\u0000') {
                    countB++;
                    if (countB == 2) {
                        for (int w = 0; w < 3; w++) {
                            if (gameBoard.gameBoard[w][j] == '\u0000') {
                                gameBoard.gameBoard[w][j] = playingPiece;
                                return false;
                            }
                        }
                    }
                }
            }
        }
        int countB = 0;
        for (int i = 0; i < 3; i++) {
            if (gameBoard.gameBoard[i][i] != playingPiece && gameBoard.gameBoard[i][i] != '\u0000') {
                countB++;
            }
        }
        if (countB == 2) {
            for (int i = 0; i < 3; i++) {
                if (gameBoard.gameBoard[i][i] == '\u0000') {
                    gameBoard.gameBoard[i][i] = playingPiece;
                    return false;
                }
            }
        }
        countB = 0;
        if (gameBoard.gameBoard[2][0] != playingPiece && gameBoard.gameBoard[2][0] != '\u0000') {
            countB++;
        }
        if (gameBoard.gameBoard[1][1] != playingPiece && gameBoard.gameBoard[1][1] != '\u0000') {
            countB++;
        }
        if (gameBoard.gameBoard[0][2] != playingPiece && gameBoard.gameBoard[0][2] != '\u0000') {
            countB++;
        }
        if (countB == 2) {
            if (gameBoard.gameBoard[2][0] == '\u0000') {
                gameBoard.gameBoard[2][0] = playingPiece;
                return false;
            }
            if (gameBoard.gameBoard[1][1] == '\u0000') {
                gameBoard.gameBoard[1][1] = playingPiece;
                return false;
            }
            if (gameBoard.gameBoard[0][2] == '\u0000') {
                gameBoard.gameBoard[0][2] = playingPiece;
                return false;
            }
        }
        // defense
        if (gameBoard.gameBoard[1][1] == '\u0000') {
            gameBoard.gameBoard[1][1] = playingPiece;
            return false;
        }

        // for if it doesnt matter
        boolean foundEmpty = false;
        while (foundEmpty == false) {
            int randx = rand.nextInt(2);
            int randy = rand.nextInt(2);
            if (gameBoard.gameBoard[randx][randy] == '\u0000') {
                gameBoard.gameBoard[randx][randy] = playingPiece;
                foundEmpty = true;
                return false;
            }
        }

        return true;
    }

    // if you see an X and there are two in the column

    public boolean playerRunChoice(int x, GameBoard gameBoard) {
        int filledCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.gameBoard[i][j] != '\u0000') {
                    filledCount++;
                }
            }
        }
        if (filledCount == 9) {
            System.out.println("It's a tie! Please start a new game.");
            return true;
        }
        Scanner scanner = new Scanner(System.in);
        boolean isTaken = true;
        int loopCount = 0;
        while (isTaken == true) {
            if (loopCount != 0) {
                x = scanner.nextInt();
            }
            if (x <= 9 && x >= 1) {
                switch (x) {
                    case 1:
                        if (gameBoard.gameBoard[0][0] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[0][0] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[0][0] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 2:
                        if (gameBoard.gameBoard[1][0] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[1][0] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[1][0] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 3:
                        if (gameBoard.gameBoard[2][0] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[2][0] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[2][0] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 4:
                        if (gameBoard.gameBoard[0][1] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[0][1] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[0][1] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 5:
                        if (gameBoard.gameBoard[1][1] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[1][1] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[1][1] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 6:
                        if (gameBoard.gameBoard[2][1] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[2][1] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[2][1] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 7:
                        if (gameBoard.gameBoard[0][2] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[0][2] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[0][2] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 8:
                        if (gameBoard.gameBoard[1][2] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[1][2] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[1][2] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                    case 9:
                        if (gameBoard.gameBoard[2][2] != '\u0000') {
                            System.out.println("Please choose a spot that is not taken.");
                            loopCount++;
                        } else {
                            if (playerNumber == 1) {
                                gameBoard.gameBoard[2][2] = 'X';
                            }
                            if (playerNumber == 2) {
                                gameBoard.gameBoard[2][2] = 'O';
                            }
                            isTaken = false;
                        }
                        break;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[j][k] == playingPiece) {
                    count++;
                    if (count == 3) {
                        System.out.println("Player " + playerNumber + " wins!");
                        return true;
                    }
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            int count = 0;
            for (int k = 0; k < 3; k++) {
                if (gameBoard.gameBoard[k][j] == playingPiece) {
                    count++;
                    if (count == 3) {
                        System.out.println("Player " + playerNumber + " wins!");
                        return true;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (gameBoard.gameBoard[i][i] == playingPiece) {
                count++;
            }
        }
        if (count == 3) {
            System.out.println("Player " + playerNumber + " wins!");
            return true;
        }
        count = 0;
        if (gameBoard.gameBoard[2][0] == playingPiece) {
            count++;
        }
        if (gameBoard.gameBoard[1][1] == playingPiece) {
            count++;
        }
        if (gameBoard.gameBoard[0][2] == playingPiece) {
            count++;
        }
        if (count == 3) {
            System.out.println("Player " + playerNumber + " wins!");
            return true;
        }

        return false;
    }

}
