package cg.vsu.g.g.lagrange;

public class Point {

    public double x;
    public double y;
    private int size;


    public Point(double x, double y, int size){
      this.x = x;
      this.y = y;
      this.size = size;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
