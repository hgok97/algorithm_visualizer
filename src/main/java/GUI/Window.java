package GUI;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * This class contains the Pane for our Main Scene
 */
public class Window extends BorderPane {


    private HBox bottomControls;
    private VBox sideControls;

    // This Pane will be filled with Elements which depend on the current Algorithm which is going to be visualized
    private Pane visualizerPane;


    public Window() {
        createWindow();
    }


    private void createWindow() {

        HBox bottomControls = new BottomControls();
        VBox sideControls = new SideControls();

        visualizerPane = new Pane();
        visualizerPane.setPrefWidth(400);
        visualizerPane.setPrefHeight(400);

        this.setBottom(bottomControls);
        this.setRight(sideControls);
        this.setCenter(visualizerPane);


    }



    public HBox getBottomControls() {
        return bottomControls;
    }

    public void setBottomControls(HBox bottomControls) {
        this.bottomControls = bottomControls;
    }

    public VBox getSideControls() {
        return sideControls;
    }

    public void setSideControls(VBox sideControls) {
        this.sideControls = sideControls;
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
