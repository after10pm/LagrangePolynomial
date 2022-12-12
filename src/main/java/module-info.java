module cg.vsu.g.g.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;


    opens cg.vsu.g.g.lagrange to javafx.fxml;
    exports cg.vsu.g.g.lagrange;
}