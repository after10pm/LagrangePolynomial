module cg.vsu.g.g.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens cg.vsu.g.g.lagrange to javafx.fxml;
    exports cg.vsu.g.g.lagrange;
}