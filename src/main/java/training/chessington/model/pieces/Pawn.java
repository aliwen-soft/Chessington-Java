package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    private boolean notMoved(PlayerColour colour, Coordinates from) {
        if (colour == PlayerColour.WHITE) {
            return from.getRow() == 6;
        } else {
            return from.getRow() == 1;
        }
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        int modifier = (colour == PlayerColour.BLACK ? 1 : -1);

        Coordinates to = from.plus(modifier, 0);
        if (to.emptySpace(board)) {
            moves.add(new Move(from, to));
        }

        to = from.plus(2 * modifier, 0);
        if (to.emptySpace(board) && notMoved(colour, from)) {
            moves.add(new Move(from, to));
        }

        int[] diags = {1,-1};
        for(int d :diags) {
            to = from.plus(modifier, d);
            if (to.attackableSpace(board, colour)) {
                moves.add(new Move(from, to));
            }
        }


        return moves;
    }
}