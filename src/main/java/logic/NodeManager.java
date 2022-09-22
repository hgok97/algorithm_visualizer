package logic;

import gui.Window;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.Random;

/**
 * Holds an Array of the Nodes and takes care of resizing and shuffling of the Array
 */
public class NodeManager {


    private Node[] nodes;


    public NodeManager(int numOfNodes) {
        this.nodes = new Node[numOfNodes];

        for (int i = 0; i < numOfNodes; i++) {
            this.nodes[i] = new Rectangle(10, 140, Color.YELLOW);
        }
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void shuffleArray() {


        Random rng = new Random();
        int num_of_nodes = this.nodes.length;
        Rectangle[] rectangles = new Rectangle[num_of_nodes];


        int width = Window.SCENE_WIDTH / num_of_nodes;


        for (int i = 0; i < num_of_nodes; i++) {

            int height = rng.nextInt(Window.SCENE_HEIGHT/2) + 20;

            int offset = 5;
            Rectangle rec1 = new Rectangle((Window.SCENE_WIDTH/rectangles.length) - offset, height, AnimationSort.COLOR_DEFAULT);
            rec1.setStrokeWidth(2);
            rec1.setStroke(Color.BLACK);
            rec1.relocate((i * rec1.getWidth()) + (i*offset) + rec1.getWidth(), Window.SCENE_HEIGHT/2 + 200);


            rec1.getTransforms().add(new Rotate(180, rec1.getX(), rec1.getY()));

            rec1.setStrokeWidth(1);
            rec1.setStroke(Color.BLACK);



            rectangles[i] = rec1;

        }




    }

    /**
     * Resizes the Array and Shuffles the Array Elements
     * @param numOfNodes
     */
    public void  setNumOfNodes(int numOfNodes) {

        // TO-DO

    }

}
