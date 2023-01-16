package model.entities.ChessLayer;

import model.entities.BoardLayer.Position;
import model.entities.ChessLayer.exceptions.ChessException;

public class ChessPosition {
  private char column;
  private Integer row;
  
  public ChessPosition(char column, Integer row) {
    if (column < 'a' || column > 'h' || row < 1 || row > 8) {
      throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
    }
    this.row = row;
    this.column = column;
  }

  public Integer getRow() {
    return row;
  }

  public char getColumn() {
    return column;
  }

  protected Position toPosition() {
    return new model.entities.BoardLayer.Position(8 - row, column - 'a');
  }

  protected static ChessPosition fromPosition(Position position) {
    return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
  }

  @Override
  public String toString() {
    return "" + column + row;
  }
}
