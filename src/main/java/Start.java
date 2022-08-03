import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.AnimationSort;
import logic.BubbleSort;
import org.w3c.dom.css.Rect;

import java.util.Random;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    public static final int SCENE_HEIGHT = 720;
    public static final int SCENE_WIDTH = 1280;


    private GraphicsContext graphicsContext;
    private Button controlButton1;
    private Button controlButton2;
    private Button controlButton3;

    // zu prototyp zwecken schmeißen wir erstmals alles in die main/start klasse

    @Override
    public void start(Stage primaryStage) {


         BorderPane root = new BorderPane();

        Canvas canvas = initCanvas();
        VBox controlBox = createControlBox();
        controlBox.setAlignment(Pos.CENTER);
        root.setCenter(canvas);
        root.setRight(controlBox);





        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }


    private VBox createControlBox() {


        VBox box = new VBox();
        controlButton1 = new Button("btn1");
        controlButton2 = new Button("btn2");
        controlButton3 = new Button("btn3");
        box.getChildren().addAll(controlButton1, controlButton2, controlButton3);

        return box;


    }

    private Canvas initCanvas() {

        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.GRAY);
        graphicsContext.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);

        return canvas;
    }

    private void drawLine(double startX, double startY, double endX, double endY) {
        graphicsContext.setFill(Color.WHITESMOKE);

        graphicsContext.setStroke(Color.WHITESMOKE);
        graphicsContext.moveTo(startX, startY);
        graphicsContext.lineTo(endX, endY);

    }


}
