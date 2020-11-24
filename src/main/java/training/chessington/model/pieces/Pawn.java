package training.chessington.model.pieces;

import training.chessington.model.*;

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

        int[] diags = {1, -1};
        for (int d : diags) {
            to = from.plus(modifier, d);
            if (to.attackableSpace(board, colour)) {
                moves.add(new Move(from, to));
            }
        }

        if (board.getCompleteMoves().size() > 0 && board.getCompleteMoves().get(board.getCompleteMoves().size() - 1).getPiece() == PieceType.PAWN) {
            BoardMove preMove = board.getCompleteMoves().get(board.getCompleteMoves().size() - 1);
            boolean doubleMove = Math.abs(preMove.getFrom().getRow() - preMove.getTo().getRow()) == 2;
            boolean nextTo = Math.abs(preMove.getTo().getCol() - from.getCol()) == 1 && preMove.getTo().getRow() == from.getRow();
            if (doubleMove && nextTo) {
                moves.add(new Move(from, new Coordinates(from.getRow()+modifier,preMove.getTo().getCol()) ));
            }
            return moves;
        }


        return moves;
    }
}