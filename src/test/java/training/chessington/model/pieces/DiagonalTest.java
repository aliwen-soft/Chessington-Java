package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiagonalTest {

    public static void canMoveDiagonally(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
    }

    public static void cannotMoveThroughAPiece(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(piece.getColour());
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 6);
        board.placePiece(coords, piece);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
    }

    public static void cannotMoveVertically(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 0)));
    }

    public static void cannotMoveHorizontally(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));
    }

    public static void cannotMoveOffTheBoard(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Coordinates coords = new Coordinates(7, 7);
        board.placePiece(coords, piece);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 1)));
    }

    public static void canTakePieces(Piece piece) {
        // Arrange
        Board board = Board.empty();
        Piece king = piece.getColour() == PlayerColour.BLACK? new King(PlayerColour.WHITE) : new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 6);
        board.placePiece(coords, piece);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = piece.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
    }
}
