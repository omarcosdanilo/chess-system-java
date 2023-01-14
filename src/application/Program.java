package application;

import model.entities.ChessLayer.ChessMatch;

public class Program {
    public static void main(String[] args) throws Exception {   
        ChessMatch chessMatch = new ChessMatch();

        UI.printBoard(chessMatch.getPieces());
        
    }
}
