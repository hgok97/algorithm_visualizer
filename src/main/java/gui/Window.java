package gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * This class contains the Pane for our Main Scene
 */
public class Window extends BorderPane {


    public static final int SCENE_HEIGHT = 720;
    public static final int SCENE_WIDTH = 1280;

    private HBox bottomControls;

    // This Pane will be filled with Elements which depend on the current Algorithm which is going to be visualized
    private Pane visualizerPane;


    public Window(Pane pane, HBox hbox) {
        this.visualizerPane = pane;
        this.bottomControls = hbox;

        this.setBottom(bottomControls);
        this.setCenter(visualizerPane);
    }






    public HBox getBottomControls() {
        return bottomControls;
    }

    public void setBottomControls(HBox bottomControls) {
        this.bottomControls = bottomControls;
    }


    public Pane getVisualizerPane() {
        return visualizerPane;
    }

    // Important, because with this, all the Algorithms can do their own stuff and put their own pane in there?
    // Or should we work with just one pane and just edit that one pane? It will depend on the current algorithm and stuff
    public void setVisualizerPane(Pane visualizerPane) {
        this.visualizerPane = visualizerPane;
    }
}
