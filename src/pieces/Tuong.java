package src.pieces;

import src.main.Board;

import java.awt.image.BufferedImage;

public class Tuong extends Piece{
    public Tuong(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;

        this.name = "Tuong";
        this.sprite = sheet.getSubimage(2*sheetScale, isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int newCol, int newRow){
        return Math.abs(this.col - newCol) == Math.abs(this.row - newRow) ;
    }

    public boolean isObstacle(int newCol, int newRow){
        // check up-left
        if (this.col > newCol && this.row > newRow){
            for (int i = 1;i< Math.abs(this.col - newCol);i++){
                if (board.getPiece(this.col - i, this.row -i) != null) return true;
            }
        }
        // check up-right
        if (this.col < newCol && this.row > newRow){
            for (int i = 1;i< Math.abs(this.col - newCol);i++){
                if (board.getPiece(this.col + i, this.row -i) != null) return true;
            }
        }
        // check down-left
        if (this.col > newCol && this.row < newRow){
            for (int i = 1;i< Math.abs(this.col - newCol);i++){
                if (board.getPiece(this.col - i, this.row +i) != null) return true;
            }
        }
        // check down-right
        if (this.col < newCol && this.row < newRow){
            for (int i = 1;i< Math.abs(this.col - newCol);i++){
                if (board.getPiece(this.col + i, this.row + i) != null) return true;
            }
        }
        return false;
    }
}
