package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StraightTest {

    public static void canMoveVertically(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
    }

    public static void canMoveHorizontally(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
    }

    public static void cannotMoveThroughAPiece(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(piece.getColour());
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, piece);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
    }

    public static void cannotMoveDiagonally(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -1)));
    }

    public static void cannotMoveOffTheBoard(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(7, 7);
        board.placePiece(coords, piece );

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));
    }

    public static void canTakePieces(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Piece king =  piece.getColour() == PlayerColour.BLACK? new King(PlayerColour.WHITE) : new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, piece);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }
}
