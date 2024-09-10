package src.pieces;

import src.main.Board;

import java.awt.image.BufferedImage;

public class Xe extends Piece{
    public Xe(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;

        this.name = "Xe";
        this.sprite = sheet.getSubimage(4*sheetScale, isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int newCol, int newRow){
        return this.col == newCol || this.row == newRow;
    }

    public boolean isObstacle(int newCol, int newRow){
        // check left direction
        if (newCol < this.col){
            for (int c =this.col -1;c > newCol;c--){
                if (board.getPiece(c,this.row) != null) return true;
            }
        }
        // check right direction
        if (newCol > this.col){
            for (int c = this.col +1;c < newCol;c++){
                if (board.getPiece(c,this.row) != null) return true;
            }
        }
        // check up direction
        if (newRow < this.row){
            for (int r =this.row -1;r > newRow;r--){
                if (board.getPiece(this.col, r) != null) return true;
            }
        }
        // check down direction
        if (newRow > this.row){
            for (int r =this.row +1;r < newRow;r++){
                if (board.getPiece(this.col, r) != null) return true;
            }
        }
        return false;
    }
}
