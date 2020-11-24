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

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();
        if (this.colour.equals(PlayerColour.WHITE)) {
            Coordinates to = from.plus(-1, 0);
            if (to.getRow()>0 && board.get(to)==null) {
                moves.add(new Move(from, to));
            }
            to = from.plus(-2, 0);
            if(from.getRow()==6 && board.get(to)==null){
                moves.add(new Move(from, to));
            }
            to = from.plus(-1, -1);
            if (to.getCol()>0 && to.getRow()>0 && board.get(to)!=null && board.get(to).getColour() != PlayerColour.WHITE ) {
                moves.add(new Move(from, to));
            }
            to = from.plus(-1, 1);
            if (to.getCol()<8 && to.getRow()>0 && board.get(to)!=null&& board.get(to).getColour() != PlayerColour.WHITE ) {
                moves.add(new Move(from, to));
            }
        }else{
            Coordinates to = from.plus(1, 0);
            if (to.getRow()<8 && board.get(to)==null) {
                moves.add(new Move(from, to));
            }
            to = from.plus(2, 0);
            if(from.getRow()==1 && board.get(to)==null){
                moves.add(new Move(from, to));
            }
            to = from.plus(1, -1);
            if (to.getCol()>0 && to.getRow()<8 && board.get(to)!=null&& board.get(to).getColour() != PlayerColour.BLACK) {
                moves.add(new Move(from, to));
            }
            to = from.plus(1, 1);
            if (to.getCol()<8 && to.getRow()<8 && board.get(to)!=null && board.get(to).getColour() != PlayerColour.BLACK) {
                moves.add(new Move(from, to));
            }
        }

        return moves;
    }
}
