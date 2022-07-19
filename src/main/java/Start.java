import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.AnimationSort;
import logic.BubbleSort;

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
        Node[] nodes = createRandomNodes(10, SCENE_HEIGHT);

        root.getChildren().addAll(nodes);
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(SCENE_HEIGHT/2 + 200);
        line.setEndX(SCENE_WIDTH);
        line.setEndY(SCENE_HEIGHT/2 + 200);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(5);
        root.getChildren().add(line);




        Button sortBtn = new Button("Sort");

        root.getChildren().add(sortBtn);



        AnimationSort sort = new BubbleSort();
        //sort.sort(nodes);





        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

    }



    private Node[] createRandomNodes(int num_of_nodes, int max_height_of_node) {

        Random rng = new Random();
        Rectangle[] rectangles = new Rectangle[num_of_nodes];


        int width = SCENE_WIDTH / num_of_nodes;


        for (int i = 0; i < num_of_nodes; i++) {

            int height = rng.nextInt(max_height_of_node/2) + 20;

            int offset = 5;
            Rectangle rec1 = new Rectangle((SCENE_WIDTH/rectangles.length) - offset, height, Color.YELLOW);
            rec1.setStrokeWidth(2);
            rec1.setStroke(Color.BLACK);
            rec1.relocate((i * rec1.getWidth()) + (i*offset), SCENE_HEIGHT/2 + 200);


            rec1.getTransforms().add(new Rotate(180, rec1.getX(), rec1.getY()));

            rec1.setStrokeWidth(1);
            rec1.setStroke(Color.BLACK);

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000));
            translateTransition.setByX(-rec1.getWidth());

            FillTransition fillTransition = new FillTransition(Duration.millis(1000), Color.RED, Color.YELLOW);

            ParallelTransition parallelTransition = new ParallelTransition(rec1, translateTransition, fillTransition);

            rec1.setOnMouseClicked(event -> {
                translateTransition.setByX(-1 * translateTransition.getByX());
                parallelTransition.play();
            });



            rectangles[i] = rec1;

        }

        return rectangles;
    }




}
