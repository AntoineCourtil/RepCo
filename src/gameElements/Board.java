package gameElements;

import java.util.ArrayList;
import java.util.Collections;


public class Board {

    private Game game;
    private int size;
    private int numberOfPieces;
    private Square[][] board;

    //ATTENTION
    //Ceci est un squelette incomplet contenant uniquement le profil de quelques méthodes, dans le but de compiler la classe GameUI sans erreurs
    //Il manque les getters et les setters ainsi que les classes externes telles que Square, Eval, Game, Player,...

    public Board() {
        this.game = new Game();
        this.size = 8;
        this.numberOfPieces = 0;

        Square[][] board = new Square[8][8];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = this.game.getEmpty();
            }
        }

        this.board = board;
    }


    public Board(Game game, int size, int numberOfPieces, Square[][] board) {
        this.game = game;
        this.size = size;
        this.numberOfPieces = numberOfPieces;
        this.board = board;
    }

    public Board(Game game, int numberOfPieces, Square[][] board) {
        //Default size : 8

        this.game = game;
        this.size = 8;
        this.numberOfPieces = numberOfPieces;
        this.board = board;
    }


    //------------------ GETTERS --------------------------

    public Game getGame() {
        return game;
    }

    public int getSize() {
        return size;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public Square[][] getBoard() {
        return board;
    }

    //------------------ SETTERS --------------------------

    public void setGame(Game game) {
        this.game = game;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }


    //---------------TP1------------------------

    public Square getPiece(int i, int j) {
        return this.board[i][j];
    }

    public void setPiece(int i, int j, Square piece) {
        if (this.board[i][j].isEmpty()) {
            this.numberOfPieces++;
        }
        this.board[i][j] = piece;
    }

    public void removePiece(int i, int j) {
        if (!this.board[i][j].isEmpty()) {
            this.numberOfPieces--;
        }
        this.board[i][j] = this.game.getEmpty();
    }

    public boolean isEmpty(int i, int j) {
        return this.board[i][j].isEmpty();
    }

    public boolean isAccessible(int i, int j) {

        boolean ok = true;
        //TEST EN LIGNE
        //TEST EN COLONNE
        //DIAGONALES
        int k = 0;
        while (k < getSize() && ok) {
            //LIGNE
            if (getSquare(k, 0).isEmpty()) ok = false;
            //COLONNE
            if (getSquare(0, k).isEmpty()) ok = false;
            //DIAGO
            if((i+1 < getSize()) && (j-1 >= 0))
                if(getSquare(i+1, j-1).isEmpty()) ok = false;
            if((i+1 < getSize()) && (j+1 < getSize()))
                if(getSquare(i+1, j+1).isEmpty()) ok = false;
            if((i-1 >= 0) && (j+1 < getSize()))
                if(getSquare(i-1, j+1).isEmpty()) ok = false;
            if((i-1 >= 0) && (j-1 >= 0))
                if(getSquare(i-1, j-1).isEmpty()) ok = false;
            k++;
        }
        return ok;
    }

    


    public int numberOfAccessible() {
    	int nbAccessible = 0;
    	
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(this.isAccessible(i, j)){
                	nbAccessible++;
                }
            }
        }
    	
        return nbAccessible;
    }

    public int numberOfQueens() {
    	int nbQueens = 0;
    	
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	if(this.getPiece(i, j) instanceof Queen){
            		nbQueens++;
    			}
            }
        }
    	
        return nbQueens;
    }

    public boolean placeQueen(int i, int j) {
        if(this.isAccessible(i, j)){
        	this.setPiece(i, j, new Queen(this.game.getPlayer0()));
        	this.numberOfPieces++;
        	return true;
        }
        return false;
    }

    //----------TP2-----------------------
    public ArrayList<Board> depthFirstSearch(Board b) {
        // TODO Auto-generated method stub
        return null;
    }


    //------------TP3----------------------
    public boolean isAccessible2(int i, int j, Player currentPlayer) {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean placeQueen2(int i, int j, Player player) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean placeRock2(int i, int j, Player player) {
        // TODO Auto-generated method stub
        return false;
    }

    public int getNumberOfRocksLeft(Player player) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getScore(Player player) {
        // TODO Auto-generated method stub
        return 0;
    }


    //----------------------TP4&5--------------------------
    public boolean isFinal() {
        // TODO Auto-generated method stub
        return false;
    }

    public Board minimax(Board b, Player currentPlayer, int minimaxDepth, Eval evaluation) {
        // TODO Auto-generated method stub
        return null;
    }

    public Square getSquare(int i, int j) {
        //TODO VERIF
        return board[i][j];
    }

    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                strb.append(getSquare(i, j).toString());
            }
            strb.append("\n");
        }
        return strb.toString();
    }

    public Board clone() {
        return new Board(this.getGame(), this.getSize(), this.getNumberOfPieces(), this.getBoard().clone());
    }


}
