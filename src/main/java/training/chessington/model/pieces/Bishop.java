package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();
        int[] modifiers = {-1,1};
        for (int modifier : modifiers) {
            boolean clearBackwards=true;
            boolean clearRow=true;
            for (int i = 1; i < 8; i++) {
                Coordinates to = from.plus(i, modifier*i);
                clearRow =  to.friendlySpace(board,colour) ? false : clearRow;
                if (clearRow &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
                to = from.plus(-i, modifier*i);
                clearBackwards =  to.friendlySpace(board,colour) ? false : clearBackwards;
                if (clearBackwards &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }
}
