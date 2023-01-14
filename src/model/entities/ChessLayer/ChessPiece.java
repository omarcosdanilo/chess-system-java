package model.entities.ChessLayer;

import model.entities.BoardLayer.Board;
import model.entities.BoardLayer.Piece;
import model.entities.ChessLayer.enums.Color;

public class ChessPiece extends Piece {
  private Color color;
  private Integer moveCount;

  public ChessPiece(Board board, Color color) {
    super(board);
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
  
}
