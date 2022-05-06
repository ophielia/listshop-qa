package hellocucumber.meg.listshop.uitests.framework;

import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class SwipeButtonCollection {

    private List<String> labels = new ArrayList<>();

    private Double swipedButtonPercentage = 0.5;

    public SwipeButtonCollection(List<String> labels) {
        this.labels = labels;
    }

    public Point getTapCoordinates(String label, Rectangle rectangle) {
        int targetedIndex = getIndexForLabel(label);
        if (rectangle == null || targetedIndex < 0) {
            return null;
        }

        // get buttons width
        long allButtonsWidth = Math.round(rectangle.width * swipedButtonPercentage);
        // get width of individual button
        long individualWidth = Math.round(allButtonsWidth / labels.size());
        // get start point of individual button (x value)
        long xStartPoint = individualWidth * (targetedIndex);// individualWidth * (targetedIndex)
        long xCenterPoint = Math.round(xStartPoint + (individualWidth / 2));
        // get center of y
        long yCenterPoint = Math.round(rectangle.getY() + (rectangle.getHeight() / 2));

        // create point and return
        long translatedX = rectangle.getX() + (rectangle.getWidth() - allButtonsWidth) + xCenterPoint;
        return new Point((int) translatedX, (int) yCenterPoint);
    }

    private int getIndexForLabel(String label) {
        if (label == null || labels.isEmpty()) {
            return -1;
        }
        int index = 0;
        for (String testLabel : labels) {
            if (testLabel.equals(label)) {
                return index;
            }
            index++;
        }
        return -1;
    }

}
