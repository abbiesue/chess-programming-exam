package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueenMovesCalculator implements PieceMovesCalculator {
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
        col = startPosition.getColumn();
        row = startPosition.getRow()+1;
        while (row<9) {
            if (checkNAdd(row, col)) {
                row++;
            } else {
                break;
            }
        }
        //check up right
        row = startPosition.getRow();
        col = startPosition.getColumn();
        while (row+1<9 && col+1<9){
            if (checkNAdd(row+1, col+1)) {
                row++;
                col++;
            } else {
                break;
            }
        }
        //check right
        col = startPosition.getColumn()+1;
        row = startPosition.getRow();
        while (col<9) {
            if (checkNAdd(row, col)) {
                col++;
            } else {
                break;
            }
        }
        //check down right
        row = startPosition.getRow();
        col = startPosition.getColumn();
        while (row-1>0 && col+1<9) {
            if (checkNAdd(row-1, col+1)) {
                row--;
                col++;
            } else {
                break;
            }
        }
        //check down
        col = startPosition.getColumn();
        row = startPosition.getRow()-1;
        while (row>0) {
            if (checkNAdd(row, col)) {
                row--;
            } else {
                break;
            }
        }
        //check down left
        row = startPosition.getRow();
        col = startPosition.getColumn();
        while (row-1>0 && col-1>0) {
            if (checkNAdd(row-1, col-1)) {
                row--;
                col--;
            } else {
                break;
            }
        }
        //check left
        col = startPosition.getColumn()-1;
        row = startPosition.getRow();
        while (col>0) {
            if (checkNAdd(row, col)) {
                col--;
            } else {
                break;
            }
        }
        //check up left
        row = startPosition.getRow();
        col = startPosition.getColumn();
        while (row+1<9 && col-1>0) {
            if (checkNAdd(row+1, col-1)) {
                row++;
                col--;
            } else {
                break;
            }
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
