package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.PlayerColour;

public class BishopTest {
    @Test
    public void bishopCanMoveDiagonally() {
        // Arrange
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.canMoveDiagonally(bishop);
    }

    @Test
    public void bishopCannotMoveThroughAPiece() {
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.cannotMoveThroughAPiece(bishop);

    }

    @Test
    public void bishopCannotMoveVertically() {
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.cannotMoveVertically(bishop);
    }

    @Test
    public void bishopCannotMoveHorizontally() {
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.cannotMoveHorizontally(bishop);
    }

    @Test
    public void bishopCannotMoveOffTheBoard() {
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.cannotMoveOffTheBoard(bishop);
    }

    @Test
    public void bishopCanTakePieces() {
        Piece bishop = new Bishop(PlayerColour.WHITE);
        DiagonalTest.canTakePieces(bishop);
    }
}
