public class ChessBoard {
    private Cell[][] board;

    public ChessBoard() {
        board = new Cell[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(new CellPosition(i, j));
            }
        }

        // Place initial pieces for both players (simplified example with pawns and rooks)
        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(new Pawn(Color.WHITE));
            board[6][j].setPiece(new Pawn(Color.BLACK));
        }
        board[0][0].setPiece(new Rook(Color.WHITE));
        board[7][0].setPiece(new Rook(Color.BLACK));
    }

    public Cell getCell(CellPosition position) {
        return board[position.getRow()][position.getCol()];
    }

    public void updateBoard(CellPosition from, CellPosition to) {
        Cell fromCell = getCell(from);
        Cell toCell = getCell(to);
        toCell.setPiece(fromCell.getPiece());
        fromCell.setPiece(null);
    }
}
