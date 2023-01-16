package model.entities.ChessLayer.exceptions;

import model.entities.BoardLayer.exceptions.BoardException;

public class ChessException extends BoardException {
  public ChessException(String msg) {
    super(msg);
  }
}
