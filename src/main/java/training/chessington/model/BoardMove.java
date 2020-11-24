package training.chessington.model;

import training.chessington.model.pieces.Piece;

public final class BoardMove extends Move {
    private final Piece.PieceType piece;

    public Piece.PieceType getPiece() {
        return piece;
    }

    public BoardMove(Coordinates from, Coordinates to, Piece.PieceType piece) {
        super(from, to);
        this.piece = piece;
    }
}
