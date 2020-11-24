package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void rookCanMoveVertically() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.canMoveVertically(rook);

    }

    @Test
    public void rookCanMoveHorizontally() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.canMoveHorizontally(rook);
    }

    @Test
    public void rookCannotMoveThroughAPiece() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.cannotMoveThroughAPiece(rook);
    }

    @Test
    public void rookCannotMoveDiagonally() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.cannotMoveDiagonally(rook);
    }

    @Test
    public void rookCannotMoveOffTheBoard() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.cannotMoveOffTheBoard(rook);
    }

    @Test
    public void rookCanTakePieces() {
        Piece rook = new Rook(PlayerColour.WHITE);
        StraightTest.canTakePieces(rook);
    }

}
