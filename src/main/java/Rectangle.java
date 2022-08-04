import javafx.geometry.Point2D;

/**
 * Pojo Class for our Sorting Algorithm Visualizer
 * This Rectangle acts as a sortable node
 * If im gonna refactor this, i will have to think about a neat abstraction, hehe
 *
 */
public class Rectangle {


    private double width;
    private double height;

    private double x;
    private double y;

    public Rectangle(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }


    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
