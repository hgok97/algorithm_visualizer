package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BottomControls extends HBox {




    private Button startBtn;



    public BottomControls() {
        createControlBox();
    }




    private void createControlBox() {
        startBtn = new Button("start");
        // and other stuff that is neeeded.....

        this.getChildren().add(startBtn);
    }
    public Button getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(Button startBtn) {
        this.startBtn = startBtn;
    }
}
