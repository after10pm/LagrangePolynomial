package cg.vsu.g.g.lagrange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.LinkedList;

public class CurveController {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    LinkedList<Double> xs = new LinkedList<>();
    LinkedList<Double> ys = new LinkedList<>();
    LinkedList<Point> p = new LinkedList<>();
    Lagrange2D lagrange2D = new Lagrange2D(xs, ys);
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas = new Canvas(HEIGHT, WIDTH);
    //LagrangePolynomial lagrangePolynomial = new LagrangePolynomial();
    private GraphicsContext graphicsContext;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));
        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(event);
            }
        });
        graphicsContext = canvas.getGraphicsContext2D();
        repaint();
    }

    private void handlePrimaryClick(MouseEvent event) {
        double clickPointX = event.getX();
        double clickPointY = event.getY();
        Point clickPoint = new Point(clickPointX, clickPointY);
        p.add(clickPoint);
        lagrange2D.addPoint(p.getLast());
        graphicsContext.beginPath();
        graphicsContext.moveTo(clickPointX, clickPointY);
        graphicsContext.strokeOval(clickPointX, clickPointY, 3, 3);
        graphicsContext.fill();
        graphicsContext.closePath();
    }

    private void repaint() {
        paint(graphicsContext);
    }

    protected void paint(GraphicsContext g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        lagrange2D.drawIn2D(g);
    }

    public void compute(ActionEvent actionEvent) {
        repaint();
    }

    public void delete() {
        p.clear();
        graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
        lagrange2D.xValues.clear();
        lagrange2D.yValues.clear();
    }
}