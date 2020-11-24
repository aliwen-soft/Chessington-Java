package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {

    @Test
    public void whiteKingCanMoveUpOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
    }

    @Test
    public void blackKingCanMoveUpOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
    }

    @Test
    public void whiteKingCanMoveLeftOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
    }

    @Test
    public void blackKingCanMoveLeftOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
    }

    @Test
    public void whiteKingCanMoveRightOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
    }

    @Test
    public void blackKingCanMoveRightSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void whiteKingCanMoveDownOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }

    @Test
    public void blackKingCanMoveDownSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }
    public void blackKingCanMoveDiagSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
    }

    @Test
    public void blackKingCannotMoveMultipleSquares() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -1)));
    }





}
