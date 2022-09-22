package logic;

import gui.AlgorithmVisualizerPane;
import gui.BottomControls;
import gui.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainTest extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {

        // assemble GUI Elements
        NodeManager nodeManager = new NodeManager(50);
        BottomControls bottomControls = new BottomControls(nodeManager);
        AlgorithmVisualizerPane algorithmVisualizerPane = new AlgorithmVisualizerPane(nodeManager);
        Window animationWindow = new Window(algorithmVisualizerPane, bottomControls);

    }
}
