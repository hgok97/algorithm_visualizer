import GUI.Window;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.Random;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    public static final int SCENE_HEIGHT = 720;
    public static final int SCENE_WIDTH = 1280;
    // zu prototyp zwecken schmeißen wir erstmals alles in die main/start klasse

    @Override
    public void start(Stage primaryStage) {


        /*
        BorderPane root = new Window();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

         */


        Pane root = new Pane();


        // Create Rectangles/Nodes with Random Values x Position of the Rectangle can be seen as index of Array
        // y - Position or Height is the Value at the given Array Position
        Node[] nodes = createRandomNodes(20, SCENE_HEIGHT);

        root.getChildren().addAll(nodes);
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

    }



    private Node[] createRandomNodes(int num_of_nodes, int max_height_of_node) {

        Random rng = new Random();
        Rectangle[] rectangles = new Rectangle[num_of_nodes];


        int width = SCENE_WIDTH / num_of_nodes;
        for (int i = 0; i < num_of_nodes; i++) {

            int height = rng.nextInt(max_height_of_node/2) + 1;
            Rectangle rectangle = new Rectangle(width, height, Color.YELLOW);
            rectangle.setLayoutX(10 + (i+1) * width);
            rectangle.setLayoutY(SCENE_HEIGHT/2 - 50);
            //rectangle.getTransforms().add(new Rotate(90, rectangle.getLayoutX(), rectangle.getLayoutY()));
            rectangle.setStrokeWidth(2);
            rectangle.setStroke(Color.BLACK);



            rectangles[i] = rectangle;

        }

        return rectangles;
    }




}
