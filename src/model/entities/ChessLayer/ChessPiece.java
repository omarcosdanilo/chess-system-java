package model.entities.ChessLayer;


import model.entities.BoardLayer.Board;
import model.entities.BoardLayer.Piece;
import model.entities.BoardLayer.Position;
import model.entities.ChessLayer.enums.Color;

public abstract class ChessPiece extends Piece {
  private Color color;
  private Integer moveCount;

  public ChessPiece(Board board, Color color) {
    super(board);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
  
  public int getMoveCount() {
    return moveCount;
  }
  
  protected boolean isThereOpponentPiece(Position position) {
    ChessPiece p = (ChessPiece) getBoard().piece(position);

    return p != null && p.getColor() != color;
  }

  public ChessPosition getChessPosition() {
    return ChessPosition.fromPosition(position);
  }

  protected void increaseMoveCount() {
    moveCount++;
  }

  protected void decreaseMoveCount() {
    moveCount--;
  }
}
