import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class testing extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle circle1 = new Circle(50, Color.RED);
        Circle circle2 = new Circle(80, Color.BLUE);

        // Set tooltips for the circles
        Tooltip tooltip1 = new Tooltip("This is Circle 1");
        Tooltip tooltip2 = new Tooltip("This is Circle 2");

        Tooltip.install(circle1, tooltip1);
        Tooltip.install(circle2, tooltip2);

        Pane root = new Pane();
        root.setPadding(new Insets(10));
        root.getChildren().addAll(circle1, circle2);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
