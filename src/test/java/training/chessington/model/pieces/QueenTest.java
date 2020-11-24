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
        Piece queen = new Queen(PlayerColour.WHITE);
        DiagonalTest.canMoveDiagonally(queen);

    }

    @Test
    public void queenCannotMoveThroughAPieceDiagonally() {
        Piece queen = new Queen(PlayerColour.WHITE);
        DiagonalTest.canMoveDiagonally(queen);
    }

    @Test
    public void queenCannotMoveOffTheBoardDiagonally() {
        Piece queen = new Queen(PlayerColour.WHITE);
        DiagonalTest.cannotMoveOffTheBoard(queen);
    }

    @Test
    public void queenCanTakePiecesDiagonally() {
        Piece queen = new Queen(PlayerColour.WHITE);
        DiagonalTest.canTakePieces(queen);
    }

    @Test
    public void queenCanMoveVertically() {
        Piece queen = new Queen(PlayerColour.WHITE);
        StraightTest.canMoveVertically(queen);
    }

    @Test
    public void queenCanMoveHorizontally() {
        Piece queen = new Queen(PlayerColour.WHITE);
        StraightTest.canMoveHorizontally(queen);
    }

    @Test
    public void queenCannotMoveThroughAPieceVertically() {
        Piece queen = new Queen(PlayerColour.WHITE);
        StraightTest.cannotMoveThroughAPiece(queen);
    }

    @Test
    public void queenCannotMoveOffTheBoard() {
        Piece queen = new Queen(PlayerColour.WHITE);
        StraightTest.cannotMoveOffTheBoard(queen);
    }

    @Test
    public void queenCanTakePiecesVertically() {
        Piece queen = new Queen(PlayerColour.WHITE);
        StraightTest.canTakePieces(queen);
    }
}
