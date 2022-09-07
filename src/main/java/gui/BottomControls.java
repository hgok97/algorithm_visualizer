package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.NodeManager;

public class BottomControls extends HBox {



    private final NodeManager nodeManager;

    private Button animationStartBtn;
    private Button shuffleArrayBtn;




    public BottomControls(NodeManager nodeManager) {
        super(10);

        this.nodeManager = nodeManager;

        animationStartBtn = new Button("sort");
        shuffleArrayBtn = new Button("shuffle");
        this.setAlignment(Pos.TOP_CENTER);
        getChildren().addAll(animationStartBtn, shuffleArrayBtn);
        CornerRadii cornerRadii = new CornerRadii(5);
        Insets insets = new Insets(5, 5, 5,5 );
        Background background = new Background(new BackgroundFill(Color.GRAY, cornerRadii, insets));
        setBackground(background);


    }



}
