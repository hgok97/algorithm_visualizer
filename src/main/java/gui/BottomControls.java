package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import logic.NodeManager;

public class BottomControls extends HBox {



    private final NodeManager nodeManager;

    private Button animationStartBtn;
    private Button shuffleArrayBtn;
    private Spinner<Integer> animationSpeedSpinner;






    public BottomControls(NodeManager nodeManager) {
        super(10);

        this.nodeManager = nodeManager;

        animationStartBtn = new Button("sort");
        shuffleArrayBtn = new Button("shuffle");
        animationSpeedSpinner = new Spinner<>();
        animationSpeedSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5));
        VBox spinnerContainer = new VBox();
        Label speedLabel = new Label("animation speed");
        spinnerContainer.getChildren().addAll(speedLabel, animationSpeedSpinner);


        this.setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(animationStartBtn, shuffleArrayBtn, spinnerContainer);
        CornerRadii cornerRadii = new CornerRadii(5);
        Insets insets = new Insets(5, 5, 5,5 );
        Background background = new Background(new BackgroundFill(Color.GRAY, cornerRadii, insets));
        setBackground(background);


    }



}
