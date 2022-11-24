package cg.vsu.g.g.lagrange;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CurveController {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    @FXML
    private Label welcomeText;
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas = new Canvas(HEIGHT,WIDTH);

    LagrangePolynomial lagrangePolynomial = new LagrangePolynomial();
    LinkedList<Point> points = new LinkedList<>();
    LinkedList<Double> xs = new LinkedList<>();
    LinkedList<Double> ys = new LinkedList<>();
    private GraphicsContext g;



    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov,oldValue,newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(canvas.getGraphicsContext2D(), event);
            }
        });
        g = canvas.getGraphicsContext2D();
        repaint();
    }
    private void repaint() {
        paint(g);
    }
    protected void paint(GraphicsContext g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        lagrangePolynomial.sortArray();
        lagrangePolynomial.drawGraphic(g);

    }
    public void computeFunction(ActionEvent actionEvent) {
        repaint();
    }

    private void handlePrimaryClick(GraphicsContext graphicsContext, MouseEvent event) {
        final Point clickPoint = new Point(event.getX(), event.getY());
        points.add(clickPoint);
        double tempX = event.getX();
        double tempY = event.getY();
        lagrangePolynomial.points.add(new Point (tempX,tempY));
        g.beginPath();
        g.moveTo(tempX,tempY);
        g.strokeOval(tempX,tempY,3,3);
        g.fill();
        g.closePath();
    }
}