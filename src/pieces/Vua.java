package src.pieces;

import src.main.Board;

import java.awt.image.BufferedImage;

public class Vua extends Piece {
    public Vua(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;

        this.name = "Vua";
        this.sprite = sheet.getSubimage(0*sheetScale, isWhite ? 0:sheetScale,sheetScale,sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);
    }
    public boolean isValidMovement(int newCol, int newRow){
        return Math.abs((this.col - newCol) * (this.row - newRow)) == 1 || Math.abs(this.col - newCol ) + Math.abs(this.row - newRow ) == 1;
    }
}
