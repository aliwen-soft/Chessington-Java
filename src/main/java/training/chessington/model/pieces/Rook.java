package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();
        int[] modifiers = {-1,1};
        for (int modifier : modifiers) {
            for (int i = 0; i < 8; i++) {
                Coordinates to = from.plus(modifier*i, 0);
                if (to.emptySpace(board) || to.attackableSpace(board, colour)) {
                    moves.add(new Move(from, to));
                }
                to = from.plus(0, modifier*i);
                if (to.emptySpace(board) || to.attackableSpace(board, colour)) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }
}
