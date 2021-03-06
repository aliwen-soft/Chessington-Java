package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

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

    @Test
    public void blackKingCanTakeWhitePiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsking = new Coordinates(6, 4);
        Coordinates coordspawn = new Coordinates(7, 4);
        board.placePiece(coordsking, king);
        board.placePiece(coordspawn, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).contains(new Move(coordsking, coordspawn));

    }

    @Test
    public void blackKingCannotTakeBlackPiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates coordsking = new Coordinates(6, 4);
        Coordinates coordspawn = new Coordinates(7, 4);
        board.placePiece(coordsking, king);
        board.placePiece(coordspawn, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coordsking, coordspawn));

    }

    @Test
    public void whiteKingCanTakeBlackPiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates coordsking = new Coordinates(6, 4);
        Coordinates coordspawn = new Coordinates(7, 4);
        board.placePiece(coordsking, king);
        board.placePiece(coordspawn, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).contains(new Move(coordsking, coordspawn));

    }

    @Test
    public void whiteKingCannotTakeWhitePiece() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates coordsking = new Coordinates(6, 4);
        Coordinates coordspawn = new Coordinates(7, 4);
        board.placePiece(coordsking, king);
        board.placePiece(coordspawn, pawn);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coordsking, coordspawn));

    }

    @Test
    public void whiteKingCannotLeaveBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coordsking = new Coordinates(7, 7);

        board.placePiece(coordsking, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(0,1)));
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(1,1)));
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(1,0)));
    }

    @Test
    public void blackKingCannotLeaveBoard() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coordsking = new Coordinates(0, 0);

        board.placePiece(coordsking, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(0,-1)));
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(-1,-1)));
        assertThat(moves).doesNotContain(new Move(coordsking, coordsking.plus(-1,0)));
    }

    @Test
    public void KingCanCastle() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Piece castle = new Rook(PlayerColour.BLACK);
        Coordinates coordsking = new Coordinates(0, 4);
        Coordinates coordsCastle = new Coordinates(0, 0);

        board.placePiece(coordsking, king);
        board.placePiece(coordsCastle, castle);

        // Act
        List<Move> moves = king.getAllowedMoves(coordsking, board);

        // Assert
        Move castling = new Move(coordsking, coordsking.plus(0,-2));
        assertThat(moves).contains(castling);
        board.move(castling.getFrom(), castling.getTo());
        assertThat(board.get(castling.getTo().plus(0,1)).getType()== Piece.PieceType.ROOK);
        assertThat(board.get(coordsCastle)==null);
    }




}
