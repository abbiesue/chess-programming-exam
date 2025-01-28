package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMovesCalculator implements PieceMovesCalculator{
    ChessBoard chessboard;
    ChessPosition startPosition;
    List<ChessMove> moves = new ArrayList<>();

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        chessboard = board;
        startPosition = position;
        int row;
        int col;

        //check up
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row+1<9) {
            checkNAdd(row+1, col);
        }
        //check up right
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row+1<9 && col+1<9) {
            checkNAdd(row+1, col+1);
        }
        //check right
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (col+1<9) {
            checkNAdd(row, col+1);
        }
        //check down right
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row-1>0 && col+1<9) {
            checkNAdd(row-1, col+1);
        }
        //check down
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row-1>0) {
            checkNAdd(row-1, col);
        }
        //check down left
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row-1>0 && col-1>0) {
            checkNAdd(row-1, col-1);
        }
        //check left
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (col-1>0) {
            checkNAdd(row, col-1);
        }
        //check up left
        row = startPosition.getRow();
        col = startPosition.getColumn();
        if (row+1<9 && col-1>0) {
            checkNAdd(row+1, col-1);
        }

        return moves;
    }

    @Override
    public boolean checkNAdd(int row, int col) {
        ChessPosition position = new ChessPosition(row,col);
        if (chessboard.getPiece(position) == null){
            moves.add(new ChessMove(startPosition, position, null));
        } else if (chessboard.getPiece(position).getTeamColor() != chessboard.getPiece(startPosition).getTeamColor()) {
            moves.add(new ChessMove(startPosition, position, null));
            return false;
        } else {
            return false;
        }
        return true;
    }
}
