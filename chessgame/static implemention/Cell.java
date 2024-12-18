public class Cell {
    private Piece piece;
    private CellPosition position;

    public Cell(CellPosition position) {
        this.position = position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public CellPosition getPosition() {
        return position;
    }
}
