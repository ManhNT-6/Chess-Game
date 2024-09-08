package src.main;

import src.pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int tileSize = 75;
    int col =8, row = 8;
    ArrayList<Piece> pieceList = new ArrayList<>();
    public Board(){
        this.setPreferredSize(new Dimension(col*tileSize , row*tileSize));
        addPiece();
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
        for (int i=0;i<col;i++){
            for (int j=0;j<row;j++){
                g2d.setColor((i+j) %2==0 ? new Color(143, 217, 143) : new Color(16, 114, 16));
                g2d.fillRect(i*tileSize,j*tileSize,tileSize,tileSize);
            }
        }

        for (Piece piece:pieceList){
            piece.paint(g2d);
        }
    }
}
