package training.chessington.model;

import training.chessington.model.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] board = new Piece[8][8];
    private List<BoardMove> completeMoves =new ArrayList<>();

    public List<BoardMove> getCompleteMoves() {
        return completeMoves;
    }

    private Board() {
    }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, PlayerColour.WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new Pawn(PlayerColour.BLACK);
            board.board[6][col] = new Pawn(PlayerColour.WHITE);
        }

        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new Rook(colour);
        board[rowIndex][1] = new Knight(colour);
        board[rowIndex][2] = new Bishop(colour);
        board[rowIndex][3] = new Queen(colour);
        board[rowIndex][4] = new King(colour);
        board[rowIndex][5] = new Bishop(colour);
        board[rowIndex][6] = new Knight(colour);
        board[rowIndex][7] = new Rook(colour);
    }

    public Piece get(Coordinates coords) {
        return board[coords.getRow()][coords.getCol()];
    }

    public void move(Coordinates from, Coordinates to) {
        Piece piece= get(from);
        Piece.PieceType pieceType = get(from).getType();
        if(pieceType == Piece.PieceType.PAWN && from.getCol() != to.getCol() && board[to.getRow()][to.getCol()] == null ){
            board[from.getRow()][to.getCol()] = null;
        }
        if(pieceType == Piece.PieceType.KING && Math.abs(from.getCol() - to.getCol())==2){
            int rook = from.getCol() - to.getCol()<0 ? 7 : 0;
            int direction = from.getCol() - to.getCol()>0 ? 1 : -1;
            if(board[from.getRow()][rook]!=null&&board[from.getRow()][rook].getType()==Piece.PieceType.ROOK){
                Coordinates rookloc = new Coordinates(from.getRow(),rook);
                Piece movingPiece= board[rookloc.getRow()][rookloc.getCol()];
                movingPiece.pieceMoved();
                board[rookloc.getRow()][to.getCol()+direction] = movingPiece;
                board[rookloc.getRow()][rookloc.getCol()] = null;
            }
            board[from.getRow()][to.getCol()] = null;
        }
        if(pieceType == Piece.PieceType.ROOK && !piece.getHasMoved()){
            Coordinates kingloc=new Coordinates(from.getRow(), 4);
            if(board[from.getRow()][4]!=null&&board[kingloc.getRow()][kingloc.getCol()].getType()==Piece.PieceType.KING){
               if(to.getCol()==3 || to.getCol()==5){
                   int dir = to.getCol()==3? -1:1;
                   Piece movingPiece= board[kingloc.getRow()][kingloc.getCol()];
                   movingPiece.pieceMoved();
                   board[kingloc.getRow()][kingloc.getCol()+dir*2] = movingPiece;
                   board[kingloc.getRow()][kingloc.getCol()] = null;
               }
            }
        }

        Piece movingPiece= board[from.getRow()][from.getCol()];
        movingPiece.pieceMoved();
        board[to.getRow()][to.getCol()] = movingPiece;
        board[from.getRow()][from.getCol()] = null;
        completeMoves.add(new BoardMove(from,to,pieceType));
    }

    public void placePiece(Coordinates coords, Piece piece) {
        board[coords.getRow()][coords.getCol()] = piece;
    }
}
