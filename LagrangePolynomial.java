import java.awt.*;
import java.util.List;

public class LagrangePolynomial {

    private List<Double> xValues;
    private List<Double> yValues;

    public LagrangePolynomial (List<Double> xValues, List<Double> yValues){
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public void addPoint(Point point){
        this.xValues.add(point.getX());
        this.xValues.add(point.getX());
    }

    private double interpolateY(double s, double x){
        double lagrangePolynomial = 0;
        for (int i = 0; i < xValues.size(); i++){
            double basicPolynomial = 1;
            for (int j = 0; j < xValues.size(); j++){
                if (j != i) {
                    basicPolynomial *= (x - this.xValues.get(j))/(this.xValues.get(i) - this.xValues.get(j));
                }
            }
            lagrangePolynomial += basicPolynomial * this.yValues.get(i);
        }
        return lagrangePolynomial;
    }
// попытка интерполировать x, чтобы можно было вызвать метод drawLine(xValue(i),yValue(i),interpolateX,interpolateY)
    private double interpolateX( double s, double y){
        double lagrangePolynomial = 0;
        for (int i = 0; i < yValues.size(); i++){
            double basicPolynomial = 1;
            for (int j = 0; j < yValues.size(); j++) {
                if (j != i){
                    basicPolynomial *= (y - this.yValues.get(j))/(this.yValues.get(i) - this.yValues.get(j));
                }
            }
            lagrangePolynomial += basicPolynomial * this.xValues.get(i);
        }
        return lagrangePolynomial;
    }


    public void draw (Graphics2D graphics){
        for (int i = 0; i < xValues.size(); i++){
            //graphics.drawLine(xValues.get(i),yValues.get(i));
        }

    }
}
