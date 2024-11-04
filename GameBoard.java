public class GameBoard {

    static char[][] gameBoard = new char[3][3];

    public static void printGameBoard() {

        System.out.print("    ");
        for (int i = 1; i <= 3; i++) {
            System.out.print("| " + i + " ");
        }
        System.out.println("|");

        for (int j = 1; j <= 3; j++) {
            System.out.print("  " + j + " ");
            for (int i = 1; i <= 3; i++) {
                if ((gameBoard[i - 1][j - 1]) != '\u0000') {
                    System.out.print("| " + gameBoard[i - 1][j - 1] + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
    }
}
