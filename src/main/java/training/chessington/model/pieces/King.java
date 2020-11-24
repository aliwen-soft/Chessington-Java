package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        int[] cols = {1,0,-1};
        int[] rows = {1,0,-1};

        for(int c :cols) {
            for(int r :rows) {
                Coordinates to = from.plus(c, r);
                if(c!=0 || r!= 0) {
                    if (to.attackableSpace(board, colour) || to.emptySpace(board)) {
                        moves.add(new Move(from, to));
                    }
                }
            }
        }

        if(!hasMoved){
            int[] direction = {1,-1};
            for(int d: direction){
                Piece rook = board.get(new Coordinates(from.getRow(),d==1?7:0));
                if(rook!=null && !rook.getHasMoved()) {
                    Coordinates blockingSpace = from.plus(0, d);
                    Coordinates to = from.plus(0, d*2);
                    if (blockingSpace.emptySpace(board) && (to.emptySpace(board) || to.attackableSpace(board, colour))) {
                        moves.add(new Move(from, to));
                    }
                }
            }
        }


        return moves;
    }
}
