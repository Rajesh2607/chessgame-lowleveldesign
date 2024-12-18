public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        int direction = (color == Color.WHITE) ? 1 : -1;
        return (to.getRow() == from.getRow() + direction) && (from.getCol() == to.getCol());
    }
}
