package dp_decorator;

public class TestClient {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        RedShapeDecorator redShapeCircle = new RedShapeDecorator(new Circle());
        redShapeCircle.draw();
    }
}
