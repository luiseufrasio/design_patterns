package creational.prototype;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static Logger logger = System.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		List<Shape> shapesCopy = new ArrayList<>();
		
		Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);
        
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);
        
        cloneAndCompare(shapes, shapesCopy);
	}
	
	private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                logger.log(Level.INFO, i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    logger.log(Level.INFO, i + ": And they are identical (yay!)");
                } else {
                    logger.log(Level.INFO, i + ": But they are not identical (booo!)");
                }
            } else {
                logger.log(Level.INFO, i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
