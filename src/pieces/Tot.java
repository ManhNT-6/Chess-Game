package src.pieces;

import src.main.Board;

import java.awt.image.BufferedImage;

public class Tot extends Piece{
    public Tot(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;

        this.name = "Tot";
        this.sprite = sheet.getSubimage(5*sheetScale, isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int newCol, int newRow){

        int indexTeam = isWhite ? 1 : -1;

        // step 1 step
        if (this.col == newCol && this.row == newRow + indexTeam && board.getPiece(newCol,newRow) == null) {
            return true;
        }
        // step 2 step
        if ( isFirstMove && this.col == newCol && this.row == newRow + indexTeam * 2 && board.getPiece(newCol,newRow) == null && board.getPiece(newCol,newRow + indexTeam) == null) {
            return true;
        }
        // capture left
        if (newCol == this.col -1 && newRow == this.row - indexTeam && board.getPiece(newCol,newRow) != null) {
            return true;
        }
        // capture right
        if (newCol == this.col +1 && newRow == this.row - indexTeam && board.getPiece(newCol,newRow) != null) {
            return true;
        }
        return false;
    }
}
