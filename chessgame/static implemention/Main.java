import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Static Player setup
        Player player1 = new Player(new Account("player1", "1234", "Player1", "", ""), Color.WHITE);
        Player player2 = new Player(new Account("player2", "1234", "Player2", "", ""), Color.BLACK);

        ChessBoard board = new ChessBoard();

        System.out.println("Game Starting...");
        System.out.println(player1.getName() + " (White) vs " + player2.getName() + " (Black)");
        System.out.println();

        // Predefined static moves for testing
        CellPosition[] fromPositions = {
            new CellPosition(1, 0), new CellPosition(6, 0), // Pawn moves
            new CellPosition(1, 1), new CellPosition(6, 1), // Pawn moves
            new CellPosition(0, 0), new CellPosition(7, 0)  // Rook moves
        };

        CellPosition[] toPositions = {
            new CellPosition(2, 0), new CellPosition(5, 0), // Pawn moves forward
            new CellPosition(2, 1), new CellPosition(5, 1), // Pawn moves forward
            new CellPosition(0, 3), new CellPosition(7, 3)  // Rook moves horizontally
        };

        Player currentPlayer = player1;

        // Play through static moves
        for (int i = 0; i < fromPositions.length; i++) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getColor() + ")");
            CellPosition from = fromPositions[i];
            CellPosition to = toPositions[i];

            Piece piece = board.getCell(from).getPiece();
            if (piece != null && piece.getColor() == currentPlayer.getColor() && piece.validate(from, to)) {
                board.updateBoard(from, to);
                System.out.println("Move " + piece.getClass().getSimpleName() + " from (" + 
                    from.getRow() + ", " + from.getCol() + ") to (" + to.getRow() + ", " + to.getCol() + ")");
            } else {
                System.out.println("Invalid Move! Skipping...");
            }

            // Switch players
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        System.out.println("\nGame Over! Static moves completed.");
    }
}
