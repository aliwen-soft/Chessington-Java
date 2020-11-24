package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();
        int[] modifiers={-1,1};
        int[] modifiersInside={-1,1};

        for(int modifier: modifiers){
            for(int modifierInside: modifiersInside) {
                Coordinates to = from.plus(modifierInside*3, modifier * 1);
                if ((to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
                to = from.plus(modifierInside*1, modifier * 3);
                if ((to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }
}
