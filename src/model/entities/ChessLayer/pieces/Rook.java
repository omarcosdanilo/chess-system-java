package model.entities.ChessLayer.pieces;

import model.entities.BoardLayer.Board;
import model.entities.ChessLayer.ChessPiece;
import model.entities.ChessLayer.enums.Color;

public class Rook extends ChessPiece {

  public Rook(Board board, Color color) {
    super(board, color);
  }
  
  @Override
  public String toString() {
    return "R";
  }
}