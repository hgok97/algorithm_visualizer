import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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




        Button colorFadeBtn = new Button("colorFade");


        colorFadeBtn.setOnAction(event -> {

            SequentialTransition sqt = new SequentialTransition();

            for (int i = 0; i < nodes.length; i++) {

                // SequentialTransistion "füllen"
                FillTransition ft = new FillTransition();
                ft.setFromValue(Color.YELLOW);
                ft.setToValue(Color.AQUAMARINE);
                ft.setDuration(Duration.millis(500));
                ft.setShape((Rectangle)nodes[i]);
                sqt.getChildren().add(ft);


            }
            sqt.play();


        });

        Text debugOutputText = new Text("Debug Output");



        Button swapNodesBtn = new Button("swap random nodes");

        swapNodesBtn.setOnAction(event -> {

            Random rng = new Random();
            int upperBound = nodes.length;

            // choose 2 random points, they should not be equal!
            boolean found = true;
            int i = rng.nextInt(upperBound);
            int j;
            // check if the next random value isnt equal, can be refactored obv.
            do {
                j = rng.nextInt(upperBound);
                if (!(i == j)) {
                    found = false;
                }
            } while (found);


            Rectangle rec1 = (Rectangle)nodes[i];
            Rectangle rec2 = (Rectangle)nodes[j];



            // move rec1 to rec2 and rec2 to the position of rec1



            // Ist LayoutX nun der korrekte x-wert? Wir benötigen die x-Koordinaten des Nodes in der globalen Scene
            final double rec1_x = rec1.getLayoutX();
            final double rec2_x = rec2.getLayoutX();




            debugOutputText.setText(rec1_x + ", " + rec2_x);
            int speed = 500;


            // 1. color rec1 to visualize that is "choosen"
            FillTransition ft = new FillTransition();
            ft.setDuration(Duration.millis(speed));
            ft.setFromValue(Color.YELLOW);
            ft.setToValue(Color.RED);
            ft.setShape(rec1);

            // 2. Color rec2

            FillTransition ft2 = new FillTransition();
            ft2.setDuration(Duration.millis(speed));
            ft2.setFromValue(Color.YELLOW);
            ft2.setToValue(Color.RED);
            ft2.setShape(rec2);


            ParallelTransition pt = new ParallelTransition(ft, ft2);



            // Abhaengig davon ob rec1 kleiner oder größer ist wird die Verschiebung gemacht

            double translateRec1X = 0;
            double translateRec2X = 0;

            // bewege rec1 richtung rec2 (positiv)
            double distanceX = Math.abs(rec1_x - rec2_x);
            if (rec1_x < rec2_x) {
                translateRec1X = distanceX;
                translateRec2X = -1 * distanceX;
            } else {
                translateRec1X = -1 * distanceX;
                translateRec2X = distanceX;
            }



            System.out.println("Rectangle 1 = nodes[" + i + "]\tx - Value: " + rec1_x + "\t translate distance: " + translateRec1X);
            System.out.println("Rectangle 2 = nodes[" + j + "]\tx - Value: " + rec2_x + "\t translate distance: " + translateRec2X);

            TranslateTransition tt = new TranslateTransition();
            tt.setByX(translateRec1X);
            tt.setNode(rec1);
            tt.setDuration(Duration.millis(speed));

            TranslateTransition tt2 = new TranslateTransition();
            tt2.setByX(translateRec2X);
            tt2.setNode(rec2);
            tt2.setDuration(Duration.millis(speed));

            ParallelTransition pt2 = new ParallelTransition(tt, tt2);


            SequentialTransition sqt = new SequentialTransition(pt, pt2);
            sqt.setOnFinished(event1 -> {




                rec1.setLayoutX(rec1_x + rec1.getTranslateX());
                rec2.setLayoutX(rec2_x + rec2.getTranslateX());
                System.out.println("Rectangle 1 x - Value = " + rec1_x + "\t" + "Rectangle 1 translateX after Animation = " + rec1.getTranslateX());
                System.out.println("Rectangle 2 x - Value = " + rec2_x + "\t" + "Rectangle 1 translateX after Animation = " + rec2.getTranslateX());

                rec1.setTranslateX(0);
                rec2.setTranslateX(0);

                System.out.println(rec1.getLayoutX());
                System.out.println(rec2.getLayoutX());


            });

            sqt.play();



        });

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(colorFadeBtn, swapNodesBtn, debugOutputText);


        root.getChildren().add(buttonBox);

        root.setOnMouseClicked(event -> {
            debugOutputText.setText("x = " + event.getX() + ", " + "y = " + event.getY());
        });



        AnimationSort sort = new BubbleSort();
        //sort.sort(nodes);





        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    /**
     * kp warum kein terminal output da ist, man könnte auch in eine datei schreiben oder eine extra window parallel
     * bzw. in ein scrollable text reinschreiben ^^
     * @param nodes
     */
    private void printNodePosition(Node[] nodes) {

        for (Node node: nodes) {
            System.out.println(node.getLayoutX() + ", " + node.getTranslateX() + ", " + node.getLocalToSceneTransform());
        }


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
            rec1.relocate((i * rec1.getWidth()) + (i*offset) + rec1.getWidth(), SCENE_HEIGHT/2 + 200);


            rec1.getTransforms().add(new Rotate(180, rec1.getX(), rec1.getY()));

            rec1.setStrokeWidth(1);
            rec1.setStroke(Color.BLACK);



            rectangles[i] = rec1;

        }

        return rectangles;
    }




}
