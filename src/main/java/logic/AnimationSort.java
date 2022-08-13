package logic;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class AnimationSort {

    private ArrayList<Animation> sortingAnimation;

    public final int speed = 200;


    public AnimationSort() {
        sortingAnimation = new ArrayList<>();
    }






    protected double[] toDoubleArray(Node[] nodes) {

        double[] array = new double[nodes.length];

        for (int i = 0; i < nodes.length; i++) {

            array[i] = ((Rectangle)nodes[i]).getHeight();

        }


        return array;
    }


    /**
     * Sorts the nodes and fills the animationList
     * @param nodes
     */
    public abstract void sort(Node[] nodes);


    /**
     * plays the animations from the list in sequential manner
     */
    public void play() {

        SequentialTransition sqt = new SequentialTransition();

        for (Animation animation: sortingAnimation) {
            sqt.getChildren().add(animation);
        }

        sqt.play();

    }

    public void addAnimation(Animation animation) {

        if (animation == null) {
            throw new NullPointerException();
        }

        sortingAnimation.add(animation);
    }






}
