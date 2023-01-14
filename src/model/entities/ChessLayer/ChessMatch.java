package model.entities.ChessLayer;

import model.entities.BoardLayer.Board;
import model.entities.ChessLayer.enums.Color;

public class ChessMatch {
  private Board board;
  private Integer turn;
  private Color currentPlayer;
  private boolean check;
  private boolean checkMate;
  private ChessPiece enPassantVulnerable;
  private ChessPiece promoted;

  public ChessMatch() {
    board = new Board(8, 8);
  }

  public ChessPiece[][] getPieces() {
    ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

    for (int i = 0; i < board.getRows(); i++) {
      for (int j = 0; j < board.getColumns(); j++) {
        matrix[i][j] = (ChessPiece) board.piece(i, j);
        
      }
    }

    return matrix;
  }
}
