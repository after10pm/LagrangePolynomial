package cg.vsu.g.g.lagrange;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

//  {x,y} but with paramS --> {x,y}
// param -> x ; param -> y
public class Lagrange2D {
    public List<Double> xValues;
    public List<Double> yValues;
    private List<Double> tValues = new ArrayList<>();

    public Lagrange2D(List<Double> xValues, List<Double> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public void addPoint(Point point) {
        this.xValues.add(point.getX());
        this.yValues.add(point.getY());
        getTValues();
    }

    private void getTValues() {
        double t1 = 0;
        double t2 = 0;
        double sum = 0;
        this.tValues.clear();
        this.tValues.add(t1);
        for (int i = 1; i < xValues.size(); i++) {
            sum += Math.sqrt(Math.abs(xValues.get(i - 1) - xValues.get(i) * (xValues.get(i - 1) - xValues.get(i)) -
                    (yValues.get(i - 1) - yValues.get(i)) * (yValues.get(i - 1) - yValues.get(i))));
        }
        for (int i = 1; i < xValues.size(); i++) {
            t2 += Math.sqrt(Math.abs(xValues.get(i - 1) - xValues.get(i) * (xValues.get(i - 1) - xValues.get(i)) -
                    (yValues.get(i - 1) - yValues.get(i)) * (yValues.get(i - 1) - yValues.get(i)))) / sum;
            tValues.add(t2);
        }
    }

    public List<Point> getPoints() {
        List<Point> pointList = new ArrayList<>();
        LagrangePolynomial lagrange2DPolynomialXs = new LagrangePolynomial(this.tValues, this.xValues);
        LagrangePolynomial lagrange2DPolynomialYs = new LagrangePolynomial(this.tValues, this.yValues);
        Point newPoint;
        double x, y;
        for (double t = 0; t < 1; t += 0.01) {
            x = lagrange2DPolynomialXs.interpolateLagrangePolynomial(t);
            y = lagrange2DPolynomialYs.interpolateLagrangePolynomial(t);
            newPoint = new Point(x, y);
            pointList.add(newPoint);
        }
        return pointList;
    }

    public void drawIn2D(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BLACK);
        List<Point> points2D = getPoints();
        double x1, y1, x2, y2;
        for (int i = 1; i < points2D.size(); i++) {
            x1 = points2D.get(i - 1).getX();
            y1 = points2D.get(i - 1).getY();
            x2 = points2D.get(i).getX();
            y2 = points2D.get(i).getY();
            graphicsContext.strokeLine(x1, y1, x2, y2);
        }
    }
}
