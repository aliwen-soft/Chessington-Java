package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {
    @Test
    public void queenCanMoveDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
    }

    @Test
    public void queenCannotMoveThroughAPieceDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 6);
        board.placePiece(coords, queen);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(4, 4)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
    }

    @Test
    public void queenCannotMoveOffTheBoardDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 7);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void queenCanTakePiecesDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 6);
        board.placePiece(coords, queen);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
    }

    @Test
    public void queenCanMoveVertically() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

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
    public void queenCanMoveHorizontally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 3);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

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
    public void queenCannotMoveThroughAPieceVertically() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, queen);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

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
    public void queenCannotMoveOffTheBoardVerticallyOrHorizontally() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 7);
        board.placePiece(coords, queen);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void queenCanTakePiecesVertically() {
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingcoords = new Coordinates(5, 4);
        board.placePiece(coords, queen);
        board.placePiece(kingcoords, king);

        // Act
        List<Move> moves = queen.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }
}
