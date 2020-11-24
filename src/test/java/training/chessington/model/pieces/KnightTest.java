package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {
    @Test
    public void knightCanMoveKnightly() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));
    }

    @Test
    public void knightCannotMoveDiagonally() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 1)));

    }

    @Test
    public void knightCannotMoveStraight() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));

    }

    @Test
    public void knightCanJump() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates kingCoords = new Coordinates(3, 5);
        board.placePiece(coords, knight);
        board.placePiece(kingCoords, king);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));
    }

    @Test
    public void knightCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(1, 1);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-3, -1)));

    }

    @Test
    public void knightCanCapture() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates coordsking = coords.plus(3, -1);
        board.placePiece(coords, knight);
        board.placePiece(coordsking, king);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));

    }

    @Test
    public void knightCanBeBlocked() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        Coordinates coordsking = coords.plus(3, -1);
        board.placePiece(coords, knight);
        board.placePiece(coordsking, king);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -3)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(3, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));
    }
}
