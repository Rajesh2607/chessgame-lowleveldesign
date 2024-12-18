public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return (from.getRow() == to.getRow()) || (from.getCol() == to.getCol()) ||
               (Math.abs(to.getRow() - from.getRow()) == Math.abs(to.getCol() - from.getCol()));
    }
}
