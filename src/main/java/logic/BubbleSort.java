package logic;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class BubbleSort extends AnimationSort {


    /**
     * Performs the Bubble Sort Algorithm, to Sort the Nodes with the Height as a Key
     * @param nodes which are to be sorted
     */
    @Override
    public void sort(Node[] nodes) {

        boolean changed = false;
        for (int i = 0; i < nodes.length - 2; i++) {



            for (int j = 0; j < nodes.length - 2 - i; j++) {


                Rectangle rec1 = (Rectangle)nodes[j];
                Rectangle rec2 = (Rectangle)nodes[j+1];



                if (rec1.getHeight() > rec2.getHeight()) {

                    // put rec1 on the position where rec2 is and rec2 where rec1 is  (swapp)
                    double xTemp = rec1.getX();
                    double yTemp = rec1.getY();
                    rec1.relocate(rec2.getX(), rec2.getY());
                    rec2.relocate(xTemp, yTemp);
                }



            }

            if (changed) {
                return;
            }


        }





    }
}
