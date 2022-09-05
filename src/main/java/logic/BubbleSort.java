package logic;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class BubbleSort extends AnimationSort {


    private HashMap<Rectangle, Double> rectangleDoubleMap = new HashMap<>();



    @Override
    public void initMap(Node[] nodes) {


        for (int i = 0; i < nodes.length; i++) {
            Rectangle rec = (Rectangle)nodes[i];
            rectangleDoubleMap.put(rec, rec.getLayoutX());
        }

    }


    /**
     * Performs the Bubble Sort Algorithm, to Sort the Nodes with the Height as a Key
     * @param nodes which are to be sorted
     */
    @Override
    public void sort(Node[] nodes) {

        initMap(nodes);





        for (int i = 0; i < nodes.length - 1; i++) {

            boolean changed = false;

            for (int j = 0; j < nodes.length - 1 - i; j++) {

                // select nodes
                Rectangle rec1 = (Rectangle)nodes[j];
                Rectangle rec2 = (Rectangle)nodes[j+1];

                createSelectAnimation(rec1, rec2);


                // swap if height is bigger
                if (rec1.getHeight() > rec2.getHeight()) {
                    swap(nodes, j, j+1);
                    createSwapAnimation(rec1, rec2);
                    changed = true;
                }

            }



            // vorzeitiges abbruchkriterium, falls in einem Durchlauf kein swap vorhanden war
            if (!changed) {
                return;
            }

        }


    }

    /**
     *
     * @param nodes array
     * @param i to be swapped with nodes[j]
     * @param j to be swapped with nodes[i]
     */
    private void swap(Node[] nodes, int i, int j) {

        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;



    }


    public void createFillSortedAnimation(Node node1) {

        Rectangle rec = (Rectangle) node1;
        FillTransition ft = new FillTransition();
        ft.setDuration(Duration.millis(speed));
        ft.setFromValue(COLOR_DEFAULT);
        ft.setToValue(COLOR_SORTED);
        ft.setShape(rec);
        addAnimation(ft);

    }
    private void createSelectAnimation(Node node1, Node node2) {



        Rectangle rec1 = (Rectangle)node1;
        FillTransition ft = new FillTransition();
        ft.setDuration(Duration.millis(speed));
        ft.setFromValue(COLOR_DEFAULT);
        ft.setToValue(COLOR_SELECTED);
        ft.setShape(rec1);
        ft.setOnFinished(event -> {
            rec1.setFill(COLOR_DEFAULT);
        });

        Rectangle rec2 = (Rectangle)node2;
        FillTransition ft2 = new FillTransition();
        ft2.setDuration(Duration.millis(speed));
        ft2.setFromValue(Color.YELLOW);
        ft2.setToValue(Color.ALICEBLUE);
        ft2.setShape(rec2);
        ft2.setOnFinished(event -> rec2.setFill(Color.YELLOW));


        ParallelTransition pt = new ParallelTransition(ft, ft2);

        addAnimation(pt);

    }


    private double getX(Rectangle rec) {
        return rectangleDoubleMap.get(rec);
    }
    private void setX(Rectangle r, double x) {
        rectangleDoubleMap.put(r, x);
    }

    private void createSwapAnimation(Node node1, Node node2) {

        Rectangle rec1 = (Rectangle)node1;
        Rectangle rec2 = (Rectangle)node2;


        double rec1_x = getX(rec1);
        double rec2_x = getX(rec2);

        // wir wissen, falls geswappt wird das rec1 in richtung rec2 geht und rec2 in richtung rec1 !

        double translateDistanceX = Math.abs(rec1_x - rec2_x);

        TranslateTransition tt = new TranslateTransition();
        tt.setByX(translateDistanceX);
        tt.setNode(rec1);
        tt.setDuration(Duration.millis(speed));

        TranslateTransition tt2 = new TranslateTransition();
        tt2.setByX(-1 * translateDistanceX);
        tt2.setNode(rec2);
        tt2.setDuration(Duration.millis(speed));

        ParallelTransition pt2 = new ParallelTransition(tt, tt2);

        setX(rec1, rec1_x+translateDistanceX);
        setX(rec2, rec2_x-translateDistanceX);

        pt2.setOnFinished(event -> {

            double newX1 = rec1_x + rec1.getTranslateX();
            double newX2 = rec2_x + rec2.getTranslateX();
            rec1.setLayoutX(newX1);
            rec2.setLayoutX(newX2);


            rec1.setTranslateX(0);
            rec2.setTranslateX(0);



        });

        addAnimation(pt2);

    }
}
