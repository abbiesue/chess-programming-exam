package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMovesCalculator implements PieceMovesCalculator{
    ChessBoard chessboard;
    ChessPosition startPosition;
    List<ChessMove> moves = new ArrayList<>();

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        chessboard = board;
        startPosition = position;
        int row;
        int col;

        //check up right (row+2, col+1)
        row = startPosition.getRow()+2;
        col = startPosition.getColumn()+1;
        if (row<9 && col<9) {
            checkNAdd(row, col);
        }
        //check right up (row+1, col+2)
        row = startPosition.getRow()+1;
        col = startPosition.getColumn()+2;
        if (row<9 && col<9) {
            checkNAdd(row, col);
        }
        //check right down (row-1, col+2)
        row = startPosition.getRow()-1;
        col = startPosition.getColumn()+2;
        if (row>0 && col<9) {
            checkNAdd(row, col);
        }
        //check down right (row-2, col+1)
        row = startPosition.getRow()-2;
        col = startPosition.getColumn()+1;
        if (row>0 && col<9) {
            checkNAdd(row, col);
        }
        //check down left (row-2, col-1)
        row = startPosition.getRow()-2;
        col = startPosition.getColumn()-1;
        if (row>0 && col>0) {
            checkNAdd(row, col);
        }
        //check left down (row-1, col-2)
        row = startPosition.getRow()-1;
        col = startPosition.getColumn()-2;
        if (row>0 && col>0) {
            checkNAdd(row, col);
        }
        //check left up (row+1, col-2)
        row = startPosition.getRow()+1;
        col = startPosition.getColumn()-2;
        if (row<9 && col>0) {
            checkNAdd(row, col);
        }
        //check up left (row+2, col-1)
        row = startPosition.getRow()+2;
        col = startPosition.getColumn()-1;
        if (row<9 && col>0) {
            checkNAdd(row, col);
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
