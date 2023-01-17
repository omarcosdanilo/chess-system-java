package model.entities.ChessLayer.pieces;


import model.entities.BoardLayer.Board;
import model.entities.BoardLayer.Position;
import model.entities.ChessLayer.ChessMatch;
import model.entities.ChessLayer.ChessPiece;
import model.entities.ChessLayer.enums.Color;

public class King extends ChessPiece{
  private ChessMatch chessMatch;

  public King(Board board, Color color, ChessMatch chessMatch) {
    super(board, color);
    this.chessMatch = chessMatch;
  }
  
  @Override
  public String toString() {
    return "K";
  }

  private boolean canMove(Position position) {
    ChessPiece p = (ChessPiece)getBoard().piece(position);

    return p == null || p.getColor() != getColor();
  }

  private boolean testRookCastling(Position position) {
    ChessPiece p = (ChessPiece)getBoard().piece(position);

    return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
  }
 
  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position p = new Position(0, 0);

    // above
    p.setValues(position.getRow() - 1, position.getColumn());

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // below
    p.setValues(position.getRow() + 1, position.getColumn());

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // left
    p.setValues(position.getRow(), position.getColumn() - 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // right
    p.setValues(position.getRow(), position.getColumn() + 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // nw
    p.setValues(position.getRow() - 1, position.getColumn() - 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // ne
    p.setValues(position.getRow() - 1, position.getColumn() + 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // sw
    p.setValues(position.getRow() + 1, position.getColumn() - 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // se
    p.setValues(position.getRow() + 1, position.getColumn() + 1);

    if (getBoard().positionExists(p) && canMove(p)) {
      mat[p.getRow()][p.getColumn()] = true;
    };

    // specialmove castling
    if (getMoveCount() == 0 && !chessMatch.getCheck()) {
      // specialmove clastling kingside rook
      Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);

      if (testRookCastling(positionRook1)) {
        Position rightPosition1 = new Position(position.getRow(), position.getColumn() + 1);
        Position rightPosition2 = new Position(position.getRow(), position.getColumn() + 2);

        if (getBoard().piece(rightPosition1) == null && getBoard().piece(rightPosition2) == null) {
          mat[position.getRow()][position.getColumn() + 2] = true;
        }
      }
      // specialmove clastling queenside rook
      Position positionRook2 = new Position(position.getRow(), position.getColumn() - 4);

      if (testRookCastling(positionRook2)) {
        Position lefPosition1 = new Position(position.getRow(), position.getColumn() - 1);
        Position lefPosition2 = new Position(position.getRow(), position.getColumn() - 2);
        Position lefPosition3 = new Position(position.getRow(), position.getColumn() - 2);

        if (
          getBoard().piece(lefPosition1) == null 
          && getBoard().piece(lefPosition2) == null
          && getBoard().piece(lefPosition3) == null
          ) {
          mat[position.getRow()][position.getColumn() - 2] = true;
        }
      }
    }

    return mat;
  }
}
