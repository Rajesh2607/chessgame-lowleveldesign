public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean validate(CellPosition from, CellPosition to) {
        return Math.abs(to.getRow() - from.getRow()) == Math.abs(to.getCol() - from.getCol());
    }
}
