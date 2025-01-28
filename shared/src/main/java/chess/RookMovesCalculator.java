package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMovesCalculator implements PieceMovesCalculator{
    ChessBoard chessboard;
    ChessPosition startPosition;
    List<ChessMove> moves = new ArrayList<>();

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        chessboard = board;
        startPosition = position;
        int row;
        int col;

        //check right (col++)
        col = startPosition.getColumn()+1;
        row = startPosition.getRow();
        while (col<9) {
            if (checkNAdd(row, col)) {
                col++;
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
