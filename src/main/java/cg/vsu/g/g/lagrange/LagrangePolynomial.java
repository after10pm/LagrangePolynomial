package cg.vsu.g.g.lagrange;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LagrangePolynomial {

    public List<Double> xValues;
    public List<Double> yValues;

    LagrangePolynomial(List<Double> xValues, List<Double> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }


    LagrangePolynomial() {

    }

    public ArrayList<Point> points = new ArrayList<>();

    public double interpolateLagrangePolynomial(double x) {
        double lagrangePol = 0;
        for (int i = 0; i < xValues.size(); i++) {
            double basicsPol = 1;
            for (int j = 0; j < xValues.size(); j++) {
                if (j != i) {
                    basicsPol *= (x - this.xValues.get(j)) / (this.xValues.get(i) - this.xValues.get(j));
                }
            }
            lagrangePol += basicsPol * this.yValues.get(i);
        }

        return lagrangePol;
    }

    public void sortArray() {
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = 0; j < points.size() - 1; j++) {
                if (points.get(j).getX() > points.get(j + 1).getX()) {
                    double xTemp = points.get(j).getX();
                    double yTemp = points.get(j).getY();
                    points.get(j).x = points.get(j + 1).getX(); // мне очень не нравится обращение к полю,
                    points.get(j).y = points.get(j + 1).getY(); // возможно, в дальнейшем я исправлю это
                    points.get(j + 1).x = xTemp;
                    points.get(j + 1).y = yTemp;
                }
            }
        }
    }

    public void drawGraphic(GraphicsContext g) {
        if (points.size() == 0)
            return;
        double ys;
        g.setFill(Color.BLACK);
        g.beginPath();
        g.moveTo(points.get(0).getX(), points.get(0).getY());
        for (int i = 0; i < points.size() - 1; i++) {
            for (double xs = points.get(i).getX(); xs <= points.get(i + 1).getX(); xs += 0.001) {
                ys = interpolateLagrangePolynomial(xs);
                g.lineTo(xs, ys);
            }
        }
        g.stroke();
        g.closePath();
    }
}
