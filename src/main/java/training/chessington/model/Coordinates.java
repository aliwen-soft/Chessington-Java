package training.chessington.model;

import training.chessington.model.pieces.Piece;

import java.util.Objects;

public final class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean onBoard(){
        return row >=0 && row <=7 && col>=0 && col<=7 ;
    }

    public boolean emptySpace(Board board){
        if (onBoard()) {
            return board.get(this) == null;
        }
        return false;
    }

    public boolean attackableSpace(Board board, PlayerColour colour){
        if(onBoard()) {
            Piece space = board.get(this);
            return space != null && space.getColour() != colour;
        }
        return false;
    }

    public boolean friendlySpace(Board board, PlayerColour colour){
        if(onBoard()) {
            Piece space = board.get(this);
            return space != null && space.getColour() == colour;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return String.format("row %d, column %d", row, col);
    }

    public Coordinates plus(int rowDiff, int colDiff) {
        return new Coordinates(row + rowDiff, col + colDiff);
    }
}
