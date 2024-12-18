import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1 Name:");
        Player player1 = new Player(new Account(scanner.nextLine(), "1234", "Player1", "", ""), Color.WHITE);
        System.out.println("Enter Player 2 Name:");
        Player player2 = new Player(new Account(scanner.nextLine(), "1234", "Player2", "", ""), Color.BLACK);

        ChessBoard board = new ChessBoard();
        Player currentPlayer = player1;

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getColor() + ")");
            System.out.print("Enter move (fromRow fromCol toRow toCol): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            CellPosition from = new CellPosition(fromRow, fromCol);
            CellPosition to = new CellPosition(toRow, toCol);

            Piece piece = board.getCell(from).getPiece();
            if (piece != null && piece.getColor() == currentPlayer.getColor() && piece.validate(from, to)) {
                board.updateBoard(from, to);
                System.out.println("Move Successful!");
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid Move! Try Again.");
            }
        }
    }
}
