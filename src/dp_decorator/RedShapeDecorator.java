package dp_decorator;

public class RedShapeDecorator extends ShapeDecorator {

    RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public void draw() {
        super.draw();
        fillColor();
    }

    private void fillColor() {
        System.out.println("Fill Red Color");
    }

}
