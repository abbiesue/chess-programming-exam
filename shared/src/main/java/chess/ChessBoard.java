package chess;

import java.util.Arrays;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPiece [][] squares;

    public ChessBoard() {
        squares = new ChessPiece[9][9];
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()][position.getColumn()] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()][position.getColumn()];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[9][9];

    }

    @Override
    public String toString() {
        String boardString = "ChessBoard: \n";

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (squares[i][j] == null) {
                    boardString = boardString.concat(" ");
                } else {
                    switch (squares[i][j].getTeamColor()) {
                        case WHITE -> {
                            switch (squares[i][j].getPieceType()) {
                                case ROOK -> boardString = boardString.concat("R");
                                case KNIGHT -> boardString = boardString.concat("N");
                                case BISHOP -> boardString = boardString.concat("B");
                                case QUEEN -> boardString = boardString.concat("Q");
                                case KING -> boardString = boardString.concat("K");
                                case PAWN -> boardString = boardString.concat("P");
                            }
                        }
                        case BLACK -> {
                            switch (squares[i][j].getPieceType()) {
                                case ROOK -> boardString = boardString.concat("r");
                                case KNIGHT -> boardString = boardString.concat("n");
                                case BISHOP -> boardString = boardString.concat("b");
                                case QUEEN -> boardString = boardString.concat("q");
                                case KING -> boardString = boardString.concat("k");
                                case PAWN -> boardString = boardString.concat("p");
                            }
                        }
                    }
                }
                boardString = boardString.concat("|");
            }
            boardString = boardString.concat("\n");
        }

        return "ChessBoard{" +
                "squares=" + Arrays.toString(squares) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (squares[i][j] == null || that.squares[i][j] == null) {
                    if (squares[i][j] == that.squares[i][j]){
                        break;
                    } else {
                        return false;
                    }
                } else if (squares[i][j].getTeamColor() != that.squares[i][j].getTeamColor()) {
                    return false;
                } else if (squares[i][j].getPieceType() != that.squares[i][j].getPieceType()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(squares);
    }
}
