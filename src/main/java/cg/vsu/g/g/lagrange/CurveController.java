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

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas = new Canvas(HEIGHT,WIDTH);

    LagrangePolynomial lagrangePolynomial = new LagrangePolynomial();
    private GraphicsContext graphicsContext;



    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov,oldValue,newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));
        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(event);
            }
        });
        graphicsContext = canvas.getGraphicsContext2D();
        repaint();
    }

    private void repaint() {
        paint(graphicsContext);
    }
    protected void paint(GraphicsContext g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        lagrangePolynomial.sortArray();
        lagrangePolynomial.drawGraphic(g);

    }
    public void compute(ActionEvent actionEvent) {
        repaint();
    }
    public void delete(){
        lagrangePolynomial.points.clear();
        graphicsContext.clearRect(0,0,WIDTH,HEIGHT);
    }

    private void handlePrimaryClick(MouseEvent event) {
        double clickPointX = event.getX();
        double clickPointY = event.getY();
        lagrangePolynomial.points.add(new Point (clickPointX,clickPointY));
        graphicsContext.beginPath();
        graphicsContext.moveTo(clickPointX,clickPointY);
        graphicsContext.strokeOval(clickPointX,clickPointY,3,3);
        graphicsContext.fill();
        graphicsContext.closePath();
    }
}