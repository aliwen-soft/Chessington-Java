package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    protected List<Move> getDiagonalMoves(Board board, Coordinates from){
        List<Move> moves = new ArrayList<>();
        int[] modifiers ={1,-1};
        for (int modifier : modifiers) {
            boolean clearBackwards=true;
            boolean clearRow=true;
            for (int i = 1; i < 8; i++) {
                Coordinates to = from.plus(i, modifier*i);
                clearRow = !to.friendlySpace(board, colour) && clearRow;
                if (clearRow &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
                to = from.plus(-i, modifier*i);
                clearBackwards = !to.friendlySpace(board, colour) && clearBackwards;
                if (clearBackwards &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }

    protected List<Move> getStraightMoves(Board board, Coordinates from){
        List<Move> moves = new ArrayList<>();
        int[] modifiers = {-1,1};
        for (int modifier : modifiers) {
            boolean clearCol=true;
            boolean clearRow=true;
            for (int i = 1; i < 8; i++) {
                Coordinates to = from.plus(modifier*i, 0);
                clearRow = !to.friendlySpace(board, colour) && clearRow;
                if (clearRow &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
                to = from.plus(0, modifier*i);
                clearCol = !to.friendlySpace(board, colour) && clearCol;
                if (clearCol &&(to.emptySpace(board) || to.attackableSpace(board, colour))) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }
}
