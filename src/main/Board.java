package src.main;

import src.pieces.Tot;
import src.pieces.Ma;
import src.pieces.Piece;

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
        pieceList.add(new Ma(this,1,0,false));
        pieceList.add(new Ma(this,1,7,true));
        pieceList.add(new Ma(this,6,0,false));
        pieceList.add(new Ma(this,6,7,true));

        pieceList.add(new Tot(this,0,1,false));
        pieceList.add(new Tot(this,1,1,false));
        pieceList.add(new Tot(this,2,1,false));
        pieceList.add(new Tot(this,3,1,false));
        pieceList.add(new Tot(this,4,1,false));
        pieceList.add(new Tot(this,5,1,false));
        pieceList.add(new Tot(this,6,1,false));
        pieceList.add(new Tot(this,7,1,false));



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
