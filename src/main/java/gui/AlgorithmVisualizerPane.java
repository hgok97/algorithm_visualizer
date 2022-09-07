package gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import logic.NodeManager;


/**
 * Contains the Node Elements and a Line
 */
public class AlgorithmVisualizerPane extends Pane {


    private NodeManager nodeManager;

    public AlgorithmVisualizerPane(NodeManager nodeManager) {
        addLineToScene();
        this.nodeManager = nodeManager;
        this.getChildren().addAll(nodeManager.getNodes());

    }

    private void addLineToScene() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(Window.SCENE_HEIGHT/2 + 200);
        line.setEndX(Window.SCENE_WIDTH);
        line.setEndY(Window.SCENE_HEIGHT/2 + 200);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(5);
        this.getChildren().add(line);
    }





}
