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

    @Test
    public void rookCanCastle() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Piece castle = new Rook(PlayerColour.BLACK);
        Coordinates coordsking = new Coordinates(0, 4);
        Coordinates coordsCastle = new Coordinates(0, 0);

        board.placePiece(coordsking, king);
        board.placePiece(coordsCastle, castle);

        // Act
        List<Move> moves = castle.getAllowedMoves(coordsking, board);

        // Assert
        Move castling = new Move(coordsCastle, coordsking.plus(0,2));
        assertThat(moves).contains(castling);
        board.move(castling.getFrom(), castling.getTo());
        assertThat(board.get(castling.getTo().plus(0,-1)).getType()== Piece.PieceType.KING);
        assertThat(board.get(coordsking)==null);
    }

}
