package logic;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AnimationSort {


    public static final Color COLOR_SELECTED = Color.DARKGOLDENROD;
    public static final Color COLOR_DEFAULT = Color.YELLOW;
    public static final Color COLOR_SORTED  = Color.LIGHTGREEN;
    public static final int speed = 3;

    private ArrayList<Animation> sortingAnimation;
    private HashMap<Shape, Double> shapeToXcoordinate;




    public AnimationSort() {
        sortingAnimation = new ArrayList<>();
        shapeToXcoordinate = new HashMap<>();
    }


    public abstract void initMap(Node[] nodes);






    /**
     * Sorts the nodes and fills the animationList
     * @param nodes
     * 
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
