package src.main;

import src.pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int tileSize = 75;
    int col =8, row = 8;

    Piece selectedPiece;
    Input input = new Input(this);
    ArrayList<Piece> pieceList = new ArrayList<>();
    public Board(){
        this.setPreferredSize(new Dimension(col*tileSize , row*tileSize));
        addPiece();
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Piece getPiece(int col, int row){
        for (Piece piece:pieceList){
            if (piece.col == col && piece.row == row) return piece;
        }
        return null;
    }

    public void makeMove(Move move){
        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCol * tileSize;
        move.piece.yPos = move.newRow * tileSize;

        move.piece.isFirstMove = false;

        capture(move);
    }

    public void capture(Move move){
        pieceList.remove(move.capture);
    }

    public boolean isValidMove( Move move){
        if (isSameTeam(move.piece, move.capture)) return false;
        if (!move.piece.isValidMovement(move.newCol, move.newRow)) return false;
        if (move.piece.isObstacle(move.newCol, move.newRow)) return false;
        return true;
    }

    public boolean isSameTeam(Piece p1, Piece p2){
        if (p1 == null || p2 == null) return false;
        return p1.isWhite == p2.isWhite;
    }

    public void addPiece(){

        // Thêm mã
        pieceList.add(new Ma(this,1,0,false));
        pieceList.add(new Ma(this,6,0,false));
        pieceList.add(new Ma(this,1,7,true));
        pieceList.add(new Ma(this,6,7,true));

        // Thêm tốt
        pieceList.add(new Tot(this,0,1,false));
        pieceList.add(new Tot(this,1,1,false));
        pieceList.add(new Tot(this,2,1,false));
        pieceList.add(new Tot(this,3,1,false));
        pieceList.add(new Tot(this,4,1,false));
        pieceList.add(new Tot(this,5,1,false));
        pieceList.add(new Tot(this,6,1,false));
        pieceList.add(new Tot(this,7,1,false));
        pieceList.add(new Tot(this,0,6,true));
        pieceList.add(new Tot(this,1,6,true));
        pieceList.add(new Tot(this,2,6,true));
        pieceList.add(new Tot(this,3,6,true));
        pieceList.add(new Tot(this,4,6,true));
        pieceList.add(new Tot(this,5,6,true));
        pieceList.add(new Tot(this,6,6,true));
        pieceList.add(new Tot(this,7,6,true));

        // Thêm xe
        pieceList.add(new Xe(this,0,0,false));
        pieceList.add(new Xe(this,7,0,false));
        pieceList.add(new Xe(this,0,7,true));
        pieceList.add(new Xe(this,7,7,true));

        // Thêm tượng
        pieceList.add(new Tuong(this,2,0,false));
        pieceList.add(new Tuong(this,5,0,false));
        pieceList.add(new Tuong(this,2,7,true));
        pieceList.add(new Tuong(this,5,7,true));

        // Thêm Hậu
        pieceList.add(new Hau(this,3,0,false));
        pieceList.add(new Hau(this,3,7,true));

        // Thêm Vua
        pieceList.add(new Vua(this,4,0,false));
        pieceList.add(new Vua(this,4,7,true));



    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // paint ChessBoard
        for (int i=0;i<col;i++){
            for (int j=0;j<row;j++){
                g2d.setColor((i+j) %2==0 ? Color.white : new Color(17, 203, 187));
                g2d.fillRect(i*tileSize,j*tileSize,tileSize,tileSize);
            }
        }

        // paint hightlight
        if (selectedPiece != null)
        for (int r=0;r<row;r++){
            for (int c =0;c<col;c++){
                if (isValidMove(new Move(this,selectedPiece,c,r))){
                    g2d.setColor(new Color(23, 241, 10, 157));
                    g2d.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
                }
            }
        }

        // paint piece
        for (Piece piece:pieceList){
            piece.paint(g2d);
        }
    }

}
