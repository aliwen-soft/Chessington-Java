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
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
    }

    @Test
    public void rookCanMoveHorizontally() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
    }

    @Test
    public void rookCannotMoveThroughAPiece() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, rook);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
    }

    @Test
    public void rookCannotMoveDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -1)));
    }

    @Test
    public void rookCannotMoveOffTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 7);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void rookCanTakePieces() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, rook);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
            assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }

}
