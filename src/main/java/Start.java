import gui.AlgorithmVisualizerPane;
import gui.BottomControls;
import gui.Window;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.AnimationSort;
import logic.BubbleSort;
import logic.NodeManager;


import java.util.Random;

public class Start extends Application {


    private HBox bottomControls;
    private VBox sideControl;
    private Pane animationPane;

    private Button animationStartBtn;
    private Button shuffleArrayBtn;


    private Node[] nodes;



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

        this.nodes = createRandomNodes(50, SCENE_HEIGHT);


        BorderPane root = createScene();




        animationStartBtn.setOnAction(event -> {
            BubbleSort sort = new BubbleSort();
            sort.sort(nodes);
            sort.play();
        });

        shuffleArrayBtn.setOnAction(event -> {
            animationPane.getChildren().clear();
            this.nodes = createRandomNodes(50, SCENE_HEIGHT);
            addLineToScene();
            animationPane.getChildren().addAll(nodes);

        });


        // Create Rectangles/Nodes with Random Values x Position of the Rectangle can be seen as index of Array
        // y - Position or Height is the Value at the given Array Position










        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private BorderPane createScene() {

        // initiating the GUI Parts
        createAnimationPane();
        createSideControls();
        createBottomControls();

        // Glue the GUI Parts together in a BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(animationPane);
        root.setBottom(bottomControls);
        //root.setRight(sideControl);

        return root;
    }

    private void createBottomControls() {

        this.bottomControls = new HBox(10);
        this.animationStartBtn = new Button("sort");
        this.shuffleArrayBtn = new Button("shuffle");


        this.bottomControls.getChildren().addAll(animationStartBtn, shuffleArrayBtn);
        this.bottomControls.setAlignment(Pos.TOP_CENTER);
        CornerRadii cornerRadii = new CornerRadii(5);
        Insets insets = new Insets(5, 5, 5,5 );
        Background background = new Background(new BackgroundFill(Color.GRAY, cornerRadii, insets));
        this.bottomControls.setBackground(background);



    }

    private void createSideControls() {

    }


    private void createAnimationPane() {
        this.animationPane = new Pane();
        addLineToScene();
        this.animationPane.getChildren().addAll(nodes);

    }

    private void addLineToScene() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(SCENE_HEIGHT/2 + 200);
        line.setEndX(SCENE_WIDTH);
        line.setEndY(SCENE_HEIGHT/2 + 200);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(5);
        this.animationPane.getChildren().add(line);

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
            Rectangle rec1 = new Rectangle((SCENE_WIDTH/rectangles.length) - offset, height, AnimationSort.COLOR_DEFAULT);
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
