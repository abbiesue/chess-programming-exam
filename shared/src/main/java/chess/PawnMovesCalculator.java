package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator implements PieceMovesCalculator{
    ChessBoard chessboard;
    ChessPosition startPosition;
    List<ChessMove> moves = new ArrayList<>();

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        chessboard = board;
        startPosition = position;
        int row = startPosition.getRow();
        int col = startPosition.getColumn();

        if (chessboard.getPiece(startPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            position = new ChessPosition(row+1, col);
            if (chessboard.getPiece(position) == null) {
                if (position.getRow() == 8) {
                    promote(position);
                } else if (row == 2 && chessboard.getPiece(new ChessPosition(row+2, col)) == null) {
                    moves.add(new ChessMove(startPosition, position, null));
                    position = new ChessPosition(row+2, col);
                    moves.add(new ChessMove(startPosition, position, null));
                } else {
                    moves.add(new ChessMove(startPosition,position, null));
                }
            }

            if (row+1<9 && col-1>0) {
                position = new ChessPosition(row+1,col-1);
                if (chessboard.getPiece(position) != null && chessboard.getPiece(position).pieceColor == ChessGame.TeamColor.BLACK) {
                    if (position.getRow() == 8) {
                        promote(position);
                    } else {
                        moves.add(new ChessMove(startPosition,position, null));
                    }
                }
            }

            if (row+1<9 && col+1<9) {
                position = new ChessPosition(row+1,col+1);
                if (chessboard.getPiece(position) != null && chessboard.getPiece(position).pieceColor == ChessGame.TeamColor.BLACK) {
                    if (position.getRow() == 8) {
                        promote(position);
                    } else {
                        moves.add(new ChessMove(startPosition,position, null));
                    }
                }
            }
        }

        if (chessboard.getPiece(startPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {
            position = new ChessPosition(row-1, col);
            if (chessboard.getPiece(position) == null) {
                if (position.getRow() == 1) {
                    promote(position);
                } else if (row == 7 && chessboard.getPiece(new ChessPosition(row-2, col)) == null) {
                    moves.add(new ChessMove(startPosition, position, null));
                    position = new ChessPosition(row-2, col);
                    moves.add(new ChessMove(startPosition, position, null));
                } else {
                    moves.add(new ChessMove(startPosition,position, null));
                }
            }

            if (row+1<9 && col-1>0) {
                position = new ChessPosition(row-1,col-1);
                if (chessboard.getPiece(position) != null && chessboard.getPiece(position).pieceColor == ChessGame.TeamColor.WHITE) {
                    if (position.getRow() == 1) {
                        promote(position);
                    } else {
                        moves.add(new ChessMove(startPosition,position, null));
                    }
                }
            }

            if (row+1<9 && col+1<9) {
                position = new ChessPosition(row-1,col+1);
                if (chessboard.getPiece(position) != null && chessboard.getPiece(position).pieceColor == ChessGame.TeamColor.WHITE) {
                    if (position.getRow() == 1) {
                        promote(position);
                    } else {
                        moves.add(new ChessMove(startPosition,position, null));
                    }
                }
            }
        }
        return moves;
    }

    void promote(ChessPosition position) {
        moves.add(new ChessMove(startPosition, position, ChessPiece.PieceType.ROOK));
        moves.add(new ChessMove(startPosition, position, ChessPiece.PieceType.BISHOP));
        moves.add(new ChessMove(startPosition, position, ChessPiece.PieceType.KNIGHT));
        moves.add(new ChessMove(startPosition, position, ChessPiece.PieceType.QUEEN));
    }

    @Override
    public boolean checkNAdd(int row, int col) {
        return true;
    }
}
