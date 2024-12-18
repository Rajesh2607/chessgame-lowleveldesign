public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return (from.getRow() == to.getRow()) || (from.getCol() == to.getCol());
    }
}
