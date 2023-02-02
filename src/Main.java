import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        Player playerA = new Player("Player A", 1);
        Player playerB = new Player("Player B", 2);

        while (true) {
            System.out.println("It's " + playerA.getName() + "'s turn.");
            int row = getInput("Enter row (-4): ");
            int col = getInput("Enter column (0-4): ");
            board.shoot(row, col, playerA);

            if (board.wins(playerA)) {
                System.out.println(playerA.getName() + " wins!");
                break;
            }

            if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            System.out.println("It's " + playerB.getName() + "'s turn.");
            row = getInput("Enter row (0-4): ");
            col = getInput("Enter column (0-4): ");
            board.shoot(row, col, playerB);

            if (board.wins(playerB)) {
                System.out.println(playerB.getName() + " wins!");
                break;
            }

            if (board.isDraw()) {
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    public static int getInput(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        return in.nextInt();
    }
}