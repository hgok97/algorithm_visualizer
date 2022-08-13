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
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;
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
    public static final int STARTING_HEIGHT = SCENE_HEIGHT/2 + 200;


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




        controlButton1.setOnAction(event -> {
            Rectangle[] rectangles = generateRandomRectangles(20);
            drawRectangles(rectangles);
        });





        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setResizable(false);

    }

    private void drawRectangle(Rectangle rectangle) {
        graphicsContext.setFill(Color.YELLOWGREEN);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(2);

        graphicsContext.beginPath();
        graphicsContext.moveTo(rectangle.getX(), rectangle.getY());
        graphicsContext.lineTo(rectangle.getX() + rectangle.getWidth(), rectangle.getY());
        graphicsContext.lineTo(rectangle.getX() + rectangle.getWidth(), rectangle.getY() - rectangle.getHeight());
        graphicsContext.lineTo(rectangle.getX(), rectangle.getY() - rectangle.getHeight());
        graphicsContext.lineTo(rectangle.getX(), rectangle.getY());
        graphicsContext.fill();
        graphicsContext.stroke();

    }


    private VBox createControlBox() {


        VBox box = new VBox();
        controlButton1 = new Button("generate rectangles");
        controlButton2 = new Button("btn2");
        controlButton3 = new Button("btn3");
        box.getChildren().addAll(controlButton1, controlButton2, controlButton3);

        return box;


    }

    private Canvas initCanvas() {

        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();

        drawDefault();


        return canvas;
    }

    private void drawDefault() {
        graphicsContext.setFill(Color.GRAY);
        graphicsContext.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        drawLine(0, STARTING_HEIGHT, SCENE_WIDTH-1, STARTING_HEIGHT);

    }

    private void drawLine(double startX, double startY, double endX, double endY) {
        graphicsContext.setFill(Color.WHITESMOKE);
        graphicsContext.setStroke(Color.WHITESMOKE);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeLine(startX, startY, endX, endY);

    }

    private Rectangle[] generateRandomRectangles(int num_of_objects) {
        Random rng = new Random();
        double maxHeight = SCENE_HEIGHT - 300;
        int offset = 7;
        int width = SCENE_WIDTH / num_of_objects - (offset);


        Rectangle[] rectangles = new Rectangle[num_of_objects];

        for (int i = 0; i < num_of_objects; i++) {

            double height = rng.nextInt((int)maxHeight) + 100;
            double x = (i * width) + (offset*i);
            double y = STARTING_HEIGHT;
            Rectangle rectangle = new Rectangle(width, height, x, y);
            rectangles[i] = rectangle;

        }


        return rectangles;

    }

    private void drawRectangles(Rectangle[] rectangles) {


        drawDefault();
        graphicsContext.setFill(Color.YELLOWGREEN);
        graphicsContext.setStroke(Color.BLACK);

        for (int i = 0; i < rectangles.length; i++) {


            Rectangle rec = rectangles[i];

            drawRectangle(rec);


        }





    }


}
