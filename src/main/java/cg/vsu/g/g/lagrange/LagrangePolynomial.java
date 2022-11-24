package cg.vsu.g.g.lagrange;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LagrangePolynomial {

    public ArrayList<Point> points = new ArrayList<>();
    public boolean checkPoint (double xn, double yn) {
        for (int i = 0; i < points.size(); i++) {
            if(points.get(i).getX() == xn && points.get(i).getY() == yn)
                return false;
        }
        return true;
    }

    private double InterpolateLagrangePolynomial(double x0) {
        double y0 = 0;
        for (int i = 0; i < points.size(); i++)
        {
            double basicsPolynomial = points.get(i).getY();
            for (int j = 0; j < points.size(); j++) {
                if (j != i) {
                    basicsPolynomial *= (x0 - this.points.get(j).getX())/(this.points.get(i).getX() - this.points.get(j).getX());
                }
            }
            y0 += basicsPolynomial;
        }
        return y0;
    }

    public void sortArray() {
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = 0; j < points.size() - 1 ; j++) {
                if (points.get(j).getX() > points.get(j + 1).getX()){
                    double xTemp = points.get(j).getX();
                    double yTemp = points.get(j).getY();

                    points.get(j).x = points.get(j + 1).getX();
                    points.get(j).y = points.get(j + 1).getY();
                    points.get(j + 1).x = xTemp;
                    points.get(j + 1).y = yTemp;
                }
            }
        }
    }
    public void drawGraphic (GraphicsContext g) {
        if (points.size() == 0)
            return;
        double ys;
        g.setFill(Color.BLACK);
        g.beginPath();
        g.moveTo(points.get(0).getX(),points.get(0).getY());
        for (int i = 0; i < points.size() - 1 ; i++) {
            for (double xs = points.get(i).getX(); xs <= points.get(i+1).getX(); xs+= 0.001){
                ys = InterpolateLagrangePolynomial(xs);
                g.lineTo(xs,ys);
            }
        }
        g.stroke();
        g.closePath();
    }

}
