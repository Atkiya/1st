package Tetris;

import java.awt.Color;
import java.util.*;

public class TetrisBlock {

    private int[][] shape;
    private Color color;
    private int x, y, currentRotation;
    private int[][][] shapes;

    private Color[] availableColors = {new Color(100,149,237,255), new Color(227,28,121,255),new Color(0,155,119,255),new Color(255,191,0,255),new Color(128,0,128,255),new Color(199,0,0,255)};

    public TetrisBlock(int[][] shape) {
        this.shape = shape;

        intitShapes();
    }

    public void intitShapes() {
        shapes = new int[4][][];
        for (int i = 0; i < 4; i++) {
            int r = shape[0].length;
            int c = shape.length;
            shapes[i] = new int[r][c];
            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    shapes[i][y][x] = shape[c - x - 1][y];
                }
            }
            shape = shapes[i];
        }
    }

    public void spawn(int gridWidth) {

        Random r = new Random();
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());

        color = availableColors[r.nextInt(availableColors.length)];

    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return shape.length;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void rotate() {
        currentRotation++;
        if (currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }

    public int getBottomEdge() {
        return y + getHeight();
    }

    public int getLeftEdge() {
        return x;
    }

    public int getRightEdge() {
        return x + getWidth();
    }

}
